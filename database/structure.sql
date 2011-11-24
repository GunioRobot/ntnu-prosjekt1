# phpMyAdmin SQL Dump
# version 2.5.6
# http://www.phpmyadmin.net
#
# Host: mysql.stud.ntnu.no
# Generation Time: Nov 23, 2011 at 06:54 PM
# Server version: 5.0.51
# PHP Version: 5.2.4-2ubuntu5.18
# 
# Database : `tordly_gjestebok`
# 

# --------------------------------------------------------

#
# Table structure for table `addresses`
#

CREATE TABLE `addresses` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `street` varchar(255) NOT NULL,
  `houseNumber` int(10) unsigned NOT NULL,
  `houseLetter` char(1) NOT NULL,
  `zipcode` varchar(12) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` char(2) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

# --------------------------------------------------------

#
# Table structure for table `orders`
#

CREATE TABLE `orders` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `user_id` int(11) unsigned NOT NULL,
  `ordered` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `due` timestamp NULL default NULL,
  `delivered` timestamp NULL default NULL,
  `products` varchar(255) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `levering` tinyint(1) NOT NULL,
  `kort` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

# --------------------------------------------------------

#
# Table structure for table `orders_products`
#

CREATE TABLE `orders_products` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `product_id` int(10) unsigned NOT NULL,
  `order_id` int(10) unsigned NOT NULL,
  `count` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

# --------------------------------------------------------

#
# Table structure for table `products`
#

CREATE TABLE `products` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `deleted` tinyint(1) unsigned NOT NULL default '0',
  `nr` tinyint(2) unsigned NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

# --------------------------------------------------------

#
# Table structure for table `settings`
#

CREATE TABLE `settings` (
  `id` int(11) NOT NULL auto_increment,
  `deliver_price` int(11) NOT NULL,
  `deliver_limit` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

# --------------------------------------------------------

#
# Table structure for table `users`
#

CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `address_id` int(10) unsigned NOT NULL,
  `created` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
