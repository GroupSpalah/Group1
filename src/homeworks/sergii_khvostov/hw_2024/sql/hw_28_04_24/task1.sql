/*Cоздать таблицы:
Item(название, дата производства, производитель, хрупкость, цена),
Producer товара(название фирмы(Enum), страна производства(отдельная таблица) ).
Country(название)
Выбрать товары:
1) Одного производителя(любое название), хрупкие(boolean)
2) Товары, произведенные в разных странах Канада и Украина и одинаковые производители
3) Хрупкие из разных стран.
4) Выбрать товары, страны которых начинаютс¤ с определенной(ых) букв.
5) Вывести товары, отсортированные по стране(сортировать по убыванию и возрастанию)
и вывести только 5 первых.
6) Вывести товары с максимальной, минимальной, средней ценой
В задаче использовать Primary and Foreign keys, создать свою базу данных,
использовать корректные типы данных.
Название товара должно быть уникальным(не допускать в таблице одинаковых товаров)*/

CREATE DATABASE Producer_item_country;
USE Producer_item_country;

CREATE TABLE Country (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) UNIQUE
);
INSERT INTO Country (country_name) VALUES
 ('Ukraine'), ('Canada'), ('USA'), ('Germany'), ('France'),
 ('Italy'), ('Spain'), ('Australia'), ('Japan'), ('China'),
 ('Brazil'), ('Mexico'), ('India'), ('United Kingdom'),
 ('South Korea'), ('Turkey'), ('Indonesia'), ('Netherlands'),
 ('Saudi Arabia');


CREATE TABLE Producer(
    producer_id INT AUTO_INCREMENT PRIMARY KEY,
    producer_name ENUM,
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);
INSERT INTO Producer (producer_name, country_id) VALUES
('Apple', 1),('Samsung', 2),('Sony', 3),('Microsoft', 4),('LG', 5),('Huawei', 6),('Lenovo', 7),
('Dell', 8),('HP', 9),('Asus', 10),('Acer', 11),('Canon', 12),('Nikon', 13),('Panasonic', 14),
('Philips', 15),('Toshiba', 16),('Hitachi', 17),('Siemens', 18),('Bosch', 19),('Whirlpool', 20),
('Nokia', 21);


CREATE TABLE Item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) UNIQUE,
    production_date DATE,
    producer_id INT,
    fragile BOOLEAN,
    price DECIMAL(10, 2),
    FOREIGN KEY (producer_id) REFERENCES Producer(producer_id)
);
INSERT INTO Item (item_name, production_date, producer_id, fragile, price) VALUES
('iPhone 13', '2023-09-15', 1, 0, 999.99),
('Galaxy S21', '2023-05-20', 2, 0, 899.99),
('PlayStation 5', '2023-03-10', 3, 0, 499.99),
('Xbox Series X', '2023-04-05', 4, 0, 499.99),
('LG OLED TV', '2023-06-25', 5, 1, 1499.99),
('Huawei MateBook X Pro', '2023-08-12', 6, 0, 1299.99),
('Lenovo ThinkPad', '2023-07-18', 7, 0, 999.99),
('Dell XPS 15', '2023-09-01', 8, 0, 1499.99),
('HP Spectre x360', '2023-10-30', 9, 0, 1299.99),
('Asus ROG Strix', '2023-12-20', 10, 0, 1799.99),
('Acer Swift 3', '2023-11-15', 11, 0, 699.99),
('Canon EOS Rebel T7', '2023-08-05', 12, 0, 499.99),
('Nikon D850', '2023-10-10', 13, 0, 1999.99),
('Panasonic Lumix GH5', '2023-09-28', 14, 0, 1499.99),
('Philips Hue Starter Kit', '2023-07-02', 15, 0, 199.99),
('Toshiba Canvio Basics', '2023-05-14', 16, 0, 79.99),
('Hitachi Deskstar', '2023-04-20', 17, 0, 129.99),
('Siemens iQ500', '2023-11-30', 18, 0, 799.99),
('Bosch Serie 8', '2023-12-10', 19, 0, 899.99),
('Whirlpool WRS325SDHZ', '2023-06-08', 20, 0, 1499.99),
('Nokia 8.3', '2023-03-18', 21, 0, 599.99);


/*1*/
SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
WHERE p.producer_name = 'Producer1' AND i.fragile = TRUE;


/*2*/
SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
INNER JOIN Country c ON p.country_id = c.country_id
WHERE  c.country_name IN ('Canada', 'Ukraine');

/*3*/
SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
INNER JOIN Country c ON p.country_id = c.country_id
WHERE fragile = TRUE
GROUP BY c.country_id
HAVING count(DISTINCT c.country_id) > 1;


/*4*/
SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
INNER JOIN Country c ON p.country_id = c.country_id
WHERE c.country_name LIKE 'U%';


/*5*/
SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
INNER JOIN Country c ON p.country_id = c.country_id
ORDER BY c.country_name ASC
LIMIT 5;

SELECT * FROM Item i
INNER JOIN Producer p ON i.producer_id = p.producer_id
INNER JOIN Country c ON p.country_id = c.country_id
ORDER BY c.country_name DESC
LIMIT 5;


/*6*/
SELECT max(price) AS max_price, min(price) AS min_price, avg(price) AS avg_price FROM Item;




