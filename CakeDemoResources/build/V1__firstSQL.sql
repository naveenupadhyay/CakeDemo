-- TODO after adding flyway in pom

CREATE TABLE `cakedemo_property` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(48) NOT NULL,
  `value` varchar(256) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `access_control` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_code_csv` varchar(64) NOT NULL,
  `url_prefix` varchar(200) NOT NULL,
  `feature` varchar(100) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `created` datetime NOT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code_csv` (`role_code_csv`,`url_prefix`),
  KEY `enabled` (`enabled`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(64) NOT NULL,
  `description` varchar(64) DEFAULT NULL,
  `parent_role_code` varchar(64) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `default_url` varchar(256) NOT NULL DEFAULT '/inbound',
  `created` timestamp NULL DEFAULT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `email_verified` tinyint(1) NOT NULL DEFAULT '0',
  `display_name` varchar(48) DEFAULT NULL,
  `first_name` varchar(48) DEFAULT NULL,
  `middle_name` varchar(48) DEFAULT NULL,
  `last_name` varchar(48) DEFAULT NULL,
  `email_verification_code` varchar(48) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_index` (`email`(255))
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_code` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `created` timestamp NULL DEFAULT NULL,
  `last_updated` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_user_role` (`user_id`),
  KEY `FK_role_user_role` (`role_code`),
  KEY `enabled` (`enabled`),
  CONSTRAINT `FK_role_user_role` FOREIGN KEY (`role_code`) REFERENCES `role` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_to_user_role` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cakedemo_pdf_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `template` longtext NOT NULL,
  `created` datetime DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE `signature_cake` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `category` varchar(18) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10112 DEFAULT CHARSET=utf8;

CREATE TABLE `cake_shape` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shape` varchar(64) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE `cake_icing_flavours` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `flavor_name` varchar(64) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cake_decorator_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `decorator_type_name` varchar(64) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE `cake_flower_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `flower_type_name` varchar(64) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cake_border_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `border_type_name` varchar(64) DEFAULT NULL,
  `image_url` varchar(256) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `cake_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `image_url` varchar(256) NOT NULL ,
  `cake_details` varchar(256) NOT NULL ,
  `status` varchar(48) NOT NULL ,
  `created` timestamp NULL DEFAULT NULL,
  `delivered_date` varchar(100) DEFAULT NULL,
  `order_total` decimal(9,2) NOT NULL ,
   `mobile` varchar(12) DEFAULT NULL,
   `cake_type` varchar(50) DEFAULT NULL,
    `feedback_details` varchar(128) DEFAULT NULL,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;






