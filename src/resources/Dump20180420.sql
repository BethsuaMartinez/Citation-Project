-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: citation
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `citation`
--

DROP TABLE IF EXISTS `citation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citation` (
  `id` int(11) NOT NULL,
  `licenseNo` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `permitNo` varchar(45) DEFAULT NULL,
  `vehicleModel` varchar(45) DEFAULT NULL,
  `vehicleColor` varchar(45) DEFAULT NULL,
  `violationType` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `issuedBy` varchar(45) DEFAULT NULL,
  `otherViolation` varchar(45) DEFAULT NULL,
  `isPaid` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citation`
--

LOCK TABLES `citation` WRITE;
/*!40000 ALTER TABLE `citation` DISABLE KEYS */;
INSERT INTO `citation` VALUES (0,'KMOAW','GA','32134','Ford','Black','2,5,7','Dec 8','6:00 PM ','San Benito','Bethsua','',0),(239,'JKPSP','LA','27830','Ford','Red','2,5,7','Dec 8','6:00 PM ','San Benito','Juan','',1),(1335,'DVF129F','Texas','67899554','Ford','Blue','0,4,6,8','Feb 12','12:00','Pharr','Jose','parked wrong',1),(1336,'QZCS','Texas','6543','Nissan','Grey','2,7','Feb 87','12:00','Pharr','Bethsua','',1),(1337,'OOLKJK','Texas','5675','Toyota','Green','0,3,6','Feb 87','9:23','Pharr','Bethsua','',0),(1338,'NHGVHHJHG','Texas','5675','Ford','White','8','Feb 1','9:23','Pharr','Bethsua','',1),(1339,'BVDFGHNB','CA','12508','Ford','Purple','7,8','Jan 12 2015','2:20 pm','Toronto','Jaime','high speed',0),(1340,'ASDWSx','Texas','5675','Toyota','Green','0,3,6','Feb 87','9:23','Pharr','Jaime','',0),(1341,'HGJSOL','GA','32134','Ford','Pink','2,5,7','Dec 8','6:00 PM ','San Benitio','Bethsua','',1);
/*!40000 ALTER TABLE `citation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-20 15:21:28
