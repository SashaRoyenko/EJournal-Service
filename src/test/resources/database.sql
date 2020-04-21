CREATE DATABASE IF NOT EXISTS `e-journal` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `e-journal`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: e-journal
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `school_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`),
  KEY `FK8iobx67713d3iha5k8w1antqd` (`school_id`),
  CONSTRAINT `FK8iobx67713d3iha5k8w1antqd` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'ADMIN','string@gmail.com','string','string','string',1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_group`
--

DROP TABLE IF EXISTS `class_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `class_group` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  `schedule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ku40yuuivtmfohqjj1q61rf0` (`teacher_id`),
  KEY `FKp3kvvy2pn2hm935kvfmmrm9l5` (`schedule_id`),
  CONSTRAINT `FK5ku40yuuivtmfohqjj1q61rf0` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKp3kvvy2pn2hm935kvfmmrm9l5` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_group`
--

LOCK TABLES `class_group` WRITE;
/*!40000 ALTER TABLE `class_group` DISABLE KEYS */;
INSERT INTO `class_group` VALUES (1,'tv-71',NULL,NULL);
/*!40000 ALTER TABLE `class_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (18),(18),(18),(18),(18),(18),(18),(18),(18);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homework`
--

DROP TABLE IF EXISTS `homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `homework` (
  `id` bigint(20) NOT NULL,
  `deadline` date DEFAULT NULL,
  `group_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs5n1v1ecml68qyuin02erjoah` (`group_id`),
  KEY `FK2kd5kaavry4vb9t349g82pab1` (`subject_id`),
  CONSTRAINT `FK2kd5kaavry4vb9t349g82pab1` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  CONSTRAINT `FKs5n1v1ecml68qyuin02erjoah` FOREIGN KEY (`group_id`) REFERENCES `class_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homework`
--

LOCK TABLES `homework` WRITE;
/*!40000 ALTER TABLE `homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mark` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `score` varchar(255) DEFAULT NULL,
  `student_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `teacher_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowe2x7exr25ndsor8yq0b9710` (`student_id`),
  KEY `FKt6kc1aolba30ld4m8fqmcrt1q` (`subject_id`),
  KEY `FKhrg5stnw0lmwchxv7lq6pn9va` (`teacher_id`),
  CONSTRAINT `FKhrg5stnw0lmwchxv7lq6pn9va` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKowe2x7exr25ndsor8yq0b9710` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt6kc1aolba30ld4m8fqmcrt1q` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `native`
--

DROP TABLE IF EXISTS `native`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `native` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `native`
--

LOCK TABLES `native` WRITE;
/*!40000 ALTER TABLE `native` DISABLE KEYS */;
INSERT INTO `native` VALUES (1);
/*!40000 ALTER TABLE `native` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent_student`
--

DROP TABLE IF EXISTS `parent_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parent_student` (
  `student_id` bigint(20) NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  KEY `FKfwtoe5cmm9kjsegvmtab7tfor` (`parent_id`),
  KEY `FKtovkwdqqfsurx3y849r3h4rak` (`student_id`),
  CONSTRAINT `FKfwtoe5cmm9kjsegvmtab7tfor` FOREIGN KEY (`parent_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtovkwdqqfsurx3y849r3h4rak` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent_student`
--

LOCK TABLES `parent_student` WRITE;
/*!40000 ALTER TABLE `parent_student` DISABLE KEYS */;
INSERT INTO `parent_student` VALUES (2,3),(2,4);
/*!40000 ALTER TABLE `parent_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdk4kgqp47a9w6864j6b1iaj95` (`group_id`),
  CONSTRAINT `FKdk4kgqp47a9w6864j6b1iaj95` FOREIGN KEY (`group_id`) REFERENCES `class_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_item`
--

DROP TABLE IF EXISTS `schedule_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedule_item` (
  `id` bigint(20) NOT NULL,
  `cabinet` varchar(255) DEFAULT NULL,
  `day_of_week` varchar(255) NOT NULL,
  `subject_number` tinyint(4) NOT NULL,
  `subject_id` bigint(20) NOT NULL,
  `teacher_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKaccphm9imm5pej6qvj3638fd5` (`subject_id`),
  KEY `FK61wgk671hfxcy8k62sph29nit` (`teacher_id`),
  CONSTRAINT `FK61wgk671hfxcy8k62sph29nit` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKaccphm9imm5pej6qvj3638fd5` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_item`
--

LOCK TABLES `schedule_item` WRITE;
/*!40000 ALTER TABLE `schedule_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_schedule_item`
--

DROP TABLE IF EXISTS `schedule_schedule_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `schedule_schedule_item` (
  `schedule_id` bigint(20) NOT NULL,
  `schedule_item_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_8j71k3bfng06jp6084dobgxet` (`schedule_item_id`),
  KEY `FKfxwvoh4b5suljg7epq8lw7sil` (`schedule_id`),
  CONSTRAINT `FKfxwvoh4b5suljg7epq8lw7sil` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`),
  CONSTRAINT `FKgqssg2tti0559vkahmx8tqfmp` FOREIGN KEY (`schedule_item_id`) REFERENCES `schedule_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_schedule_item`
--

LOCK TABLES `schedule_schedule_item` WRITE;
/*!40000 ALTER TABLE `schedule_schedule_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_schedule_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `school` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `director_id` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `settlement_name` varchar(255) DEFAULT NULL,
  `settlement_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7su5xu7e0wqd5gfex7gl1ljvb` (`director_id`),
  CONSTRAINT `FK7su5xu7e0wqd5gfex7gl1ljvb` FOREIGN KEY (`director_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'nam','reg','url',1,NULL,NULL,NULL),(12,'orest','kyiv','any',NULL,'sanya','any',0),(16,'string','string','second',NULL,'string','string',0),(17,'string','string','third',NULL,'string','string',0);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_group`
--

DROP TABLE IF EXISTS `student_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_group` (
  `group_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_dk7u5r2x996wqj71b3muwpryj` (`student_id`),
  KEY `FKeh8oao8j2tvc5xn8hfn718fab` (`group_id`),
  CONSTRAINT `FKeh8oao8j2tvc5xn8hfn718fab` FOREIGN KEY (`group_id`) REFERENCES `class_group` (`id`),
  CONSTRAINT `FKo0h5m694ojcark4483a26idiq` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_group`
--

LOCK TABLES `student_group` WRITE;
/*!40000 ALTER TABLE `student_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `second_name` varchar(255) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `school_id` bigint(20) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhbkxju61kpht7qnnhemgjv3u7` (`school_id`),
  KEY `FKc9wloemv2pr0rjwr7xb4kpjln` (`group_id`),
  CONSTRAINT `FKc9wloemv2pr0rjwr7xb4kpjln` FOREIGN KEY (`group_id`) REFERENCES `class_group` (`id`),
  CONSTRAINT `FKhbkxju61kpht7qnnhemgjv3u7` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Director',1,'a','a','a','a','1','a',NULL,NULL,1,NULL),('Student',2,'s','orest','sanya','a','1','a','2012-03-20',NULL,1,1),('Parent',3,'mama','mama','mama','mama','1','mama',NULL,NULL,1,NULL),('Parent',4,'tato','tato','tato','tato','1','tato',NULL,NULL,1,NULL),('student',5,'string@gmail.com','string','string',NULL,NULL,'string',NULL,NULL,1,1),('student',6,'string@gmail.com','string','string',NULL,NULL,'string',NULL,NULL,1,1),('student',7,'string@gmail.com','string','string','string',NULL,'string',NULL,NULL,1,1),('student',8,'string@gmail.com','string','string','string',NULL,'string',NULL,NULL,1,1),('student',9,'string@gmail.com','string','string','string',NULL,'string',NULL,NULL,1,1),('student',10,'string@a.com','string','string','string',NULL,'string',NULL,NULL,1,1),('student',11,'string@gmail.com','string','string','string',NULL,'string',NULL,NULL,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-21 21:09:05
