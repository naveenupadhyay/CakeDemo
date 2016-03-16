package com.walmart.cakedemo.sro;

import java.util.Date;

public class SignatureCakeSRO {


	private int id;
	private String description;
	private String category;
	private String imageUrl;
	private Date created;
	
	
	public SignatureCakeSRO(int id, String description, String category, String imageUrl, Date created) {
		super();
		this.id = id;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
		this.created = created;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
