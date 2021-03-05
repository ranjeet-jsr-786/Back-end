package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudaidatastream.shoppingmart.dto.InvoiceDTO;
import com.cloudaidatastream.shoppingmart.dto.InvoiceDetailDTO;
import com.cloudaidatastream.shoppingmart.dto.ItemDTO;
import com.cloudaidatastream.shoppingmart.dto.LineItemDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductDeliveredDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductReceivedDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductStockDTO;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.Invoice;
import com.cloudaidatastream.shoppingmart.models.InvoiceDetail;
import com.cloudaidatastream.shoppingmart.repositories.InvoiceRepository;
import com.cloudaidatastream.shoppingmart.repositories.ProductRepository;
import com.cloudaidatastream.shoppingmart.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	private static Logger LOGGER = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	
	 @Autowired
	 private ProductRepository productRepository;
	 @Autowired
	 private InvoiceRepository invoiceRepository;
	 @Autowired
	 private StockDelegatorService stockDelegatorService;
	 
	 
	public InvoiceDTO saveInvoice(InvoiceDTO dto) throws DataNotFoundException {
		if(dto == null) {
			throw new DataNotFoundException("Line Item Data not found");
		}
		Invoice invoice = null;
		Optional<Invoice> invoiceOpt = invoiceRepository.findById(dto.getId());		
		if(!invoiceOpt.isPresent()) {	
			invoice = new Invoice();
			BeanUtils.copyProperties(dto, invoice);
			invoice.setCustomer_id(1L);
			invoice.setCreate_date(new Timestamp(System.currentTimeMillis()));
			setInvoiceDetailEntity(dto, invoice);
			Invoice savedInvoice = invoiceRepository.save(invoice);
			dto.setId(savedInvoice.getId());			
		} else {
			invoice = invoiceOpt.get();
			BeanUtils.copyProperties(dto, invoice);
			setInvoiceDetailEntity(dto, invoice);
			invoiceRepository.save(invoice);
		}		
		stockDeliver(dto);
		return dto;
	}

	private void setInvoiceDetailEntity(InvoiceDTO dto, Invoice invoice) {
		for(InvoiceDetailDTO detailDto : dto.getInvoceDetails()) {
			InvoiceDetail invoiceDtl = null;
			if(detailDto.getId() == 0) {
				invoiceDtl = new InvoiceDetail();
			} else {
				Optional<InvoiceDetail> invoiceDtlOpt = invoice.getInvoceDetails().stream()
						.filter(p -> p.getId() == detailDto.getId()).findFirst();
				invoiceDtl = invoiceDtlOpt.get();
			}
			BeanUtils.copyProperties(detailDto, invoiceDtl);
			invoiceDtl.setInvoice(invoice);
			invoice.getInvoceDetails().add(invoiceDtl);
		}
	}

	@Override
	public InvoiceDTO generateInvoice(LineItemDTO dto) throws DataNotFoundException {
		
		if(dto == null) {
			throw new DataNotFoundException("Line Item Data not found");
		}
		InvoiceDTO invoiceDto = new InvoiceDTO();
		for(ItemDTO item : dto.getLineItems()) {
			/*
			 * Product prod = productRepository.findByCode(item.getId()); if(prod != null) {
			 * ProductPrice prodPrice = prod.getProductPrice(); }
			 */
			InvoiceDetailDTO invoiceDtl = getCalculatedInvoice(item);			
			invoiceDto.setTotal_base_price(invoiceDto.getTotal_base_price() + (invoiceDtl.getBase_price() * item.getQty()));
			invoiceDto.setTotal_amount(invoiceDto.getTotal_amount() + invoiceDtl.getAmount());
			invoiceDto.setTotal_discount(invoiceDto.getTotal_discount() + invoiceDtl.getDiscount());
			invoiceDto.setTotal_net_amount(invoiceDto.getTotal_net_amount() + invoiceDtl.getNet_amount());
			invoiceDto.setTotal_tax1(invoiceDto.getTotal_tax1() + invoiceDtl.getTax1());
			invoiceDto.setTotal_tax2(invoiceDto.getTotal_tax2() + invoiceDtl.getTax2());
			invoiceDto.setTotal_tax3(invoiceDto.getTotal_tax3() + invoiceDtl.getTax3());
			//invoiceDto.setDetail(null);
			//invoiceDto.setType(item.get);
			invoiceDto.getInvoceDetails().add(invoiceDtl);
		}
		invoiceDto.setGross_amount(invoiceDto.getTotal_net_amount());
		invoiceDto.setOrder_id(dto.getOrder_id());
		invoiceDto.setInvoice_date(new Timestamp(System.currentTimeMillis()));
		return saveInvoice(invoiceDto);
	}

	private InvoiceDetailDTO getCalculatedInvoice(ItemDTO item) {
		InvoiceDetailDTO dto = new InvoiceDetailDTO();
		dto.setBase_price(item.getBase_price());
		dto.setTax1(calculateTax1(item.getBase_price(), item.getSale_price()));
		dto.setTax2(calculateTax2(item.getBase_price(), item.getSale_price()));
		dto.setTax3(calculateTax3(item.getBase_price(), item.getSale_price()));
		double amount = calculateAmount(item.getBase_price(), dto.getTax1(), dto.getTax2(), dto.getTax3());
		dto.setDiscount(calCulateDiscount(amount, item.getDiscount_percent(), item.getDiscount()));		
		dto.setAmount(amount - dto.getDiscount());
		dto.setNet_amount(calculateNetAmount(dto.getAmount(), item.getQty()));
		dto.setQuanity(item.getQty());
		dto.setProduct_id(item.getId());	
		dto.setProduct_name(item.getItem());
		return dto;
	}

	public static double calCulateDiscount(double totalAmount, double discountPercent, double discountedAmt) {
		double percentAmt = totalAmount * discountPercent * 0.01;
		double discount = BigDecimal.valueOf(percentAmt).doubleValue();
		if(discountedAmt > discount + 1) {
			return discountedAmt;
		}
		return discount;
	}

	public static double calculateNetAmount(double amount, double qty) {
		return amount * qty;
	}

	public static double calculateTax3(double base_price, double sale_price) {
		// TODO later to be calculate from tax data
		return 0;
	}

	public static double calculateTax1(double basePrice, double salePrice) {
		// TODO later to be calculate from tax data
		BigDecimal taxValue = BigDecimal.valueOf((salePrice - basePrice));
		return taxValue.divide(BigDecimal.valueOf(2), 2, RoundingMode.CEILING).doubleValue();
	}
	
	public static double calculateTax2(double basePrice, double salePrice) {
		// TODO later to be calculate from tax data
		BigDecimal taxValue = BigDecimal.valueOf((salePrice - basePrice));
		//taxValue.divide(BigDecimal.valueOf(2.0), 2, RoundingMode.CEILING);
		return taxValue.divide(BigDecimal.valueOf(2), 2, RoundingMode.CEILING).doubleValue();
	}

	public static double calculateAmount(double basePrice, double tax1, double tax2, double tax3) {
		return basePrice + tax1 + tax2 + tax3;
	}
	
	/*
	 * public static void main(String arg[]) { //calculateTax1(10000, 12000);
	 * System.out.println(calculateTax1(10000, 12000)); }
	 */
	
	
	public void stockDeliver(InvoiceDTO dto) { 
		List<ProductStockDTO> stockDtoList = new ArrayList();
		for(InvoiceDetailDTO invoiceDto : dto.getInvoceDetails()) {
		  ProductStockDTO productStockDto =  new ProductStockDTO(); 
		  productStockDto.setProduct_code(invoiceDto.getProduct_id());
		  productStockDto.setStore_id(1L); 
		  productStockDto.setQuanity(invoiceDto.getQuanity());
		  productStockDto.getProductsDelivered().add(addProductDeliverDTO(invoiceDto, dto.getId()));
		  productStockDto.setOther_info(invoiceDto.getOther_info());
		  //productStockDto.setId(0);
		  //productStockDto.setUnit(null);
		  stockDtoList.add(productStockDto);		  
		}
		stockDelegatorService.stockDeliver(stockDtoList); 	  
	 }

	private ProductDeliveredDTO addProductDeliverDTO(InvoiceDetailDTO invoiceDto, long invoiceId) {
		ProductDeliveredDTO productDeliveredDTO = new ProductDeliveredDTO();
		productDeliveredDTO.setProduct_code(invoiceDto.getProduct_id());
		productDeliveredDTO.setRefrence_id(invoiceId);
		productDeliveredDTO.setDelivered_date(Timestamp.from(Instant.now()));
		productDeliveredDTO.setQuanity(invoiceDto.getQuanity());
		productDeliveredDTO.setUnit(invoiceDto.getQuanity_unit());
		productDeliveredDTO.setRefrence_type("SALE");		
		return productDeliveredDTO;
	}
	
	public void stockReceive(InvoiceDTO dto) { 
		List<ProductStockDTO> stockDtoList = new ArrayList();
		for(InvoiceDetailDTO invoiceDto : dto.getInvoceDetails()) {
		  ProductStockDTO productStockDto =  new ProductStockDTO(); 
		  productStockDto.setProduct_code(invoiceDto.getProduct_id());
		  productStockDto.setStore_id(1L); 
		  productStockDto.setQuanity(invoiceDto.getQuanity());
		  productStockDto.getProductsReceived().add(addProductReceivedDTO(invoiceDto, dto.getId()));
		  productStockDto.setOther_info(invoiceDto.getOther_info());
		  //productStockDto.setId(0);
		  //productStockDto.setUnit(null);
		  stockDtoList.add(productStockDto);		  
		}
		stockDelegatorService.stockReceive(stockDtoList); 	  
	 }

	private ProductReceivedDTO addProductReceivedDTO(InvoiceDetailDTO invoiceDto, long invoiceId) {
		ProductReceivedDTO productReceivedDTO = new ProductReceivedDTO();
		productReceivedDTO.setProduct_code(invoiceDto.getProduct_id());
		productReceivedDTO.setRefrence_id(invoiceId);
		productReceivedDTO.setDelivered_date(Timestamp.from(Instant.now()));
		productReceivedDTO.setQuanity(invoiceDto.getQuanity());
		productReceivedDTO.setUnit(invoiceDto.getQuanity_unit());
		productReceivedDTO.setRefrence_type("PURCHASE");		
		return productReceivedDTO;
	}
	 
	
}
