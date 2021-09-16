package com.poly.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.DAO.CategoryDAO;
import com.poly.Entity.Category;
import com.poly.Entity.Product;
import com.poly.Service.CategoryService;
import com.poly.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired 
	CategoryService categoryService;

	@RequestMapping("/home/view")
	public String list(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 6);
		Page<Product> page = productService.findAll(pageable);
		int totalPages=page.getTotalPages();
		if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		model.addAttribute("activeArticleList", true);
		model.addAttribute("items", page.getContent());
		List<Category> view = categoryService.findAll();
		model.addAttribute("listcategory" ,view);
		return "home/view";
	}
	@RequestMapping("/home/paging={cid}")
	public String findbycategory(Model model, @PathVariable("cid") String cid, @RequestParam("p") Optional<Integer> p) {
		List<Category> view = categoryService.findAll();
		model.addAttribute("listcategory" ,view);
		Pageable pageable = PageRequest.of(p.orElse(0), 9);
		Page<Product> page = productService.findByCategoryId(cid,pageable);
		int totalPages=page.getTotalPages();
		if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
		model.addAttribute("items", page.getContent());
		return "home/paging";
	}
	@RequestMapping("/home/detail/{id}")
	public String detail(Model model,@RequestParam("p") Optional<Integer> p, @PathVariable("id") Integer id) {
		Product product = productService.findById(id);
		model.addAttribute("p", product);
		Product item = new Product();
		model.addAttribute("item" , item);
		Pageable pageable = PageRequest.of(p.orElse(0), 4);
		Page<Product> products = productService.findByCategoryId(product.getCategory().getId(),pageable);
		model.addAttribute("products", products);
		List<Category> view = categoryService.findAll();
		model.addAttribute("listcategory" ,view);
		return "home/detail";
	}
}
