package com.poly.Service;

import java.util.List;

import com.poly.Entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> findByOrderId(Long id);

}
