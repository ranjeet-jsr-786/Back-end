package com.cloudaidatastream.shoppingmart.service;

import com.cloudaidatastream.shoppingmart.dto.PaymentDTO;
import com.cloudaidatastream.shoppingmart.dto.PaymentListDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;

public interface PaymentService {

	String addPaymentDetails(PaymentDTO dto) throws DataNotFoundException;

	String addPaymentDetails(PaymentListDTO dto)throws DataNotFoundException;;

}
