CREATE DATABASE learn_sql;

USE learn_sql;

CREATE TABLE Persons(
first_name VARCHAR(30),
last_name VARCHAR(30),
age INT
);

INSERT INTO persons (first_name, last_name, age)
VALUES
('John', 'Travolta', 32),
('Ben',  'Kennedi',  60);

SELECT * FROM persons;