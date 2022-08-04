/**
  * My First MySQL Script - testscript.sql
  * You need to run this scriptwith an authorized user.
 */
    SHOW DATABASES;
    USE seckill;
CREATE TABLE t_user(
   `id` BIGINT(20) NOT NULL COMMENT 'User ID, cellphone',
   `nickname` VARCHAR(255) not NULL,
   `password`  VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass + fixed salt) + salt)',
   `salt` VARCHAR(10) DEFAULT NULL,
   `head` VARCHAR(128) DEFAULT NULL COMMENT 'Avatar',
   `register_date` datetime DEFAULT NULL COMMENT 'Register time',
   `last_login_date` datetime DEFAULT NULL COMMENT 'Time of Last sign-in',
   `login_count` int(11) DEFAULT '0' COMMENT 'sign-in times',
   PRIMARY KEY(`id`)
);
CREATE TABLE `t_goods`(
  `id` BIGINT(20) not null AUTO_INCREMENT COMMENT 'Product ID',
  `goods_name` VARCHAR(16) DEFAULT NULL COMMENT 'Product Name',
  `goods_title` VARCHAR(64) DEFAULT NULL COMMENT 'Product Title',
  `goods_img` VARCHAR(64) DEFAULT NULL COMMENT 'Product Image',
  `goods_detail` LONGTEXT  COMMENT 'Product Description',
  `goods_price` DECIMAL(10, 2) DEFAULT '0.00' COMMENT 'Product Price',
  `goods_stock` INT(11) DEFAULT '0' COMMENT 'Product in stock,-1 represents no limitation',
  PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `t_order` (
   `id` BIGINT(20) NOT NULL  AUTO_INCREMENT COMMENT 'Order ID',
   `user_id` BIGINT(20) DEFAULT NULL COMMENT 'User ID',
   `goods_id` BIGINT(20) DEFAULT NULL COMMENT 'Product ID',
   `delivery_addr_id` BIGINT(20) DEFAULT NULL  COMMENT 'Delivery Address ID',
   `goods_name` VARCHAR(16) DEFAULT NULL  COMMENT 'Product Name',
   `goods_count` INT(20) DEFAULT '0'  COMMENT 'Product Count',
   `goods_price` DECIMAL(10,2) DEFAULT '0.00'  COMMENT 'Product Price',
   `order_channel` TINYINT(4) DEFAULT '0'  COMMENT '1 PC, 2 Android, 3 ios',
   `status` TINYINT(4) DEFAULT '0'  COMMENT 'Order Status，0 Has not pay，1 Already pay，2 Already Delivery，3 Already Receive，4 Already Refund，5 Already Finished',
   `create_date` datetime DEFAULT NULL  COMMENT 'Order Create Time',
   `pay_date` datetime DEFAULT NULL  COMMENT 'Pay Time',
   PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=12 DEFAULT CHARSET = utf8mb4;
