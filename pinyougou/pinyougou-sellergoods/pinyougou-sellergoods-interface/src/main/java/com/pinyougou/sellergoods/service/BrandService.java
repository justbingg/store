package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.service.BaseService;

import java.util.List;

public interface BrandService extends BaseService<TbBrand>{
	public List<TbBrand> testPage(Integer page,Integer rows);

	List<TbBrand> queryAll();
}
