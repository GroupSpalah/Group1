SELECT item.name,
    item.production_date, producer.product_producer, item.fragility, item.price
FROM item it
INNER JOIN producer prod
ON it.manufacturer_id = prod.product_producer;