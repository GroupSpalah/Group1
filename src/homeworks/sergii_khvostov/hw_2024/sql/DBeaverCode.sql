USE sql_project;

CREATE TABLE customers(
    customer_id INT,
    name varchar(20),
    phone varchar(20),
    email varchar(30)
);

CREATE TABLE products(
    product_id INT,
    name varchar(20),
    price decimal,
    description text
);

CREATE TABLE product_photo(
    photo_id INT,
    url varchar(100),
    product_id INT
);

CREATE TABLE cart(
    cart_id INT,
    customer_id INT
);

CREATE TABLE cart_products(
    cart_id INT,
    product_id INT
);

ALTER TABLE customers
MODIFY COLUMN email varchar(50);


ALTER TABLE cart
ADD FOREIGN KEY (customer_id) REFERENCES customers(customer_id);

ALTER TABLE product_photo
ADD FOREIGN KEY (product_id) REFERENCES products(product_id);

ALTER TABLE cart_products
ADD FOREIGN KEY (cart_id) REFERENCES cart(cart_id);

ALTER TABLE cart_products
ADD FOREIGN KEY (product_id) REFERENCES products(product_id);