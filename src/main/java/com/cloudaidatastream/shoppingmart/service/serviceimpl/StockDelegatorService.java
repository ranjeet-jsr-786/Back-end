package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cloudaidatastream.shoppingmart.dto.ProductStockDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.service.StockService;

@Service
public class StockDelegatorService {
	private static Logger LOGGER = LoggerFactory.getLogger(StockDelegatorService.class);
	@Autowired
	private StockService stockService;
	
	@Async
	public void stockDeliver(List<ProductStockDTO> stockDtoList) {
		try {
			for(ProductStockDTO dto : stockDtoList) {
				stockService.stockDeliver(dto);
			}
		} catch (DataNotFoundException e) {
			LOGGER.error("Error in stock delivery" + e.getMessage(), e);
		}	
	}
	@Async
	public void stockReceive(List<ProductStockDTO> stockDtoList) {
		try {
			for(ProductStockDTO dto : stockDtoList) {
				stockService.stockReceive(dto);
			}
		} catch (DataNotFoundException e) {
			LOGGER.error("Error in stock receive" + e.getMessage(), e);
		}
	}
}
