CREATE DATABASE warehouse;
USE warehouse;

CREATE TABLE country(
	country_id INT AUTO_INCREMENT PRIMARY KEY,
	country_name VARCHAR(20)
);

CREATE TABLE producer(
	producer_id INT AUTO_INCREMENT PRIMARY KEY,
	producer_name VARCHAR(20) NOT NULL,// Lenovo, Lenovo
	country_id INT,//1,2
	FOREIGN KEY(country_id) REFERENCES country(country_id)
);
CREATE TABLE item(
	item_id INT AUTO_INCREMENT PRIMARY KEY,
	item_name VARCHAR(20) NOT NULL,
	manufacture_date DATE NOT NULL,
	producer_id INT,
	fragility BOOLEAN NOT NULL,
	price DECIMAL(8,2) NOT NULL,
	FOREIGN KEY(producer_id) REFERENCES producer(producer_id)
);