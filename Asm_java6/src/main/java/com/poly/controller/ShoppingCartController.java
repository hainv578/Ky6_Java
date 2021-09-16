package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.DAO.CategoryDAO;
import com.poly.Entity.Category;
import com.poly.Service.CategoryService;

@Controller
public class ShoppingCartController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping("/cart/view")
	public String view(Model model) {
		List<Category> view = categoryService.findAll();
		model.addAttribute("listcategory" ,view);
		return "cart/view";
	}
}
