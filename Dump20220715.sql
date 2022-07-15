CREATE DATABASE  IF NOT EXISTS `boca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `boca`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: boca
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `idjugadores` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  `edad` tinyint NOT NULL,
  `pais` varchar(50) NOT NULL,
  `cotizacion` double NOT NULL,
  PRIMARY KEY (`idjugadores`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'ROSSI Agustin','arquero',26,'Argentina',3500000),(2,'GARCIA Javier','arquero',35,'Argentina',100000),(3,'ADVINCULA Luis','lateral-derecho',32,'Peru',1200000),(5,'ROJO Marcos','defensor-central',32,'Argentina',2500000),(6,'FABRA Frank','lateral-izquierdo',31,'Colombia',500000),(7,'FERNANDEZ Pol','volante',30,'Argentina',3000000),(8,'VARELA Alan','volante-central',20,'Argentina',7000000),(9,'ROMERO Oscar','volante',29,'Paraguay',3500000),(10,'ZEBALLOS Exequiel','delantero',20,'Argentina',8000000),(11,'VAZQUEZ Luis','centrodelantero',21,'Argentina',5000000),(12,'VILLA Sebastian','delantero',26,'Colombia',3000000),(14,'MARADONA Diego Armando','delantero',21,'Argentina',50000000),(15,'PALERMO Martin','centrodelantero',25,'Argentina',10000000),(19,'PAYERO Martín','volante',22,'Argentina',2000000),(20,'WEIGANDT Marcelo','lateral-derecho',22,'Argentina',2000000);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'boca'
--

--
-- Dumping routines for database 'boca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-15  7:16:41
