package com.walmart.cakedemo.sro;

import java.util.Date;

public class CakeIcingFlavorSRO {

	private int id;
	private String icingFlavorName;
	private String imageUrl;
	private Date created;
	
	
	
	public CakeIcingFlavorSRO(int id, String icingFlavorName, String imageUrl, Date created) {
		super();
		this.id = id;
		this.icingFlavorName = icingFlavorName;
		this.imageUrl = imageUrl;
		this.created = created;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcingFlavorName() {
		return icingFlavorName;
	}
	public void setIcingFlavorName(String icingFlavorName) {
		this.icingFlavorName = icingFlavorName;
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
