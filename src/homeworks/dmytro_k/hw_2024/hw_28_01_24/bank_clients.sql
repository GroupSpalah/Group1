CREATE DATABASE `bank_clients`;

CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `citizenship` varchar(100) DEFAULT 'ukrainian',
  `account_number` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `account_number` (`account_number`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`account_number`) REFERENCES `account_number` (`id`)
);

CREATE TABLE `account_number` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint NOT NULL,
  `account_number` bigint NOT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE bank_clients.newtable
CHANGE citizenship citizenship varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'ukrainian' NOT NULL;

CREATE TABLE bank_clients.account_number (
	id BIGINT  AUTO_INCREMENT PRIMARY KEY,
	amount BIGINT NOT NULL,
	account_number BIGINT NOT NULL
	);

	INSERT INTO bank_clients.account_number (amount, account_number) 
    VALUES(2000, 0987654321);   
