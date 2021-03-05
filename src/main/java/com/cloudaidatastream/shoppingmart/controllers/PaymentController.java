package com.cloudaidatastream.shoppingmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudaidatastream.shoppingmart.dto.PaymentDTO;
import com.cloudaidatastream.shoppingmart.dto.PaymentListDTO;
import com.cloudaidatastream.shoppingmart.dto.SuccessResponseDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.service.PaymentService;
import com.cloudaidatastream.shoppingmart.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/payments")
@Api("Customers Related Operation")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private StockService stockService;
	
	@ApiOperation(value = "Add payment", notes = "This api is used to store a payment", httpMethod = "POST")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 401, message = "UnAuthorized") })
    @PostMapping(value = "/payment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addPayment(@RequestBody PaymentDTO dto) throws DataNotFoundException {
        return new ResponseEntity<SuccessResponseDTO>(new SuccessResponseDTO(paymentService.addPaymentDetails(dto)), HttpStatus.CREATED);
    }
	
	@ApiOperation(value = "Add payment", notes = "This api is used to store a payment", httpMethod = "POST")
    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
            @ApiResponse(code = 401, message = "UnAuthorized") })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addPayments(@RequestBody PaymentListDTO dto) throws DataNotFoundException {
		String addedPayment = paymentService.addPaymentDetails(dto);
		
		//stockService.maintainProductStock(dto);
        return new ResponseEntity<SuccessResponseDTO>(new SuccessResponseDTO(addedPayment), HttpStatus.CREATED);
    }
}
