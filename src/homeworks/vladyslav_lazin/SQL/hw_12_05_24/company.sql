CREATE DATABASE company;
USE company;
CREATE TABLE depts(
	dept_id INT AUTO_INCREMENT PRIMARY KEY,
	city VARCHAR(25)
);

CREATE TABLE empls(
	empl_id INT AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(25),
	last_name VARCHAR(25),
	fk_dept_id INT,
	FOREIGN KEY (fk_dept_id) REFERENCES depts(dept_id)
);

--1.
SELECT city
FROM depts d;

--2.
SELECT DISTINCT last_name, first_name
FROM empls
ORDER BY last_name;

--3.
SELECT COUNT(*)
FROM empls
WHERE fk_dept_id = 3;

--4.
SELECT fk_dept_id, COUNT(*) count
FROM empls
GROUP BY fk_dept_id
ORDER BY count DESC;

--5.
SELECT fk_dept_id, COUNT(*) count
FROM empls
GROUP BY fk_dept_id
ORDER BY fk_dept_id;

--6.
SELECT city
FROM depts
WHERE city LIKE 'S%';

INSERT INTO depts (city) VALUES
('New York'), ('Los Angeles'), ('Chicago'), ('Houston'), ('Phoenix'),
('Philadelphia'), ('San Antonio'), ('San Diego'), ('Dallas'), ('San Jose');

INSERT INTO empls (first_name, last_name, fk_dept_id)
VALUES
('John', 'Doe', 3);

--7.
SELECT city, COUNT(e.first_name)
FROM empls e
INNER JOIN depts d
ON e.fk_dept_id = d.dept_id
GROUP BY e.fk_dept_id
HAVING LOWER(city) LIKE '%l%';

--8.
SELECT * FROM empls
WHERE last_name
IN(
SELECT last_name
FROM empls
GROUP BY last_name
HAVING count(*) > 1)
ORDER BY last_name;

