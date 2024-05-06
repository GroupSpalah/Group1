--1.1
SELECT i.item_name, i.manufacture_date, i.price, p.producer_name
FROM item i
INNER JOIN producer p ON i.producer_id = p.producer_id
WHERE i.fragility = TRUE AND p.producer_name = "Cervelo";

--1.2
SELECT i.item_name, i.manufacture_date, i.price, p.producer_name, c.country_name
FROM item i
INNER JOIN producer p ON i.producer_id = p.producer_id
INNER JOIN country c ON p.country_id = c.country_id
WHERE c.country_name = "Ukraine" OR c.country_name = "Canada";

--1.3
