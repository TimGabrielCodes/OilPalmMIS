-- -------------------------------------------------------------
-- TablePlus 4.6.4(414)
--
-- https://tableplus.com/
--
-- Database: oilmill_db
-- Generation Time: 2022-05-24 14:56:25.4420
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `id` int NOT NULL AUTO_INCREMENT,
  `batchMonth` varchar(30) DEFAULT NULL,
  `batchDate` date DEFAULT NULL,
  `logger` int DEFAULT NULL,
  `batchName` varchar(200) DEFAULT NULL,
  `harvested` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `logger` (`logger`),
  CONSTRAINT `batch_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `expense`;
CREATE TABLE `expense` (
  `id` int NOT NULL AUTO_INCREMENT,
  `expenseCategory` varchar(500) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `logger` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `logger` (`logger`),
  CONSTRAINT `expense_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `harvest`;
CREATE TABLE `harvest` (
  `id` int NOT NULL AUTO_INCREMENT,
  `logger` int DEFAULT NULL,
  `batch` int DEFAULT NULL,
  `stockInBunches` int DEFAULT NULL,
  `costPerBunch` decimal(10,0) DEFAULT NULL,
  `dateAdded` date DEFAULT NULL,
  `milled` tinyint(1) DEFAULT NULL,
  `otherCosts` decimal(10,0) DEFAULT NULL,
  `honorarium` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `logger` (`logger`),
  KEY `batch` (`batch`),
  CONSTRAINT `harvest_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `user` (`id`),
  CONSTRAINT `harvest_ibfk_2` FOREIGN KEY (`batch`) REFERENCES `batch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int NOT NULL AUTO_INCREMENT,
  `incomeType` varchar(200) DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `receivedFrom` varchar(200) DEFAULT NULL,
  `logger` int DEFAULT NULL,
  `incomeDate` date DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `income_id_uindex` (`id`),
  KEY `logger` (`logger`),
  CONSTRAINT `income_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `mill`;
CREATE TABLE `mill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `batch` int DEFAULT NULL,
  `harvestStock` int DEFAULT NULL,
  `numberOfPresses` int DEFAULT NULL,
  `millingDate` date DEFAULT NULL,
  `logger` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `batch` (`batch`) USING BTREE,
  KEY `logger` (`logger`),
  CONSTRAINT `mill_ibfk_4` FOREIGN KEY (`logger`) REFERENCES `user` (`id`),
  CONSTRAINT `mill_ibfk_5` FOREIGN KEY (`batch`) REFERENCES `batch` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `millingExpense`;
CREATE TABLE `millingExpense` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fuel` decimal(10,0) DEFAULT NULL,
  `storage` decimal(10,0) DEFAULT NULL,
  `harvestStockCost` decimal(10,0) DEFAULT NULL,
  `adhocLabour` decimal(10,0) DEFAULT NULL,
  `firewood` decimal(10,0) DEFAULT NULL,
  `fruitPurchase` decimal(10,0) DEFAULT NULL,
  `plantParts` decimal(10,0) DEFAULT NULL,
  `logger` int DEFAULT NULL,
  `mill` int DEFAULT NULL,
  `honorarium` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `logger` (`logger`),
  KEY `mill` (`mill`),
  CONSTRAINT `millingexpense_ibfk_1` FOREIGN KEY (`logger`) REFERENCES `user` (`id`),
  CONSTRAINT `millingexpense_ibfk_2` FOREIGN KEY (`mill`) REFERENCES `mill` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(200) DEFAULT NULL,
  `otherNames` varchar(200) DEFAULT NULL,
  `surname` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `batch` (`id`, `batchMonth`, `batchDate`, `logger`, `batchName`, `harvested`) VALUES
(10, 'February-2022', '2022-05-24', 1, 'Test Batch ', 1),
(11, 'April-2022', '2022-04-11', 1, 'April Batch', 1),
(15, 'May-2022', '2022-05-23', 1, 'May 2022 Batch', 0);

INSERT INTO `expense` (`id`, `expenseCategory`, `amount`, `remark`, `date`, `logger`) VALUES
(6, 'HONORARIUM', 80000, 'Honorarium ', '2022-05-16', 1),
(7, 'BUSH_CUTTING', 249827, 'No remark', '2022-05-28', 1),
(8, 'HARVEST_COST', 500000, 'No remarks', '2022-05-16', 1);

INSERT INTO `harvest` (`id`, `logger`, `batch`, `stockInBunches`, `costPerBunch`, `dateAdded`, `milled`, `otherCosts`, `honorarium`) VALUES
(11, 1, 11, 8000, 5000, '2022-05-11', 1, 54454545, NULL),
(16, 1, 10, 50000, 2000, '2022-05-16', 1, 5000, NULL),
(20, 1, 15, 50000, 4000, '2022-05-23', 0, 5000020, 3935235);

INSERT INTO `income` (`id`, `incomeType`, `amount`, `receivedFrom`, `logger`, `incomeDate`, `remark`, `unit`) VALUES
(8, 'FIBRE_PALM_OIL', 700000, 'Mr Goodnews Gamage', 1, '2022-05-12', 'ihaoiehwoeihtwe', 'CANS'),
(9, 'FIBRE_PALM_OIL', 200000, 'Mr Goodnews Gamage', 1, '2022-05-13', 'ihaoiehwoeihtwe', 'CANS'),
(10, 'MILLING_CHARGE_PO', 500000, 'Mr Goodnews Gamage', 1, '2022-05-14', 'No remarks', 'BAGS_50KG'),
(11, 'FIBRE_PALM_OIL', 50000, 'Mr Samuel', 1, '2022-05-01', 'None', 'DRUMS'),
(12, 'CRUDE_PALM_OIL', 500000, 'Mr Paul Onirinkurin', 1, '2022-05-26', 'none', 'CANS'),
(13, 'PKS', 1500000, 'Mr Sammy', 1, '2022-05-19', 'NO remark\r\n', 'BAGS_25KG');

INSERT INTO `mill` (`id`, `batch`, `harvestStock`, `numberOfPresses`, `millingDate`, `logger`) VALUES
(36, 11, 500, 500, '2022-05-31', 1),
(37, 10, 200, 400, '2022-05-16', 1);

INSERT INTO `millingExpense` (`id`, `fuel`, `storage`, `harvestStockCost`, `adhocLabour`, `firewood`, `fruitPurchase`, `plantParts`, `logger`, `mill`, `honorarium`) VALUES
(18, 500, 600, 400000, 7878, 565, 4566, 64545, 1, 37, 500);

INSERT INTO `user` (`id`, `firstName`, `otherNames`, `surname`, `email`, `password`, `isAdmin`) VALUES
(1, 'Timothy', 'Gabriel', 'Zinwota', 'zinwotatimothy@gmail.com', 'password', 1),
(2, 'Goodnews', 'Gamage', 'Gamage', 'goodnews@gmail.com', 'password', 1);



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;