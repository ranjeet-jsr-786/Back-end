package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudaidatastream.shoppingmart.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
