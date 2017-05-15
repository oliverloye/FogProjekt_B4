# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.16)
# Database: FOG
# Generation Time: 2017-05-15 07:41:09 +0000
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
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `customer_email_uindex` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;

INSERT INTO `customer` (`cid`, `firstname`, `lastname`, `address`, `email`, `phone`)
VALUES
	(11,'Oliver','LÃ?Â¸ye','Ordrupvej','oliver@loye.dk','11111111'),
	(12,'djsalkdjasl','dajlksdjsal','djasldjal','djsakldjkasl',''),
	(13,'jdksa','hdakjsnk','','nlndals','dnaslno'),
	(14,'a','r','Vej 7','a@gmail.com','12345678'),
	(15,'Victor','Larsen','Skovbakkevej 17','victor@larsen.dk','99775522'),
	(16,'Olle','Bolle','ollekollevej 1','bolle@olle.dk','87654321');

/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table materials
# ------------------------------------------------------------

DROP TABLE IF EXISTS `materials`;

CREATE TABLE `materials` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` double NOT NULL,
  `stock` int(100) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;

INSERT INTO `materials` (`mid`, `name`, `price`, `stock`)
VALUES
	(1,'Søm',1.5,999),
	(2,'Bjælke',50,999),
	(3,'Tag',75,999),
	(4,'Brædder',25,999);

/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Order`;

CREATE TABLE `Order` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `status` int(3) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `length` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `Relevant` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`oid`),
  KEY `cid FK#_idx` (`cid`),
  CONSTRAINT `cid FK` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

LOCK TABLES `Order` WRITE;
/*!40000 ALTER TABLE `Order` DISABLE KEYS */;

INSERT INTO `Order` (`oid`, `cid`, `status`, `height`, `length`, `width`, `Relevant`)
VALUES
	(12,11,NULL,250,400,300,0),
	(13,11,NULL,111,333,222,1),
	(14,12,NULL,123,123,123,1),
	(15,13,NULL,213,2312,123,1),
	(16,11,NULL,321,763,452,1),
	(17,11,NULL,125.5,450.25,370.5,1),
	(18,14,NULL,200,400,300,1),
	(19,14,NULL,200,400,300,1),
	(20,15,NULL,280,400,300,1),
	(21,16,NULL,100,100,100,1);

/*!40000 ALTER TABLE `Order` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
