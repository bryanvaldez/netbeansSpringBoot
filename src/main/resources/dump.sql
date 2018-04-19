/*
SQLyog Community v13.0.0 (64 bit)
MySQL - 10.1.31-MariaDB : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `test`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `idCourse` bigint(20) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `prerequisite` text,
  `numberOfHours` smallint(6) DEFAULT NULL,
  `courseCode` varchar(10) DEFAULT NULL,
  `courseType` smallint(6) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCourse`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `course` */

insert  into `course`(`idCourse`,`courseName`,`description`,`prerequisite`,`numberOfHours`,`courseCode`,`courseType`,`userCreated`,`dateCreated`,`status`) values 
(2,'Spring Boot','Spring Boot','Java',40,'SPRBOOT-01',2,'amalaver',NULL,1),
(3,'Spring boot advance','abc','nada',40,'SBOOT02',1,NULL,NULL,NULL);

/*Table structure for table `courseclass` */

DROP TABLE IF EXISTS `courseclass`;

CREATE TABLE `courseclass` (
  `idCourseClass` bigint(20) NOT NULL AUTO_INCREMENT,
  `className` varchar(100) DEFAULT NULL,
  `startHour` time DEFAULT NULL,
  `endHour` time DEFAULT NULL,
  `nroOfHours` smallint(6) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCourseClass`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `courseclass` */

/*Table structure for table `courseclassattendance` */

DROP TABLE IF EXISTS `courseclassattendance`;

CREATE TABLE `courseclassattendance` (
  `idCourseClassAttendance` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEnrollmentCourseClass` bigint(20) DEFAULT NULL,
  `attendanceType` smallint(6) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCourseClassAttendance`),
  KEY `FK_COURSECLASSATTENDANCE_01_idx` (`idEnrollmentCourseClass`),
  CONSTRAINT `FK_COURSECLASSATTENDANCE_01` FOREIGN KEY (`idEnrollmentCourseClass`) REFERENCES `enrollmentcourseclass` (`idEnrollmentCourseClass`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `courseclassattendance` */

/*Table structure for table `courseclassdetail` */

DROP TABLE IF EXISTS `courseclassdetail`;

CREATE TABLE `courseclassdetail` (
  `idCourseClassDetail` bigint(20) NOT NULL AUTO_INCREMENT,
  `idCourseClass` bigint(20) DEFAULT NULL,
  `topicName` varchar(100) DEFAULT NULL,
  `topicDetail` text,
  `goal` text,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCourseClassDetail`),
  KEY `FK_COURSECLASSDETAIL_01_idx` (`idCourseClass`),
  CONSTRAINT `FK_COURSECLASSDETAIL_01` FOREIGN KEY (`idCourseClass`) REFERENCES `courseclass` (`idCourseClass`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `courseclassdetail` */

/*Table structure for table `coursetopic` */

DROP TABLE IF EXISTS `coursetopic`;

CREATE TABLE `coursetopic` (
  `idCourseDetail` bigint(20) NOT NULL AUTO_INCREMENT,
  `idCourse` bigint(20) DEFAULT NULL,
  `topicName` varchar(100) DEFAULT NULL,
  `topicDetail` text,
  `goal` text,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idCourseDetail`),
  KEY `FK_COURSETOPIC_01_idx` (`idCourse`),
  CONSTRAINT `FK_COURSETOPIC_01` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `coursetopic` */

/*Table structure for table `enrollment` */

DROP TABLE IF EXISTS `enrollment`;

CREATE TABLE `enrollment` (
  `idEnrollment` bigint(20) NOT NULL AUTO_INCREMENT,
  `idStudent` bigint(20) DEFAULT NULL,
  `idSemester` bigint(20) DEFAULT NULL,
  `idService` bigint(20) DEFAULT NULL,
  `userCreated` varchar(45) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idEnrollment`),
  KEY `FK_ENROLLMENT_idx` (`idStudent`),
  KEY `FK_ENROLLMENT_03_idx` (`idSemester`),
  KEY `FK_ENROLLMENT_04_idx` (`idService`),
  CONSTRAINT `FK_ENROLLMENT_01` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENROLLMENT_03` FOREIGN KEY (`idSemester`) REFERENCES `semester` (`idSemester`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENROLLMENT_04` FOREIGN KEY (`idService`) REFERENCES `service` (`idService`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `enrollment` */

/*Table structure for table `enrollmentcourseclass` */

DROP TABLE IF EXISTS `enrollmentcourseclass`;

CREATE TABLE `enrollmentcourseclass` (
  `idEnrollmentCourseClass` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEnrollmentDetail` bigint(20) DEFAULT NULL,
  `idCourseClass` bigint(20) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idEnrollmentCourseClass`),
  KEY `FK_ENROLLCOURSECLASS_01_idx` (`idEnrollmentDetail`),
  CONSTRAINT `FK_ENROLLCOURSECLASS_01` FOREIGN KEY (`idEnrollmentDetail`) REFERENCES `enrollmentdetail` (`idEnrollmentDetail`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `enrollmentcourseclass` */

/*Table structure for table `enrollmentdetail` */

DROP TABLE IF EXISTS `enrollmentdetail`;

CREATE TABLE `enrollmentdetail` (
  `idEnrollmentDetail` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEnrollment` bigint(20) DEFAULT NULL,
  `idCourse` bigint(20) DEFAULT NULL,
  `idProfessor` bigint(20) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idEnrollmentDetail`),
  KEY `FK_ENROLLMENTDETAIL_01_idx` (`idEnrollment`),
  KEY `FK_ENROLLMENTDETAIL_02_idx` (`idCourse`),
  KEY `FK_ENROLLMENTDETAIL_03_idx` (`idProfessor`),
  CONSTRAINT `FK_ENROLLMENTDETAIL_01` FOREIGN KEY (`idEnrollment`) REFERENCES `enrollment` (`idEnrollment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENROLLMENTDETAIL_02` FOREIGN KEY (`idCourse`) REFERENCES `course` (`idCourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ENROLLMENTDETAIL_03` FOREIGN KEY (`idProfessor`) REFERENCES `professor` (`idProfessor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `enrollmentdetail` */

/*Table structure for table `enrollmentdetailschedule` */

DROP TABLE IF EXISTS `enrollmentdetailschedule`;

CREATE TABLE `enrollmentdetailschedule` (
  `idEnrollmentDetailSchedule` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEnrollmentDetail` bigint(20) DEFAULT NULL,
  `scheduleDate` date DEFAULT NULL,
  `startHour` time DEFAULT NULL,
  `endHour` time DEFAULT NULL,
  `numberOfHours` smallint(6) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idEnrollmentDetailSchedule`),
  KEY `FK_ENRDETAILSCHEDULE_01_idx` (`idEnrollmentDetail`),
  CONSTRAINT `FK_ENRDETAILSCHEDULE_01` FOREIGN KEY (`idEnrollmentDetail`) REFERENCES `enrollmentdetail` (`idEnrollmentDetail`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `enrollmentdetailschedule` */

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `idGrade` bigint(20) NOT NULL AUTO_INCREMENT,
  `idEnrollmentDetail` bigint(20) DEFAULT NULL,
  `gradeName` varchar(30) DEFAULT NULL,
  `gradeValue` decimal(4,2) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idGrade`),
  KEY `FK_GRADE_01_idx` (`idEnrollmentDetail`),
  CONSTRAINT `FK_GRADE_01` FOREIGN KEY (`idEnrollmentDetail`) REFERENCES `enrollmentdetail` (`idEnrollmentDetail`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `grade` */

/*Table structure for table `group` */

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `group` */

insert  into `group`(`id`,`name`,`userCreated`,`dateCreated`) values 
(1,'ROLE_ADMIN','admin','2018-04-19 00:00:00'),
(2,'ROLE_USER','admin','2018-04-19 00:00:00'),
(3,'ROLE_CONTRIB','admin','2018-04-19 00:00:00');

/*Table structure for table `professor` */

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
  `idProfessor` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `gender` smallint(6) DEFAULT NULL,
  `hireType` smallint(6) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idProfessor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `professor` */

/*Table structure for table `semester` */

DROP TABLE IF EXISTS `semester`;

CREATE TABLE `semester` (
  `idSemester` bigint(20) NOT NULL AUTO_INCREMENT,
  `semesterName` varchar(50) DEFAULT NULL,
  `description` text,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idSemester`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `semester` */

/*Table structure for table `service` */

DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `idService` bigint(20) NOT NULL AUTO_INCREMENT,
  `serviceName` varchar(100) DEFAULT NULL,
  `goal` text,
  `customerType` smallint(6) DEFAULT NULL,
  `modalityType` smallint(6) DEFAULT NULL,
  `components` text,
  `serviceType` smallint(6) DEFAULT NULL,
  `contact` text,
  `description` text,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idService`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `service` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `idStudent` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idStudent`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`idStudent`,`firstName`,`lastName`,`birthDate`,`gender`,`emailAddress`,`userCreated`,`dateCreated`,`status`) values 
(1,'Aldo Junior','Malaver Ciudad','1987-09-01 17:00:00',1,'almalaver@gmail.com','amalaver','2018-03-11 17:00:00',1);

/*Table structure for table `studentaddress` */

DROP TABLE IF EXISTS `studentaddress`;

CREATE TABLE `studentaddress` (
  `idStudentAddress` bigint(20) NOT NULL AUTO_INCREMENT,
  `idStudent` bigint(20) DEFAULT NULL,
  `addressName` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `addressType` smallint(6) DEFAULT NULL,
  `addressNumber` smallint(6) DEFAULT NULL,
  `apartment` smallint(6) DEFAULT NULL,
  `additionalInformation` varchar(100) DEFAULT NULL,
  `reference` varchar(200) DEFAULT NULL,
  `idDistrict` int(11) DEFAULT NULL,
  `userCreated` varchar(100) DEFAULT NULL,
  `dateCreated` datetime DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`idStudentAddress`),
  KEY `FK_STUDENTADDRESS_01_idx` (`idStudent`),
  CONSTRAINT `FK_STUDENTADDRESS_01` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studentaddress` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `id_group` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_group_idx` (`id_group`),
  CONSTRAINT `fk_user_group_idx` FOREIGN KEY (`id_group`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`user`,`password`,`status`,`id_group`) values 
(1,'bryan','$2a$10$P6HiIcEcg54ZMC8dxccZrugbEEuTvjM4n/MVvUN5OiST22cgy8Qmy','1',1),
(2,'jose','$2a$10$P6HiIcEcg54ZMC8dxccZrugbEEuTvjM4n/MVvUN5OiST22cgy8Qmy','1',2),
(3,'pedro','$2a$10$P6HiIcEcg54ZMC8dxccZrugbEEuTvjM4n/MVvUN5OiST22cgy8Qmy','1',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
