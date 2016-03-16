package com.walmart.cakedemo.model.response;

import java.io.Serializable;

public class SubmitOrderResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4123875217054456783L;
	
	public int orderCode;
	public String message;
	
	
	public int getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
