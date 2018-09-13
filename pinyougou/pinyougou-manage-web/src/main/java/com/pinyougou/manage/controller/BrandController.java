package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RequestMapping("/brand")
@RestController
public class BrandController {
	@Reference
	private BrandService brandService;

	@GetMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	@GetMapping("/findPage")
	public PageResult findPage(@RequestParam(value = "page", defaultValue =
			"1")Integer page,
							   @RequestParam(value = "rows", defaultValue =
									   "10")Integer rows) {
		return brandService.findPage(page, rows);
	}

	@GetMapping("/testPage")
	public List<TbBrand> testPage(Integer page, Integer rows) {

		return (List<TbBrand>) brandService.findPage(page,rows).getRows();
	}

	/**
	 * 保存
	 * @param tbBrand
	 * @return
	 */
	@PostMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand){
		try {
			System.out.println(tbBrand.getName());
			System.out.println(tbBrand.getFirstChar());
			brandService.add(tbBrand);
			return Result.ok("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Result.fail("新增失败");

	}

	/**
	 * 根据id查找品牌
	 * @param id
	 * @return
	 */
	@PostMapping("/findOne")
	public TbBrand findOne(Long id){
		try {
			TbBrand one = brandService.findOne(id);
			return one;
		}catch (Exception e){
			return null;
		}
	}

	/**
	 * 更新品牌
	 * @param tbBrand
	 * @return
	 */
	@PostMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand){

		try {
			brandService.update(tbBrand);
			return Result.ok("修改成功");
		} catch (Exception e) {
			e.printStackTrace();

		}
		return Result.fail("修改失败");

	}

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	public Result delete(Long[] ids){
		try {
			brandService.deleteByIds(ids);
			return Result.ok("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Result.fail("删除失败");
	}

	/**
	 * 根据条件分页查询
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, @RequestParam(value = "page",defaultValue = "1")Integer page,
							 @RequestParam(value = "rows",defaultValue = "10")Integer rows){
		return brandService.search(brand,page,rows);
	}


	@GetMapping("/selectOptionList")
	public List<Map<String,Object>> selectOptionList(){
		return brandService.selectOptionList();
	}


}
