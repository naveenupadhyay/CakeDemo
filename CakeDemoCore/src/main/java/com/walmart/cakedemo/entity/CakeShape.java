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
@Table(name="cake_shape")
public class CakeShape implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 953266571246899885L;
/*
 * CREATE TABLE `signature_cake` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `category` varchar(18) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10112 DEFAULT CHARSET=utf8;
 */
	


	/**
	 * 
	 */
		private int id;
		private String cakeShape;
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
		
		@Column(name = "shape")
		public String getCakeShape() {
			return cakeShape;
		}
		public void setCakeShape(String cakeShape) {
			this.cakeShape = cakeShape;
		}
		@Column(name = "image_url")
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		
	    @Column(name = "created")
		public Date getCreated() {
			return created;
		}
		public void setCreated(Date created) {
			this.created = created;
		}
		
	
}
