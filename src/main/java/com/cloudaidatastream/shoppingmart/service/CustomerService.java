package com.cloudaidatastream.shoppingmart.service;

import com.cloudaidatastream.shoppingmart.dto.CustomerDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;

public interface CustomerService {

	String addCustomer(CustomerDTO dto) throws DataNotFoundException;
	
	CustomerDTO getCustomer(String customerId);

}
