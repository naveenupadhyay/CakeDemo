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
@Table(name="cake_flower_type")
public class CakeFlowerType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3633078753871937676L;
	/*CREATE TABLE `cake_flower_type` (
			  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
			  `flower_type_name` varchar(64) DEFAULT NULL,
			  `image_url` varchar(256) NOT NULL ,
			  `created` timestamp NULL DEFAULT NULL,
			  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
			  PRIMARY KEY (`id`)
			) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
		
		/**
		 * 
		 */
		private int id;
		private String flowerTypeName;
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
	    @Column(name = "flower_type_name")
		public String getFlowerTypeName() {
			return flowerTypeName;
		}
		public void setFlowerTypeName(String flowerTypeName) {
			this.flowerTypeName = flowerTypeName;
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
