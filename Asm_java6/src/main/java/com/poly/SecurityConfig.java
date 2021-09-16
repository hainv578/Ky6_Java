package com.poly;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.poly.Entity.Account;
import com.poly.Service.AccountService;


@Configuration 
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accountService;
//	UserService userService;
//	Ma hoa mat khau
	@Autowired
	BCryptPasswordEncoder pe;
	//Cung cấp nguồn dữ 
	@Override
	protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
		auth.userDetailsService(username ->{
			try {
				Account account = accountService.findById(username);
				//tao userdetails tu account;
				String password = pe.encode(account.getPassword());
				String[] roles = account.getAuthorities().stream()
						.map(au -> au.getRole().getId())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username)
						.password(password)
						.roles(roles).build();
			} catch (Exception e) {
				throw new UsernameNotFoundException(username +"not found!");
			}
		});
		
		
	}
	//phan quyen su dung va hinh thuc dang nhap 
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		//phan quyen su dung 
		http.authorizeRequests()
		//cau hinh phan quyen su dung
		.antMatchers("/order/**").authenticated()
		.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
		.antMatchers("/rest/authorities").hasRole("DIRE")
		.anyRequest().permitAll();
		// giao dang nhap
		http.formLogin()
		//dia chi dan den form
			.loginPage("/security/login/form")
			.loginProcessingUrl("/security/login")
			.defaultSuccessUrl("/security/login/success",false)
			.failureUrl("/security/login/error");   
		http.rememberMe()
			.tokenValiditySeconds(86400);
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthoried");
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
	}
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
