
-- 1. Create User as Root --

-- Drop user first if they exist
DROP USER if exists 'postcodeTester1'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'postcodeTester1'@'localhost' IDENTIFIED BY 'postcodeTester1';

GRANT ALL PRIVILEGES ON * . * TO 'postcodeTester1'@'localhost';
