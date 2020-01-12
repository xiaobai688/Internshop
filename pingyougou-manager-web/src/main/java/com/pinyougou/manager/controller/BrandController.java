package com.pinyougou.manager.controller;

import java.util.List;
import java.util.Map;

import entry.PageResult;
import entry.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("brand")

public class BrandController {

	@Reference
	private BrandService brandService;

	//查询全部
	@RequestMapping("findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();		
	}

	//分页查询
	@RequestMapping("findPage")
	public PageResult findPage(int page, int rows) {

		return brandService.findPage(page, rows);
	}
	//增加
	@RequestMapping("addBrand")
	public Result addBrand(@RequestBody TbBrand brand) {
		try {
			brandService.addBrand(brand);
			return new Result(true,"增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"增加失败");
		}
	}
	//修改
	@RequestMapping("updateBrand")
	public Result updateBrand(@RequestBody TbBrand brand) {
		try {
			brandService.updateBrand(brand);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	//查询单个
	@RequestMapping("findById")
	public TbBrand findById(Long id){
		return brandService.findById(id);
	}
	//删除品牌数据
	@RequestMapping("deleteBrand")
	public Result deleteBrand(Long[] ids) {
		try {
			brandService.deleteBrand(ids);
			return new Result(true,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"删除失败");
		}
	}
	//条件查询
	@RequestMapping("search")
	public PageResult search(@RequestBody TbBrand brand ,int page, int rows) {
		return brandService.findPageSearch(brand,page,rows);
	}
	//下拉列表选项
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return brandService.selectOptionList();
	}

}
