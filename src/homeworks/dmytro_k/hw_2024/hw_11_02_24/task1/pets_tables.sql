USE pets;

CREATE TABLE breeds(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
TYPE VARCHAR(30)
);

INSERT INTO breeds(TYPE)
VALUES
('collie'),
('bulldog'),
('poodle'),
('mongrel'),
('terrier'),
('saint bernard'),
('akita'),
('german shepherd');

CREATE TABLE masters(
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30)
);

INSERT INTO masters(name)
VALUES
('Tintin'),
('Willian'),
('Fedor'),
('Hidesaburo'),
('Malvina'),
('Emily'),
('Richard'),
('Gregory');

CREATE TABLE dogs(
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(30),
breeds_id INT,
masters_id INT, 
PRIMARY KEY (id),
FOREIGN KEY (breeds_id) REFERENCES breeds(id),
FOREIGN KEY (masters_id) REFERENCES masters(id)
ON UPDATE CASCADE
ON DELETE CASCADE
);

INSERT INTO dogs(name, breeds_id, masters_id)
VALUES
('Sharik', 4, 3),
('Artemon', 3, 5),
('Rex', 8, 7),
('Snowy', 5, 1),
('Bethowen', 6, 6),
('Lassie', 1, 8),
('Hachico', 7, 4),
('Spike', 2, 2);
