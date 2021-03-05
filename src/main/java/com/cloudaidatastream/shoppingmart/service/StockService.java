package com.cloudaidatastream.shoppingmart.service;

import com.cloudaidatastream.shoppingmart.dto.ProductStockDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;

public interface StockService {

	void stockDeliver(ProductStockDTO dto) throws DataNotFoundException;

	void stockReceive(ProductStockDTO dto) throws DataNotFoundException;

}
