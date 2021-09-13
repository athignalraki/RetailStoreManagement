package com.myapp.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.spring.model.Cart;
import com.myapp.spring.model.ShoppingCart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	public List<Cart> findByProductName(String ProductName);


}
