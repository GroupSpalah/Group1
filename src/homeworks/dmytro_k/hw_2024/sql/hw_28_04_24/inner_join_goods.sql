SELECT item.name, item.production_date, producer.product_producer, item.fragility, item.price
FROM item
INNER JOIN producer ON item.manufacturer_id = producer.product_producer