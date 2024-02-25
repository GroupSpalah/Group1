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

insert into dogs(name)
values
('Sharik'),
('Artemon'),
('Rex'),
('Snowy'),
('Bethowen'),
('Lassie'),
('Hachico'),
('Spike');
