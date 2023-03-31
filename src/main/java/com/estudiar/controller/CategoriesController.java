package com.estudiar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estudiar.dto.CategoryAll;
import com.estudiar.dto.CategoryInfo;
import com.estudiar.dto.CategoryRegister;
import com.estudiar.dto.ItemRegister;
import com.estudiar.mapper.CategoryMapper;
import com.estudiar.mapper.ItemMapper;
import com.estudiar.model.Category;
import com.estudiar.service.CategoryService;
import com.estudiar.service.ItemService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/categories")
@AllArgsConstructor
public class CategoriesController {

	private CategoryService categoryService;
	private ItemService itemService;

	@GetMapping
	public String categories(Model model) {
		List<Category> categories = categoryService.findAll();
		List<CategoryInfo> infoCategories = new ArrayList<CategoryInfo>();
		
		if(!categories.isEmpty()) {
			infoCategories = CategoryMapper.toCategoryInfoList(categories);
		}
		model.addAttribute("categories", infoCategories);
		return "categories";
	}

	@GetMapping("/add")
	public String addCategoryForm(Model model) {
		model.addAttribute("category", new CategoryRegister());
		return "categories_add";
	}

	@PostMapping("/add")
	public String addCategory(@ModelAttribute("category") CategoryRegister categoryRegister) {
		categoryService.create(CategoryMapper.CategoryRegisterToCategory(categoryRegister));
		return "redirect:/categories";
	}

	@GetMapping("/{id}")
	public String categoriesId(@PathVariable(name = "id") String id, Model model) {
		Integer idInteger = Integer.valueOf(id);
		CategoryAll categoryAll = CategoryMapper.categoryToCategoryAll(categoryService.findById(idInteger));
		String vista = "categories_id";
		
		if(categoryAll==null) {
			vista = "redirect:/categories";
		}else {
			model.addAttribute("category", categoryAll);
			model.addAttribute("items", ItemMapper.toItemInfoList(itemService.findByCategoryId(idInteger)));
		}
		
		return vista;
	}
	
	@GetMapping("/{id}/add")
	public String addItemForm(@PathVariable(name = "id")String id, Model model) {
		Integer idInteger = Integer.valueOf(id);
		model.addAttribute("category", categoryService.findById(idInteger));
		model.addAttribute("item", new ItemRegister());
		
		return "categories_id_add";
	}

	@PostMapping("/{id}/add")
	public String addItem(@PathVariable(name = "id")String id, @ModelAttribute("category") ItemRegister itemRegister) {
		Integer idInteger = Integer.valueOf(id);
		itemService.create(ItemMapper.ItemRegisterToItem(itemRegister, categoryService.findById(idInteger)));
		
		return "redirect:/categories/" + idInteger;
	}
	
	@GetMapping("/{id}/{itemId}")
	public String deleteItem(@PathVariable(name = "id") String id, @PathVariable(name = "itemId") String itemId) {
		Integer idInteger = Integer.valueOf(id);
		Integer idItemInteger = Integer.valueOf(itemId);
		
		itemService.deleteById(idItemInteger);
		
		return "redirect:/categories/" + idInteger;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable(name = "id") String id) {
		Integer idInteger = Integer.valueOf(id);
		
		try {
			
			itemService.deleteByCategoryId(idInteger);
			categoryService.deleteById(idInteger);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/categories";
	}
	
	@GetMapping("/{id}/study")
	public String study(@PathVariable(name = "id") String id, Model model) {
		Integer idInteger = Integer.valueOf(id);
		model.addAttribute("category", CategoryMapper.categoryToCategoryAll(categoryService.findById(idInteger)));
		model.addAttribute("items", ItemMapper.toItemInfoList(itemService.findByCategoryId(idInteger)));
		
		return "study";
	}
	
}
