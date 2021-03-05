package com.cloudaidatastream.shoppingmart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudaidatastream.shoppingmart.dto.CustomerDTO;
import com.cloudaidatastream.shoppingmart.dto.ResponseData;
import com.cloudaidatastream.shoppingmart.dto.SuccessResponseDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.exceptions.InvalidInputException;
import com.cloudaidatastream.shoppingmart.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
@Api("Customers Related Operation")
public class CustomerController {
	
	private CustomerService customerService;
	
	@ApiOperation(value = "Add customer", notes = "This api is used to store a customer", httpMethod = "POST")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 401, message = "UnAuthorized") })
    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addProduct(@RequestBody CustomerDTO dto) throws DataNotFoundException {
        return new ResponseEntity<SuccessResponseDTO>(new SuccessResponseDTO(customerService.addCustomer(dto)), HttpStatus.CREATED);
    }
	
	@ApiOperation(value = "Get customer", notes = "this api is used to get  customer by Id", httpMethod = "GET")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 401, message = "UnAuthorized") })
    @GetMapping(value = "/customer/{customerId}", produces = "application/json")
    public ResponseEntity<?> getProduct(@PathVariable String customerId) throws InvalidInputException {
		CustomerDTO cutomer = customerService.getCustomer(customerId);
		ResponseData response = new ResponseData();
		if(cutomer == null) {
			response.setData("Data not availavle");
		} else {
			response.setData(cutomer);	
		}
        return new ResponseEntity<ResponseData>(response, HttpStatus.OK);
    }
	

}
