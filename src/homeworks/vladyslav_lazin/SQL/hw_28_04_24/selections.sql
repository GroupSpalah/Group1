--1.1
SELECT i.name item, i.manufacture_date manufactured, i.price price, p.name producer
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
WHERE i.fragility = TRUE
AND p.name = 'Samsung Electronics';

--1.2
SELECT i.name item,
        i.manufacture_date manufatured,
        i.price price,
    p.name producer,
    c.name country
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
WHERE c.name IN ('Japan', 'United States')
ORDER BY p.name;

--1.3
SELECT i.name item, p.name producer, c.name country
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
WHERE  fragility = TRUE;

--1.4
SELECT i.name item, i.manufacture_date manufactured,
i.price price, p.name producer_name, c.name country_name
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
WHERE c.name LIKE 'U%';

--1.5
SELECT i.name item, i.manufacture_date manufactured,
i.price price, p.name producer, c.name country
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
ORDER BY c.name ASC
LIMIT 5;

SELECT i.name item, i.manufacture_date manufactured,
i.price price, p.name producer, c.name country
FROM items i
INNER JOIN producers p
ON i.fk_producer_id = p.producer_id
INNER JOIN countries c
ON p.fk_country_id = c.country_id
ORDER BY c.name DESC
LIMIT 5;

--1.6
SELECT i.name item, i.manufacture_date manufactured,
i.price price, p.name producer, c.name country
FROM items i
INNER JOIN producers p ON i.fk_producer_id = p.producer_id
INNER JOIN countries c ON p.fk_country_id = c.country_id
WHERE i.price = (SELECT MAX(price) FROM items);

SELECT i.name item, i.manufacture_date manufactured,
i.price price, p.name producer_name, c.name country_name
FROM items i
INNER JOIN producers p ON i.fk_producer_id = p.producer_id
INNER JOIN countries c ON p.fk_country_id = c.country_id
WHERE i.price = (SELECT MIN(price) FROM items);

SELECT i.name item, i.manufacture_date manufacture,
i.price price, p.name producer, c.name country
FROM items i
INNER JOIN producers p ON i.fk_producer_id = p.producer_id
INNER JOIN countries c ON p.fk_country_id = c.country_id
WHERE i.price = (SELECT AVG(price) FROM items);