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

-- 导出 guitar 的数据库结构
CREATE DATABASE IF NOT EXISTS `guitar` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `guitar`;


-- 导出  表 guitar.guitar 结构
CREATE TABLE IF NOT EXISTS `guitar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  guitar.guitar 的数据：~0 rows (大约)
DELETE FROM `guitar`;
/*!40000 ALTER TABLE `guitar` DISABLE KEYS */;
/*!40000 ALTER TABLE `guitar` ENABLE KEYS */;


-- 导出  表 guitar.spec 结构
CREATE TABLE IF NOT EXISTS `spec` (
  `id` int(11) NOT NULL,
  `val` varchar(255) DEFAULT NULL,
  `spec` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`spec`),
  CONSTRAINT `FKex38arjho20im2c4ppxpdm7n8` FOREIGN KEY (`id`) REFERENCES `guitar` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  guitar.spec 的数据：~0 rows (大约)
DELETE FROM `spec`;
/*!40000 ALTER TABLE `spec` DISABLE KEYS */;
/*!40000 ALTER TABLE `spec` ENABLE KEYS */;


-- 导出  表 guitar.test 结构
CREATE TABLE IF NOT EXISTS `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  guitar.test 的数据：~0 rows (大约)
DELETE FROM `test`;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
