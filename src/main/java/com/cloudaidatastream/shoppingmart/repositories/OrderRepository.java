package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudaidatastream.shoppingmart.models.Orders;


public interface OrderRepository extends JpaRepository<Orders, String> {
	
	/*
	 * @Query("select count(*) from Orders" ) int findOrderCount();
	 */
}
