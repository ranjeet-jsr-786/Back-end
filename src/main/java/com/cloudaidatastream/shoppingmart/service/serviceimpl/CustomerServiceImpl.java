package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudaidatastream.shoppingmart.dto.CustomerDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.Customer;
import com.cloudaidatastream.shoppingmart.repositories.CustomerRepository;
import com.cloudaidatastream.shoppingmart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addCustomer(CustomerDTO dto) throws DataNotFoundException {
		
		if(dto == null) {
    		throw new DataNotFoundException("No Customer Data passed ");
    	}
		Customer customer = new Customer();
		//Set<Address> customerAddress = new HashSet<Address>();
		try {
			BeanUtils.copyProperties(customer, dto);
			customerRepository.save(customer);
		} catch (IllegalAccessException except) {
			LOGGER.error("Illegal access in copy of entity to bean", except);
		} catch (InvocationTargetException except) {
			LOGGER.error("Invocation Target Exceptionin in copy of entity to bean", except);
		}
		return "SUCCESS";
	}

	@Override
	public CustomerDTO getCustomer(String customerId) {
		CustomerDTO dto = new CustomerDTO();
		try {
			Optional<Customer> customerOpt = customerRepository.findById(Long.valueOf(customerId));
			if(customerOpt.get() == null) {
				return null;
			}
			BeanUtils.copyProperties(dto, customerOpt.get());
		} catch (IllegalAccessException except) {
			LOGGER.error("Illegal access in copy of entity to bean", except);
		} catch (InvocationTargetException except) {
			LOGGER.error("Invocation Target Exceptionin in copy of entity to bean", except);
		}
		return dto;
	}

}
