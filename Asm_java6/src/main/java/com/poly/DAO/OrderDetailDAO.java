package com.poly.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.Entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	@Query("SELECT o FROM OrderDetail o WHERE o.order.id=:id")
	List<OrderDetail> findByOrderId(@Param("id") long id);
}
