
use pets;

create table breeds(
id int,
type varchar(20)
);

insert into breeds (id,`type`)
values
(1, 'collie'),
(2, 'bulldog'),
(3, 'poodle'),
(4, 'mongrel'),
(5, 'terrier'),
(6, 'saint bernard'),
(7, 'akita'),
(8, 'german shepherd');

create table dogs(
id int,
name varchar(20),
breeds_id int,
masters_id int
);

insert into dogs (id, name, breeds_id, masters_id)
values
(1, 'sharik', 4, 3),
(2, 'artemon', 3, 5),
(3, 'rex', 8, 7),
(4, 'snowy', 5, 1),
(5, 'bethowen', 6, 6),
(6, 'lassie', 1, 8),
(7, 'hachico', 7, 4),
(8, 'spike', 2, 2);


create table masters(
id int,a
name varchar(20)
);

insert into masters (id, name)
values
(1, 'Tintin'),
(2, 'Willian'),
(3, 'Fedor'),
(4, 'Hidesaburo'),
(5, 'Malvina'),
(6, 'Emily'),
(7, 'Richard'),
(8, 'Gregory');

select dogs.id as dogs_id, dogs.name as dogs_name, breeds.type as breeds_type, masters.name as masters_name
from dogs
inner join breeds on dogs.breeds_id  = breeds.id
inner join masters on dogs.masters_id = masters.id




