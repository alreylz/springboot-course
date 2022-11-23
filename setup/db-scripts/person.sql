-- author: @alreylz
CREATE DATABASE IF NOT EXISTS `springboot-course`;
SHOW DATABASES;
USE `springboot-course`;

-- Creamos un procedure llamado printf para añadir logs
DELIMITER ;;
DROP PROCEDURE IF EXISTS printf;
CREATE PROCEDURE printf(thetext TEXT)
BEGIN
    select thetext as ``;
END;
;;
DELIMITER ;

-- Comprobación de la configuración:
-- [!] Vemos qué directorio está accesible para mysql para meter las fotos ahí antes de ejecutar este script
call printf(concat('Put your files at: ', @@GLOBAL.secure_file_priv,
                   ' for them to be accessible. If secure_file_priv is null, then you must overwrite the mysql configuration file.'));
SET @fileDir := @@GLOBAL.secure_file_priv;
-- Creación de tabla

drop table if exists `Person`;
CREATE TABLE IF NOT EXISTS `Person`
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `name`    varchar(15) NOT NULL,
    `surname` varchar(20) NOT NULL,
    `img`     longblob DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- SET @filesFolderPath := "C:\Program Files\MySQL\MySQL Server 8.0\data\cara.jpg" ;
-- select load_file('C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\1.jpg'); -- This one works

-- Imágenes descargadas de https://thispersondoesnotexist.com/
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Juan", "Palomo", load_file(concat(@fileDir, '1.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Ignacio", "Peripecias", load_file(concat(@fileDir, '2.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Manolo", "De la Torre Alta", load_file(concat(@fileDir, '3.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Phillip", "Seriousness", load_file(concat(@fileDir, '4.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Sarah", "Stares", load_file(concat(@fileDir, '5.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Belly", "Kapoor", load_file(concat(@fileDir, '6.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Yaroslav", "Kralinick", load_file(concat(@fileDir, '7.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Pancho", "Cilic", load_file(concat(@fileDir, '8.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Stephanie", "Kaldwin", load_file(concat(@fileDir, '9.jpg')));
INSERT INTO `Person`(`name`, `surname`, `img`)
VALUES ("Cindy", "Nero", load_file(concat(@fileDir, '10.jpg')));
COMMIT;

