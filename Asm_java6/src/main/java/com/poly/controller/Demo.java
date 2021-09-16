package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.Entity.Account;
import com.poly.Entity.Authority;
import com.poly.Entity.Role;
import com.poly.Service.AccountService;
import com.poly.Service.AuthorityService;
import com.poly.Service.RoleService;

@CrossOrigin("*")
@RestController
public class Demo {
@Autowired AccountService accountService;
@GetMapping("adc/df")
public List<Account> nrw() {
	return accountService.findAll();
}
}
