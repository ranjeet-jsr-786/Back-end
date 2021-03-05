package com.cloudaidatastream.shoppingmart.service.serviceimpl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudaidatastream.shoppingmart.dto.OrdersDTO;
import com.cloudaidatastream.shoppingmart.dto.ProductOrderDTO;
import com.cloudaidatastream.shoppingmart.enums.ProductStatus;
import com.cloudaidatastream.shoppingmart.exceptions.DataNotFoundException;
import com.cloudaidatastream.shoppingmart.models.Orders;
import com.cloudaidatastream.shoppingmart.models.ProductOrder;
import com.cloudaidatastream.shoppingmart.repositories.OrderRepository;
import com.cloudaidatastream.shoppingmart.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	private static final String SHOP_NUMBER = "S1";

    @Autowired
    private OrderRepository orderRepository;
    
    @Transactional
    @Override
    public String placeOrder(OrdersDTO dto) throws DataNotFoundException {
		if (dto == null) {
			throw new DataNotFoundException("Data not found to plsce the order");
		}
		Orders order = null;
		Optional<Orders> orderOpt = orderRepository.findById(dto.getOrder_num());
		if (!orderOpt.isPresent()) {
			order = new Orders();
			order.setCreate_date(new Timestamp(System.currentTimeMillis()));
		} else {
			order = orderOpt.get();
		}
		BeanUtils.copyProperties(dto, order);
		setProductOrderDetails(dto, order);
		orderRepository.save(order);
		return "SUCCESS";
    }

	private void setProductOrderDetails(OrdersDTO dto, Orders order) {
		for (ProductOrderDTO prdOrderDTO : dto.getProductOrders()) {
			ProductOrder prdOrd = null;
			if(prdOrderDTO.getId() == 0) {
				prdOrd = new ProductOrder();
				order.getProductOrders().add(prdOrd);
			} else {
				Optional<ProductOrder> prdOrdOpt = order.getProductOrders().stream()
						.filter(p -> p.getId() == prdOrderDTO.getId()).findFirst();
				prdOrd = prdOrdOpt.get();
			}
			prdOrd.setAmount(prdOrderDTO.getAmount());
			prdOrd.setProduct_id(prdOrderDTO.getProduct_id());
			prdOrd.setPrice(prdOrderDTO.getPrice());
			prdOrd.setOrderNumber(order);
			prdOrd.setQuanity_unit(prdOrderDTO.getQuanity_unit());
			prdOrd.setQuanity(prdOrderDTO.getQuanity());
			prdOrd.setStatus(ProductStatus.valueOf("Ordered"));
			// BeanUtils.copyProperties(prdOrd, prdOrderDTO);
			prdOrd.setOrderNumber(order);			
			//prdOrd.setCreate_date(new Timestamp(System.currentTimeMillis()));
		}
	}
    
    @Override
    public String generateOrderNumber(Locale locale) {
    	 Calendar calender = Calendar.getInstance(locale);
    	 StringBuilder buffer = new StringBuilder(SHOP_NUMBER);
    	 buffer.append("-")
    	.append(orderRepository.count())
    	.append("-")
    	.append(calender.get(Calendar.YEAR))
    	.append(calender.get(Calendar.MONTH))
    	.append(calender.get(Calendar.DATE))
    	.append("-")
    	.append(calender.get(Calendar.HOUR))
    	.append(calender.get(Calendar.MINUTE));    	
    return buffer.toString();	
    }

    @Override
    public ProductOrder findByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<ProductOrder> findByUserId(Long userId) {
        return null;
    }

    @Override
    public ProductOrder updateOrder(ProductOrder dto, Long orderId) {
        return null;
    }

    @Override
    public String cancelOrder(Long orderId) {
        return null;
    }
}
