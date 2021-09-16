package com.poly.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.poly.Entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	 @Query("SELECT p FROM Product p WHERE p.category.id=?1")
	Page<Product> findByCategoryId(String cid , Pageable pageable);

}
