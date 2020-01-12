package com.pinyougou.search.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FilterQuery;
import org.springframework.data.solr.core.query.GroupOptions;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.HighlightQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.GroupEntry;
import org.springframework.data.solr.core.query.result.GroupPage;
import org.springframework.data.solr.core.query.result.GroupResult;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightEntry.Highlight;
import org.springframework.data.solr.core.query.result.HighlightPage;
import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.search.service.ItemSearchService;

@Service(timeout=5000)
public class ItemSearchServiceImpl implements ItemSearchService {

	@Autowired
	private SolrTemplate solrTemplate;
	
	@Override
	public Map<String,Object> search(Map searchMap) {
		Map<String,Object> map=new HashMap<>();

		//1.查询列表
		map.putAll(searchList(searchMap));
		//2.分组查询 商品分类列表
		List<String> categoryList = searchCategoryList(searchMap);
		map.put("category", categoryList);

		//3.查询品牌和规格列表
		String categoryName=(String)searchMap.get("category");
		if(!"".equals(categoryName)){//如果有分类名称
			map.putAll(searchBrandAndSpecList(categoryName));
		}else{//如果没有分类名称，按照第一个查询
			if(categoryList.size()>0){
				map.putAll(searchBrandAndSpecList(categoryList.get(0)));
			}
		}


		return map;
	}
	
	
	//查询列表
	private Map searchList(Map searchMap){
		Map map=new HashMap();
		//关键字去空格
		String keywords= (String) searchMap.get("keywords");
		searchMap.put("keywords",keywords.replace(" ",""));
		//高亮选项初始化
		HighlightQuery query=new SimpleHighlightQuery();		
		HighlightOptions highlightOptions=new HighlightOptions().addField("item_title");//高亮域
		highlightOptions.setSimplePrefix("<em style='color:red'>");//前缀
		highlightOptions.setSimplePostfix("</em>");		
		query.setHighlightOptions(highlightOptions);//为查询对象设置高亮选项
		
		//1.1 关键字查询
		Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));
		query.addCriteria(criteria);

		//1.2按分类筛选
		if(!"".equals(searchMap.get("category"))){
			Criteria filterCriteria=new Criteria("item_category").is(searchMap.get("category"));
			FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
			query.addFilterQuery(filterQuery);
		}


		//1.3按品牌筛选
		if(!"".equals(searchMap.get("brand"))){
			Criteria filterCriteria=new Criteria("item_brand").is(searchMap.get("brand"));
			FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
			query.addFilterQuery(filterQuery);
		}

		//1.4过滤规格
		if(searchMap.get("spec")!=null){
			Map<String,String> specMap= (Map) searchMap.get("spec");
			for(String key:specMap.keySet() ){
				Criteria filterCriteria=new Criteria("item_spec_"+key).is( specMap.get(key) );
				FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
		}
		//1.5过滤价格
		if(!"".equals(searchMap.get("price"))){
			String[] price = ((String) searchMap.get("price")).split("-");
			if(!price[0].equals("0")){//如果区间起点不等于0
				Criteria filterCriteria=new Criteria("item_price").greaterThanEqual(price[0]);
				FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
			if(!price[1].equals("*")){//如果区间终点不等于*
				Criteria filterCriteria=new  Criteria("item_price").lessThanEqual(price[1]);
				FilterQuery filterQuery=new SimpleFilterQuery(filterCriteria);
				query.addFilterQuery(filterQuery);
			}
	    }

		//1.6设置分页
        //获取页码
        Integer pageNo = (Integer) searchMap.get("pageNo");
		if(pageNo==null){
		    pageNo=1;
        }
		//获取页面数据大小
        Integer pageSize = (Integer) searchMap.get("pageSize");
		if(pageSize==null){
            pageSize=15;
        }

		//1.7设置关键字排序
		String sortValue=(String)searchMap.get("sort");
		String sortFiled=(String)searchMap.get("sortFiled");
		if (sortValue!=null&&sortValue!=""){
			if(sortValue.equals("ASC")) {
				Sort sort = new Sort(Sort.Direction.ASC, "item_" + sortFiled);
				query.addSort(sort);
			}
			if(sortValue.equals("DESC")) {
				Sort sort = new Sort(Sort.Direction.DESC, "item_" + sortFiled);
				query.addSort(sort);
			}
		}


		//起始索引
        query.setOffset((pageNo-1)*pageSize);
		//每页记录数
        query.setRows(pageSize);

        //***********  获取高亮结果集  ***********
		//高亮页对象
		HighlightPage<TbItem> page = solrTemplate.queryForHighlightPage(query, TbItem.class);
		//高亮入口集合(每条记录的高亮入口)
		List<HighlightEntry<TbItem>> entryList = page.getHighlighted();		
		for(HighlightEntry<TbItem> entry:entryList  ){
			//获取高亮列表(高亮域的个数)
			List<Highlight> highlightList = entry.getHighlights();
			/*
			for(Highlight h:highlightList){
				List<String> sns = h.getSnipplets();//每个域有可能存储多值
				System.out.println(sns);				
			}*/			
			if(highlightList.size()>0 &&  highlightList.get(0).getSnipplets().size()>0 ){
				TbItem item = entry.getEntity();
				item.setTitle(highlightList.get(0).getSnipplets().get(0));			
			}			
		}
		map.put("rows", page.getContent());
		map.put("totalPages", page.getTotalPages());//总页数
		map.put("total", page.getTotalElements());//总记录数
		return map;
		
	}
	
	/**
	 * 分组查询（查询商品分类列表）
	 * @return
	 */
	private List<String> searchCategoryList(Map searchMap){
		List<String> list=new ArrayList();
		
		Query query=new SimpleQuery("*:*");
		//根据关键字查询  
		Criteria criteria=new Criteria("item_keywords").is(searchMap.get("keywords"));// where ...
		query.addCriteria(criteria);
		//设置分组选项
		GroupOptions groupOptions=new GroupOptions().addGroupByField("item_category");  //group by ...
		query.setGroupOptions(groupOptions);
		//获取分组页
		GroupPage<TbItem> page = solrTemplate.queryForGroupPage(query, TbItem.class);
		//获取分组结果对象
		GroupResult<TbItem> groupResult = page.getGroupResult("item_category");
		//获取分组入口页
		Page<GroupEntry<TbItem>> groupEntries = groupResult.getGroupEntries();
		//获取分组入口集合
		List<GroupEntry<TbItem>> entryList = groupEntries.getContent();
		
		for(GroupEntry<TbItem> entry:entryList  ){
			list.add(entry.getGroupValue()	);	//将分组的结果添加到返回值中
		}
		return list;
		
	}
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * 根据商品分类名称查询品牌和规格列表
	 * @param category 商品分类名称
	 * @return
	 */
	private Map searchBrandAndSpecList(String category){
		Map map=new HashMap();
		//1.根据商品分类名称得到模板ID		
		Long templateId= (Long) redisTemplate.boundHashOps("itemCat").get(category);
		if(templateId!=null){
			//2.根据模板ID获取品牌列表
			List brandList = (List) redisTemplate.boundHashOps("brandList").get(templateId);
			map.put("brandList", brandList);	

			//3.根据模板ID获取规格列表
			List specList = (List) redisTemplate.boundHashOps("specList").get(templateId);
			map.put("specList", specList);		

		}	
		
		return map;
	}

	/**
	 * 导入数据
	 * @param list
	 */
	public void importList(List list){
		solrTemplate.saveBeans(list);
		solrTemplate.commit();
	}

	/**
	 * 删除数据
	 * @param goodsIdList
	 */
	@Override
	public void deleteByGoodsIds(List goodsIdList) {
		System.out.println("删除商品ID"+goodsIdList);
		Query query=new SimpleQuery();
		Criteria criteria=new Criteria("item_goodsid").in(goodsIdList);
		query.addCriteria(criteria);
		solrTemplate.delete(query);
		solrTemplate.commit();
	}

}
