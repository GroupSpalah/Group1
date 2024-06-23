use goods;

/*1*/
SELECT * FROM item i
JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
WHERE p.product_producer = 'Samsung' AND i.fragility = 1;

/*1.2.1*/
ALTER TABLE producer 
MODIFY product_producer ENUM('Apple', 'Samsung', 'Google', 'OnePlus', 'Motorola', 'Nokia', 'Sony', 'Huawei', 'Xiaomi', 'Oppo', 'Realme', 
'Asus', 'ZTE', 'Vivo', 'TCL', 'Lenovo', 'Black Shark', 'Nubia', 'Meizu', 'Honor', 'Samsung Canada');

INSERT INTO country (name) 
VALUES ('Canada');
INSERT INTO producer (product_producer, FK_producer_country) 
VALUES ('Samsung', (SELECT id FROM country WHERE name = 'Canada'));
INSERT INTO item (name, production_date, FK_item_producer, fragility, price) 
VALUES ('New Samsung Product 2', '2024-10-12', 22, 1, 500);

/*1.2.2*/
SELECT * FROM item i
inner JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
inner JOIN country c
ON p.FK_producer_country = c.id
WHERE p.product_producer = 'Samsung';

/*1.3*/
SELECT * FROM item i
JOIN producer p
ON item.FK_item_producer = p.manufacturer_id
JOIN country c
ON p.FK_producer_country = c.id
WHERE i.fragility = 1;

/*4*/
SELECT * FROM item i
JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
JOIN country c
ON p.FK_producer_country = c.id
WHERE c.name LIKE 'C%';

/*5*/
SELECT * FROM item i
JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
JOIN country c
ON p.FK_producer_country = c.id
ORDER BY c.name ASC
LIMIT 5;

SELECT * FROM item i
JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
JOIN country c
ON p.FK_producer_country = country.id
ORDER BY c.name DESC
LIMIT 5;

/*6*/
SELECT 
MAX(price) AS MaxPrice, 
MIN(price) AS MinPrice, 
AVG(price) AS AvgPrice FROM item;

/*2.1*/
INSERT INTO item (name, production_date, FK_item_producer, fragility, price) 
VALUES 
('iPhone 13',                  '2024-01-01', 1, 0, 100), 
('Samsung Galaxy S21',         '2024-02-02', 2, 1, 200), 
('Google Pixel 6',             '2024-03-03', 3, 0, 300), 
('OnePlus 9',                  '2024-03-03', 4, 1, 400);

/*2.2.1*/
UPDATE item SET price = 500, name = 'New product name' WHERE id IN (1, 2, 3);

/*2.2.2*/
SELECT price, COUNT(*) 
FROM item 
GROUP BY price;

SELECT fragility, COUNT(*) 
FROM item 
GROUP BY fragility;

SELECT name, COUNT(*) 
FROM item 
GROUP BY name;

SELECT production_date, COUNT(*) 
FROM item 
GROUP BY production_date;

/*2.4*/
ALTER TABLE item MODIFY name VARCHAR(100);

/*2.5*/
SELECT COUNT(*) 
FROM item i
JOIN producer p
ON i.FK_item_producer = p.manufacturer_id
JOIN country c
ON p.FK_producer_country = c.id
WHERE c.name LIKE 'C%';

INSERT INTO producer (product_producer, FK_producer_country) VALUES 
('Samsung', (SELECT id FROM country WHERE name = 'Canada'));
INSERT INTO item (name, production_date, FK_item_producer, fragility, price) VALUES 
('New Samsung Product 2', '2024-10-12', 22, 1, 500);


/*не работает*/
/*ALTER TABLE producer CHANGE manufacturer_id id INT AUTO_INCREMENT PRIMARY KEY;*/

