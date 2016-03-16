package com.walmart.cakedemo.sro;

import java.util.Date;

public class CakeBorderTypeSRO {

	
	private int id;
	private String borderTypeName;
	private String imageUrl;
	private Date created;
	
	public CakeBorderTypeSRO(int id, String borderTypeName, String imageUrl, Date created) {
		super();
		this.id = id;
		this.borderTypeName = borderTypeName;
		this.imageUrl = imageUrl;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorderTypeName() {
		return borderTypeName;
	}

	public void setBorderTypeName(String borderTypeName) {
		this.borderTypeName = borderTypeName;
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
