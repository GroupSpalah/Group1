--- всех студентов учащихся в одном университете(по названию университета).
SELECT s.name, s.surname, u.name
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
INNER JOIN univercities u
ON sg.fk_univercity_id = u.univercity_id
WHERE u.name = 'University of Bologna';

--- всех студентов учащихся в одном университете(по названию университета) и на одном факультете.
SELECT s.name name, s.surname surname, f.name faculty,  u.name university
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
INNER JOIN univercities u
ON sg.fk_univercity_id = u.univercity_id
INNER JOIN faculties f
ON sg.fk_faculty_id = f.faculty_id
WHERE u.name = 'University of Cambridge'
AND f.name = 'physics';

--- количество студентов учащихся в каждом университете, факультете, группе.
SELECT u.name university, COUNT(*) quantity
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
INNER JOIN univercities u
ON sg.fk_univercity_id = u.univercity_id
GROUP BY u.name;

SELECT f.name faculty, COUNT(*) quantity
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
INNER JOIN faculties f
ON sg.fk_faculty_id  = f.faculty_id
GROUP BY f.name;

SELECT sg.name st_group, COUNT(*) quantity
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
GROUP BY sg.name;

-- - найти группу с максимальным/минимальным количеством студентов.
SELECT sg.name st_group, COUNT(*) quantity
FROM students s
INNER JOIN st_groups sg
ON s.fk_st_group_id = sg.st_group_id
GROUP BY sg.name
ORDER BY quantity DESC
LIMIT 1;
-- - подсчитать количество студентов, которые живут по одному адресу(улица, дом).

-- - вывести даты рождения студентов в формате '30 Oct 16'.
SELECT DATE_FORMAT(s.birthday, '%d %b %y') birthday
FROM students s;
-- - вывести среднее количество людей в группе по университету.

-- - вывести всех старост групп.
SELECT sg.name group_name, CONCAT(s.name, ' ', s.surname) name
FROM st_groups sg
INNER JOIN students s
ON sg.fk_group_leader = s.student_id;

-- - вывести университет, с наибольшим количеством факультетов/групп/студентов.
SELECT u.name, COUNT(*) faculty_count
FROM faculty_to_university ftu
INNER JOIN faculties f
ON ftu.fk_faculty_id = f.faculty_id
INNER JOIN univercities u
ON ftu.fk_univercity_id = u.univercity_id
GROUP BY u.name
ORDER BY faculty_count DESC
LIMIT 1;