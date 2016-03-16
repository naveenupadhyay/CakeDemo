package com.walmart.cakedemo.model.request;

import java.io.Serializable;
import java.util.Date;

public class SubmitOrderRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8507708679291495038L;
	private Integer orderCode;
	private String imageUrl;
	private String cakeDetails;
	private String status;
	private String deliveredDate;
	private Double orderTotal;
	private String mobile;
	private String cakeType;
	private String feedbackType;
	
	
	
	public SubmitOrderRequest() {
		super();
	}
	
	public SubmitOrderRequest(String imageUrl, String cakeDetails, String status,  String deliveredDate,
			Double orderTotal, String mobile, String cakeType, String feedbackType) {
		super();
		this.imageUrl = imageUrl;
		this.cakeDetails = cakeDetails;
		this.status = status;
		this.deliveredDate = deliveredDate;
		this.orderTotal = orderTotal;
		this.mobile = mobile;
		this.cakeType = cakeType;
		this.feedbackType = feedbackType;
	}
	
	public Integer getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Integer orderCode) {
		this.orderCode = orderCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCakeDetails() {
		return cakeDetails;
	}
	public void setCakeDetails(String cakeDetails) {
		this.cakeDetails = cakeDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCakeType() {
		return cakeType;
	}
	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}
	public String getFeedbackType() {
		return feedbackType;
	}
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	
	
	
}
