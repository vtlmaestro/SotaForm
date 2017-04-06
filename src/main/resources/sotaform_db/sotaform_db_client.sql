-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sotaform_db
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `edrpou` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phoneclient` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `authortask` varchar(70) CHARACTER SET utf8 DEFAULT NULL,
  `internaltelauthor` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_client_task_id_idx` (`id`),
  CONSTRAINT `fk_client_task_id` FOREIGN KEY (`id`) REFERENCES `task` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('78978978','uuuu@ukr.net','78978945','Миняйло Виталий',2306,1),('45645645','uuuu@ukr.net','78978945','Миняйло Виталий',2306,2),('4545454545','uuuu@ukr.net','745458484','Миняйло Виталий',2306,4),('456454545','uuuu@ukr.net','745458484','Миняйло Виталий',2306,5),('12312312','zvit33333@ukr.net','4156156','Миняйло Виталий',2306,7),('12312312','uuuu@ukr.net','4156156','Миняйло Виталий',2306,12),('77777777','uuuu@ukr.net','4156156','Ступак Алексей',2157,16),('77777777','uuuu@ukr.net','4156156','Ступак Алексей',2157,17),('12312312','zvit33333@ukr.net','78978945','Ступак Алексей',2157,18),('12312312','zvit33333@ukr.net','78978945','Ступак Алексей',2157,19),('77777777','zvit33333@ukr.net',NULL,'Ступак Алексей',2157,20),('77777777','zvit33333@ukr.net',NULL,'Ступак Алексей',2157,21),('77777777','zvit33333@ukr.net',NULL,'Ступак Алексей',2157,22);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 17:44:55
