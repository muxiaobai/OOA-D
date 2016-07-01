-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 srs 的数据库结构
CREATE DATABASE IF NOT EXISTS `srs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `srs`;


-- 导出  表 srs.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `courseNo` varchar(255) DEFAULT NULL,
  `credits` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.course_course 结构
CREATE TABLE IF NOT EXISTS `course_course` (
  `Course_id` int(11) NOT NULL,
  `prerequisites_id` int(11) NOT NULL,
  UNIQUE KEY `UK_r8t47id6esiwylv8bilahm979` (`prerequisites_id`),
  KEY `FK1amdcikwwhxkqbqnlsctpx7fi` (`Course_id`),
  CONSTRAINT `FK1amdcikwwhxkqbqnlsctpx7fi` FOREIGN KEY (`Course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FK1vcis9htunykmab5emskt7m3o` FOREIGN KEY (`prerequisites_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.hibernate_sequence 结构
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.professor 结构
CREATE TABLE IF NOT EXISTS `professor` (
  `id` int(11) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.section 结构
CREATE TABLE IF NOT EXISTS `section` (
  `id` int(11) NOT NULL,
  `dayOfWeek` char(1) NOT NULL,
  `sectionsOffered` tinyblob,
  `semester` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `seatingCapacity` int(11) DEFAULT NULL,
  `sectionNo` int(11) DEFAULT NULL,
  `timeOfDay` varchar(255) DEFAULT NULL,
  `professor_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkw7lb1dhqm9ric5oe31qt6wxj` (`professor_id`),
  KEY `FKo1pynipqa5v3ace3vy5ccbmy3` (`course_id`),
  CONSTRAINT `FKkw7lb1dhqm9ric5oe31qt6wxj` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`),
  CONSTRAINT `FKo1pynipqa5v3ace3vy5ccbmy3` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.student 结构
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ssn` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.student_transcriptentry 结构
CREATE TABLE IF NOT EXISTS `student_transcriptentry` (
  `Student_id` int(11) NOT NULL,
  `transcriptEntries_id` int(11) NOT NULL,
  UNIQUE KEY `UK_2dpipmg7l35huja07gyeeyx0n` (`transcriptEntries_id`),
  KEY `FKq9q04fdw6m49wx9vit7t9ghl2` (`Student_id`),
  CONSTRAINT `FKq9q04fdw6m49wx9vit7t9ghl2` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKth43s444y1h0humvjk393roeq` FOREIGN KEY (`transcriptEntries_id`) REFERENCES `transcriptentry` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.test 结构
CREATE TABLE IF NOT EXISTS `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.transcriptentry 结构
CREATE TABLE IF NOT EXISTS `transcriptentry` (
  `id` int(11) NOT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `section_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `assignedGrades_KEY` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrgpmsrdw5usd29ijs5i453825` (`section_id`),
  KEY `FKtenj4dhd4xwd7sp5f21nuy59v` (`student_id`),
  KEY `FKtnun2b2f54oy4p39j1av6m8ug` (`assignedGrades_KEY`),
  CONSTRAINT `FKrgpmsrdw5usd29ijs5i453825` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
  CONSTRAINT `FKtenj4dhd4xwd7sp5f21nuy59v` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FKtnun2b2f54oy4p39j1av6m8ug` FOREIGN KEY (`assignedGrades_KEY`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 srs.transcriptentry_transcriptentry 结构
CREATE TABLE IF NOT EXISTS `transcriptentry_transcriptentry` (
  `TranscriptEntry_id` int(11) NOT NULL,
  `transcriptEntries_id` int(11) NOT NULL,
  UNIQUE KEY `UK_llt075pivv70rva82p5vdj45t` (`transcriptEntries_id`),
  KEY `FKnttsyajdj16m0kombvd64t5d7` (`TranscriptEntry_id`),
  CONSTRAINT `FKnttsyajdj16m0kombvd64t5d7` FOREIGN KEY (`TranscriptEntry_id`) REFERENCES `transcriptentry` (`id`),
  CONSTRAINT `FKtpr1g6y86p97ot9qe5l4euaif` FOREIGN KEY (`transcriptEntries_id`) REFERENCES `transcriptentry` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
