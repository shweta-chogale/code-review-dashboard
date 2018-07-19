CREATE DATABASE  IF NOT EXISTS `code_review_data` 
USE `code_review_data`;

--
-- Table structure for table `code_review_summary`
--

DROP TABLE IF EXISTS `code_review_summary`;

CREATE TABLE `code_review_summary` (
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
