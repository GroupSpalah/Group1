
use pets;

create table breeds(
id int AUTO_INCREMENT PRIMARY KEY,
typo varchar(20)
);

INSERT INTO breeds (typo)
VALUES
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

INSERT INTO masters (name)
VALUES
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
FOREIGN KEY (masters_id) REFERENCES masters(id) ON DELETE CASCADE
);

INSERT INTO dogs (name, breeds_id, masters_id)
VALUES
('sharik', 4, 3),
('artemon', 3, 5),
('rex', 8, 7),
('snowy', 5, 1),
('bethowen', 6, 6),
('lassie', 1, 8),
('hachico', 7, 4),
('spike', 2, 2);


SELECT dogs.id AS dogs_id, dogs.name AS dogs_name, breeds.typo AS breeds_type, masters.name AS masters_name
FROM dogs
INNER JOIN breeds ON dogs.breeds_id  = breeds.id
INNER JOIN masters ON dogs.masters_id = masters.id




