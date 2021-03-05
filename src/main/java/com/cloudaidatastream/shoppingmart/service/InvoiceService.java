package com.cloudaidatastream.shoppingmart.service;

import com.cloudaidatastream.shoppingmart.dto.InvoiceDTO;
import com.cloudaidatastream.shoppingmart.dto.LineItemDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;

public interface InvoiceService {

	InvoiceDTO generateInvoice(LineItemDTO dto) throws DataNotFoundException;

}
