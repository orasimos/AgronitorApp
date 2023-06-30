CREATE DATABASE  IF NOT EXISTS `agronitor_testdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agronitor_testdb`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: agronitor_testdb
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `greenhouses`
--

DROP TABLE IF EXISTS `greenhouses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `greenhouses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `greenhouse_name` varchar(50) NOT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjhdkmcwvh1u9cohkmy9pr0koj` (`id_user`),
  CONSTRAINT `FKjhdkmcwvh1u9cohkmy9pr0koj` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `greenhouses`
--

LOCK TABLES `greenhouses` WRITE;
/*!40000 ALTER TABLE `greenhouses` DISABLE KEYS */;
INSERT INTO `greenhouses` VALUES (12,'Cucumbers',1),(13,'Eggplants',1),(16,'Tomatoes',1),(21,'Tomatoes',4),(22,'Cucumbers',4),(23,'Peppers',4),(24,'Cherry Tomatoes',4),(25,'Eggplants',4);
/*!40000 ALTER TABLE `greenhouses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (21);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humidities`
--

DROP TABLE IF EXISTS `humidities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `humidities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` datetime(6) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `id_greenhouse` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4q4ythbrcjrrup57cp037stth` (`id_greenhouse`),
  CONSTRAINT `FK4q4ythbrcjrrup57cp037stth` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humidities`
--

LOCK TABLES `humidities` WRITE;
/*!40000 ALTER TABLE `humidities` DISABLE KEYS */;
INSERT INTO `humidities` VALUES (35,'2023-06-29 16:29:58.339000','42,72',12),(36,'2023-06-29 16:29:58.343000','32,12',13),(39,'2023-06-29 16:59:58.347000','44,05',12),(40,'2023-06-29 16:59:58.351000','28,58',13),(44,'2023-06-29 17:29:58.346000','66,77',12),(45,'2023-06-29 17:29:58.350000','42,22',13),(49,'2023-06-29 17:59:58.335000','87,21',12),(50,'2023-06-29 17:59:58.338000','16,46',13),(54,'2023-06-29 18:29:58.341000','40,43',12),(55,'2023-06-29 18:29:58.345000','50,79',13),(59,'2023-06-29 18:59:59.759000','22,76',12),(60,'2023-06-29 18:59:59.762000','72,04',13),(64,'2023-06-29 19:29:59.746000','88,46',12),(65,'2023-06-29 19:29:59.750000','49,44',13),(67,'2023-06-29 19:59:59.747000','62,39',12),(68,'2023-06-29 19:59:59.751000','10,98',13),(70,'2023-06-29 20:06:37.370000','81,16',12),(71,'2023-06-29 20:06:37.412000','82,88',13),(73,'2023-06-29 20:06:37.429000','75,23',16),(74,'2023-06-29 20:19:54.373000','73,11',12),(75,'2023-06-29 20:19:54.415000','91,15',13),(77,'2023-06-29 20:19:54.431000','11,13',16),(78,'2023-06-29 20:34:37.772000','37,95',12),(79,'2023-06-29 20:34:37.825000','59,40',13),(81,'2023-06-29 20:34:37.843000','4,63',16),(82,'2023-06-29 20:42:27.258000','70,50',12),(83,'2023-06-29 20:42:27.300000','14,95',13),(85,'2023-06-29 20:42:27.317000','2,16',16),(86,'2023-06-29 20:43:34.109000','6,20',12),(87,'2023-06-29 20:43:34.160000','77,45',13),(89,'2023-06-29 20:43:34.177000','43,60',16),(90,'2023-06-29 20:46:21.932000','46,30',12),(91,'2023-06-29 20:46:21.978000','80,29',13),(93,'2023-06-29 20:46:21.997000','63,11',16),(94,'2023-06-29 20:46:49.711000','67,83',12),(95,'2023-06-29 20:46:49.769000','99,33',13),(97,'2023-06-29 20:46:49.788000','53,79',16),(98,'2023-06-29 20:55:56.362000','6,51',12),(99,'2023-06-29 20:55:56.411000','35,22',13),(101,'2023-06-29 20:55:56.431000','72,87',16),(102,'2023-06-29 21:02:24.886000','71,94',12),(103,'2023-06-29 21:02:24.926000','63,42',13),(105,'2023-06-29 21:02:24.942000','17,43',16),(106,'2023-06-29 21:05:16.119000','53,61',12),(107,'2023-06-29 21:05:16.168000','65,50',13),(109,'2023-06-29 21:05:16.184000','94,88',16),(110,'2023-06-29 21:11:01.072000','93,76',12),(111,'2023-06-29 21:11:01.115000','34,72',13),(113,'2023-06-29 21:11:01.131000','11,64',16),(114,'2023-06-29 21:20:28.157000','26,44',12),(115,'2023-06-29 21:20:28.198000','46,42',13),(117,'2023-06-29 21:20:28.224000','17,06',16),(118,'2023-06-29 21:22:40.366000','38,96',12),(119,'2023-06-29 21:22:40.407000','12,94',13),(121,'2023-06-29 21:22:40.423000','2,07',16),(122,'2023-06-29 21:30:32.656000','32,85',12),(123,'2023-06-29 21:30:32.698000','5,49',13),(125,'2023-06-29 21:30:32.716000','49,00',16),(126,'2023-06-29 21:34:03.139000','36,53',12),(127,'2023-06-29 21:34:03.184000','28,00',13),(129,'2023-06-29 21:34:03.203000','94,87',16),(130,'2023-06-29 21:35:44.332000','82,98',12),(131,'2023-06-29 21:35:44.372000','10,89',13),(133,'2023-06-29 21:35:44.388000','60,75',16),(134,'2023-06-29 21:37:44.341000','63,86',12),(135,'2023-06-29 21:37:44.383000','15,43',13),(137,'2023-06-29 21:37:44.399000','38,68',16),(138,'2023-06-29 21:46:44.824000','25,67',12),(139,'2023-06-29 21:46:44.864000','28,07',13),(141,'2023-06-29 21:46:44.880000','82,53',16),(142,'2023-06-29 21:49:59.369000','43,13',12),(143,'2023-06-29 21:49:59.414000','80,31',13),(145,'2023-06-29 21:49:59.432000','36,16',16),(146,'2023-06-29 21:58:30.830000','77,80',12),(147,'2023-06-29 21:58:30.871000','33,44',13),(149,'2023-06-29 21:58:30.888000','36,90',16),(150,'2023-06-29 21:59:21.243000','65,96',12),(151,'2023-06-29 21:59:21.282000','80,59',13),(153,'2023-06-29 21:59:21.297000','51,44',16),(154,'2023-06-29 22:02:22.329000','6,65',12),(155,'2023-06-29 22:02:22.370000','5,82',13),(157,'2023-06-29 22:02:22.391000','17,42',16),(158,'2023-06-29 22:07:02.688000','22,95',12),(159,'2023-06-29 22:07:02.729000','5,65',13),(161,'2023-06-29 22:07:02.744000','14,27',16),(162,'2023-06-29 22:11:04.189000','83,03',12),(163,'2023-06-29 22:11:04.231000','61,01',13),(165,'2023-06-29 22:11:04.247000','80,54',16),(166,'2023-06-29 22:11:56.091000','78,04',12),(167,'2023-06-29 22:11:56.132000','1,03',13),(169,'2023-06-29 22:11:56.151000','81,01',16),(170,'2023-06-30 06:38:40.802000','33,82',12),(171,'2023-06-30 06:38:40.863000','13,17',13),(173,'2023-06-30 06:38:40.899000','72,71',16),(174,'2023-06-30 07:08:40.768000','64,42',12),(175,'2023-06-30 07:08:40.775000','81,98',13),(177,'2023-06-30 07:08:40.787000','18,75',16),(181,'2023-06-30 07:38:40.762000','91,83',12),(182,'2023-06-30 07:38:40.768000','9,73',13),(184,'2023-06-30 07:38:40.778000','21,21',16),(188,'2023-06-30 08:08:40.768000','3,37',12),(189,'2023-06-30 08:08:40.775000','45,85',13),(191,'2023-06-30 08:08:40.784000','93,78',16),(195,'2023-06-30 08:21:12.712000','63,27',12),(196,'2023-06-30 08:21:12.765000','93,88',13),(197,'2023-06-30 08:21:12.782000','90,71',16);
/*!40000 ALTER TABLE `humidities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_hydrations`
--

DROP TABLE IF EXISTS `soil_hydrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soil_hydrations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` datetime(6) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `id_greenhouse` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc6aqtk6q2rgxs6fcc02f7evgt` (`id_greenhouse`),
  CONSTRAINT `FKc6aqtk6q2rgxs6fcc02f7evgt` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_hydrations`
--

LOCK TABLES `soil_hydrations` WRITE;
/*!40000 ALTER TABLE `soil_hydrations` DISABLE KEYS */;
INSERT INTO `soil_hydrations` VALUES (35,'2023-06-29 16:29:58.339000','86,34',12),(36,'2023-06-29 16:29:58.343000','30,69',13),(39,'2023-06-29 16:59:58.347000','0,07',12),(40,'2023-06-29 16:59:58.351000','24,49',13),(44,'2023-06-29 17:29:58.346000','37,34',12),(45,'2023-06-29 17:29:58.350000','2,28',13),(49,'2023-06-29 17:59:58.335000','30,59',12),(50,'2023-06-29 17:59:58.338000','27,63',13),(54,'2023-06-29 18:29:58.341000','90,12',12),(55,'2023-06-29 18:29:58.345000','18,42',13),(59,'2023-06-29 18:59:59.759000','92,55',12),(60,'2023-06-29 18:59:59.762000','41,61',13),(64,'2023-06-29 19:29:59.746000','85,53',12),(65,'2023-06-29 19:29:59.750000','25,59',13),(67,'2023-06-29 19:59:59.747000','86,85',12),(68,'2023-06-29 19:59:59.751000','48,80',13),(70,'2023-06-29 20:06:37.370000','98,57',12),(71,'2023-06-29 20:06:37.412000','11,46',13),(73,'2023-06-29 20:06:37.429000','12,58',16),(74,'2023-06-29 20:19:54.373000','71,64',12),(75,'2023-06-29 20:19:54.415000','93,90',13),(77,'2023-06-29 20:19:54.431000','57,15',16),(78,'2023-06-29 20:34:37.772000','50,72',12),(79,'2023-06-29 20:34:37.825000','69,36',13),(81,'2023-06-29 20:34:37.843000','79,48',16),(82,'2023-06-29 20:42:27.258000','88,07',12),(83,'2023-06-29 20:42:27.300000','93,00',13),(85,'2023-06-29 20:42:27.317000','66,18',16),(86,'2023-06-29 20:43:34.109000','0,03',12),(87,'2023-06-29 20:43:34.160000','18,21',13),(89,'2023-06-29 20:43:34.177000','37,85',16),(90,'2023-06-29 20:46:21.932000','45,53',12),(91,'2023-06-29 20:46:21.978000','22,13',13),(93,'2023-06-29 20:46:21.997000','43,90',16),(94,'2023-06-29 20:46:49.711000','23,01',12),(95,'2023-06-29 20:46:49.769000','85,97',13),(97,'2023-06-29 20:46:49.788000','32,53',16),(98,'2023-06-29 20:55:56.362000','96,23',12),(99,'2023-06-29 20:55:56.411000','72,42',13),(101,'2023-06-29 20:55:56.431000','65,69',16),(102,'2023-06-29 21:02:24.886000','76,06',12),(103,'2023-06-29 21:02:24.926000','81,14',13),(105,'2023-06-29 21:02:24.942000','46,04',16),(106,'2023-06-29 21:05:16.119000','44,76',12),(107,'2023-06-29 21:05:16.168000','26,53',13),(109,'2023-06-29 21:05:16.184000','12,48',16),(110,'2023-06-29 21:11:01.072000','37,67',12),(111,'2023-06-29 21:11:01.115000','25,53',13),(113,'2023-06-29 21:11:01.131000','44,88',16),(114,'2023-06-29 21:20:28.157000','80,05',12),(115,'2023-06-29 21:20:28.198000','95,67',13),(117,'2023-06-29 21:20:28.224000','19,36',16),(118,'2023-06-29 21:22:40.366000','92,90',12),(119,'2023-06-29 21:22:40.407000','44,44',13),(121,'2023-06-29 21:22:40.423000','26,90',16),(122,'2023-06-29 21:30:32.656000','82,67',12),(123,'2023-06-29 21:30:32.698000','17,20',13),(125,'2023-06-29 21:30:32.716000','58,65',16),(126,'2023-06-29 21:34:03.139000','45,18',12),(127,'2023-06-29 21:34:03.184000','89,45',13),(129,'2023-06-29 21:34:03.203000','54,06',16),(130,'2023-06-29 21:35:44.332000','77,97',12),(131,'2023-06-29 21:35:44.372000','46,56',13),(133,'2023-06-29 21:35:44.388000','8,25',16),(134,'2023-06-29 21:37:44.341000','92,40',12),(135,'2023-06-29 21:37:44.383000','35,76',13),(137,'2023-06-29 21:37:44.399000','1,22',16),(138,'2023-06-29 21:46:44.824000','47,93',12),(139,'2023-06-29 21:46:44.864000','27,22',13),(141,'2023-06-29 21:46:44.880000','81,10',16),(142,'2023-06-29 21:49:59.369000','33,24',12),(143,'2023-06-29 21:49:59.414000','35,15',13),(145,'2023-06-29 21:49:59.432000','78,61',16),(146,'2023-06-29 21:58:30.830000','9,55',12),(147,'2023-06-29 21:58:30.871000','22,71',13),(149,'2023-06-29 21:58:30.888000','67,65',16),(150,'2023-06-29 21:59:21.243000','13,06',12),(151,'2023-06-29 21:59:21.282000','4,96',13),(153,'2023-06-29 21:59:21.297000','85,63',16),(154,'2023-06-29 22:02:22.329000','94,75',12),(155,'2023-06-29 22:02:22.370000','5,18',13),(157,'2023-06-29 22:02:22.391000','84,06',16),(158,'2023-06-29 22:07:02.688000','43,66',12),(159,'2023-06-29 22:07:02.729000','46,82',13),(161,'2023-06-29 22:07:02.744000','22,36',16),(162,'2023-06-29 22:11:04.189000','53,86',12),(163,'2023-06-29 22:11:04.231000','84,14',13),(165,'2023-06-29 22:11:04.247000','0,74',16),(166,'2023-06-29 22:11:56.091000','52,45',12),(167,'2023-06-29 22:11:56.132000','95,52',13),(169,'2023-06-29 22:11:56.151000','72,21',16),(170,'2023-06-30 06:38:40.802000','37,30',12),(171,'2023-06-30 06:38:40.863000','36,27',13),(173,'2023-06-30 06:38:40.899000','4,36',16),(174,'2023-06-30 07:08:40.768000','11,77',12),(175,'2023-06-30 07:08:40.775000','74,08',13),(177,'2023-06-30 07:08:40.787000','69,33',16),(181,'2023-06-30 07:38:40.762000','32,59',12),(182,'2023-06-30 07:38:40.768000','61,58',13),(184,'2023-06-30 07:38:40.778000','45,63',16),(188,'2023-06-30 08:08:40.768000','78,02',12),(189,'2023-06-30 08:08:40.775000','88,79',13),(191,'2023-06-30 08:08:40.784000','28,33',16),(195,'2023-06-30 08:21:12.712000','6,98',12),(196,'2023-06-30 08:21:12.765000','98,46',13),(197,'2023-06-30 08:21:12.782000','16,31',16);
/*!40000 ALTER TABLE `soil_hydrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temperatures`
--

DROP TABLE IF EXISTS `temperatures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `temperatures` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` datetime(6) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `id_greenhouse` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjvh1n1yqggwubtbavtfptnst6` (`id_greenhouse`),
  CONSTRAINT `FKjvh1n1yqggwubtbavtfptnst6` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temperatures`
--

LOCK TABLES `temperatures` WRITE;
/*!40000 ALTER TABLE `temperatures` DISABLE KEYS */;
INSERT INTO `temperatures` VALUES (35,'2023-06-29 16:29:58.339000','24,38',12),(36,'2023-06-29 16:29:58.343000','21,12',13),(39,'2023-06-29 16:59:58.347000','39,84',12),(40,'2023-06-29 16:59:58.351000','27,56',13),(44,'2023-06-29 17:29:58.346000','27,77',12),(45,'2023-06-29 17:29:58.350000','38,97',13),(49,'2023-06-29 17:59:58.335000','35,20',12),(50,'2023-06-29 17:59:58.338000','38,50',13),(54,'2023-06-29 18:29:58.341000','35,34',12),(55,'2023-06-29 18:29:58.345000','24,28',13),(59,'2023-06-29 18:59:59.759000','31,32',12),(60,'2023-06-29 18:59:59.762000','25,71',13),(64,'2023-06-29 19:29:59.746000','38,70',12),(65,'2023-06-29 19:29:59.750000','23,79',13),(67,'2023-06-29 19:59:59.747000','37,47',12),(68,'2023-06-29 19:59:59.751000','32,10',13),(70,'2023-06-29 20:06:37.370000','35,04',12),(71,'2023-06-29 20:06:37.412000','33,51',13),(73,'2023-06-29 20:06:37.429000','38,80',16),(74,'2023-06-29 20:19:54.373000','21,22',12),(75,'2023-06-29 20:19:54.415000','23,62',13),(77,'2023-06-29 20:19:54.431000','32,36',16),(78,'2023-06-29 20:34:37.772000','36,27',12),(79,'2023-06-29 20:34:37.825000','32,93',13),(81,'2023-06-29 20:34:37.843000','34,53',16),(82,'2023-06-29 20:42:27.258000','34,78',12),(83,'2023-06-29 20:42:27.300000','38,89',13),(85,'2023-06-29 20:42:27.317000','31,41',16),(86,'2023-06-29 20:43:34.109000','21,70',12),(87,'2023-06-29 20:43:34.160000','35,23',13),(89,'2023-06-29 20:43:34.177000','29,89',16),(90,'2023-06-29 20:46:21.932000','21,81',12),(91,'2023-06-29 20:46:21.978000','30,73',13),(93,'2023-06-29 20:46:21.997000','31,17',16),(94,'2023-06-29 20:46:49.711000','26,49',12),(95,'2023-06-29 20:46:49.769000','37,21',13),(97,'2023-06-29 20:46:49.788000','22,84',16),(98,'2023-06-29 20:55:56.362000','24,13',12),(99,'2023-06-29 20:55:56.411000','24,21',13),(101,'2023-06-29 20:55:56.431000','34,93',16),(102,'2023-06-29 21:02:24.886000','30,05',12),(103,'2023-06-29 21:02:24.926000','26,67',13),(105,'2023-06-29 21:02:24.942000','39,26',16),(106,'2023-06-29 21:05:16.119000','27,70',12),(107,'2023-06-29 21:05:16.168000','34,24',13),(109,'2023-06-29 21:05:16.184000','29,87',16),(110,'2023-06-29 21:11:01.072000','37,09',12),(111,'2023-06-29 21:11:01.115000','33,26',13),(113,'2023-06-29 21:11:01.131000','33,79',16),(114,'2023-06-29 21:20:28.157000','21,62',12),(115,'2023-06-29 21:20:28.198000','21,20',13),(117,'2023-06-29 21:20:28.224000','27,79',16),(118,'2023-06-29 21:22:40.366000','39,98',12),(119,'2023-06-29 21:22:40.407000','23,24',13),(121,'2023-06-29 21:22:40.423000','38,87',16),(122,'2023-06-29 21:30:32.656000','22,52',12),(123,'2023-06-29 21:30:32.698000','31,30',13),(125,'2023-06-29 21:30:32.716000','30,13',16),(126,'2023-06-29 21:34:03.139000','25,86',12),(127,'2023-06-29 21:34:03.184000','26,89',13),(129,'2023-06-29 21:34:03.203000','26,48',16),(130,'2023-06-29 21:35:44.332000','21,88',12),(131,'2023-06-29 21:35:44.372000','31,07',13),(133,'2023-06-29 21:35:44.388000','26,15',16),(134,'2023-06-29 21:37:44.341000','31,63',12),(135,'2023-06-29 21:37:44.383000','34,83',13),(137,'2023-06-29 21:37:44.399000','34,51',16),(138,'2023-06-29 21:46:44.824000','29,82',12),(139,'2023-06-29 21:46:44.864000','30,01',13),(141,'2023-06-29 21:46:44.880000','31,11',16),(142,'2023-06-29 21:49:59.369000','36,00',12),(143,'2023-06-29 21:49:59.414000','34,02',13),(145,'2023-06-29 21:49:59.432000','38,47',16),(146,'2023-06-29 21:58:30.830000','22,87',12),(147,'2023-06-29 21:58:30.871000','29,66',13),(149,'2023-06-29 21:58:30.888000','38,35',16),(150,'2023-06-29 21:59:21.243000','22,27',12),(151,'2023-06-29 21:59:21.282000','24,20',13),(153,'2023-06-29 21:59:21.297000','28,77',16),(154,'2023-06-29 22:02:22.329000','26,75',12),(155,'2023-06-29 22:02:22.370000','30,11',13),(157,'2023-06-29 22:02:22.391000','25,26',16),(158,'2023-06-29 22:07:02.688000','27,15',12),(159,'2023-06-29 22:07:02.729000','30,83',13),(161,'2023-06-29 22:07:02.744000','34,19',16),(162,'2023-06-29 22:11:04.189000','27,43',12),(163,'2023-06-29 22:11:04.231000','25,45',13),(165,'2023-06-29 22:11:04.247000','22,09',16),(166,'2023-06-29 22:11:56.091000','34,89',12),(167,'2023-06-29 22:11:56.132000','27,82',13),(169,'2023-06-29 22:11:56.151000','23,65',16),(170,'2023-06-30 06:38:40.802000','21,77',12),(171,'2023-06-30 06:38:40.863000','22,31',13),(173,'2023-06-30 06:38:40.899000','26,23',16),(174,'2023-06-30 07:08:40.768000','22,05',12),(175,'2023-06-30 07:08:40.775000','22,78',13),(177,'2023-06-30 07:08:40.787000','31,01',16),(181,'2023-06-30 07:38:40.762000','35,59',12),(182,'2023-06-30 07:38:40.768000','25,97',13),(184,'2023-06-30 07:38:40.778000','38,04',16),(188,'2023-06-30 08:08:40.768000','32,90',12),(189,'2023-06-30 08:08:40.775000','25,05',13),(191,'2023-06-30 08:08:40.784000','35,10',16),(195,'2023-06-30 08:21:12.712000','33,89',12),(196,'2023-06-30 08:21:12.765000','24,52',13),(197,'2023-06-30 08:21:12.782000','26,17',16);
/*!40000 ALTER TABLE `temperatures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'orasimos@gmail.com','orasimos1234','orasimos'),(4,'test_user@test.com','test_user1234','test_user');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uvradiations`
--

DROP TABLE IF EXISTS `uvradiations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uvradiations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` datetime(6) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `id_greenhouse` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbswra801n315w4ytgykotol1w` (`id_greenhouse`),
  CONSTRAINT `FKbswra801n315w4ytgykotol1w` FOREIGN KEY (`id_greenhouse`) REFERENCES `greenhouses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uvradiations`
--

LOCK TABLES `uvradiations` WRITE;
/*!40000 ALTER TABLE `uvradiations` DISABLE KEYS */;
INSERT INTO `uvradiations` VALUES (35,'2023-06-29 16:29:58.339000','43,14',12),(36,'2023-06-29 16:29:58.343000','55,10',13),(39,'2023-06-29 16:59:58.347000','85,46',12),(40,'2023-06-29 16:59:58.351000','63,57',13),(44,'2023-06-29 17:29:58.346000','26,63',12),(45,'2023-06-29 17:29:58.350000','32,69',13),(49,'2023-06-29 17:59:58.335000','93,28',12),(50,'2023-06-29 17:59:58.338000','19,07',13),(54,'2023-06-29 18:29:58.341000','69,73',12),(55,'2023-06-29 18:29:58.345000','89,78',13),(59,'2023-06-29 18:59:59.759000','0,88',12),(60,'2023-06-29 18:59:59.762000','11,86',13),(64,'2023-06-29 19:29:59.746000','59,31',12),(65,'2023-06-29 19:29:59.750000','61,85',13),(67,'2023-06-29 19:59:59.747000','91,44',12),(68,'2023-06-29 19:59:59.751000','2,58',13),(70,'2023-06-29 20:06:37.370000','71,36',12),(71,'2023-06-29 20:06:37.412000','14,32',13),(73,'2023-06-29 20:06:37.429000','50,77',16),(74,'2023-06-29 20:19:54.373000','34,16',12),(75,'2023-06-29 20:19:54.415000','33,90',13),(77,'2023-06-29 20:19:54.431000','84,49',16),(78,'2023-06-29 20:34:37.772000','3,39',12),(79,'2023-06-29 20:34:37.825000','55,98',13),(81,'2023-06-29 20:34:37.843000','67,39',16),(82,'2023-06-29 20:42:27.258000','94,90',12),(83,'2023-06-29 20:42:27.300000','95,43',13),(85,'2023-06-29 20:42:27.317000','41,81',16),(86,'2023-06-29 20:43:34.109000','12,08',12),(87,'2023-06-29 20:43:34.160000','0,97',13),(89,'2023-06-29 20:43:34.177000','50,36',16),(90,'2023-06-29 20:46:21.932000','13,27',12),(91,'2023-06-29 20:46:21.978000','23,10',13),(93,'2023-06-29 20:46:21.997000','67,91',16),(94,'2023-06-29 20:46:49.711000','42,41',12),(95,'2023-06-29 20:46:49.769000','97,29',13),(97,'2023-06-29 20:46:49.788000','24,71',16),(98,'2023-06-29 20:55:56.362000','13,86',12),(99,'2023-06-29 20:55:56.411000','32,70',13),(101,'2023-06-29 20:55:56.431000','90,51',16),(102,'2023-06-29 21:02:24.886000','31,44',12),(103,'2023-06-29 21:02:24.926000','15,78',13),(105,'2023-06-29 21:02:24.942000','38,07',16),(106,'2023-06-29 21:05:16.119000','34,68',12),(107,'2023-06-29 21:05:16.168000','30,63',13),(109,'2023-06-29 21:05:16.184000','32,87',16),(110,'2023-06-29 21:11:01.072000','51,76',12),(111,'2023-06-29 21:11:01.115000','82,41',13),(113,'2023-06-29 21:11:01.131000','29,03',16),(114,'2023-06-29 21:20:28.157000','6,44',12),(115,'2023-06-29 21:20:28.198000','13,71',13),(117,'2023-06-29 21:20:28.224000','77,74',16),(118,'2023-06-29 21:22:40.366000','67,78',12),(119,'2023-06-29 21:22:40.407000','93,29',13),(121,'2023-06-29 21:22:40.423000','52,33',16),(122,'2023-06-29 21:30:32.656000','94,94',12),(123,'2023-06-29 21:30:32.698000','16,93',13),(125,'2023-06-29 21:30:32.716000','48,12',16),(126,'2023-06-29 21:34:03.139000','46,20',12),(127,'2023-06-29 21:34:03.184000','93,70',13),(129,'2023-06-29 21:34:03.203000','14,65',16),(130,'2023-06-29 21:35:44.332000','48,28',12),(131,'2023-06-29 21:35:44.372000','21,88',13),(133,'2023-06-29 21:35:44.388000','25,25',16),(134,'2023-06-29 21:37:44.341000','96,80',12),(135,'2023-06-29 21:37:44.383000','40,32',13),(137,'2023-06-29 21:37:44.399000','7,78',16),(138,'2023-06-29 21:46:44.824000','99,82',12),(139,'2023-06-29 21:46:44.864000','48,06',13),(141,'2023-06-29 21:46:44.880000','19,64',16),(142,'2023-06-29 21:49:59.369000','84,03',12),(143,'2023-06-29 21:49:59.414000','68,04',13),(145,'2023-06-29 21:49:59.432000','68,56',16),(146,'2023-06-29 21:58:30.830000','19,91',12),(147,'2023-06-29 21:58:30.871000','57,73',13),(149,'2023-06-29 21:58:30.888000','70,72',16),(150,'2023-06-29 21:59:21.243000','31,87',12),(151,'2023-06-29 21:59:21.282000','57,96',13),(153,'2023-06-29 21:59:21.297000','17,86',16),(154,'2023-06-29 22:02:22.329000','60,55',12),(155,'2023-06-29 22:02:22.370000','97,61',13),(157,'2023-06-29 22:02:22.391000','22,79',16),(158,'2023-06-29 22:07:02.688000','15,95',12),(159,'2023-06-29 22:07:02.729000','77,87',13),(161,'2023-06-29 22:07:02.744000','60,69',16),(162,'2023-06-29 22:11:04.189000','49,72',12),(163,'2023-06-29 22:11:04.231000','39,20',13),(165,'2023-06-29 22:11:04.247000','75,61',16),(166,'2023-06-29 22:11:56.091000','73,89',12),(167,'2023-06-29 22:11:56.132000','85,70',13),(169,'2023-06-29 22:11:56.151000','15,69',16),(170,'2023-06-30 06:38:40.802000','8,68',12),(171,'2023-06-30 06:38:40.863000','2,59',13),(173,'2023-06-30 06:38:40.899000','74,14',16),(174,'2023-06-30 07:08:40.768000','37,67',12),(175,'2023-06-30 07:08:40.775000','93,81',13),(177,'2023-06-30 07:08:40.787000','43,09',16),(181,'2023-06-30 07:38:40.762000','45,10',12),(182,'2023-06-30 07:38:40.768000','88,70',13),(184,'2023-06-30 07:38:40.778000','37,94',16),(188,'2023-06-30 08:08:40.768000','7,78',12),(189,'2023-06-30 08:08:40.775000','35,66',13),(191,'2023-06-30 08:08:40.784000','89,34',16),(195,'2023-06-30 08:21:12.712000','70,18',12),(196,'2023-06-30 08:21:12.765000','77,65',13),(197,'2023-06-30 08:21:12.782000','51,95',16);
/*!40000 ALTER TABLE `uvradiations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-30 12:30:48
