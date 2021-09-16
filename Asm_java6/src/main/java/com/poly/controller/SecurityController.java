package com.poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/security/login/form")
	public String form() {
		return "security/login";
	}
	@RequestMapping("/security/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		System.out.println("ok");
		return "redirect:/home/view";
	}
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Sai thông tin đăng nhập");
		return "security/login";
	}
	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		model.addAttribute("message", "Dang xuat thanh cong");
		return "security/login";
	}
	@RequestMapping("/security/unauthoried")
	public String denied(Model model) {
		model.addAttribute("message", "Ban khong co quyen truy xuất");
		return "security/login";
	}
}
