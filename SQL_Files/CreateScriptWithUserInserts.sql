
CREATE SCHEMA IF NOT EXISTS `lego` ;
USE lego;

DROP TABLE IF EXISTS `lego`.`order_details`;
DROP TABLE IF EXISTS `lego`.`orders`;
DROP TABLE IF EXISTS `lego`.`users`;


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
  `length` INT NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  `door` BOOLEAN NOT NULL DEFAULT FALSE,
  `window` BOOLEAN NOT NULL DEFAULT FALSE,
  
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC) VISIBLE,
  INDEX `id_user_idx` (`id_user` ASC) VISIBLE,
  CONSTRAINT `id_user`
    FOREIGN KEY (`id_user`)
    REFERENCES `lego`.`users` (`id_user`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

INSERT INTO `lego`.`users` (`email`, `password`, `role`) VALUES ('cust@test.dk', '1234', 'customer');
INSERT INTO `lego`.`users` (`email`, `password`, `role`) VALUES ('emp@test.dk', '1234', 'employee');






