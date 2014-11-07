# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : DB_Electrodomesticos


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `DB_Electrodomesticos`;

CREATE DATABASE `DB_Electrodomesticos`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `DB_Electrodomesticos`;

#
# Structure for the `color` table : 
#

CREATE TABLE `color` (
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY  (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `consumo` table : 
#

CREATE TABLE `consumo` (
  `tipo` varchar(1) NOT NULL,
  `precio` double(15,3) default NULL,
  PRIMARY KEY  (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `electrodomestico` table : 
#

CREATE TABLE `electrodomestico` (
  `id_Electrodomestico` int(11) NOT NULL auto_increment,
  `tipo_Electrodomestico` varchar(20) NOT NULL,
  `precio` double(15,3) NOT NULL,
  `peso` double(15,3) NOT NULL,
  `carga` double(15,3) default NULL,
  `sintonizador` tinyint(1) default NULL,
  `resolucion` int(11) default NULL,
  `color` varchar(20) NOT NULL,
  `consumo` varchar(1) NOT NULL,
  PRIMARY KEY  (`id_Electrodomestico`),
  KEY `color` (`color`),
  KEY `consumo` (`consumo`),
  CONSTRAINT `elec-color` FOREIGN KEY (`color`) REFERENCES `color` (`nombre`) ON UPDATE CASCADE,
  CONSTRAINT `elec-con` FOREIGN KEY (`consumo`) REFERENCES `consumo` (`tipo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for the `color` table  (LIMIT 0,500)
#

INSERT INTO `color` (`nombre`) VALUES 
  ('azul'),
  ('blanco'),
  ('gris'),
  ('negro'),
  ('rojo');

COMMIT;

#
# Data for the `consumo` table  (LIMIT 0,500)
#

INSERT INTO `consumo` (`tipo`, `precio`) VALUES 
  ('A',100),
  ('B',80),
  ('C',60),
  ('D',50),
  ('E',30),
  ('F',10);

COMMIT;

#
# Data for the `electrodomestico` table  (LIMIT 0,500)
#

INSERT INTO `electrodomestico` (`id_Electrodomestico`, `tipo_Electrodomestico`, `precio`, `peso`, `carga`, `sintonizador`, `resolucion`, `color`, `consumo`) VALUES 
  (1,'television',5000,20,NULL,0,21,'blanco','A'),
  (4,'lavarropas',200,7,6,NULL,NULL,'rojo','E');

COMMIT;

