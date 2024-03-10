SELECT dogs.name, breeds.type, masters.name
FROM dogs
INNER JOIN breeds ON dogs.breeds_id = breeds.id 
INNER JOIN masters ON dogs.masters_id = masters.id