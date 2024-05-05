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

create TABLE Country (
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) UNIQUE
);

create TABLE Producer(
    producer_id INT AUTO_INCREMENT PRIMARY KEY,
    producer_name ENUM('Producer1', 'Producer2', 'Producer3'),
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

create TABLE Item (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) UNIQUE,
    production_date DATE,
    producer_id INT,
    fragile BOOLEAN,
    price DECIMAL(10, 2),
    FOREIGN KEY (producer_id) REFERENCES Producer(producer_id)
);

/*1*/
select * from Item
where producer_id = (select producer_id from Producer where producer_name = 'Producer1')
and fragile = TRUE;

/*2*/
select * from Item
where producer_id in (
    select producer_id from Producer
    where country_id in (
        select country_id from Country
        where country_name in ('Canada', 'Ukraine')
    )
)
group by producer_id
having count(distinct Country (country_id) = 2;

/*3*/
select * from Item
where fragile = TRUE
group by country_id
having count(distinct country_id) > 1;

/*4*/
select * from Item
where producer_id in (
    select producer_id from Producer
    where country_id in (
        select country_id from Country
        where country_name like 'U%'
    )
);

/*5*/
select * from Item
order by country_id asc, item_name asc
LIMIT 5;

/*6*/
select max(price) as max_price, min(price) as min_price, avg(price) as avg_price from Item;




