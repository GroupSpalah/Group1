USE student_registry;

--- всех студентов учащихся в одном университете(по названию университета).
DELIMITER @@
CREATE PROCEDURE get_students_from_one_university(IN un_name VARCHAR(30))
	BEGIN
		SELECT s.name, s.surname, u.name
		FROM students s
		INNER JOIN st_groups sg
		ON s.fk_st_group_id = sg.st_group_id
		INNER JOIN univercities u
		ON sg.fk_univercity_id = u.univercity_id
		WHERE u.name = un_name;
	END@@
DELIMITER ;

CALL get_students_from_one_university('University of Bologna');
CALL get_students_from_one_university('University of Oxford');

--- всех студентов учащихся в одном университете(по названию университета) и на одном факультете.
DELIMITER @@
CREATE PROCEDURE get_students_from_one_university_and_faculty(IN un_name VARCHAR(30), IN fac_name VARCHAR(30))
	BEGIN
		SELECT s.name name, s.surname surname, f.name faculty,  u.name university
		FROM students s
		INNER JOIN st_groups sg
		ON s.fk_st_group_id = sg.st_group_id
		INNER JOIN univercities u
		ON sg.fk_univercity_id = u.univercity_id
		INNER JOIN faculties f
		ON sg.fk_faculty_id = f.faculty_id
		WHERE u.name = un_name
		AND f.name = fac_name;
	END@@
DELIMITER ;

CALL get_students_from_one_university_and_faculty('University of Cambridge', 'physics');

--- количество студентов учащихся в каждом университете, факультете, группе.
USE student_registry;
DELIMITER @@
CREATE PROCEDURE get_quantity_in_all(IN param ENUM('university', 'faculty', 'group'))
	BEGIN
		IF param = 'university' THEN
			SELECT u.name university, COUNT(*) quantity
			FROM students s
			INNER JOIN st_groups sg
			ON s.fk_st_group_id = sg.st_group_id
			INNER JOIN univercities u
			ON sg.fk_univercity_id = u.univercity_id
			GROUP BY u.name;
		ELSEIF param = 'faculty' THEN
			SELECT f.name faculty, COUNT(*) quantity
			FROM students s
			INNER JOIN st_groups sg
			ON s.fk_st_group_id = sg.st_group_id
			INNER JOIN faculties f
			ON sg.fk_faculty_id  = f.faculty_id
			GROUP BY f.name;
		ELSEIF param = 'group' THEN
			SELECT sg.name st_group, COUNT(*) quantity
			FROM students s
			INNER JOIN st_groups sg
			ON s.fk_st_group_id = sg.st_group_id
			GROUP BY sg.name;
		END IF;
	END@@
DELIMITER ;

CALL get_quantity_in_all('university');

-- - найти группу с максимальным/минимальным количеством студентов.
USE student_registry;
DELIMITER @@
CREATE PROCEDURE get_grpup_with_min_or_max_students(IN param ENUM('min', 'max'))
	BEGIN
		IF param = 'min' THEN
			SELECT sg.name st_group, COUNT(*) quantity
			FROM students s
			INNER JOIN st_groups sg
			ON s.fk_st_group_id = sg.st_group_id
			GROUP BY sg.name
			ORDER BY quantity
			LIMIT 1;
		ELSEIF param = 'max' THEN
			SELECT sg.name st_group, COUNT(*) quantity
			FROM students s
			INNER JOIN st_groups sg
			ON s.fk_st_group_id = sg.st_group_id
			GROUP BY sg.name
			ORDER BY quantity DESC
			LIMIT 1;
		END IF;
	END@@
DELIMITER ;

CALL get_grpup_with_min_or_max_students('min');

-- - вывести даты рождения студентов в формате '30 Oct 16'.
USE student_registry;
DELIMITER @@
CREATE PROCEDURE get_birthdaays_in_human_format()
	BEGIN
		SELECT DATE_FORMAT(s.birthday, '%d %b %y') birthday
		FROM students s;
	END@@
DELIMITER ;

CALL get_birthdaays_in_human_format();

-- - вывести всех старост групп.
USE student_registry;
DELIMITER @@
CREATE PROCEDURE get_all_group_leaders()
	BEGIN
		SELECT sg.name group_name, CONCAT(s.name, ' ', s.surname) name
		FROM st_groups sg
		INNER JOIN students s
		ON sg.fk_group_leader = s.student_id;
	END@@
DELIMITER ;

CALL get_all_group_leaders();

-- - вывести университет, с наибольшим количеством факультетов/групп/студентов.
USE student_registry;
DELIMITER @@
CREATE PROCEDURE get_university_with_max_students()
	BEGIN
		SELECT u.name, COUNT(*) faculty_count
		FROM faculty_to_university ftu
		INNER JOIN faculties f
		ON ftu.fk_faculty_id = f.faculty_id
		INNER JOIN univercities u
		ON ftu.fk_univercity_id = u.univercity_id
		GROUP BY u.name
		ORDER BY faculty_count DESC
		LIMIT 1;
	END@@
DELIMITER ;

CALL get_university_with_max_students();
