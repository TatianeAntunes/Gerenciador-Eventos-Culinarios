-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eventos_culinario
-- ------------------------------------------------------
-- Server version	5.6.15-log

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
-- Table structure for table `ingred_itens_ag`
--

DROP TABLE IF EXISTS `ingred_itens_ag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingred_itens_ag` (
  `cod_item` int(11) NOT NULL,
  `cod_ing` int(11) NOT NULL DEFAULT '0',
  `qtd_ing` decimal(9,3) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`cod_item`,`cod_ing`),
  KEY `cod_ing` (`cod_ing`),
  KEY `cod_item` (`cod_item`),
  CONSTRAINT `ingred_itens_ag_ibfk_1` FOREIGN KEY (`cod_item`) REFERENCES `item` (`cod_i`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ingred_itens_ag_ibfk_2` FOREIGN KEY (`cod_ing`) REFERENCES `ingrediente` (`cod_ing`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingred_itens_ag`
--

LOCK TABLES `ingred_itens_ag` WRITE;
/*!40000 ALTER TABLE `ingred_itens_ag` DISABLE KEYS */;
INSERT INTO `ingred_itens_ag` VALUES (54,4,10.000,7.55),(54,26,10.000,1.99),(54,30,1.000,10.99),(54,45,10.000,2.99),(54,49,2.000,3.45),(54,81,10.000,26.49),(54,83,1.000,22.99),(54,84,2.000,12.59);
/*!40000 ALTER TABLE `ingred_itens_ag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-16  0:29:01
