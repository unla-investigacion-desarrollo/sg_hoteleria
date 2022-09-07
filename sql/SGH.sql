CREATE DATABASE  IF NOT EXISTS `sgh` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sgh`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: zf4nk2bcqjvif4in.cbetxkdyhwsb.us-east-1.rds.amazonaws.com    Database: qiv69jsgdrk5dp6k
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
-- SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--


--
-- Table structure for table `alicuota`
--

DROP TABLE IF EXISTS `alicuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `alicuota` (
  `idAlicuota` int(11) NOT NULL AUTO_INCREMENT,
  `baseImponible` double DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `idComprobante` int(11) NOT NULL,
  PRIMARY KEY (`idAlicuota`),
  KEY `FK_2eedg7kpiyatv9e60x3oyt6mu` (`idComprobante`),
  CONSTRAINT `FK_2eedg7kpiyatv9e60x3oyt6mu` FOREIGN KEY (`idComprobante`) REFERENCES `comprobante` (`idComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alicuota`
--

LOCK TABLES `alicuota` WRITE;
/*!40000 ALTER TABLE `alicuota` DISABLE KEYS */;
/*!40000 ALTER TABLE `alicuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user`
--

DROP TABLE IF EXISTS `app_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(150) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sso_id` (`sso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user`
--

LOCK TABLES `app_user` WRITE;
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` VALUES (10,'Romina','$2a$10$gj7A7PNSXq8qfwRw0oPRJecnSP0.J/3YMr8WGFoU9s96FPlWvOI8S','Romina (admin)','Mansilla','romina@gmail.com'),(11,'Damian','$2a$10$ZLxaTRB5lPxpCrbP1nfcweH2AEolZYYBtMp1H85MDqDb4RpoHGH6C','DamiÃ¡n (dba)','Cuda','damian@gmail.com'),(12,'Pedro','$2a$10$I3NmUqzA71nVUfxdrIRuMOXFLqTO82bd0FfGbBFYJhWJE7GIP1X36','Pedro (usuario)','Lopez','pedro@gmail.com'),(13,'Fernando','$2a$10$zWdAuBi68ig0Mpvn./vL4.RJGff73C4gvQ2sWSJlnrvfCdz3F08gO','Fernando','Perez','fernando@gmail.com'),(14,'AdminSGH','$2a$10$uS.ico0tIQhiSZH0wqN11uXqwgH6auNZLCeboqGr2Xi5zKzPKQIRy','Administrador ','SGH','SistemaGestionHotelera.unla@gmail.com'),(15,'Marianitem','$2a$10$QBQQUlSe84Aea5a/DnqzfOHswvexPU6hDbYM.R.igX0rSTXSC1AQq','Mariano','Ortiz','mariano@ortiz'),(16,'admin','$2a$10$r7gZa5N2kwhVgF64W6W0bOqOvq7d5D4XfQrydFs90E07TwA8Xjt5i','admin','admin','admin@gmail.com');
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_user_user_profile`
--

DROP TABLE IF EXISTS `app_user_user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `app_user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_user_user_profile`
--

LOCK TABLES `app_user_user_profile` WRITE;
/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
INSERT INTO `app_user_user_profile` VALUES (12,4),(10,5),(13,5),(14,5),(15,5),(16,5),(11,6),(15,6);
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aux_caracteristicasporhabitacion`
--

DROP TABLE IF EXISTS `aux_caracteristicasporhabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `aux_caracteristicasporhabitacion` (
  `idHabitacion` int(10) unsigned NOT NULL DEFAULT '0',
  `idCaracteristica` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idHabitacion`,`idCaracteristica`),
  KEY `habitacion_idx` (`idHabitacion`),
  KEY `caracteristica_idx` (`idCaracteristica`),
  CONSTRAINT `caracteristica` FOREIGN KEY (`idCaracteristica`) REFERENCES `caracteristicahabitacion` (`idCaracteristicaHabitacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_caracteristicasporhabitacion`
--

LOCK TABLES `aux_caracteristicasporhabitacion` WRITE;
/*!40000 ALTER TABLE `aux_caracteristicasporhabitacion` DISABLE KEYS */;
INSERT INTO `aux_caracteristicasporhabitacion` VALUES (3,2),(5,1),(17,1),(17,2);
/*!40000 ALTER TABLE `aux_caracteristicasporhabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aux_caracteristicasporpasajero`
--

DROP TABLE IF EXISTS `aux_caracteristicasporpasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `aux_caracteristicasporpasajero` (
  `idPasajero` int(10) unsigned NOT NULL DEFAULT '0',
  `idCaracteristicaPasajero` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPasajero`,`idCaracteristicaPasajero`),
  KEY `id_caracteristicas_pasajero_idx` (`idCaracteristicaPasajero`),
  CONSTRAINT `aux_a_caracteristica` FOREIGN KEY (`idCaracteristicaPasajero`) REFERENCES `caracteristicapasajero` (`idCaracteristicaPasajero`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `aux_a_pasajero` FOREIGN KEY (`idPasajero`) REFERENCES `pasajero` (`idContacto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_caracteristicasporpasajero`
--

LOCK TABLES `aux_caracteristicasporpasajero` WRITE;
/*!40000 ALTER TABLE `aux_caracteristicasporpasajero` DISABLE KEYS */;
INSERT INTO `aux_caracteristicasporpasajero` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `aux_caracteristicasporpasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aux_serviciosPorPlan`
--

DROP TABLE IF EXISTS `aux_serviciosPorPlan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `aux_serviciosPorPlan` (
  `idPlanAlojamiento` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL,
  PRIMARY KEY (`idPlanAlojamiento`,`idServicio`),
  CONSTRAINT `FK_q1fepmawi9h230konkoj8xe5m` FOREIGN KEY (`idPlanAlojamiento`) REFERENCES `planAlojamiento` (`idPlanAlojamiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_serviciosPorPlan`
--

LOCK TABLES `aux_serviciosPorPlan` WRITE;
/*!40000 ALTER TABLE `aux_serviciosPorPlan` DISABLE KEYS */;
/*!40000 ALTER TABLE `aux_serviciosPorPlan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aux_serviciosporplan`
--

DROP TABLE IF EXISTS `aux_serviciosporplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `aux_serviciosporplan` (
  `idServicio` int(10) unsigned NOT NULL,
  `idPlanAlojamiento` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idServicio`,`idPlanAlojamiento`),
  KEY `aux_a_plan_idx` (`idPlanAlojamiento`),
  CONSTRAINT `aux_a_plan` FOREIGN KEY (`idPlanAlojamiento`) REFERENCES `planalojamiento` (`idPlanAlojamiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `aux_a_servicios` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aux_serviciosporplan`
--

LOCK TABLES `aux_serviciosporplan` WRITE;
/*!40000 ALTER TABLE `aux_serviciosporplan` DISABLE KEYS */;
INSERT INTO `aux_serviciosporplan` VALUES (3,2),(3,3),(4,3);
/*!40000 ALTER TABLE `aux_serviciosporplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicaHabitacion`
--

-- DROP TABLE IF EXISTS `caracteristicaHabitacion`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `caracteristicaHabitacion` (
--   `idCaracteristicaHabitacion` int(11) NOT NULL AUTO_INCREMENT,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idCaracteristicaHabitacion`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `caracteristicaHabitacion`
-- --

-- LOCK TABLES `caracteristicaHabitacion` WRITE;
-- /*!40000 ALTER TABLE `caracteristicaHabitacion` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `caracteristicaHabitacion` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `caracteristicahabitacion`
--

DROP TABLE IF EXISTS `caracteristicahabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicahabitacion` (
  `idCaracteristicaHabitacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCaracteristicaHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicahabitacion`
--

LOCK TABLES `caracteristicahabitacion` WRITE;
/*!40000 ALTER TABLE `caracteristicahabitacion` DISABLE KEYS */;
INSERT INTO `caracteristicahabitacion` VALUES (1,'Comodidad Extrema'),(2,'Standard');
/*!40000 ALTER TABLE `caracteristicahabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracteristicapasajero`
--

DROP TABLE IF EXISTS `caracteristicapasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `caracteristicapasajero` (
  `idCaracteristicaPasajero` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCaracteristicaPasajero`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristicapasajero`
--

LOCK TABLES `caracteristicapasajero` WRITE;
/*!40000 ALTER TABLE `caracteristicapasajero` DISABLE KEYS */;
INSERT INTO `caracteristicapasajero` VALUES (1,'Celiacos'),(9,'Obeso');
/*!40000 ALTER TABLE `caracteristicapasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienteComprobante`
--

-- DROP TABLE IF EXISTS `clienteComprobante`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `clienteComprobante` (
--   `idClienteComprobante` int(11) NOT NULL AUTO_INCREMENT,
--   `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `razonSocial` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `documento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `idTipoDocumento` int(11) NOT NULL,
--   PRIMARY KEY (`idClienteComprobante`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `clienteComprobante`
-- --

-- LOCK TABLES `clienteComprobante` WRITE;
-- /*!40000 ALTER TABLE `clienteComprobante` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `clienteComprobante` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `clientecomprobante`
--

DROP TABLE IF EXISTS `clientecomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `clientecomprobante` (
  `idClienteComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `idTipoDocumento` int(11) NOT NULL,
  `domicilio` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClienteComprobante`),
  KEY `FK_t48g5h1f99j72hrkwtwibidwr` (`idTipoDocumento`),
  CONSTRAINT `FK_t48g5h1f99j72hrkwtwibidwr` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientecomprobante`
--

LOCK TABLES `clientecomprobante` WRITE;
/*!40000 ALTER TABLE `clientecomprobante` DISABLE KEYS */;
INSERT INTO `clientecomprobante` VALUES (1,'Ezequiel','Alvarez','','35996744',2,'Av. Cordoba 2300','Ciudad Autonoma de Buenos Aires','ezealv77@gmail.com'),(3,'Edesur','SA',NULL,'30646512952',6,'Brasil 3100','Ciudad Autonoma de Buenos Aires','ezealv77@gmail.com');
/*!40000 ALTER TABLE `clientecomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante`
--

DROP TABLE IF EXISTS `comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `comprobante` (
  `idComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `nroComprobante` int(11) DEFAULT NULL,
  `ptoVenta` int(11) DEFAULT NULL,
  `fechaComprobante` date DEFAULT NULL,
  `fechaFacturadoDesde` date DEFAULT NULL,
  `fechaFacturadoHasta` date DEFAULT NULL,
  `vencimientoPago` date DEFAULT NULL,
  `importeNeto` double DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `totalIva` double DEFAULT NULL,
  `importeTotal` double DEFAULT NULL,
  `importeExcento` double DEFAULT NULL,
  `importeTributos` double DEFAULT NULL,
  `cae` varchar(255) DEFAULT NULL,
  `vencimientoCae` date DEFAULT NULL,
  `idTipoComprobante` int(11) NOT NULL,
  `idMoneda` int(11) NOT NULL,
  `idConceptosAIncluir` int(11) NOT NULL,
  `idFormaDePago` int(11) NOT NULL,
  `idClienteComprobante` int(11) NOT NULL,
  `importeNoGravado` double DEFAULT NULL,
  PRIMARY KEY (`idComprobante`),
  KEY `FK_jjx95g6tgkly3jt5l5t3ocu48` (`idTipoComprobante`),
  KEY `FK_ld149xsy06y8ckadlpiew6vwr` (`idMoneda`),
  KEY `FK_a6wttmdlkvh3mjc7o4aqg77co` (`idConceptosAIncluir`),
  KEY `FK_skrx1p647omww0eqlral4rpp` (`idFormaDePago`),
  KEY `FK_gbwssym2fcbbbb4o4ea9vy8m1` (`idClienteComprobante`),
  CONSTRAINT `FK_a6wttmdlkvh3mjc7o4aqg77co` FOREIGN KEY (`idConceptosAIncluir`) REFERENCES `conceptosaincluir` (`idConceptosAIncluir`),
  CONSTRAINT `FK_gbwssym2fcbbbb4o4ea9vy8m1` FOREIGN KEY (`idClienteComprobante`) REFERENCES `clientecomprobante` (`idClienteComprobante`),
  CONSTRAINT `FK_jjx95g6tgkly3jt5l5t3ocu48` FOREIGN KEY (`idTipoComprobante`) REFERENCES `tipocomprobante` (`idTipoComprobante`),
  CONSTRAINT `FK_ld149xsy06y8ckadlpiew6vwr` FOREIGN KEY (`idMoneda`) REFERENCES `moneda` (`idMoneda`),
  CONSTRAINT `FK_skrx1p647omww0eqlral4rpp` FOREIGN KEY (`idFormaDePago`) REFERENCES `formadepago` (`idFormaDePago`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante`
--

LOCK TABLES `comprobante` WRITE;
/*!40000 ALTER TABLE `comprobante` DISABLE KEYS */;
INSERT INTO `comprobante` VALUES (4,4,5,'2017-12-28','2017-12-28','2017-12-29','2017-12-24',1,NULL,1087.02,6149.02,34324,0,'fdsfsdf','2017-12-28',1,1,1,1,1,3),(8,21,0,'2018-07-31',NULL,NULL,NULL,0,NULL,21,121,0,0,'68317663329328','2018-08-10',5,1,1,1,1,0),(11,110,0,'2018-07-31',NULL,NULL,NULL,0,NULL,21,121,0,0,'68317663334538','2018-08-10',1,1,1,1,3,0),(12,117,2,'2018-08-31',NULL,NULL,NULL,0,NULL,21,121,0,0,'68357670946822','2018-09-10',1,1,1,1,3,0),(13,122,2,'2018-10-08',NULL,NULL,NULL,0,NULL,31.5,181.5,0,0,'68417685112242','2018-10-18',1,1,1,1,3,0),(14,44,2,'2018-10-09',NULL,NULL,NULL,0,NULL,105,605,0,0,'68417685557352','2018-10-20',5,1,1,1,1,0),(15,0,2,'2018-11-14',NULL,NULL,NULL,0,NULL,23.73,136.73,0,0,NULL,NULL,1,1,1,1,3,0),(16,0,1,'2022-08-23',NULL,NULL,NULL,0,NULL,50.4,290.4,0,0,NULL,NULL,9,1,1,1,1,0),(17,0,1,'2022-08-23',NULL,NULL,NULL,0,NULL,63,363,0,0,NULL,NULL,1,1,3,3,1,0),(18,0,3,'2022-08-23',NULL,NULL,NULL,0,NULL,1260,7260,0,0,NULL,NULL,5,1,1,4,1,0);
/*!40000 ALTER TABLE `comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concepto`
--

DROP TABLE IF EXISTS `concepto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `concepto` (
  `idConcepto` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `tipoIva` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `idComprobante` int(11) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  `idPreTicket` int(11) DEFAULT NULL,
  PRIMARY KEY (`idConcepto`),
  KEY `FK_2cr0rt9hff8rjswcl1bp72sdv` (`idComprobante`),
  KEY `FK_lospvdwujl6p42ypr2eklpyv9` (`idPreTicket`),
  CONSTRAINT `FK_2cr0rt9hff8rjswcl1bp72sdv` FOREIGN KEY (`idComprobante`) REFERENCES `comprobante` (`idComprobante`),
  CONSTRAINT `FK_lospvdwujl6p42ypr2eklpyv9` FOREIGN KEY (`idPreTicket`) REFERENCES `preticket` (`idPreTicket`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concepto`
--

LOCK TABLES `concepto` WRITE;
/*!40000 ALTER TABLE `concepto` DISABLE KEYS */;
INSERT INTO `concepto` VALUES (7,1,5,'aa',3,NULL,NULL,NULL),(8,2,6,'bb',4,NULL,NULL,NULL),(45,10,6,'aa',40,4,0,NULL),(46,20,5,'bb',200,4,1,NULL),(47,1,5,'Bar',423,4,2,NULL),(48,1,5,'Lavanderia',239,4,3,NULL),(83,1,5,'aaaaa',100,8,0,NULL),(86,1,5,'a',100,11,0,NULL),(87,1,5,'aaaaa',100,12,0,NULL),(88,1,5,'aaaaa',150,13,0,NULL),(89,1,5,'aaaaaaaaaaaaaa',500,14,0,NULL),(90,1,5,'prueba',113,15,0,NULL),(91,1,5,'Comida',240,16,0,8),(92,1,5,'Servicio de Habitacionn',300,17,0,7),(93,4,5,'Comida y bebida y ropa',1500,18,0,NULL);
/*!40000 ALTER TABLE `concepto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conceptosAIncluir`
--

-- DROP TABLE IF EXISTS `conceptosAIncluir`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `conceptosAIncluir` (
--   `idConceptosAIncluir` int(11) NOT NULL AUTO_INCREMENT,
--   `codigo` int(11) DEFAULT NULL,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idConceptosAIncluir`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `conceptosAIncluir`
-- --

-- LOCK TABLES `conceptosAIncluir` WRITE;
-- /*!40000 ALTER TABLE `conceptosAIncluir` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `conceptosAIncluir` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `conceptosaincluir`
--

DROP TABLE IF EXISTS `conceptosaincluir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `conceptosaincluir` (
  `idConceptosAIncluir` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idConceptosAIncluir`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conceptosaincluir`
--

LOCK TABLES `conceptosaincluir` WRITE;
/*!40000 ALTER TABLE `conceptosaincluir` DISABLE KEYS */;
INSERT INTO `conceptosaincluir` VALUES (1,1,'Productos'),(2,2,'Servicios'),(3,3,'Productos y Servicios'),(4,4,'Otro');
/*!40000 ALTER TABLE `conceptosaincluir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `cuenta` (
  `idCuenta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saldo` double DEFAULT NULL,
  `idCliente` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadia`
--

DROP TABLE IF EXISTS `estadia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `estadia` (
  `idEstadia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idEstadoEstadia` int(10) unsigned NOT NULL,
  `idPlanAlojamiento` int(10) unsigned NOT NULL,
  `precioPorNoche` bigint(8) DEFAULT NULL,
  `idCuenta` int(10) unsigned DEFAULT NULL,
  `diaCheckIn` datetime DEFAULT NULL,
  `diaCheckOut` datetime DEFAULT NULL,
`comentario` varchar(250) DEFAULT NULL, 
  PRIMARY KEY (`idEstadia`),
  KEY `estadia_con_cuenta_idx` (`idCuenta`),
  KEY `estadia_con_estado_idx` (`idEstadoEstadia`),
  KEY `estadia_con_plan_idx` (`idPlanAlojamiento`),
  CONSTRAINT `FK_f9t8meh96u8gmx8a6xixge1ey` FOREIGN KEY (`idPlanAlojamiento`) REFERENCES `planalojamiento` (`idPlanAlojamiento`),
  CONSTRAINT `estadia_con_cuenta` FOREIGN KEY (`idCuenta`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `estadia_con_estado` FOREIGN KEY (`idEstadoEstadia`) REFERENCES `estadoestadia` (`idEstadoEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadia`
--

LOCK TABLES `estadia` WRITE;
/*!40000 ALTER TABLE `estadia` DISABLE KEYS */;
-- INSERT INTO `estadia` VALUES (1,7,3,200,NULL,'2017-01-16 00:00:00','2017-01-26 00:00:00'),(4,7,3,300,NULL,'2017-02-04 00:00:00','2017-02-13 00:00:00'),(6,1,2,500,NULL,'2017-06-15 00:00:00','2017-06-30 00:00:00'),(7,2,2,200,NULL,'2017-06-20 00:00:00','2017-06-24 00:00:00'),(8,3,2,200,NULL,'2017-06-20 00:00:00','2017-06-24 00:00:00'),(9,6,3,300,NULL,'2017-06-26 00:00:00','2017-07-02 00:00:00'),(10,3,2,200,NULL,'2017-06-23 00:00:00','2017-06-27 00:00:00'),(11,4,2,300,NULL,'2017-06-17 00:00:00','2017-06-22 00:00:00'),(12,1,2,100,NULL,'2017-06-21 00:00:00','2017-06-23 00:00:00'),(13,2,2,433,NULL,'2017-10-19 00:00:00','2017-10-27 00:00:00'),(14,1,2,3222,NULL,'2017-06-13 00:00:00','2017-09-20 00:00:00');
INSERT INTO `estadia` VALUES (1,7,3,200,NULL,'2017-01-16 00:00:00','2017-01-26 00:00:00',NULL),(4,7,3,300,NULL,'2017-02-04 00:00:00','2017-02-13 00:00:00',NULL),(6,1,2,500,NULL,'2017-06-15 00:00:00','2017-06-30 00:00:00',NULL),(7,2,2,200,NULL,'2017-06-20 00:00:00','2017-06-24 00:00:00',NULL),(8,3,2,200,NULL,'2017-06-20 00:00:00','2017-06-24 00:00:00',NULL),(9,6,3,300,NULL,'2017-06-26 00:00:00','2017-07-02 00:00:00',NULL),(10,3,2,200,NULL,'2017-06-23 00:00:00','2017-06-27 00:00:00',NULL),(11,4,2,300,NULL,'2017-06-17 00:00:00','2017-06-22 00:00:00',NULL),(12,1,2,100,NULL,'2017-06-21 00:00:00','2017-06-23 00:00:00',NULL),(13,2,2,433,NULL,'2017-10-19 00:00:00','2017-10-27 00:00:00',NULL),(14,1,2,3222,NULL,'2017-06-13 00:00:00','2017-09-20 00:00:00',NULL);
/*!40000 ALTER TABLE `estadia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoEstadia`
--

-- DROP TABLE IF EXISTS `estadoEstadia`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `estadoEstadia` (
--   `idEstadoEstadia` int(11) NOT NULL AUTO_INCREMENT,
--   `estado` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `color` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idEstadoEstadia`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `estadoEstadia`
-- --

-- LOCK TABLES `estadoEstadia` WRITE;
-- /*!40000 ALTER TABLE `estadoEstadia` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `estadoEstadia` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `estadoHabitacion`
--

-- DROP TABLE IF EXISTS `estadoHabitacion`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `estadoHabitacion` (
--   `idEstadoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idEstadoHabitacion`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `estadoHabitacion`
-- --

-- LOCK TABLES `estadoHabitacion` WRITE;
-- /*!40000 ALTER TABLE `estadoHabitacion` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `estadoHabitacion` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `estadoestadia`
--

DROP TABLE IF EXISTS `estadoestadia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `estadoestadia` (
  `idEstadoEstadia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstadoEstadia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoestadia`
--

LOCK TABLES `estadoestadia` WRITE;
/*!40000 ALTER TABLE `estadoestadia` DISABLE KEYS */;
INSERT INTO `estadoestadia` VALUES (1,'Solicitada','coral'),(2,'Reservada','aquamarine'),(3,'Bloqueada','darkgreen'),(4,'Cancelada','crimson'),(6,'CheckIn','dodgerBlue'),(7,'CheckOut','gray');
/*!40000 ALTER TABLE `estadoestadia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadohabitacion`
--

DROP TABLE IF EXISTS `estadohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `estadohabitacion` (
  `idEstadoHabitacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstadoHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadohabitacion`
--

LOCK TABLES `estadohabitacion` WRITE;
/*!40000 ALTER TABLE `estadohabitacion` DISABLE KEYS */;
INSERT INTO `estadohabitacion` VALUES (1,'En Reparacion'),(2,'Disponible'),(3,'En Reformas');
/*!40000 ALTER TABLE `estadohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaDePago`
--

-- DROP TABLE IF EXISTS `formaDePago`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `formaDePago` (
--   `idFormaDePago` int(11) NOT NULL AUTO_INCREMENT,
--   `codigo` int(11) DEFAULT NULL,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idFormaDePago`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `formaDePago`
-- --

-- LOCK TABLES `formaDePago` WRITE;
-- /*!40000 ALTER TABLE `formaDePago` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `formaDePago` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `formadepago`
--

DROP TABLE IF EXISTS `formadepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `formadepago` (
  `idFormaDePago` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idFormaDePago`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formadepago`
--

LOCK TABLES `formadepago` WRITE;
/*!40000 ALTER TABLE `formadepago` DISABLE KEYS */;
INSERT INTO `formadepago` VALUES (1,1,'Efectivo'),(2,2,'Cheque'),(3,3,'Tarjeta de Credito'),(4,4,'Tarjeta de Debito'),(5,5,'Test');
/*!40000 ALTER TABLE `formadepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `habitacion` (
  `idHabitacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idEstadoHabitacion` int(10) unsigned DEFAULT NULL,
  `idTipoHabitacion` int(10) unsigned NOT NULL,
  `idHotel` int(10) unsigned NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idHabitacion`),
  KEY `id_hotel_idx` (`idHotel`),
  KEY `h_a_estado_idx` (`idEstadoHabitacion`),
  KEY `h_a_tipo_habitacion_idx` (`idTipoHabitacion`),
  CONSTRAINT `h_a_estado` FOREIGN KEY (`idEstadoHabitacion`) REFERENCES `estadohabitacion` (`idEstadoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `h_a_hotel` FOREIGN KEY (`idHotel`) REFERENCES `hotel` (`idHotel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `h_a_tipo_habitacion` FOREIGN KEY (`idTipoHabitacion`) REFERENCES `tipohabitacion` (`idTipoHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (2,1,2,1,'Hab. 101'),(3,2,1,1,'Hab. 102'),(4,1,1,1,'Hab. 103'),(5,2,3,1,'Hab. 104'),(6,2,1,1,'Hab. 105'),(7,2,1,1,'Hab. 106'),(8,2,2,1,'Hab. 107'),(9,2,3,1,'Hab. 108'),(10,2,1,1,'Hab. 109'),(11,2,2,1,'Hab. 110'),(12,2,3,1,'Hab. 111'),(13,2,1,1,'Hab. 112'),(14,2,2,1,'Hab. 113'),(15,2,3,1,'Hab. 114'),(17,1,1,1,'Habitacion lalala');
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `idHotel` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombreHotel` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `eMail` varchar(45) DEFAULT NULL,
  `paginaWeb` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idHotel`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Pipinas Viva','Calle sin numero 123',42356798,'pipinasviva@gmail.com','www.pipinasviva.com.ar'),(2,'Hotel','bbb 111',999999,'hotel@gmail.com','www.hotel.com.ar'),(3,'Hotel 2','Calle a',11998822,'Hotel2@gmail.com','-');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itempreticket`
--

DROP TABLE IF EXISTS `itempreticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `itempreticket` (
  `idItemPreTicket` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `idPreTicket` int(11) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`idItemPreTicket`),
  KEY `FK_gxrqk1pqu70l4juo4k4k3tb4n` (`idPreTicket`),
  CONSTRAINT `FK_gxrqk1pqu70l4juo4k4k3tb4n` FOREIGN KEY (`idPreTicket`) REFERENCES `preticket` (`idPreTicket`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itempreticket`
--

LOCK TABLES `itempreticket` WRITE;
/*!40000 ALTER TABLE `itempreticket` DISABLE KEYS */;
INSERT INTO `itempreticket` VALUES (3,1,'Servicio de Habitacion',200,7,0),(4,2,'Toalla Adicional',50,7,1),(5,3,'Panchos',80,8,0);
/*!40000 ALTER TABLE `itempreticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moneda`
--

DROP TABLE IF EXISTS `moneda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `moneda` (
  `idMoneda` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `cotizacion` double DEFAULT NULL,
  PRIMARY KEY (`idMoneda`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moneda`
--

LOCK TABLES `moneda` WRITE;
/*!40000 ALTER TABLE `moneda` DISABLE KEYS */;
INSERT INTO `moneda` VALUES (1,'PES','Pesos',1),(2,'DOL','Dólar Estadounidense',18);
/*!40000 ALTER TABLE `moneda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizacion`
--

DROP TABLE IF EXISTS `organizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `organizacion` (
  `idContacto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telefono` varchar(45) DEFAULT NULL,
  `eMail` varchar(45) DEFAULT NULL,
  `razonSocial` varchar(150) DEFAULT NULL,
  `cuit` mediumtext,
  `idCuenta` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`idContacto`),
  KEY `pasajero_a_cuenta_idx` (`idCuenta`),
  CONSTRAINT `organizacion_a_cuenta` FOREIGN KEY (`idCuenta`) REFERENCES `cuenta` (`idCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizacion`
--

LOCK TABLES `organizacion` WRITE;
/*!40000 ALTER TABLE `organizacion` DISABLE KEYS */;
INSERT INTO `organizacion` VALUES (1,'999999999','lastresmarias@gmail.com','Las tres Marias ','23-47658736-4',NULL),(2,'111111','lanueva@gmail.com','La nueva sociedad','23-99999999-4',NULL);
/*!40000 ALTER TABLE `organizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajero`
--

DROP TABLE IF EXISTS `pasajero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pasajero` (
  `idContacto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `telefono` varchar(45) DEFAULT NULL,
  `eMail` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `documento` varchar(15) DEFAULT NULL,
  `nacimiento` datetime DEFAULT NULL,
  `idCuenta` int(10) unsigned DEFAULT NULL,
  `idTipoDocumento` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`idContacto`),
  KEY `pasajero_a_cuenta_idx` (`idCuenta`),
  KEY `pasajero_a_tipodoc_idx` (`idTipoDocumento`),
  unique(`documento`, `idTipoDocumento`) 
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajero`
--

LOCK TABLES `pasajero` WRITE;
/*!40000 ALTER TABLE `pasajero` DISABLE KEYS */;
INSERT INTO `pasajero` VALUES (1,'9999999','romina@gmail.com','Romina','Mansilla','77777777','2017-01-29 00:00:00',NULL,1),(2,'9999','daniela@gmail.com','Daniela','Llorens','88888888','2017-01-13 00:00:00',NULL,1),(4,'8888','fernando@gmail.com','Fernando','Mansilla','99999999','2017-01-06 00:00:00',NULL,1);
/*!40000 ALTER TABLE `pasajero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pasajeroEstadia`
--

-- DROP TABLE IF EXISTS `pasajeroEstadia`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `pasajeroEstadia` (
--   `idPasajeroEstadia` int(11) NOT NULL AUTO_INCREMENT,
--   `idEstadia` int(11) NOT NULL,
--   `idPasajero` int(11) DEFAULT NULL,
--   `idHabitacion` int(11) NOT NULL,
--   PRIMARY KEY (`idPasajeroEstadia`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `pasajeroEstadia`
-- --

-- LOCK TABLES `pasajeroEstadia` WRITE;
-- /*!40000 ALTER TABLE `pasajeroEstadia` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `pasajeroEstadia` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `pasajeroestadia`
--

DROP TABLE IF EXISTS `pasajeroestadia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `pasajeroestadia` (
  `idPasajeroEstadia` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `idEstadia` int(10) unsigned NOT NULL DEFAULT '0',
  `idHabitacion` int(10) unsigned NOT NULL DEFAULT '0',
  `idPasajero` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPasajeroEstadia`,`idEstadia`,`idHabitacion`),
  KEY `pe_a_habitacion_idx` (`idHabitacion`),
  KEY `pe_a_estadia` (`idEstadia`),
  CONSTRAINT `pe_a_estadia` FOREIGN KEY (`idEstadia`) REFERENCES `estadia` (`idEstadia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pe_a_habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pasajeroestadia`
--

LOCK TABLES `pasajeroestadia` WRITE;
/*!40000 ALTER TABLE `pasajeroestadia` DISABLE KEYS */;
INSERT INTO `pasajeroestadia` VALUES (2,1,4,NULL),(7,1,4,NULL),(9,1,4,NULL),(10,1,2,NULL),(11,1,3,NULL),(16,1,3,NULL),(17,4,2,NULL),(18,6,2,NULL),(19,6,3,NULL),(20,6,3,NULL),(21,6,4,NULL),(22,6,4,NULL),(23,6,4,NULL),(24,6,3,NULL),(25,6,5,NULL),(26,7,12,NULL),(27,8,7,NULL),(28,8,7,NULL),(29,8,7,NULL),(30,8,8,NULL),(31,8,9,NULL),(32,8,9,NULL),(33,7,12,NULL),(34,7,12,NULL),(35,9,12,NULL),(36,9,12,NULL),(37,9,13,NULL),(38,9,13,NULL),(39,10,14,NULL),(40,10,15,NULL),(42,11,6,NULL),(43,12,10,NULL),(45,7,13,NULL),(46,7,13,NULL),(47,7,13,NULL),(48,12,10,NULL),(49,12,11,NULL),(50,7,12,NULL),(51,1,2,NULL),(52,7,6,NULL);
/*!40000 ALTER TABLE `pasajeroestadia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planAlojamiento`
--

-- DROP TABLE IF EXISTS `planAlojamiento`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `planAlojamiento` (
--   `idPlanAlojamiento` int(11) NOT NULL AUTO_INCREMENT,
--   `plan` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `precioExtraPorNoche` decimal(19,2) DEFAULT NULL,
--   PRIMARY KEY (`idPlanAlojamiento`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `planAlojamiento`
-- --

-- LOCK TABLES `planAlojamiento` WRITE;
-- /*!40000 ALTER TABLE `planAlojamiento` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `planAlojamiento` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `planalojamiento`
--

DROP TABLE IF EXISTS `planalojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `planalojamiento` (
  `idPlanAlojamiento` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `plan` varchar(45) DEFAULT NULL,
  `precioExtraPorNoche` double DEFAULT NULL,
  PRIMARY KEY (`idPlanAlojamiento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planalojamiento`
--

LOCK TABLES `planalojamiento` WRITE;
/*!40000 ALTER TABLE `planalojamiento` DISABLE KEYS */;
INSERT INTO `planalojamiento` VALUES (2,'Desayuno Incluido',20),(3,'Media Pension',50),(5,'Pension Completa',100);
/*!40000 ALTER TABLE `planalojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preticket`
--

DROP TABLE IF EXISTS `preticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `preticket` (
  `idPreTicket` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `facturado` bit(1) DEFAULT NULL,
  `idClientePreTicket` int(11) NOT NULL,
  `idConcepto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPreTicket`),
  KEY `FK_sgw2nkctukeuxri7utqnlenp8` (`idClientePreTicket`),
  KEY `FK_q26jqojn3cbihq5j76lx0b7b4` (`idConcepto`),
  CONSTRAINT `FK_q26jqojn3cbihq5j76lx0b7b4` FOREIGN KEY (`idConcepto`) REFERENCES `concepto` (`idConcepto`),
  CONSTRAINT `FK_sgw2nkctukeuxri7utqnlenp8` FOREIGN KEY (`idClientePreTicket`) REFERENCES `clientecomprobante` (`idClienteComprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preticket`
--

LOCK TABLES `preticket` WRITE;
/*!40000 ALTER TABLE `preticket` DISABLE KEYS */;
INSERT INTO `preticket` VALUES (7,'Servicio de Habitacionn',0,'2018-11-14',NULL,1,92),(8,'Comida',0,'2022-08-23',NULL,1,91);
/*!40000 ALTER TABLE `preticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `servicio` (
  `idServicio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `tipoServicio` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idServicio`),
  KEY `servicio_a_tipo_idx` (`tipoServicio`),
  CONSTRAINT `servicio_a_tipo` FOREIGN KEY (`tipoServicio`) REFERENCES `tiposervicio` (`idTipoServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (3,'Desayuno',20,1),(4,'Almuerzo',30,1),(5,'Masajes',150,2),(6,'Sauna',75,2),(8,'Almuerzayuno',8300,1);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketacceso`
--

DROP TABLE IF EXISTS `ticketacceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `ticketacceso` (
  `idTicketAcceso` int(11) NOT NULL AUTO_INCREMENT,
  `sign` varchar(1024) DEFAULT NULL,
  `token` varchar(1024) DEFAULT NULL,
  `cuit` varchar(255) DEFAULT NULL,
  `fechahoraexpiracion` datetime DEFAULT NULL,
  PRIMARY KEY (`idTicketAcceso`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketacceso`
--

LOCK TABLES `ticketacceso` WRITE;
/*!40000 ALTER TABLE `ticketacceso` DISABLE KEYS */;
INSERT INTO `ticketacceso` VALUES (1,'AbNtGriA1KcXsZK9ZjUzZVig7Vz2SxGQxw5xCHt8d/R05/ughnjIAIePONV4YJLjnzWdKsD64tK0sqv6dOkoJnZKmDn8i5syvRJGHL5U7lAA3ZW7kB88w9rTW7Qiv1C3mAh2dnOS6+Bv9kyYjZC28YKhF9WQSruTpEST1BZwfCk=','PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/Pgo8c3NvIHZlcnNpb249IjIuMCI+CiAgICA8aWQgc3JjPSJDTj13c2FhaG9tbywgTz1BRklQLCBDPUFSLCBTRVJJQUxOVU1CRVI9Q1VJVCAzMzY5MzQ1MDIzOSIgZHN0PSJDTj13c2ZlLCBPPUFGSVAsIEM9QVIiIHVuaXF1ZV9pZD0iNzM1NjM2ODkiIGdlbl90aW1lPSIxNTM5MTMyNjk5IiBleHBfdGltZT0iMTUzOTE3NTk1OSIvPgogICAgPG9wZXJhdGlvbiB0eXBlPSJsb2dpbiIgdmFsdWU9ImdyYW50ZWQiPgogICAgICAgIDxsb2dpbiBlbnRpdHk9IjMzNjkzNDUwMjM5IiBzZXJ2aWNlPSJ3c2ZlIiB1aWQ9IlNFUklBTE5VTUJFUj1DVUlUIDIwMzU5OTY3NDQ3LCBDTj1zaXN0ZW1hcyIgYXV0aG1ldGhvZD0iY21zIiByZWdtZXRob2Q9IjIyIj4KICAgICAgICAgICAgPHJlbGF0aW9ucz4KICAgICAgICAgICAgICAgIDxyZWxhdGlvbiBrZXk9IjIwMzU5OTY3NDQ3IiByZWx0eXBlPSI0Ii8+CiAgICAgICAgICAgIDwvcmVsYXRpb25zPgogICAgICAgIDwvbG9naW4+CiAgICA8L29wZXJhdGlvbj4KPC9zc28+Cg==','20359967447','2018-10-10 12:52:40');
/*!40000 ALTER TABLE `ticketacceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoComprobante`
--

-- DROP TABLE IF EXISTS `tipoComprobante`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `tipoComprobante` (
--   `idTipoComprobante` int(11) NOT NULL AUTO_INCREMENT,
--   `codigo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idTipoComprobante`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `tipoComprobante`
-- --

-- LOCK TABLES `tipoComprobante` WRITE;
-- /*!40000 ALTER TABLE `tipoComprobante` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `tipoComprobante` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tipoDocumento`
--

-- DROP TABLE IF EXISTS `tipoDocumento`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `tipoDocumento` (
--   `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `idDocumentoAfip` int(11) DEFAULT NULL,
--   PRIMARY KEY (`idTipoDocumento`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `tipoDocumento`
-- --

-- LOCK TABLES `tipoDocumento` WRITE;
-- /*!40000 ALTER TABLE `tipoDocumento` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `tipoDocumento` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tipoHabitacion`
--

-- DROP TABLE IF EXISTS `tipoHabitacion`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `tipoHabitacion` (
--   `idTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT,
--   `nombreTipoHabitacion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `capacidad` int(11) DEFAULT NULL,
--   PRIMARY KEY (`idTipoHabitacion`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `tipoHabitacion`
-- --

-- LOCK TABLES `tipoHabitacion` WRITE;
-- /*!40000 ALTER TABLE `tipoHabitacion` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `tipoHabitacion` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tipoServicio`
--

-- DROP TABLE IF EXISTS `tipoServicio`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8 */;
-- CREATE TABLE `tipoServicio` (
--   `idTipoServicio` int(11) NOT NULL AUTO_INCREMENT,
--   `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   PRIMARY KEY (`idTipoServicio`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `tipoServicio`
-- --

-- LOCK TABLES `tipoServicio` WRITE;
-- /*!40000 ALTER TABLE `tipoServicio` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `tipoServicio` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tipocomprobante`
--

DROP TABLE IF EXISTS `tipocomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tipocomprobante` (
  `idTipoComprobante` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTipoComprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocomprobante`
--

LOCK TABLES `tipocomprobante` WRITE;
/*!40000 ALTER TABLE `tipocomprobante` DISABLE KEYS */;
INSERT INTO `tipocomprobante` VALUES (1,'001','Factura A'),(2,'002','Nota de Debito A'),(3,'003','Nota de Credito A'),(4,'004','Recibo A'),(5,'006','Factura B'),(6,'007','Nota de Debito B'),(7,'008','Nota de Credito B'),(8,'009','Recibo B'),(9,'011','Factura C'),(10,'012','Nota de Debito C'),(11,'013','Nota de Credito C'),(12,'015','Recibo C');
/*!40000 ALTER TABLE `tipocomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tipodocumento` (
  `idTipoDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `idDocumentoAfip` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'Pasaporte',94),(2,'DNI (Documento Unico)',96),(4,'Libreta de Enrolamiento',89),(5,'Cedula Policial',4),(6,'Cuit',80),(8,'Test',6);
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tipohabitacion` (
  `idTipoHabitacion` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombreTipoHabitacion` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `capacidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTipoHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohabitacion`
--

LOCK TABLES `tipohabitacion` WRITE;
/*!40000 ALTER TABLE `tipohabitacion` DISABLE KEYS */;
INSERT INTO `tipohabitacion` VALUES (1,'Triple','Comodidad Extremas',6),(2,'Single','Con Mini-Bar.',1),(3,'Cuadruple','Muy Amplia',4),(4,'Quintuple','Familia grande',5);
/*!40000 ALTER TABLE `tipohabitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiposervicio`
--

DROP TABLE IF EXISTS `tiposervicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tiposervicio` (
  `idTipoServicio` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiposervicio`
--

LOCK TABLES `tiposervicio` WRITE;
/*!40000 ALTER TABLE `tiposervicio` DISABLE KEYS */;
INSERT INTO `tiposervicio` VALUES (1,'Alimentacion'),(2,'Spa');
/*!40000 ALTER TABLE `tiposervicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tributo`
--

DROP TABLE IF EXISTS `tributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `tributo` (
  `idTributo` int(11) NOT NULL AUTO_INCREMENT,
  `impuesto` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `baseImponible` double DEFAULT NULL,
  `importe` double DEFAULT NULL,
  `alicuota` double DEFAULT NULL,
  `idComprobante` int(11) NOT NULL,
  PRIMARY KEY (`idTributo`),
  KEY `FK_mjpaw4w799rimiw2hj4v4jf10` (`idComprobante`),
  CONSTRAINT `FK_mjpaw4w799rimiw2hj4v4jf10` FOREIGN KEY (`idComprobante`) REFERENCES `comprobante` (`idComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tributo`
--

LOCK TABLES `tributo` WRITE;
/*!40000 ALTER TABLE `tributo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tributo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (5,'ADMIN'),(6,'DBA'),(4,'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;
-- SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-23 19:25:19
