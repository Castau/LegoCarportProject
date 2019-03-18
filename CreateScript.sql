CREATE SCHEMA IF NOT EXISTS `lego` ;
USE lego;

DROP TABLE IF EXISTS `lego`.`users`;
DROP TABLE IF EXISTS `lego`.`orders`;
DROP TABLE IF EXISTS `lego`.`order_details`;


CREATE TABLE `lego`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` ENUM('customer', 'employee') NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);



CREATE TABLE `lego`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `order_status` VARCHAR(45) NOT NULL DEFAULT 'NOT SHIPPED',
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC) VISIBLE,
  INDEX `id_user_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `lego`.`users` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


CREATE TABLE `lego`.`order_details` (
  `id_order_details` INT NOT NULL AUTO_INCREMENT,
  `id_order` INT NOT NULL,
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  PRIMARY KEY (`id_order_details`),
  UNIQUE INDEX `id_order_details_UNIQUE` (`id_order_details` ASC) VISIBLE,
  INDEX `id_order_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `id_order`
    FOREIGN KEY (`id_order`)
    REFERENCES `lego`.`orders` (`id_order`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);