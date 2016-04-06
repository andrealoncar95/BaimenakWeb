CREATE DATABASE  IF NOT EXISTS `baimenak` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `baimenak`;
-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: baimenak
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.15.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `baimenak`
--

DROP TABLE IF EXISTS `baimenak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baimenak` (
  `idbaimenak` int(11) NOT NULL AUTO_INCREMENT,
  `baimenaIzena` varchar(45) NOT NULL,
  `Kokalekua` varchar(45) NOT NULL,
  `EraikuntzaLanenKostua` varchar(45) NOT NULL,
  `BaimenarenKostua` varchar(45) NOT NULL,
  `EskatzaileId` int(11) NOT NULL,
  PRIMARY KEY (`idbaimenak`,`EskatzaileId`),
  KEY `iduser_idx` (`EskatzaileId`),
  CONSTRAINT `iduser` FOREIGN KEY (`EskatzaileId`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baimenak`
--

LOCK TABLES `baimenak` WRITE;
/*!40000 ALTER TABLE `baimenak` DISABLE KEYS */;
INSERT INTO `baimenak` VALUES (1,'Egongela','Santa Eulalia 43 10C','300','30.0',1),(2,'Komuna','Mungia','200','20',1),(3,'Egongela','Santa Eulalia 43 10C','300','30.0',1),(4,'Egongela','Santa Eulalia 43 10C','300','30.0',1),(5,'Egongela','Santa Eulalia 43 10C','300','30.0',1),(7,'Egongela','Santa Eulalia 43 10C','600','60.0',6),(8,'baimena','amore','1000000','100000.0',18),(9,'Egongela','Itxaropena 13','300','30.0',19),(10,'baimen','etxea','100000000','1.0E7',21);
/*!40000 ALTER TABLE `baimenak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `izenAbizen` varchar(45) NOT NULL,
  `1abizena` varchar(45) NOT NULL,
  `2abizena` varchar(45) NOT NULL,
  `NIF` varchar(45) NOT NULL,
  `Helbidea` varchar(45) NOT NULL,
  `Telefonoa` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `NIF_UNIQUE` (`NIF`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'andrealoncar95@gmail.com','1234','Andrea','Alonso','Carton','11111111A','Santa Eulalia','5555555555'),(3,'antton@hotmail.es','1234','Antton','Ojanguren','Asolo','22222222B','Antonio Alzaga',NULL),(6,'andrea@gmail.es','12345','Andrea','Asolo','Ojanguren','33333333B','Capitan Mendizabal 34',NULL),(7,'andrea','1234','Andrea','Alonso','Carton','77777890B','Santa Eulalia',NULL),(8,'proba@proba.com','1234','Proba','Proba2','Proba3','x','x',NULL),(18,'edu@edu','edu','edu','edu','edu','edu','edu','edu'),(19,'proba','proba','proba','proba','proba','11111190v','Santurtzi','null'),(20,'ines@zuru.es','1234','Eu','Ines','Andrea','22222','Santurtzi','null'),(21,'antton.o.a.10@gmail.com','kaka','antton','antton','antton','1234','kalea','null');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUser`(in izena varchar(45),in abizen1 varchar(45),in abizen2 varchar(45),in NIF varchar(45)
,in helbide varchar(45),in tlf varchar(15), in id int(11))
BEGIN
IF izena != "" THEN
UPDATE baimenak.user SET `izenAbizen` = izena WHERE `iduser` = id;
END IF;
IF abizen1 != "" THEN
UPDATE baimenak.user SET `1abizena` = abizen1 WHERE `iduser` = id;
END IF;
IF abizen2 != "" THEN
UPDATE baimenak.user SET `2abizena` = abizen2 WHERE `iduser` = id;
END IF;
IF NIF != "" THEN
UPDATE baimenak.user SET `NIF` = NIF WHERE `iduser` = id;
END IF;
IF helbide != "" THEN
UPDATE baimenak.user SET `Helbidea` = helbide WHERE `iduser` = id;
END IF;
IF tlf != "" THEN
UPDATE baimenak.user SET `Telefonoa` = tlf WHERE `iduser` = id;
END IF;
END



CREATE DEFINER=`root`@`localhost` PROCEDURE `updatePass`(in email varchar(45),in pass varchar(45), 
in id int(11))
BEGIN
IF email != "" THEN
UPDATE baimenak.user SET `email` = email WHERE `iduser` = id;
END IF;
IF pass != "" THEN
UPDATE baimenak.user SET `password` = pass WHERE `iduser` = id;
END IF;
END



CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBaimena`(in izena varchar(45),in kokalekua varchar(45),
in kostuaE varchar(45),in kostuaB varchar(45), in idB int(11), in idE int(11))
BEGIN
IF izena != "" THEN
UPDATE baimenak.baimenak SET `baimenaIzena` = izena WHERE `idbaimenak` = idB
AND `EskatzaileId` = idE;
END IF;
IF kokalekua != "" THEN
UPDATE baimenak.baimenak SET `Kokalekua` = kokalekua WHERE `idbaimenak` = idB
AND `EskatzaileId` = idE;
END IF;
IF kostuaE != "" THEN
UPDATE baimenak.baimenak SET `EraikuntzaLanenKostua` = kostuaE WHERE `idbaimenak` = idB
AND `EskatzaileId` = idE;
END IF;
IF kostuaB != "" THEN
UPDATE baimenak.baimenak SET `BaimenarenKostua` = kostuaB WHERE `idbaimenak` = idB
AND `EskatzaileId` = idE;
END IF;
END

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-06 12:16:29
