CREATE DATABASE  IF NOT EXISTS `corvil_review_data` 
USE `corvil_review_data`;

--
-- Table structure for table `code_review_data`
--

DROP TABLE IF EXISTS `code_review_data`;

CREATE TABLE `code_review_data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` varchar(45) DEFAULT NULL,
  `review_ID` varchar(45) DEFAULT NULL,
  `number_of_files` int(11) DEFAULT NULL,
  `number_of_review_comments` int(11) DEFAULT NULL,
  `review_created_date` datetime DEFAULT NULL,
  `review_closed_date` datetime DEFAULT NULL,
  `team_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=524 DEFAULT CHARSET=utf8;
