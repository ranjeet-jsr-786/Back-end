package com.cloudaidatastream.shoppingmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudaidatastream.shoppingmart.models.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

}
