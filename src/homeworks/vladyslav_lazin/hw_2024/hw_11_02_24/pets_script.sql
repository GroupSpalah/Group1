CREATE DATABASE pets;
USE pets;
CREATE TABLE breeds
(
	breed_id INT AUTO_INCREMENT PRIMARY KEY,
	breed_name VARCHAR(30) NOT NULL
);

CREATE TABLE masters
(
	master_id INT AUTO_INCREMENT PRIMARY KEY,
	master_name VARCHAR(50) NOT NULL
);

CREATE TABLE dogs
(
	dog_id INT AUTO_INCREMENT PRIMARY KEY,
	dog_name VARCHAR(20) NOT NULL,
	FK_breed_id INT,
	FK_master_id INT,
	FOREIGN KEY(FK_breed_id) REFERENCES breeds(breed_id),
	FOREIGN KEY(FK_master_id) REFERENCES masters(master_id)
);

INSERT INTO breeds (breed_name)
VALUES
	('collie'),
	('bulldog'),
	('podole'),
	('mongrel'),
	('terrier'),
	('saint bernard'),
	('akita'),
	('german shepherd');
INSERT INTO masters (master_name)
VALUES
	('Tintin'),
	('William'),
	('John'),
	('Hidesaburo'),
	('Malvina'),
	('Emily'),
	('Richard'),
	('Gregory');

INSERT INTO dogs (dog_name, breed_id, master_id)
VALUES
	('Sharik', 4, 3),
	('Artemon', 3, 5),
	('Rex', 8, 7),
	('Snowy', 5, 1),
	('Beethoven', 6, 6),
	('Lassie', 1, 8),
	('Hachiko', 7, 4),
	('Spike', 2, 2);

SELECT dogs.dog_name, breeds.breed_name, masters.master_name
FROM dogs
INNER JOIN breeds ON dogs.breed_id = breeds.breed_id
INNER JOIN masters ON dogs.master_id = masters.master_id;
