CREATE DATABASE online_shop;
USE online_shop;
CREATE TABLE products
(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(8,2)
);
CREATE TABLE produsct_photos
(
    product_photo_id INT AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(255),
    product_id INT,
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);
CREATE TABLE customers
(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(40)
);
CREATE TABLE carts
(
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);
CREATE TABLE carts_to_products
(
    cart_id INT,
    product_id INT,
    FOREIGN KEY(cart_id) REFERENCES carts(cart_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
);
