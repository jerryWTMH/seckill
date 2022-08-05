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

CREATE TABLE `t_seckill_goods`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Seckill Product ID',
  `goods_id` BIGINT(20) NOT NULL COMMENT 'Product ID',
  `seckill_price` DECIMAL(10,2) NOT NULL COMMENT 'Seckill Price',
  `stock_count` INT(10) NOT NULL  COMMENT 'The Number in stock',
  `start_date` datetime NOT NULL  COMMENT 'Seckill Start Time',
  `end_date` datetime NOT NULL COMMENT 'Seckill End Time',
  PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=3 DEFAULT CHARSET = utf8mb4;

CREATE TABLE `t_seckill_order` (
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'Seckill Order ID',
   `user_id` BIGINT(20) NOT NULL  COMMENT 'User ID',
   `order_id` BIGINT(20) NOT NULL  COMMENT 'Order ID',
   `goods_id` BIGINT(20) NOT NULL  COMMENT 'Product ID',
   PRIMARY KEY(`id`)
)ENGINE = INNODB AUTO_INCREMENT=3 DEFAULT CHARSET = utf8mb4;

INSERT INTO `t_goods` VALUES(1, 'iPhone13', 'iPhone13 128GB', '/img/Apple_iPhone13.jpg', 'iPhone13 128 GB Pink Color', '999.99', 100),(2, 'iPhone 13 Pro', 'iPhone13 Pro 256GB', '/img/Apple_iPhone13_Pro.jpg', 'iPhone13 256 GB Multiple Colors', '1299.99', 50);

INSERT INTO `t_seckill_goods` VALUES(1, 1,'599.99', 20, '2021-12-25 08:00:00', '2021-12-25 09:00:00'), (2, 2,'899.99', 10, '2021-12-25 08:00:00', '2021-12-25 09:00:00');

SELECT
    g.id,
    g.goods_name,
    g.goods_title,
    g.goods_img,
    g.goods_detail,
    g.goods_price,
    g.goods_stock,
    sg.seckill_price,
    sg.stock_count,
    sg.start_date,
    sg.end_date
    FROM t_goods g LEFT JOIN t_seckill_goods AS sg ON g.id = sg.goods_id;