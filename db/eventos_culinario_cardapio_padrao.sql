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
-- Table structure for table `cardapio_padrao`
--

DROP TABLE IF EXISTS `cardapio_padrao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardapio_padrao` (
  `cod_tema` int(11) NOT NULL,
  `cod_item` int(11) NOT NULL DEFAULT '0',
  `qtd_itens` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_tema`,`cod_item`),
  KEY `cod_tema` (`cod_tema`),
  KEY `cod_item` (`cod_item`),
  CONSTRAINT `cardapio_padrao_ibfk_1` FOREIGN KEY (`cod_tema`) REFERENCES `tema` (`cod_t`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cardapio_padrao_ibfk_2` FOREIGN KEY (`cod_item`) REFERENCES `item` (`cod_i`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardapio_padrao`
--

LOCK TABLES `cardapio_padrao` WRITE;
/*!40000 ALTER TABLE `cardapio_padrao` DISABLE KEYS */;
INSERT INTO `cardapio_padrao` VALUES (6,10,10),(6,13,10),(6,16,10),(6,18,10),(6,21,10),(6,25,10),(6,26,10),(32,29,1),(32,30,1),(32,31,1),(32,54,1);
/*!40000 ALTER TABLE `cardapio_padrao` ENABLE KEYS */;
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
