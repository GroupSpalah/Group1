CREATE DATABASE IF NOT EXISTS store;
USE store;

CREATE TABLE products (
	product_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	description TEXT,
	price FLOAT NOT NULL
);

CREATE TABLE orders (
	order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	numb INT NOT NULL,
	receipt_date DATE NOT NULL
);

CREATE TABLE order_to_product (
	fk_order_id INT NOT NULL,
	fk_product_id INT NOT NULL,
	FOREIGN KEY (fk_order_id) REFERENCES orders(order_id),
	FOREIGN KEY (fk_product_id) REFERENCES products(product_id)
	);