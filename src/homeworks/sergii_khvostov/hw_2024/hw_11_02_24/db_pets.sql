
use pets;

create table breeds(
id int AUTO_INCREMENT PRIMARY KEY,
typo varchar(20)
);

insert into breeds (typo)
values
('collie'),
('bulldog'),
('poodle'),
('mongrel'),
('terrier'),
('saint bernard'),
('akita'),
('german shepherd');

create table masters(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20)
);

insert into masters (name)
values
('Tintin'),
('Willian'),
('Fedor'),
('Hidesaburo'),
('Malvina'),
('Emily'),
('Richard'),
('Gregory');

create table dogs(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
breeds_id int,
FOREIGN KEY (breeds_id) REFERENCES breeds(id),
masters_id int,
FOREIGN KEY (masters_id) REFERENCES masters(id) ON delete CASCADE
);

insert into dogs (name, breeds_id, masters_id)
values
('sharik', 4, 3),
('artemon', 3, 5),
('rex', 8, 7),
('snowy', 5, 1),
('bethowen', 6, 6),
('lassie', 1, 8),
('hachico', 7, 4),
('spike', 2, 2);

select dogs.id as dogs_id, dogs.name as dogs_name, breeds.typo as breeds_type, masters.name as masters_name
from dogs
inner join breeds on dogs.breeds_id  = breeds.id
inner join masters on dogs.masters_id = masters.id




