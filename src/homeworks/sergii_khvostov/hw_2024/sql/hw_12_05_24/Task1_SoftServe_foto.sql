USE emlp_dept;

CREATE TABLE Dept (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100)
);

CREATE TABLE Empl (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    dept_id INT,
    FOREIGN KEY (dept_id) REFERENCES Dept(id)
);

INSERT INTO Dept (city) VALUES
('Kyiv'),
('Kharkiv'),
('Lviv'),
('Odessa'),
('Dnipro');

INSERT INTO Empl (first_name, last_name, dept_id) VALUES
('John',     'Doe',       1),
('Jane',     'Smith',     2),
('John',     'Smith',     3),
('Mary',     'Johnson',   3),
('James',    'Williams',  4),
('Patricia', 'Brown',     4),
('Robert',   'Jones',     5),
('Michael',  'Garcia',    1),
('Linda',    'Martinez',  2),
('David',    'Rodriguez', 3);


SELECT city
FROM Dept;


SELECT DISTINCT first_name
FROM Empl
ORDER BY first_name;


SELECT COUNT(*) AS EmployeeCount
FROM Empl
WHERE dept_id = 3;


SELECT dept_id, COUNT(*) AS EmployeeCount
FROM Empl
GROUP BY dept_id
ORDER BY EmployeeCount DESC;


SELECT d.city, COUNT(e.id) AS EmployeeCount
FROM Empl e
INNER JOIN Dept d ON e.dept_id = d.id
GROUP BY d.city
ORDER BY d.city;


SELECT city
FROM Dept
WHERE city LIKE 'D%';


SELECT d.city, COUNT(e.id) AS EmployeeCount
FROM Dept d
LEFT JOIN Empl e ON d.id = e.dept_id
WHERE d.city LIKE '%v%'
GROUP BY d.city;


SELECT first_name, last_name
FROM Empl
WHERE last_name IN (
    SELECT last_name
    FROM Empl
    GROUP BY last_name
    HAVING COUNT(*) > 1
)
ORDER BY last_name, first_name;


SELECT e.first_name, e.last_name
FROM Empl e
INNER JOIN Dept d ON e.dept_id = d.id
WHERE d.city = 'Lviv'
GROUP BY e.first_name, e.last_name
HAVING COUNT(*) > 1
ORDER BY e.first_name;


SELECT d.id, d.city, COUNT(e.id) AS EmployeeCount
FROM Empl e
INNER JOIN Dept d ON e.dept_id = d.id
WHERE e.first_name = 'John'
GROUP BY d.id, d.city
HAVING COUNT(e.id) > 10
ORDER BY d.id;











