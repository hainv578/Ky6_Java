package com.poly.rest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.DAO.CategoryDAO;
import com.poly.Entity.Category;
import com.poly.Service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryDAO categoryDAO;
	
	@GetMapping()
	public List<Category> getAll(){
		return categoryDAO.findAll();
	}
	@GetMapping("{id}")
	public Optional<Category> getOne(@PathVariable("id") String id) {
		return categoryDAO.findById(id);
	}
	@PostMapping
	public Category create(@RequestBody Category category) {
		return categoryDAO.save(category);
	}
	@PutMapping("{id}")
	public Category update(@PathVariable("id") String id , @RequestBody Category category) {
		return categoryDAO.save(category);
	}
//	@DeleteMapping("{id}")
//	public void delete(@PathVariable("id") String id) {
//		categoryDAO.delete(id);
//	}
}
