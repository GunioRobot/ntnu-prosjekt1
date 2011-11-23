# phpMyAdmin SQL Dump
# version 2.5.6
# http://www.phpmyadmin.net
#
# Host: mysql.stud.ntnu.no
# Generation Time: Nov 23, 2011 at 06:51 PM
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
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 AUTO_INCREMENT=28 ;

#
# Dumping data for table `addresses`
#

INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (21, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (20, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (5, 'Klæbuveien', 191, 'a', '7037', 'Trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (17, 'hehaha', 2, '\0', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (18, 'Testerveien', 1, '\0', '1234', 'Testerstad', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (10, 'Bragevegen', 12, 'a', '7032', 'Trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (22, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (12, 'bragevegen', 11, 'a', '7032', 'trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (13, 'bragevegen', 11, 'a', '7032', 'trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (14, 'bragevegen', 11, 'a', '7032', 'trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (19, 'Harald Bothners veg', 14, '\0', '', 'Trondheim', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (23, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (24, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (25, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (26, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');
INSERT INTO `addresses` (`id`, `street`, `houseNumber`, `houseLetter`, `zipcode`, `city`, `country`) VALUES (27, 'hehaha', 2, 'a', '1233', 'lolstadchgch', 'NO');

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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

#
# Dumping data for table `orders`
#

INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (1, 12, '2011-11-23 17:48:40', '2011-11-23 17:48:46', '2011-11-23 17:48:47', '', '', 1, 1);
INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (2, 12, '2011-11-23 17:54:43', '2011-11-23 18:03:03', '2011-11-23 18:03:06', '', '', 1, 1);
INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (3, 12, '2011-11-23 18:01:02', '2011-11-23 18:03:02', '2011-11-23 18:03:05', '', '', 1, 1);
INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (4, 12, '2011-11-23 18:01:49', '2011-11-23 18:03:01', '2011-11-23 18:03:06', '', '', 1, 1);
INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (5, 12, '2011-11-23 18:02:50', '2011-11-23 18:03:00', '2011-11-23 18:03:04', '', '', 1, 1);
INSERT INTO `orders` (`id`, `user_id`, `ordered`, `due`, `delivered`, `products`, `comment`, `levering`, `kort`) VALUES (6, 12, '2011-11-23 18:05:15', '2011-11-23 18:05:30', '2011-11-23 18:05:32', '', '', 1, 1);

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
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

#
# Dumping data for table `orders_products`
#

INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (1, 1, 1, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (2, 2, 2, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (3, 5, 2, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (4, 8, 2, 2);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (5, 11, 2, 2);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (6, 14, 2, 2);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (7, 1, 3, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (8, 6, 4, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (9, 6, 5, 1);
INSERT INTO `orders_products` (`id`, `product_id`, `order_id`, `count`) VALUES (10, 6, 6, 1);

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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 AUTO_INCREMENT=21 ;

#
# Dumping data for table `products`
#

INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (1, 'Margharita', 'Ost, tomatsaus og basilikum', '100.00', 0, 1);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (2, 'Vesuvio', 'Tomat, ost og skinke', '115.00', 0, 2);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (3, 'Milano', 'Tomat, ost og pepperoni', '115.00', 0, 3);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (5, 'Trondheim spesial', 'Tomat, ost, biff, løk, mais, ananas og chillisaus', '132.00', 0, 5);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (6, 'Capriciosa', 'Tomat, ost, skinke, sjampinjong', '130.00', 0, 6);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (7, 'Maffiosa', 'Tomat, ost, kebabkjøtt, løk og hvitløkssaus', '130.00', 0, 7);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (8, 'Grozzo', 'Tomat, ost, skinke, biff, pepperoni, kylling og løk', '140.00', 0, 8);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (10, 'Cola', 'Drikkevare', '20.00', 0, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (11, 'Fanta', 'Drikkevare', '20.00', 1, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (12, 'Sprite', 'Drikkevare', '20.00', 0, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (13, 'Cola-Zero', 'Drikkevare', '20.00', 0, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (14, 'BonAqua', 'Drikkevare', '15.00', 0, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (15, 'Vann', 'Drikkevare', '10.00', 1, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (19, 'Vann', 'Mineralvann', '10.00', 0, 0);
INSERT INTO `products` (`id`, `name`, `description`, `price`, `deleted`, `nr`) VALUES (20, 'Calzone', 'Tomat, skinke, ost og løk', '130.00', 0, 9);

# --------------------------------------------------------

#
# Table structure for table `settings`
#

CREATE TABLE `settings` (
  `id` int(11) NOT NULL auto_increment,
  `deliver_price` int(11) NOT NULL,
  `deliver_limit` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

#
# Dumping data for table `settings`
#

INSERT INTO `settings` (`id`, `deliver_price`, `deliver_limit`) VALUES (1, 50, 9001);

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
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

#
# Dumping data for table `users`
#

INSERT INTO `users` (`id`, `name`, `phone`, `address_id`, `created`) VALUES (12, 'agnus', '1', 17, '2011-11-23 11:52:14');
INSERT INTO `users` (`id`, `name`, `phone`, `address_id`, `created`) VALUES (13, 'Tester', '12', 18, '2011-11-23 13:42:39');
INSERT INTO `users` (`id`, `name`, `phone`, `address_id`, `created`) VALUES (14, 'Magnus Line', '12345678', 19, '2011-11-23 14:00:33');
