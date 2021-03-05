package com.cloudaidatastream.shoppingmart.service;

import java.util.List;
import java.util.Locale;

import com.cloudaidatastream.shoppingmart.dto.OrdersDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.ProductOrder;


public interface OrderService {

    String placeOrder(OrdersDTO dto) throws DataNotFoundException;

    ProductOrder findByOrderId(Long orderId);

    List<ProductOrder> findByUserId(Long userId);

    ProductOrder updateOrder(ProductOrder dto, Long orderId);

    String cancelOrder(Long orderId);

	String generateOrderNumber(Locale locale);

}
