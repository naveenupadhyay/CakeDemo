package com.walmart.cakedemo.sro;

import java.util.Date;

public class CakeShapeSRO {

	private int id;
	private String cakeShape;
	private String imageUrl;
	private Date created;
	
	
	public CakeShapeSRO(int id, String cakeShape, String imageUrl, Date created) {
		super();
		this.id = id;
		this.cakeShape = cakeShape;
		this.imageUrl = imageUrl;
		this.created = created;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCakeShape() {
		return cakeShape;
	}
	public void setCakeShape(String cakeShape) {
		this.cakeShape = cakeShape;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
