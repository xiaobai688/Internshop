package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entry.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	//查询全部品牌数据
	public List<TbBrand> findAll();
	//分页查询品牌数据
	public PageResult findPage(int pageNum,int pageSize);
	//增加品牌
	public void addBrand(TbBrand brand);
	//修改品牌(先查询单个品牌数据)
	public TbBrand findById(Long id);
	//修改
	public void updateBrand(TbBrand brand);
	//批量删除数据
	public void deleteBrand(Long[] ids);
	//按条件查询
	public PageResult findPageSearch(TbBrand brand, int pageNum,int pageSize);

	public List<Map> selectOptionList();
}
