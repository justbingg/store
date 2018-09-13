package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;

import java.util.List;
import java.util.Map;

public interface BrandService extends BaseService<TbBrand>{
	public List<TbBrand> testPage(Integer page,Integer rows);

	List<TbBrand> queryAll();

	PageResult search(TbBrand brand, Integer page, Integer rows);

	List<Map<String,Object>> selectOptionList();
}
