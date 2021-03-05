package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudaidatastream.shoppingmart.dto.PaymentDTO;
import com.cloudaidatastream.shoppingmart.dto.PaymentListDTO;
import com.cloudaidatastream.shoppingmart.enums.PaymentMode;
import com.cloudaidatastream.shoppingmart.enums.PaymentStatus;
import com.cloudaidatastream.shoppingmart.enums.ReferenceType;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.Payment;
import com.cloudaidatastream.shoppingmart.repositories.PaymentRepository;
import com.cloudaidatastream.shoppingmart.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	private static Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
	@Autowired
	private PaymentRepository paymentRepository;	
	
	@Override
	public String addPaymentDetails(PaymentDTO dto) throws DataNotFoundException {
		
		if(dto == null) {
    		throw new DataNotFoundException("No Payment Data passed ");
    	}
		Payment payment = new Payment();
		payment.setCreate_date(new Timestamp(System.currentTimeMillis()));
		//try {
			//payment.setId(dto.getId());
			payment.setAmount_paid(dto.getAmount_paid());
			payment.setPayment_mode(PaymentMode.valueOf(dto.getPayment_mode()));
			payment.setRefrence_id(dto.getRefrence_id());
			payment.setRefrence_type(ReferenceType.valueOf(dto.getRefrence_type()));
			payment.setTransaction_id(dto.getTransaction_id());
			payment.setDetail(dto.getDetail());
			payment.setOther_info(dto.getOther_info());
			payment.setStatus(PaymentStatus.valueOf(dto.getStatus()));
			//BeanUtils.copyProperties(payment, dto);
			paymentRepository.save(payment);
			/*
			 * } catch (IllegalAccessException except) {
			 * LOGGER.error("Illegal access in copy of entity to bean", except); } catch
			 * (InvocationTargetException except) {
			 * LOGGER.error("Invocation Target Exceptionin in copy of entity to bean",
			 * except); }
			 */
		return "SUCCESS";
	}

	@Override
	public String addPaymentDetails(PaymentListDTO dto) throws DataNotFoundException {

		if(dto == null) {
    		throw new DataNotFoundException("No Payment Data passed ");
    	}
		for(PaymentDTO payment : dto.getPayments()) {
			addPaymentDetails(payment);	
		}
		return "SUCCESS";
	}
}
