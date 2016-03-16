package com.walmart.cakedemo.sro;

import java.util.Date;

public class CakeFlowerTypeSRO {

	
	private int id;
	private String flowerTypeName;
	private String imageUrl;
	private Date created;
	
	
	public CakeFlowerTypeSRO(int id, String flowerTypeName, String imageUrl, Date created) {
		super();
		this.id = id;
		this.flowerTypeName = flowerTypeName;
		this.imageUrl = imageUrl;
		this.created = created;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlowerTypeName() {
		return flowerTypeName;
	}
	public void setFlowerTypeName(String flowerTypeName) {
		this.flowerTypeName = flowerTypeName;
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
