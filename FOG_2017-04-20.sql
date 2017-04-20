# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: FOG
# Generation Time: 2017-04-20 13:26:27 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`cid`, `firstname`, `lastname`, `address`, `email`, `phone`)
VALUES
	(1,'Oliver','Løye','Ordrupvej','ol@ol.dk','1234678'),
	(2,'Torsdag','eftermiddag','fkdsfjsdlk','kdakfsdÃ¦','12345678'),
	(3,'dsad','hkjhk','hkjhkh','khjkjhk','hkhk'),
	(4,'123','456','jdjalskdjla 16','djsalk@dkasl.dk','87654321'),
	(5,'Ulle','Max','Ã?blevej 123','ulle@me.com','21314151'),
	(6,'Oliver Max','LÃ¸ye','Ordrupvej 76','oliver@loye.dk','22657515');

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table materials
# ------------------------------------------------------------

DROP TABLE IF EXISTS `materials`;

CREATE TABLE `materials` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `stock` int(100) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;

INSERT INTO `materials` (`mid`, `name`, `stock`)
VALUES
	(1,'Søm',100);

/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Order`;

CREATE TABLE `Order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `Relevant` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`oid`),
  KEY `cid FK#_idx` (`cid`),
  KEY `pid FK#_idx` (`pid`),
  KEY `mid FK#_idx` (`mid`),
  CONSTRAINT `cid FK` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mid FK` FOREIGN KEY (`mid`) REFERENCES `materials` (`mid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pid FK` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;

INSERT INTO `Order` (`oid`, `cid`, `pid`, `mid`, `status`, `height`, `length`, `width`, `Relevant`)
VALUES
	(1,1,1,1,0,100,100,100,1),
	(4,3,NULL,NULL,NULL,1400,1300,15000,0),
	(5,4,NULL,NULL,NULL,270,300,180,0),
	(6,5,NULL,NULL,NULL,200,350,250,0),
	(7,6,NULL,NULL,NULL,220,350,250,1);

/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `model` int(3) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;

INSERT INTO `product` (`pid`, `model`)
VALUES
	(1,1);

/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
