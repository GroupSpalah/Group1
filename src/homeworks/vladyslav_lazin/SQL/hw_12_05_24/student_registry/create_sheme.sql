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
	name VARCHAR(30) NOT NULL,
	found_date DATE
);
CREATE TABLE univercities (
	univercity_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	found_date DATE
);

CREATE TABLE faculty_to_university (
	fk_faculty_id INT NOT NULL,
	fk_univercity_id INT NOT NULL,
	FOREIGN KEY(fk_faculty_id)
	REFERENCES faculties(faculty_id),
	FOREIGN KEY(fk_univercity_id)
	REFERENCES univercities(univercity_id)
);


CREATE TABLE st_groups(
	st_group_id INT AUTO_INCREMENT PRIMARY KEY,
	found_date DATE,
	fk_group_leader INT,
	fk_faculty_id INT,
	FOREIGN KEY (fk_faculty_id) REFERENCES faculties(faculty_id)
);

CREATE TABLE students (
	student_id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	gender ENUM('male', 'female', 'smth else') NOT NULL,
	birthday DATE NOT NULL,
	fk_address_id INT NOT NULL,
	fk_st_group_id INT NOT NULL,
	FOREIGN KEY (fk_address_id)
	REFERENCES addresses(address_id),
	FOREIGN KEY (fk_st_group_id)
	REFERENCES st_groups(st_group_id)
);

ALTER TABLE st_groups
ADD
FOREIGN KEY (fk_group_leader)
REFERENCES students(student_id);
