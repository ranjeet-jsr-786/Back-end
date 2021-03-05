package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.sql.Timestamp;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudaidatastream.shoppingmart.dto.ProductDeliveredDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductReceivedDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductStockDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.Product;
import com.cloudaidatastream.shoppingmart.models.ProductStock;
import com.cloudaidatastream.shoppingmart.models.StockDelivered;
import com.cloudaidatastream.shoppingmart.models.StockReceived;
import com.cloudaidatastream.shoppingmart.models.Store;
import com.cloudaidatastream.shoppingmart.repositories.ProductRepository;
import com.cloudaidatastream.shoppingmart.repositories.StockRepository;
import com.cloudaidatastream.shoppingmart.repositories.StoreRepository;
import com.cloudaidatastream.shoppingmart.service.StockService;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Transactional
	@Override
	public void stockReceive(ProductStockDTO dto) throws DataNotFoundException {
		if (dto == null) {
			throw new DataNotFoundException("Stock receive parmeter paassed empty");
		}
		Optional<Store> storeOpt = storeRepository.findById(dto.getStore_id());
		if (!storeOpt.isPresent()) {
			throw new DataNotFoundException("Store data not found for Id " + dto.getStore_id());
		}
		Store store = storeOpt.get();
		ProductStock stock = null;
		Optional<ProductStock> stockOpt = stockRepository.findByProductCodeAndStoreId(dto.getProduct_code(), dto.getStore_id());
		if (!stockOpt.isPresent()) {
			stock = new ProductStock();
			BeanUtils.copyProperties(dto, stock);
			stock.setStore(store);
		} else {
			stock = stockOpt.get();
			stock.setQuanity(stock.getQuanity() + dto.getQuanity());
		}
		Product product = productRepository.findByCode(dto.getProduct_code());		
		stock.setProduct(product);
		stock.setCreate_date(new Timestamp(System.currentTimeMillis()));
		setSockReceivedEntity(dto, stock, product);
		ProductStock savedProductStock = stockRepository.save(stock);
		dto.setId(savedProductStock.getId());
	}
	
	private void setSockReceivedEntity(ProductStockDTO dto, ProductStock stock, Product product) {
		for(ProductReceivedDTO receiveDto : dto.getProductsReceived()) {
			StockReceived stockReceive = null;
			if(dto.getId() == 0) {
				stockReceive = new StockReceived();
			} else {
				Optional<StockReceived> StockReceivedOpt = stock.getProductsReceived().stream()
						.filter(p -> p.getId() == receiveDto.getId()).findFirst();
				stockReceive = StockReceivedOpt.get();
			}
			BeanUtils.copyProperties(receiveDto, stockReceive);
			stockReceive.setProduct(product);
			stockReceive.setProductStock(stock);
			stock.getProductsReceived().add(stockReceive);
		}
	}

	@Transactional
	@Override
	public void stockDeliver(ProductStockDTO dto) throws DataNotFoundException {
		if (dto == null) {
			throw new DataNotFoundException("Stock receive parmeter paassed empty");
		}
		Optional<ProductStock> stockOpt = stockRepository.findByProductCodeAndStoreId(dto.getProduct_code(), dto.getStore_id());
		if (!stockOpt.isPresent()) {
			throw new DataNotFoundException("Stock data not found for Id " + dto.getId());
		}
		ProductStock stock = stockOpt.get();
		if(dto.getQuanity() > stock.getQuanity()) {
			throw new DataNotFoundException("Insufficient Stock found for product code: " + dto.getProduct_code());	
		}
		Product product = productRepository.findByCode(dto.getProduct_code());
		stock.setQuanity(stock.getQuanity() - dto.getQuanity());	
		setSockDeliverEntity(dto , stock, product);
		stock.setProduct(product);
		ProductStock savedProductStock = stockRepository.save(stock);
		dto.setId(savedProductStock.getId());
	}
	
	private void setSockDeliverEntity(ProductStockDTO dto, ProductStock stock, Product product) {
		for(ProductDeliveredDTO deliverDto : dto.getProductsDelivered()) {
			StockDelivered stockDeliver = null;
			if(dto.getId() == 0) {
				stockDeliver = new StockDelivered();
			} else {
				Optional<StockDelivered> StockDeliverOpt = stock.getProductsDelivered().stream()
						.filter(p -> p.getId() == deliverDto.getId()
						).findFirst();
				stockDeliver = StockDeliverOpt.get();
			}
			BeanUtils.copyProperties(deliverDto, stockDeliver);
			stockDeliver.setProduct(product);
			stockDeliver.setProductStock(stock);
			stock.getProductsDelivered().add(stockDeliver);
		}
	}

}
