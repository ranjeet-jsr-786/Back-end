package com.cloudaidatastream.shoppingmart.dto;

import java.util.HashSet;
import java.util.Set;

public class LineItemDTO {
	
	private Set<ItemDTO> lineItems = new HashSet<ItemDTO>();
	private String order_id;

	public Set<ItemDTO> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<ItemDTO> lineItems) {
		this.lineItems = lineItems;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	

}
