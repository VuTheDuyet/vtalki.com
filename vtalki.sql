-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: vtalki-com
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `coursehome`
--

DROP TABLE IF EXISTS `coursehome`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coursehome` (
  `id` varchar(255) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `description_en` varchar(255) NOT NULL,
  `description_ko` varchar(255) NOT NULL,
  `description_vi` varchar(255) NOT NULL,
  `discounted_price` bigint(20) NOT NULL,
  `image` varchar(255) NOT NULL,
  `language_en` varchar(255) NOT NULL,
  `language_ko` varchar(255) NOT NULL,
  `language_vi` varchar(255) NOT NULL,
  `levels_en` varchar(255) NOT NULL,
  `levels_ko` varchar(255) NOT NULL,
  `levels_vi` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `original_price` bigint(20) NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursehome`
--

LOCK TABLES `coursehome` WRITE;
/*!40000 ALTER TABLE `coursehome` DISABLE KEYS */;
INSERT INTO `coursehome` VALUES ('121de97e-75c1-4742-98e2-0936a4de186d','2025-06-13 09:41:55.000000','Korean course for absolute beginners','처음 배우는 분들을 위한 한국어 수업','Khóa học tiếng Hàn dành cho người mới bắt đầu',990000,'/uploads/coursehome/121de97e-75c1-4742-98e2-0936a4de186d-z6734124435606_a6008eb270911f48af2cd6da1bff5358.jpg','Beginner Korean','초급 한국어','Tiếng Hàn sơ cấp','Level 1, Level 2','레벨 1, 레벨 2','Sơ cấp 1, Sơ cấp 2','https://vtalki.vn/khoa-hoc/example',1500000,'','2025-06-26 19:23:50.000000');
/*!40000 ALTER TABLE `coursehome` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `course_id` varchar(255) NOT NULL,
  `course_type_en` varchar(255) DEFAULT NULL,
  `course_type_key` varchar(255) DEFAULT NULL,
  `course_type_ko` varchar(255) DEFAULT NULL,
  `course_type_vi` varchar(255) DEFAULT NULL,
  `discounted_fee` bigint(20) DEFAULT NULL,
  `duration_en` varchar(255) DEFAULT NULL,
  `duration_key` varchar(255) DEFAULT NULL,
  `duration_ko` varchar(255) DEFAULT NULL,
  `duration_vi` varchar(255) DEFAULT NULL,
  `format_en` varchar(255) DEFAULT NULL,
  `format_key` varchar(255) DEFAULT NULL,
  `format_ko` varchar(255) DEFAULT NULL,
  `format_vi` varchar(255) DEFAULT NULL,
  `language_en` varchar(255) DEFAULT NULL,
  `language_key` varchar(255) DEFAULT NULL,
  `language_ko` varchar(255) DEFAULT NULL,
  `language_vi` varchar(255) DEFAULT NULL,
  `location_en` varchar(255) DEFAULT NULL,
  `location_key` varchar(255) DEFAULT NULL,
  `location_ko` varchar(255) DEFAULT NULL,
  `location_vi` varchar(255) DEFAULT NULL,
  `offer_expiry` date DEFAULT NULL,
  `original_fee` bigint(20) DEFAULT NULL,
  `voucher` bigint(20) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES ('EN-CON-GI','Conversation','conversation','회화','Giao tiếp',6520000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','English','en','영어','Tiếng Anh','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 04:02:03.000000'),('EN-CON-GO','Conversation','conversation','회화','Giao tiếp',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','English','en','영어','Tiếng Anh','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-25 04:21:44.000000'),('EN-CON-II','Conversation','conversation','회화','Giao tiếp',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','English','en','영어','Tiếng Anh','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:49:47.000000'),('EN-CON-IO','Conversation','conversation','회화','Giao tiếp',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','English','en','영어','Tiếng Anh','Online','online','온라인','Học qua mạng','2025-06-15',6400000,600000,NULL,'','2025-06-24 03:49:56.000000'),('KO-ADV-GI','Advanced','advanced','고급','Cao cấp',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:49:56.000000'),('KO-ADV-GO','Advanced','advanced','고급','Cao cấp',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-ADV-II','Advanced','advanced','고급','Cao cấp',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-ADV-IO','Advanced','advanced','고급','Cao cấp',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-BEG-GI','Beginner','beginner','초급','Sơ cấp',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-BEG-GO','Beginner','beginner','초급','Sơ cấp',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-BEG-II','Beginner','beginner','초급','Sơ cấp',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-BEG-IO','Beginner','beginner','초급','Sơ cấp',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-INT-GI','Intermediate','intermediate','중급','Trung cấp',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-INT-GO','Intermediate','intermediate','중급','Trung cấp',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-INT-II','Intermediate','intermediate','중급','Trung cấp',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Korean','ko','한국어','Tiếng Hàn','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('KO-INT-IO','Intermediate','intermediate','중급','Trung cấp',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Korean','ko','한국어','Tiếng Hàn','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-BUS-GI','Business','business','비즈니스','Thương mại',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-BUS-GO','Business','business','비즈니스','Thương mại',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-BUS-II','Business','business','비즈니스','Thương mại',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-BUS-IO','Business','business','비즈니스','Thương mại',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-CON-GI','Conversation','conversation','회화','Giao tiếp',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-CON-GO','Conversation','conversation','회화','Giao tiếp',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-CON-II','Conversation','conversation','회화','Giao tiếp',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-CON-IO','Conversation','conversation','회화','Giao tiếp',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-EXM-GI','Exam Preparation','exam','시험 준비','Thi tín chỉ',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-EXM-GO','Exam Preparation','exam','시험 준비','Thi tín chỉ',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-EXM-II','Exam Preparation','exam','시험 준비','Thi tín chỉ',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-EXM-IO','Exam Preparation','exam','시험 준비','Thi tín chỉ',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-KID-GI','For Kids','kids','어린이용','Cho trẻ em',6320000,'40 hours','40_hours','40시간','40 giờ','Group - In-person','group_inperson','그룹 - 대면','Nhóm - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',7900000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-KID-GO','For Kids','kids','어린이용','Cho trẻ em',3360000,'40 hours','40_hours','40시간','40 giờ','Group - Online','group_online','그룹 - 온라인','Nhóm - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',4200000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-KID-II','For Kids','kids','어린이용','Cho trẻ em',8224000,'40 hours','40_hours','40시간','40 giờ','Individual - In-person','individual_inperson','개인 - 대면','Cá nhân - Trực tiếp','Vietnamese','vi','베트남어','Tiếng Việt','Café, Academy, Company, Private Home','physical_locations','카페, 학원, 회사, 개인 주택','Quán cà phê, Học viện, Công ty, Nhà riêng','2025-06-15',10280000,500000,NULL,'','2025-06-24 03:50:20.000000'),('VI-KID-IO','For Kids','kids','어린이용','Cho trẻ em',5120000,'40 hours','40_hours','40시간','40 giờ','Individual - Online','individual_online','개인 - 온라인','Cá nhân - Trực tuyến','Vietnamese','vi','베트남어','Tiếng Việt','Online','online','온라인','Học qua mạng','2025-06-15',6400000,500000,NULL,'','2025-06-24 03:50:20.000000');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `features`
--

DROP TABLE IF EXISTS `features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `features` (
  `id` varchar(255) NOT NULL,
  `description_en` varchar(255) NOT NULL,
  `description_ko` varchar(255) NOT NULL,
  `description_vi` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `title_en` varchar(255) NOT NULL,
  `title_ko` varchar(255) NOT NULL,
  `title_vi` varchar(255) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `features`
--

LOCK TABLES `features` WRITE;
/*!40000 ALTER TABLE `features` DISABLE KEYS */;
/*!40000 ALTER TABLE `features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `float_buttons`
--

DROP TABLE IF EXISTS `float_buttons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `float_buttons` (
  `id` varchar(255) NOT NULL,
  `active` bit(1) NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `href` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `show_for` varchar(255) NOT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `float_buttons`
--

LOCK TABLES `float_buttons` WRITE;
/*!40000 ALTER TABLE `float_buttons` DISABLE KEYS */;
INSERT INTO `float_buttons` VALUES ('46a63205-43d2-471a-9978-9e239f1b4697','','2025-06-27 08:43:01.000000','dsdsdsds','kakaotalk','ko, en','2025-06-27 08:43:01.000000'),('c03f2999-db50-422e-8091-0bb9cfd65e7a','','2025-06-27 04:44:10.000000','https://facebook.com/vtalkiii','instagram','vi, en','2025-06-27 05:03:19.000000');
/*!40000 ALTER TABLE `float_buttons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leadform`
--

DROP TABLE IF EXISTS `leadform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leadform` (
  `id` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `customer_question` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `staff_note` varchar(255) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `updated_by` datetime(6) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leadform`
--

LOCK TABLES `leadform` WRITE;
/*!40000 ALTER TABLE `leadform` DISABLE KEYS */;
INSERT INTO `leadform` VALUES ('16a7204b-1395-47cc-8f29-aea012e19d3f','free_consult',NULL,'📚 베트남어 – 시험 준비\n💡 형식: 개인 - 온라인\n📍 위치: 온라인\n⏱ 수업 시간: 40시간\n💰 정가: ₩376.47\n🎯 할인가: ₩301.18\n🎟 바우처: ₩29.41\n⏳ 할인 종료일: 15/6/2025','vuduyet203@gmail.com','Duyệt Vũ Thế','84393925100','','new',NULL,'2025-06-27 08:33:23.000000','2025-06-27 08:33:23.000000'),('1c1b8ad0-010a-4b69-b674-a74e9f815277','free_consult',NULL,'scsa','vuduyet203@gmail.com','Duyệt Vũ Thế ','84393925100','khách hêt tiền','rejected',NULL,'2025-06-27 06:54:03.000000','2025-06-27 08:41:54.000000'),('41f6411f-be13-4b72-b89a-854e49656fb1','free_consult',NULL,'📚 Tiếng Việt – Thi tín chỉ\n💡 Hình thức: Cá nhân - Trực tiếp\n📍 Địa điểm: Quán cà phê, Học viện, Công ty, Nhà riêng\n⏱ Thời lượng: 40 giờ\n💰 Giá gốc: 10.280.000 ₫\n🎯 Giảm còn: 8.224.000 ₫\n🎟 Voucher: 500.000 ₫\n⏳ Ưu đãi đến: 15/6/2025','vtalki79@gmail.com','Đỗ Nguyễn Hoa Tình','8423423442','','new',NULL,'2025-06-27 08:09:06.000000','2025-06-27 08:14:41.000000'),('d8a09149-5c3a-4c65-8e74-8f530f7a520e','free_consult',NULL,'📚 베트남어 – 어린이용\n💡 형식: 개인 - 온라인\n📍 위치: 온라인\n⏱ 수업 시간: 40시간\n💰 정가: ₩376.47\n🎯 할인가: ₩301.18\n🎟 바우처: ₩29.41\n⏳ 할인 종료일: 15/6/2025','vuduyet203@gmail.com','왜 저희를 선택해야 하나요','84393925100','','new',NULL,'2025-06-27 08:34:53.000000','2025-06-27 08:34:53.000000');
/*!40000 ALTER TABLE `leadform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` varchar(255) NOT NULL,
  `answeren` varchar(255) NOT NULL,
  `answerko` varchar(255) NOT NULL,
  `answervi` varchar(255) NOT NULL,
  `creacte_at` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `translationen` varchar(255) NOT NULL,
  `translationko` varchar(255) NOT NULL,
  `translationsvi` varchar(255) NOT NULL,
  `updated_by` datetime(6) DEFAULT NULL,
  `translationvi` varchar(255) NOT NULL,
  `answer_en` varchar(255) NOT NULL,
  `answer_ko` varchar(255) NOT NULL,
  `answer_vi` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `translation_en` varchar(255) NOT NULL,
  `translation_ko` varchar(255) NOT NULL,
  `translation_vi` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('94fdf6f3-5db4-4c9a-ba64-fe6ba29e21a7','This course is suitable for all ages, from children to adults, with no prior knowledge required.','이 과정은 어린이부터 성인까지 누구나 수강하실 수 있습니다. 베트남어에 대한 사전 지식이 없어도 부담 없이 시작하실 수 있습니다.','Khóa học phù hợp với mọi lứa tuổi, từ trẻ em đến người lớn, không cần kiến thức nền tảng.',NULL,'','Who can join the course?','누가 수강할 수 있나요?','Ai có thể tham gia khóa học?',NULL,'','','','',NULL,'','','',NULL),('d18fd7ef-4b19-4cb4-ae88-374b08be49aa','Fill out the consultation form or call our hotline for instructions.','등록은 간단합니다. 홈페이지의 상담 신청서를 작성하시거나, 핫라인으로 연락 주시면 자세히 안내해 드리겠습니다.','Điền biểu mẫu tư vấn hoặc gọi hotline để được hướng dẫn.',NULL,'','How can I register?','어떻게 등록하나요?','Làm thế nào để đăng ký?',NULL,'','','','',NULL,'','','',NULL),('f5a52396-13ac-41cb-8a31-5c9c8accadd0','Yes, we offer both online and offline learning with modern platforms.','네, 가능합니다. 저희는 최신 온라인 플랫폼을 통해 온라인 수업과 오프라인 수업을 모두 제공하고 있어, 원하는 방식으로 편리하게 학습하실 수 있습니다.','Có, chúng tôi cung cấp học online và offline với nền tảng hiện đại.',NULL,'','Can I study online?','온라인으로도 수강할 수 있나요?','Tôi có thể học online không?',NULL,'','','','',NULL,'','','',NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `id` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `brand_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `logo_image` varchar(255) DEFAULT NULL,
  `map_link` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `slogan` varchar(255) NOT NULL,
  `video_link` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shortplayer`
--

DROP TABLE IF EXISTS `shortplayer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shortplayer` (
  `id` varchar(255) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `id_youtube` varchar(255) NOT NULL,
  `link_url` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_by` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shortplayer`
--

LOCK TABLES `shortplayer` WRITE;
/*!40000 ALTER TABLE `shortplayer` DISABLE KEYS */;
/*!40000 ALTER TABLE `shortplayer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shorts_players`
--

DROP TABLE IF EXISTS `shorts_players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shorts_players` (
  `id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `id_youtube` varchar(255) NOT NULL,
  `link_url` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shorts_players`
--

LOCK TABLES `shorts_players` WRITE;
/*!40000 ALTER TABLE `shorts_players` DISABLE KEYS */;
INSERT INTO `shorts_players` VALUES ('2344d81e-2362-44b7-a57c-24b6924a882f','2025-06-29 18:48:32.000000','B5p0Q_mc7L8','https://www.youtube.com/shorts/B5p0Q_mc7L8','','2025-06-29 18:48:32.000000'),('460c2d91-f467-46b8-a192-dcdd85b0b905','2025-06-29 18:48:57.000000','8dYPBepS1As','https://www.youtube.com/shorts/8dYPBepS1As','','2025-06-29 18:48:57.000000'),('7e2edc56-a4ff-4b32-a081-649ecdb2f5a7','2025-06-29 18:48:06.000000','HghR6dI4sf0','https://www.youtube.com/shorts/HghR6dI4sf0','\0','2025-06-29 19:22:18.000000');
/*!40000 ALTER TABLE `shorts_players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teachers` (
  `id` varchar(255) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `bio_en` text DEFAULT NULL,
  `bio_ko` text DEFAULT NULL,
  `bio_vi` text DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `certificates` text DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `experience` text DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `languages_spoken` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `rating` double NOT NULL,
  `reviews_count` int(11) NOT NULL,
  `teaching_intro_en` text DEFAULT NULL,
  `teaching_intro_ko` text DEFAULT NULL,
  `teaching_intro_vi` text DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES ('7f1ee5ec-23a6-4332-8bc6-2b19beb502b7','/uploads/teachers/7f1ee5ec-23a6-4332-8bc6-2b19beb502b7-mic.webp','English bio','한국어 자기소개','Giới thiệu bằng tiếng Việt','Đắk Lắk','TESOL, IELTS 8.5','2025-06-11 03:03:23.000000','1990-01-01','Từng dạy tại VUS, ILA','male','\0','Vietnamese, English','Nguyễn Văn A',4.8,30,'5 years of teaching IELTS','IELTS 교육 경험 5년','Dạy IELTS 5 năm kinh nghiệm','2025-06-26 19:19:30.000000','');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_username` varchar(255) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK1misndtpfm9hx3ttvixdus8d1` (`user_username`),
  CONSTRAINT `FK1misndtpfm9hx3ttvixdus8d1` FOREIGN KEY (`user_username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-01  9:30:18
