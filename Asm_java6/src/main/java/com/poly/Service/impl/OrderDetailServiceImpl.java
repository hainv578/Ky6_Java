package com.poly.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.DAO.OrderDetailDAO;
import com.poly.Entity.OrderDetail;
import com.poly.Service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired OrderDetailDAO orderDetailDAO;
	
	@Override
	public List<OrderDetail> findByOrderId(Long id){
		return  orderDetailDAO.findByOrderId(id);
	}
	
	
}
