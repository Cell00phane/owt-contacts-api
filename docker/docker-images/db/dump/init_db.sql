SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

ALTER USER 'root'@'localhost' IDENTIFIED BY 'mypassword';

CREATE DATABASE IF NOT EXISTS `db_rest_contacts_api`;

