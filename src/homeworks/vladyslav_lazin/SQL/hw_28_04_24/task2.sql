--2.1
INSERT INTO items (name, manufacture_date, fk_producer_id, fragility, price)
VALUES ('SOLOIST', '2024-05-11', 22, TRUE, 6800);

INSERT INTO items (name, manufacture_date, fk_producer_id, fragility, price)
VALUES ('Sprite', '2024-05-11', 21, FALSE, 1.49);

--2.2
UPDATE items
SET name = 'Coca Cola Original', price = 1.99
WHERE item_id IN (17, 83);

SELECT price, COUNT(*)
FROM items i
GROUP BY i.price;

SELECT fragility , COUNT(*)
FROM items i
GROUP BY i.fragility;

SELECT name, COUNT(*)
FROM items i
GROUP BY i.name;

SELECT manufacture_date, COUNT(*)
FROM items i
GROUP BY i.manufacture_date;

SELECT manufacture_date, COUNT(*)
FROM items i
WHERE manufacture_date = '2024-05-11'
GROUP BY i.manufacture_date;

SELECT price , COUNT(*)
FROM items i
WHERE i.price = 1.99
GROUP BY i.price;

--2.3
ALTER TABLE items
MODIFY COLUMN name VARCHAR(100);

--2.4
SELECT COUNT(*)
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
WHERE c.name LIKE 'C%';