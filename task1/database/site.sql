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

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;


-- 导出  表 test.guitar 结构
CREATE TABLE IF NOT EXISTS `guitar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT '0',
  `backwood` varchar(50) DEFAULT '',
  `topwood` varchar(50) DEFAULT '',
  `type` varchar(50) DEFAULT '',
  `builder` varchar(50) DEFAULT '',
  `guitarmodel` varchar(50) DEFAULT '',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- 正在导出表  test.guitar 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `guitar` DISABLE KEYS */;
INSERT IGNORE INTO `guitar` (`id`, `price`, `backwood`, `topwood`, `type`, `builder`, `guitarmodel`) VALUES
	(3, 2, '2', '2', 'y', '', ''),
	(4, 2, 'fa', '阿萨斯', '从郑州', '是', '是 '),
	(5, 12.5, 'back铁', '木头', '带带电', '张', 'modelzhang'),
	(6, 2.5, 'bck铁', '塑料', '光', '李', 'modelli'),
	(7, 232.5, 'back纤维', '塑料', '耳麦', '赵', 'modelzhao'),
	(8, 12.5, 'back铁', '木头', '带带电', '张', 'modelzhang'),
	(9, 2.5, 'bck铁', '塑料', '光', '李', 'modelli'),
	(10, 232.5, 'back纤维', '塑料', '耳麦', '赵', 'modelzhao'),
	(11, 12.5, 'b铁', '木头', '带带电', '张', 'model'),
	(12, 14.5, 'b铁', '木头', '带带电', '张', 'modelzhang'),
	(13, 25.5, 'b铁', '塑料', '光', '李', 'modelli'),
	(14, 22.5, 'backww', '才', '耳麦', '赵', 'modelzhao'),
	(15, 162.5, 'back我铁', '木头', '带带电', '张', 'model'),
	(16, 12.5, 'back铁', '木头', '带带电', '张', 'modelzhang'),
	(17, 2.5, 'bck铁', '塑料', '光', '李', 'modelli'),
	(18, 232.5, 'back纤维', '塑料', '耳麦', '赵', 'modelzhao'),
	(19, 12.5, 'b铁', '木头', '带带电', '张', 'model'),
	(20, 14.5, 'b铁', '木头', '带带电', '张', 'modelzhang'),
	(21, 25.5, 'b铁', '塑料', '光', '李', 'modelli'),
	(22, 22.5, 'backww', '才', '耳麦', '赵', 'modelzhao'),
	(23, 162.5, 'back我铁', '木头', '带带电', '张', 'model');
/*!40000 ALTER TABLE `guitar` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
