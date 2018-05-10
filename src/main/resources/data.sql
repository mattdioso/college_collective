-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: CC_test
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `content` longtext,
  `date_created` datetime DEFAULT NULL,
  `post_name` varchar(255) NOT NULL,
  `thread_name` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `thread_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpvlaib7viw1hjbt72s4tqprlt` (`user_name`),
  KEY `FKghnxjjpgn9x6c6ct4j28qh3y5` (`thread_id`),
  KEY `FKmka5cwu1a9prus2pykxbcbeyb` (`user_id`),
  CONSTRAINT `FK9kjlxlj5d88v1mdfbd0ljhvb9` FOREIGN KEY (`id`) REFERENCES `threads` (`id`),
  CONSTRAINT `FKghnxjjpgn9x6c6ct4j28qh3y5` FOREIGN KEY (`thread_id`) REFERENCES `threads` (`id`),
  CONSTRAINT `FKmka5cwu1a9prus2pykxbcbeyb` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKpvlaib7viw1hjbt72s4tqprlt` FOREIGN KEY (`user_name`) REFERENCES `threads` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts_aud`
--

DROP TABLE IF EXISTS `posts_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts_aud` (
  `id` varchar(255) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `content` longtext,
  `date_created` datetime DEFAULT NULL,
  `post_name` varchar(255) DEFAULT NULL,
  `thread_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `thread_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKsr5ne85hjldegj923futgavkc` (`rev`),
  CONSTRAINT `FKsr5ne85hjldegj923futgavkc` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts_aud`
--

LOCK TABLES `posts_aud` WRITE;
/*!40000 ALTER TABLE `posts_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revinfo`
--

DROP TABLE IF EXISTS `revinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revinfo` (
  `rev` int(11) NOT NULL AUTO_INCREMENT,
  `revtstmp` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`rev`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revinfo`
--

LOCK TABLES `revinfo` WRITE;
/*!40000 ALTER TABLE `revinfo` DISABLE KEYS */;
INSERT INTO `revinfo` VALUES (1,1523573946432),(2,1523574256823),(3,1523574256892),(4,1523575172878),(5,1523575269967),(6,1523575358167),(7,1523575421779),(8,1523816807474),(9,1523816807633),(10,1524006457882),(11,1524067155497),(12,1524067475343),(13,1524067713830);
/*!40000 ALTER TABLE `revinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `id` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `school_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES ('b1db9d87-40e4-11e8-86e2-080027a6eb4c',0,'University of Washington'),('bfc3ec88-40e4-11e8-86e2-080027a6eb4c',0,'Seattle Pacific University'),('c40d536f-40e2-11e8-86e2-080027a6eb4c',0,'Seattle University');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_aud`
--

DROP TABLE IF EXISTS `school_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school_aud` (
  `id` varchar(255) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK4vvvxmk6gp3itk5nhatbj35gm` (`rev`),
  CONSTRAINT `FK4vvvxmk6gp3itk5nhatbj35gm` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_aud`
--

LOCK TABLES `school_aud` WRITE;
/*!40000 ALTER TABLE `school_aud` DISABLE KEYS */;
INSERT INTO `school_aud` VALUES ('466b3bad-3ea8-11e8-86e2-080027a6eb4c',6,2,NULL),('c1942431-3ea4-11e8-86e2-080027a6eb4c',5,2,NULL),('ff80818162bc155b0162bc1577ad0000',1,0,'Seattle University'),('ff80818162bc1a1a0162bc1a34490000',2,0,'Seattle University'),('ff80818162bc1a1a0162bc1a34f70001',3,0,'Seattle University'),('ff80818162bc280f0162bc282ed30000',4,0,'Seattle University'),('ff80818162bc2bde0162bc2bfafd0000',7,0,'Seattle University'),('ff80818162ca8f1f0162ca8f3b810000',8,0,'Seattle University'),('ff80818162ca8f1f0162ca8f3cc90001',9,0,'Seattle University');
/*!40000 ALTER TABLE `school_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `threads`
--

DROP TABLE IF EXISTS `threads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `threads` (
  `id` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `school_name` varchar(255) NOT NULL,
  `topic_name` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `schoolid` varchar(255) NOT NULL,
  `userid` varchar(255) NOT NULL,
  `topic_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhlkjrwf5jcutujv3awvlrhl5g` (`topic_id`),
  KEY `FKt3a2cgmiub73lc3u8b39bjl4g` (`user_id`),
  CONSTRAINT `FKhlkjrwf5jcutujv3awvlrhl5g` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`),
  CONSTRAINT `FKpf81fdcf8yr3x7um09eoqp9fl` FOREIGN KEY (`id`) REFERENCES `topic` (`id`),
  CONSTRAINT `FKt3a2cgmiub73lc3u8b39bjl4g` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threads`
--

LOCK TABLES `threads` WRITE;
/*!40000 ALTER TABLE `threads` DISABLE KEYS */;
/*!40000 ALTER TABLE `threads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `threads_aud`
--

DROP TABLE IF EXISTS `threads_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `threads_aud` (
  `id` varchar(255) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `topic_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `schoolid` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  `topic_id` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK63y9uwvnh7jm10d0ff0j0wuyn` (`rev`),
  CONSTRAINT `FK63y9uwvnh7jm10d0ff0j0wuyn` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threads_aud`
--

LOCK TABLES `threads_aud` WRITE;
/*!40000 ALTER TABLE `threads_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `threads_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `school_name` varchar(255) NOT NULL,
  `topic_name` varchar(255) NOT NULL,
  `school_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbiloch6yia8qi8uxgfa1i24ao` (`school_id`),
  CONSTRAINT `FKbiloch6yia8qi8uxgfa1i24ao` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`),
  CONSTRAINT `FKf0fr0kd20gyyssukf52g5s9so` FOREIGN KEY (`id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_aud`
--

DROP TABLE IF EXISTS `topic_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic_aud` (
  `id` varchar(255) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `topic_name` varchar(255) DEFAULT NULL,
  `school_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKljsvqc8hrtdsvrwdsragoh075` (`rev`),
  CONSTRAINT `FKljsvqc8hrtdsvrwdsragoh075` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_aud`
--

LOCK TABLES `topic_aud` WRITE;
/*!40000 ALTER TABLE `topic_aud` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic_aud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_school` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('ff80818162d97fbd0162d9801f230000',0,'dioso.matt@gmail.com','mattdioso','Seattle University'),('ff80818162d983550162d983c2b80000',0,'dioso.matt@gmail.com','mattdioso','Seattle University');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_aud`
--

DROP TABLE IF EXISTS `user_aud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_aud` (
  `id` varchar(255) NOT NULL,
  `rev` int(11) NOT NULL,
  `revtype` tinyint(4) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_school` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK5rfwf1lb9ib3k5sxootxpq9jt` (`rev`),
  CONSTRAINT `FK5rfwf1lb9ib3k5sxootxpq9jt` FOREIGN KEY (`rev`) REFERENCES `revinfo` (`rev`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_aud`
--

LOCK TABLES `user_aud` WRITE;
/*!40000 ALTER TABLE `user_aud` DISABLE KEYS */;
INSERT INTO `user_aud` VALUES ('ff80818162d5dc880162d5dd11a10000',10,0,'dioso.matt@gmail.com','mattdioso','Seattle University'),('ff80818162d97a360162d97b3d650000',11,0,'dioso.matt@gmail.com','mattdioso','Seattle University'),('ff80818162d97fbd0162d9801f230000',12,0,'dioso.matt@gmail.com','mattdioso','Seattle University'),('ff80818162d983550162d983c2b80000',13,0,'dioso.matt@gmail.com','mattdioso','Seattle University');
/*!40000 ALTER TABLE `user_aud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18  9:13:31
