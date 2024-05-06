/*
Cоздать таблицы:
Item(название, дата производства, производитель, хрупкость, цена),
Producer товара(название фирмы(Enum), страна производства(отдельная таблица) ).
Country(название).

1) Добавить новые строки с одинаковыми именами,
но разными датами или с одинаковой датой производства, но с разными имнами
2) Изменить таблицу(для существующих данных) Item с помощью команды UPDATE и
поменять price, name у некоторых items на одинаковые
и сгруппировать и посчитать:
- по цене
- по хрупкости
- по имени
- по дате производства
- по дате производства, но применить условие к дате
- по цене, но применить условие к цене
3) Изменить тип данных у колонки name с VARCHAR(20) на VARCHAR(100)
4) Посчитать товары, у которых производители находятся в странах начинающихся на букву "С"*/

USE Producer_item_country;

/*1*/
INSERT INTO Item (item_name, production_date, producer_id, fragile, price)
VALUES ('Item1', '2024-04-15', 1, FALSE, 10.99);

INSERT INTO Item (item_name, production_date, producer_id, fragile, price)
VALUES ('Item2', '2024-04-15', 2, FALSE, 15.99);

/*2*/
UPDATE Item
SET price = 20.00, item_name = 'New_name'
WHERE item_id IN (1, 2, 3);


SELECT price, COUNT(*)
FROM Item
GROUP BY price;


SELECT fragile, COUNT(*)
FROM Item
GROUP BY fragile;


SELECT item_name, COUNT(*)
FROM Item
GROUP BY item_name;


SELECT production_date, COUNT(*)
FROM Item
GROUP BY production_date;


SELECT production_date, COUNT(*)
FROM Item
WHERE production_date >= '2024-01-01'
GROUP BY production_date;


SELECT price, COUNT(*)
FROM Item
WHERE price >= 10.00
GROUP BY price;

/*3*/
ALTER TABLE Item
MODIFY COLUMN item_name VARCHAR(100);

/*4*/
SELECT COUNT(*)
FROM Item
INNER JOIN Producer
ON Item.producer_id = Producer.producer_id
INNER JOIN Country
ON Producer.country_id = Country.country_id
WHERE Country.country_name LIKE 'C%';








