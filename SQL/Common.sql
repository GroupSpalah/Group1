--http://www.sqlstyle.guide

CREATE DATABASE learn_sql;

USE learn_sql;

CREATE TABLE Persons(
first_name VARCHAR(30),
last_name VARCHAR(30),
age INT
);

INSERT INTO persons (first_name, last_name, age)
VALUES
('John', 'Travolta', 32),
('Ben',  'Kennedi',  60);

SELECT * FROM persons;

--GROUP BY

CREATE TABLE item(
 item_id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30),
 production_date DATE,
 fragility TINYINT(1),
 price INT);

 INSERT INTO item (name, production_date, fragility, price) VALUES
 ('iPhone 13', '2022-05-23', 0, 600),
 ('Samsung Galaxy S21', '2022-10-25', 1, 268),
 ('Google Pixel 6', '2022-02-28', 0, 100),
 ('OnePlus 9', '2022-11-12', 1, 200),
 ('Motorola Edge 20', '2022-12-01', 0, 300),
 ('Nokia G20', '2022-01-14', 1, 400),
 ('Sony Xperia 5 III', '2022-03-03', 0, 500);

SELECT it.name, COUNT(*)
FROM item it
GROUP BY it.name
ORDER BY it.name;

SELECT it.name, COUNT(*)
FROM item it
GROUP BY it.name
ORDER BY it.name;


SELECT it.name, COUNT(*)
FROM item it
GROUP BY it.name;

SELECT it.name, COUNT(*)
FROM item it
GROUP BY it.name
HAVING COUNT(*) > 2;

SELECT it.name, COUNT(*)
FROM item it
WHERE it.name LIKE 'N%'
GROUP BY it.name
HAVING COUNT(*) > 2;

SELECT it.name, COUNT(*)
FROM item it
WHERE it.name LIKE 'N%'
GROUP BY it.name
HAVING COUNT(*) > 2;
