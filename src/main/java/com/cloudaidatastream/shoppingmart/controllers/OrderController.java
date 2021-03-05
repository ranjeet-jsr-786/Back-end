package com.cloudaidatastream.shoppingmart.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudaidatastream.shoppingmart.dto.OrdersDTO;
import com.cloudaidatastream.shoppingmart.dto.ResponseData;
import com.cloudaidatastream.shoppingmart.dto.SuccessResponseDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/order")
@Api("Order Related Operation")
public class OrderController {
	
    @Autowired
    private OrderService orderService;

	 @ApiOperation(value = "Add order", notes = "This api is used to store a order", httpMethod = "POST")
	    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
	            @ApiResponse(code = 401, message = "UnAuthorized") })
	    @PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
	    public ResponseEntity<?> placeOrder(@RequestBody OrdersDTO dto) throws DataNotFoundException {
	        return new ResponseEntity<SuccessResponseDTO>(new SuccessResponseDTO(orderService.placeOrder(dto)), HttpStatus.CREATED);
	    }
	 
	 @ApiOperation(value = "Add order", notes = "This api is used to store a order", httpMethod = "GET")
	    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
	            @ApiResponse(code = 401, message = "UnAuthorized") })
	 @GetMapping(value = "/number", consumes = "application/json", produces = "application/json")
	 public ResponseEntity<?> generateOrderNumber(HttpServletRequest request) throws DataNotFoundException {
		 	ResponseData responseData = new ResponseData();
		 	responseData.setData(orderService.generateOrderNumber(request.getLocale()));
	        return new ResponseEntity<ResponseData>(responseData, HttpStatus.OK);
	    }
}
