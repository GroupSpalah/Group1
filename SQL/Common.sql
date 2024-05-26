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







