package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cloudaidatastream.shoppingmart.models.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
