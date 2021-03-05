package com.cloudaidatastream.shoppingmart.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudaidatastream.shoppingmart.models.ProductStock;

public interface StockRepository extends JpaRepository<ProductStock, Long> {

	@Query("select ps from ProductStock ps where ps.product.code = ?1 and ps.store.id = ?2")
	Optional<ProductStock> findByProductCodeAndStoreId(String productCode, long storeId);
}
