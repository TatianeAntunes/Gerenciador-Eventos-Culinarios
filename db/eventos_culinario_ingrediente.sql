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
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingrediente` (
  `cod_ing` int(11) NOT NULL AUTO_INCREMENT,
  `nome_ing` varchar(225) DEFAULT NULL,
  `un_med_ing` varchar(255) DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`cod_ing`),
  UNIQUE KEY `nome_ing_UNIQUE` (`nome_ing`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (2,'ovo','cartela',9.99),(4,'cebola','grama',7.55),(5,'carne de panela','kg',15.99),(6,'lombo canadense','grama',3.99),(8,'mussarela','grama',3.99),(9,'presunto','grama',15.99),(16,'provolone','grama',35.59),(17,'bacon','grama',2.89),(24,'ervilhas','grama',2.99),(25,'salame','grama',49.99),(26,'cheiro-verde','grama',1.99),(27,'maçã','kg',4.99),(28,'mel','grama',20.00),(30,'tomate seco','Litro',10.99),(33,'cravo','grama',4.89),(34,'feijão','kg',4.99),(36,'tomate cereja','kg',7.59),(37,'soco de laranja','litro',15.49),(38,'milho','kg',2.59),(39,'tomate salada','kg',3.99),(40,'peito de perú','grama',5.55),(42,'lentilha','kg',7.99),(44,'pimenta','kg',15.99),(45,'cenoura','kg',2.99),(49,'rúcula','pé',3.45),(52,'berinjela ','kg',3.99),(55,'nozes','grama',12.99),(57,'coco','kg',4.55),(58,'coco ralado','grama',3.78),(59,'vinho branco ','garrafa',35.99),(66,'ovo de codorna','unidade',0.59),(67,'doce de leite','grama',3.25),(76,'carne moida','kg',3.89),(77,'tilápia','kg',9.99),(79,'biscoito de chocolate','pacote',6.89),(80,'pera','kg',7.59),(81,'carneiro','kg',26.49),(83,'sake','garrafa',22.99),(84,'vinagre','500 ml',12.59),(85,'feijão preto','kg',8.59),(86,'torresmo','pacote 100g',15.00),(92,'requeijão','pote',3.99),(94,'queijo','grama',15.89),(108,'picanha','kg',29.89),(115,'abacate','kg',1.99),(116,'hotelã','maço',1.99);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-16  0:29:00
