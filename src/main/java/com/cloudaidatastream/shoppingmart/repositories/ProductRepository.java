package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudaidatastream.shoppingmart.models.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Product findByCode(String code);
}
