USE sql_project;

create TABLE customers(
    customer_id INT,
    name varchar(20),
    phone varchar(20),
    email varchar(30)
);

create TABLE products(
    product_id INT,
    name varchar(20),
    price decimal,
    description text
);

create TABLE product_photo(
    photo_id INT,
    url varchar(100),
    product_id INT
);

create TABLE cart(
    cart_id INT,
    customer_id INT
);

create TABLE cart_products(
    cart_id INT,
    product_id INT
);

alter table customers
modify COLUMN email varchar(50);


alter table cart
add FOREIGN KEY (customer_id) REFERENCES customers(customer_id);

alter table product_photo
add FOREIGN KEY (product_id) REFERENCES products(product_id);

alter table cart_products
add FOREIGN KEY (cart_id) REFERENCES cart(cart_id);

alter table cart_products
add FOREIGN KEY (product_id) REFERENCES products(product_id);