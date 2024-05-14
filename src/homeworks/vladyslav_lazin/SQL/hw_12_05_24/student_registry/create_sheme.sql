CREATE DATABASE student_registry;
USE student_registry;
CREATE TABLE addresses (
	address_id INT AUTO_INCREMENT PRIMARY KEY,
	city VARCHAR(30) NOT NULL,
	street VARCHAR(40) NOT NULL,
	house_number INT NOT NULL,
	flat_number INT NOT NULL
);
CREATE TABLE faculties (
	faculty_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30),
	found_date DATE
);
CREATE TABLE universities (
	university_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30),
	found_date DATE
);
