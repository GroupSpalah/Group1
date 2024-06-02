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

/*Stored procedures*/

CREATE PROCEDURE get_all_items()
BEGIN 
	SELECT * from item;
END;

CALL get_all_items();

/*Passing params
 * 
 * /*Parameters passing in stored procedure
	An IN parameter passes a value into a procedure. 
	The procedure might modify the value, but the modification is not visible to the caller 
	when the procedure returns. 
	
	An OUT parameter passes a value from the procedure back to 
	the caller. Its initial value is NULL within the procedure, and its value is visible to 
	the caller when the procedure returns.

	An INOUT parameter is initialized by the caller, 
	can be modified by the procedure, and any change made by the procedure is visible to the 
	caller when the procedure returns.
*/

/*IN params*/

CREATE PROCEDURE get_item_by_id(IN id INT)
BEGIN 
	SET id = 5;
	SELECT * from item WHERE item_id = id;
END;

SET @item_id = 1;

SELECT @item_id;

CALL get_item_by_id(@item_id);

/*OUT params*/

CREATE PROCEDURE get_item_by_id_out(OUT id INT)
BEGIN 
	SET id = 2;
	SELECT * from item WHERE item_id = id;
END;

SET @item_id = 1;

SELECT @item_id;

CALL get_item_by_id_out(@item_id);

/*INOUT params*/

CREATE PROCEDURE get_item_by_id_in_out(INOUT id INT)
BEGIN 
	SET id = 6;
	SELECT * from item WHERE item_id = id;
END;

SET @item_id = 1;

SELECT @item_id;

CALL get_item_by_id_in_out(@item_id);


-- User defined functions(UDF)
/*
 * For the same input parameters, 
if the stored function returns the same result, it is considered deterministic 
and otherwise the stored function is not deterministic. You have to decide whether 
a stored function is deterministic or not. If you declare it incorrectly, 
the stored function may produce an unexpected result, or the available optimization 
is not used which degrades the performance.
Это характеристика, показывающая всегда ли является результат работы
функции следствием ее аргументов.

Это означает следующее:

1. DETERMINISTIC: Функция считается детерминированной, что означает, что её результат полностью зависит от 
переданных в неё аргументов и всегда будет выдавать одинаковый результат для одинаковых входных данных. Это важно, 
когда функция используется в контексте оптимизации запросов или кеширования, так как результат можно 
предсказать и повторно использовать при одинаковых входных данных.

2. NOT DETERMINISTIC: Функция считается недетерминированной, что означает, что её результат 
может изменяться при одинаковых входных данных. 
Это обычно относится к функциям, которые включают элементы случайности, например, RAND(). В таком случае, результат 
функции может быть разным даже при одинаковых аргументах.

Эти метки (`DETERMINISTIC` и `NOT DETERMINISTIC`) важны для оптимизатора SQL-запросов и для 
обеспечения корректности выполнения запросов, 
так как они позволяют определить, можно ли оптимизировать запрос с учётом повторного использования результата функции.
 * */

CREATE FUNCTION multiplyCountOfChildren(count_of_children INT) RETURNS INT 
BEGIN 
DECLARE count INT;
	SET count = (SELECT count_of_children FROM man WHERE man_id = 2);
RETURN (count * 2);

CREATE FUNCTION multiply_price_twice(price INT) RETURNS INT DETERMINISTIC
BEGIN
	RETURN price * 2;
END

SELECT *, multiply_price_twice(price) new_price
FROM item;

/*
 * Views
 * 
 * product count price
 * 
 * */

/*
Представление (VIEW) — объект базы данных, являющийся результатом выполнения запроса к базе данных, 
определенного с помощью оператора SELECT, в момент обращения к представлению.

Представления иногда называют «виртуальными таблицами». Такое название связано с тем, что представление 
доступно для пользователя как таблица, но само оно не содержит данных, а извлекает их из таблиц в момент 
обращения к нему. Если данные изменены в базовой таблице, то пользователь получит актуальные данные 
при обращении к представлению, использующему данную таблицу; кэширования результатов выборки из таблицы 
при работе представлений не производится. При этом, механизм кэширования запросов (query cache) работает 
на уровне запросов пользователя безотносительно к тому, обращается ли пользователь к таблицам или представлениям.

http://www.mysqltutorial.org/create-sql-views-mysql.aspx
A database view is a virtual table or logical table which is defined as a SQL SELECT query with joins. 
Because a database view is similar to a database table, which consists of rows and columns, so you can query data against it.
A database view is dynamic because it is not related to the physical schema. 
The database system stores database views as a SQL SELECT statement with joins.
*/

/*ADVANTAGES OF DATABASE VIEW
1) A database view allows you to simplify complex queries: a database view is defined by 
an SQL statement that associates with many underlying tables. You can use database view to 
hide the complexity of underlying tables to the end-users and external applications. 
Through a database view, you only have to use simple SQL statements instead of complex ones with many joins.
2) A database view provides extra security layer. Security is a vital part of any relational database management system. 
The database view provides extra security for a database management system. 
The database view allows you to create the read-only view to expose read-only 
data to specific users. Users can only retrieve data in read-only view but cannot update it.
3) A database view enables computed columns. 
A database table should not have calculated columns however a database view should. 
Suppose in the orderDetails table you have quantityOrder (the number of ordered products) 
and priceEach (price per product item) columns. However, the orderDetails 
table does not have a computed column to store total sales for each line item of the order. 
If it has, the database schema would not be a good design. 
In this case, you can create a computed column named total, which is a product of quantityOrder 
and priceEach to represent the computed result. 
When you query data from the database view, the data of the computed column is calculated on fly.
*/

/*DISADVANTAGES OF DATABASE VIEW
1) Performance: querying data from a database view can be slow especially if the view is created based on other views.
2) Tables dependency: you create a view based on underlying tables of the a database. 
Whenever you change the structure of those tables that view associated with, you have to change the view as well.

VIEW NAME

Within a database, views and tables share the same namespace, therefore, a view and a table cannot have the same name.
*/

CREATE VIEW get_all_items AS SELECT * FROM item;

SELECT * FROM get_all_items;

SELECT gai.name  FROM get_all_items gai;

UPDATE get_all_items SET price = 1 WHERE item_id = 1;

DELETE FROM get_all_items WHERE item_id = 1;










