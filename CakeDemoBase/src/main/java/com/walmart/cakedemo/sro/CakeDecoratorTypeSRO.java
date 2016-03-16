package com.walmart.cakedemo.sro;

import java.util.Date;

public class CakeDecoratorTypeSRO {

	private int id;
	private String decoratorTypeName;
	private String imageUrl;
	private Date created;
	
	
	public CakeDecoratorTypeSRO(int id, String decoratorTypeName, String imageUrl, Date created) {
		super();
		this.id = id;
		this.decoratorTypeName = decoratorTypeName;
		this.imageUrl = imageUrl;
		this.created = created;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDecoratorTypeName() {
		return decoratorTypeName;
	}
	public void setDecoratorTypeName(String decoratorTypeName) {
		this.decoratorTypeName = decoratorTypeName;
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
