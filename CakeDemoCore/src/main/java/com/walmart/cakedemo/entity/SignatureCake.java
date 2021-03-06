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
@Table(name = "signature_cake")
public class SignatureCake implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8794211542935717360L;
	/*
	 * CREATE TABLE `signature_cake` ( `id` int(10) unsigned NOT NULL
	 * AUTO_INCREMENT, `description` varchar(64) DEFAULT NULL, `category`
	 * varchar(18) DEFAULT NULL, `image_url` varchar(256) NOT NULL , `created`
	 * timestamp NULL DEFAULT NULL, `updated` timestamp NOT NULL DEFAULT
	 * CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, PRIMARY KEY (`id`) )
	 * ENGINE=InnoDB AUTO_INCREMENT=10112 DEFAULT CHARSET=utf8;
	 */

	private int id;
	private String description;
	private String category;
	private String imageUrl;
	private Date created;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name="image_url")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name="created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
