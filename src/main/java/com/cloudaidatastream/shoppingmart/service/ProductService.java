package com.cloudaidatastream.shoppingmart.service;

import com.cloudaidatastream.shoppingmart.dto.ProductDTO;
import com.cloudaidatastream.shoppingmart.exceptions.ConflictException;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.exceptions.InvalidInputException;
import com.cloudaidatastream.shoppingmart.models.Product;

import java.util.List;


public interface ProductService {

    String addProduct(ProductDTO dto);

    String uploadProducts(List<ProductDTO> products) throws ConflictException;

    ProductDTO findProductByCode(String productId) throws InvalidInputException;

    List<ProductDTO> retrieveProducts();

    String updateProduct(ProductDTO dto, String productId) throws DataNotFoundException;

    String deleteProduct(String productId) throws DataNotFoundException;
	
}
