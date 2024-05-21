CREATE TABLE `Menu` (
  `dish_id` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`dish_id`) USING HASH,
  UNIQUE KEY `dish_name` (`dish_name`) USING HASH
);
CREATE TABLE `User` (
  `user_id` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `phone` bigint(11) NOT NULL,
  `table` int(2) DEFAULT NULL,
  `people` int(2) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING HASH,
  KEY `phone` (`phone`) USING HASH
);
CREATE TABLE `Orders` (
  `order_id` bigint(12) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `prefer` varchar(255) DEFAULT NULL,
  `time` datetime NOT NULL,
  `dish_list` text NOT NULL,
  `user_id` int(8) unsigned NOT NULL,
  `complete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`) USING HASH,
  CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE `Staff` (
  `staff_id` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) NOT NULL,
  `order_id` bigint(12) unsigned DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`staff_id`) USING HASH,
  UNIQUE KEY `order_id` (`order_id`) USING HASH,
  CONSTRAINT `Staff_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `Orders` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);