use pets;

create table breeds(
id int not null auto_increment primary key,
type varchar(30)
);

insert into breeds(type)
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
id int not null auto_increment primary key,
name varchar(30)
);

insert into masters(name)
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
id int not null auto_increment,
name varchar(30),
breeds_id int,
masters_id int, 
primary key (id),
foreign key (breeds_id) references breeds(id),
foreign key (masters_id) references masters(id)
);

insert into dogs(name, breeds_id, masters_id)
values
('Sharik', 4, 3),
('Artemon', 3, 5),
('Rex', 8, 7),
('Snowy', 5, 1),
('Bethowen', 6, 6),
('Lassie', 1, 8),
('Hachico', 7, 4),
('Spike', 2, 2);
