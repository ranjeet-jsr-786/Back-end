package com.cloudaidatastream.shoppingmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudaidatastream.shoppingmart.dto.LineItemDTO;
import com.cloudaidatastream.shoppingmart.dto.ResponseData;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.service.InvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/invoice")
@Api("Invoice Related Operation")
public class InvoiceController {
	
	 @Autowired
	    private InvoiceService invoiceService;

		 @ApiOperation(value = "Add invoice", notes = "This api is used to store a invoice", httpMethod = "POST")
		    @ApiResponses(value = { @ApiResponse(code = 500, message = "Internal Server error"),
		            @ApiResponse(code = 401, message = "UnAuthorized") })
		    @PostMapping(consumes = "application/json", produces = "application/json")
		    public ResponseEntity<?> generateInvoice(@RequestBody LineItemDTO dto) throws DataNotFoundException {
		        return new ResponseEntity<ResponseData>(new ResponseData(invoiceService.generateInvoice(dto)), HttpStatus.CREATED);
		    }

}
