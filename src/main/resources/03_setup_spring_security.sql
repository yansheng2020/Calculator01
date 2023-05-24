USE `postcode_coordinates_three`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.bcryptcalculator.com/
--
-- Default passwords here are: test123
--

INSERT INTO `users` 
VALUES 
('yansheng','{bcrypt}$2a$10$wMx4ul15NXaugEvgbDFT8.pZ3l0BIFTMwiGFB82LF.J1JiLc0Xkqa',1),
('sam','{bcrypt}$2a$10$wMx4ul15NXaugEvgbDFT8.pZ3l0BIFTMwiGFB82LF.J1JiLc0Xkqa',1),
('susan','{bcrypt}$2a$10$wMx4ul15NXaugEvgbDFT8.pZ3l0BIFTMwiGFB82LF.J1JiLc0Xkqa',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('yansheng','ROLE_EMPLOYEE'),
('sam','ROLE_EMPLOYEE'),
('sam','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');


