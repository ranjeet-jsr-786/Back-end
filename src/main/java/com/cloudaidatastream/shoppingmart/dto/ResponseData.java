package com.cloudaidatastream.shoppingmart.dto;

public class ResponseData {
	
	private Object data;
	
	public ResponseData() {
		
	}
	
	public ResponseData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
