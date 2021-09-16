package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.Entity.OrderDetail;
import com.poly.Service.OrderDetailService;
import com.poly.Service.OrderService;

@Controller
public class OrderController {
	@Autowired OrderService orderService;
	
	@Autowired OrderDetailService orderDetailService;
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model , HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders" , orderService.findByIdUsername(username));
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id ,Model model) {
		List<OrderDetail> orderdetail= orderDetailService.findByOrderId(id);
		model.addAttribute("orderdetail",orderdetail);
		return "order/detail";
	}
}
