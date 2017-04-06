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
-- Table structure for table `answertask`
--

DROP TABLE IF EXISTS `answertask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answertask` (
  `id` int(11) NOT NULL,
  `comment` varchar(1450) COLLATE utf8_unicode_ci NOT NULL,
  `author` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answertask`
--

LOCK TABLES `answertask` WRITE;
/*!40000 ALTER TABLE `answertask` DISABLE KEYS */;
INSERT INTO `answertask` VALUES (20,'Для укладення Договору про визнання електронних документiв необхiдно виконати вимоги Роздiлу 3 Iнструкцiї з пiдготовки та подання податкових документiв в електронному виглядi засобами телекомунiкацiйного зв\'язку, затвердженої наказом ДПА України','Миняйло Виталий','28.03.2017 - 17:40:37'),(20,'Заполните данные в форме ниже и завершите действие, нажав «Получить».\r\nВ отдельном окне откроется информация о сроках действия кодов доступа для предприятия и ссылкой для его скачивания. Нажмите «Скачать».\r\nИз открывшегося файла скопируйте код.','Миняйло Виталий','28.03.2017 - 17:43:09');
/*!40000 ALTER TABLE `answertask` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 17:44:56
