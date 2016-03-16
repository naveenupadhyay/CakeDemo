package com.walmart.cakedemo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cake_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1015512845616669429L;
	/*
	 * CREATE TABLE `cake_order` ( `id` int(10) unsigned NOT NULL
	 * AUTO_INCREMENT, `image_url` varchar(256) NOT NULL , `cake_details`
	 * varchar(256) NOT NULL , `status` varchar(48) NOT NULL , `created`
	 * timestamp NULL DEFAULT NULL, `delivered_date` varchar(100) DEFAULT NULL,
	 * `order_total` decimal(9,2) NOT NULL , `mobile` varchar(12) DEFAULT NULL,
	 * `cake_type` varchar(50) DEFAULT NULL, `feedback_details` varchar(128)
	 * DEFAULT NULL, `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON
	 * UPDATE CURRENT_TIMESTAMP, PRIMARY KEY (`id`) ) ENGINE=InnoDB
	 * AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	 */
	private int id;
	private String imageUrl;
	private String cakeDetails;
	private String status;
	private Date created;
	private String deliveredDate;
	private Double orderTotal;
	private String mobile;
	private String cakeType;
	private String feedbackType;

	
	
	public Order() {
		super();
	}

	public Order(String imageUrl, String cakeDetails, Date created, String deliveredDate, Double orderTotal,
			String mobile, String cakeType, String feedbackType) {
		super();
		this.imageUrl = imageUrl;
		this.cakeDetails = cakeDetails;
		this.created = created;
		this.deliveredDate = deliveredDate;
		this.orderTotal = orderTotal;
		this.mobile = mobile;
		this.cakeType = cakeType;
		this.feedbackType = feedbackType;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "cake_details")
	public String getCakeDetails() {
		return cakeDetails;
	}

	public void setCakeDetails(String cakeDetails) {
		this.cakeDetails = cakeDetails;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "delivered_date")
	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Column(name = "order_total")
	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Column(name = "mobile")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "cake_type")
	public String getCakeType() {
		return cakeType;
	}

	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}

	@Column(name = "feedback_type")
	public String getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

}
