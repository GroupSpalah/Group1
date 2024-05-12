CREATE DATABASE warehouse;

CREATE TABLE countries(
	country_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(25)
);

CREATE TABLE producers(
	producer_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(25) NOT NULL,
	fk_country_id INT,
	FOREIGN KEY(fk_country_id) REFERENCES countries(country_id)
);
CREATE TABLE items(
	item_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	manufacture_date DATE NOT NULL,
	fk_producer_id INT,
	fragility BOOLEAN NOT NULL,
	price DECIMAL(12,2) NOT NULL,
	FOREIGN KEY(fk_producer_id) REFERENCES producers(producer_id)
);