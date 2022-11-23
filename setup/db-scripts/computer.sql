-- author: @alreylz
CREATE DATABASE IF NOT EXISTS `springboot-course`;
SHOW DATABASES;
USE `springboot-course`;

-- Tabla computers
CREATE TABLE IF NOT EXISTS `springboot-course`.`computers`
(
    `id`    INT         NOT NULL AUTO_INCREMENT,
    `brand` VARCHAR(45) NULL,
    `model` VARCHAR(45) NULL,
    `price` FLOAT       NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- Datos de ejemplo
INSERT INTO `springboot-course`.`computers` (`id`, `brand`, `model`, `price`)
VALUES (1, 'Dell', 'XPS 15', 2199);
INSERT INTO `springboot-course`.`computers` (`id`, `brand`, `model`, `price`)
VALUES (2, 'Apple', 'Macbook pro 13', 1299);
INSERT INTO `springboot-course`.`computers` (`id`, `brand`, `model`, `price`)
VALUES (3, 'HP', 'Omen Gaming Laptop', 1539);
INSERT INTO `springboot-course`.`computers` (`id`, `brand`, `model`, `price`)
VALUES (4, 'Lenovo', 'ThinkPad X1', 1164.50);
INSERT INTO `springboot-course`.`computers` (`id`, `brand`, `model`, `price`)
VALUES (5, 'Microsoft', 'Surface Pro 9', 999.0);