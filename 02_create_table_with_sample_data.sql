CREATE DATABASE  IF NOT EXISTS `postcode_coordinates_three`;
USE `postcode_coordinates_three`;

--
-- Table structure for table `postcode_coordinates_three_nl`
--

DROP TABLE IF EXISTS `postcode_coordinates_three_nl`;

CREATE TABLE `postcode_coordinates_three_nl` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_code`varchar(45) DEFAULT NULL,
  `latitude` double DEFAULT 0.0,
  `longitude` double DEFAULT 0.0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- Sample Data for table `postcode_coordinates_three_nl` if you don't want to import full NL postcode & coordinates data (around 500,000 items)
--

INSERT INTO `postcode_coordinates_three_nl` VALUES 
	(1,'6651EH',51.88760463,5.597723367),
	(2,'1189WK',52.25902055,4.869899155),
	(3,'1065VL',52.36234477,4.831505362),
	(4,'8471RK',52.87352747,5.996327647),
	(5,'7231JH',52.13855772,6.225588242);