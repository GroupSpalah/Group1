INSERT INTO univercities (name, found_date)
VALUES
	('University of Cambridge', '1209-01-01'),
	('University of Oxford', '1096-01-01'),
	('University of Bologna', '1088-01-01'),
	('University of Paris', '1150-01-01'),
	('University of Salamanca', '1133-01-01'),
	('University of Padua', '1222-01-01'),
	('University of Siena', '1240-01-01'),
	('Univercity of Coimbra', '1290-01-01'),
	('Al-Karaouine University', '859-01-01'),
	('Harvard University', '1636-01-01'),
	('Yale University', '1701-01-01'),
	('Columbia University', '1754-01-01'),
	('University of Pennsylvania', '1740-01-01'),
	('Princeton University', '1746-01-01'),
	('Brown University', '1764-01-01'),
	('Dartmouth College', '1769-01-01'),
	('University of Tokyo', '1877-01-01'),
	('Peking University', '1898-01-01'),
	('Tsinghua University', '1911-01-01');

INSERT INTO faculties (name)
VALUES
	('physics', '1861-03-25'),
	('biology', '1887-09-02'),
	('astronomy', '1872-07-01'),
	('computer science', '1971-02-15'),
	('mathematics', '1521-09-11'),
	('phylology', '1910-11-30'),
	('geology', '1901-12-24'),
	('phylosophy', '1088-01-01'),
	('economics', '1829-01-08'),
	('sociology', '1967-08-29'),
	('geography', '1899-09-19'),
	('psychology', '1922-07-23');

INSERT INTO faculty_to_university (fk_faculty_id, fk_univercity_id)
VALUES
	(1, 65), (2, 65), (3, 65), (4, 65), (5, 65), (6, 65), (7, 65), (8, 65), (9, 65), (10, 65), (11, 65), (12, 65),
	(1, 66), (2, 66), (3, 66), (4, 66), (5, 66), (6, 66), (7, 66), (8, 66), (9, 66), (10, 66), (11, 66),
	(1, 67), (2, 67), (3, 67), (4, 67), (5, 67), (6, 67), (7, 67), (8, 67), (9, 67), (10, 67),
	(1, 68), (2, 68), (3, 68), (4, 68), (5, 68), (6, 68), (7, 68), (8, 68), (9, 68), (10, 68),
	(1, 69), (2, 69), (3, 69), (4, 69), (5, 69), (6, 69), (7, 69), (8, 69), (9, 69), (10, 69),
	(1, 70), (2, 70), (3, 70), (4, 70), (5, 70), (6, 70), (7, 70), (8, 70), (9, 67), (10, 70);

INSERT INTO st_groups (name, found_date, fk_faculty_id, fk_univercity_id)
VALUES
	('PH-22', '2019-08-23', 1, 65),
	('PSY-11', '2018-08-29', 6, 65),
	('CS-42', '2021-09-01', 4, 66),
	('ECON-33', '2019-08-27', 9, 67),
	('BIO-31', '2021-08-28', 2, 68),
	('ASTRO-12', '2014-07-22', 3, 69);

INSERT INTO students (name, surname, birthday, gender, address, fk_st_group_id)
VALUES
	('James', 'Smith', '2001-08-03', 'male', '10 Downing Street, London, SW1A 2AA', 1),
	('Olivia', 'Johnson', '1999-01-08', 'female', '221B Baker Street, London, NW1 6XE', 1),
	('William', 'Brown', '1198-07-23', 'male', '1 High Street, Edinburgh, EH1 1SG', 2),
	('Emma', 'Taylor', '2000-09-01', 'female', '16 Abbey Road, London, NW8 9AY', 2),
	('Benjamin', 'Wilson', '2000-03-02', 'male', '50 George Square, Glasgow, G2 1EH', 3),
	('Sophia', 'Harris', '2000-04-30', 'female', '30 St Mary Axe, London, EC3A 8EP', 3),
	('Henry', 'Martin', '2001-07-12', 'male', '32 Windsor Road, Cardiff, CF5 2DZ', 3),
	('Isabella', 'Clark', '2000-11-21', 'female', '18 Market Street, Manchester, M1 1PT', 3),
	('Michael', 'Lewis', '2002-05-16', 'male', '18 Market Street, Manchester, M1 4PT', 4),
	('Charlotte', 'Walker', '2001-06-17', 'female', '18 Abbey Road, London, NW8 7AY', 4),
	('Alexander', 'Scott', '2000-10-19', 'male', '7 Castle Hill, Windsor, SL4 1NJ', 4),
	('Mia', 'Robinson', '2000-05-11', 'female', '5 Royal Crescent, Bath, BA1 2LR', 4),
	('Daniel', 'Hall', '1998-01-13', 'male', '5 Royal Crescent, Bath, BA4 2LR', 5),
	('Amelia', 'Young', '2000-06-07', 'female', '9 Royal Crescent, Bath, BA1 6LR', 5),
	('Matthew', 'King', '2004-01-05', 'male', '25 Princes Street, Edinburgh, EH2 2AN', 5),
	('Ava', 'Wright', '2003-02-27', 'female', '9 Victoria Road, Southampton, SO14 0NT', 5),
	('Samuel', 'Green', '2004-07-30', 'male', '11 Victoria Road, Southampton, SO19 0NT', 6),
	('Grace', 'Baker', '2003-12-01', 'female', '4 King Street, Leeds, LS1 2HH', 6),
	('Joseph', 'Adams', '2002-11-30', 'male', '4 King Street, Leeds, LS2 3HH', 6),
	('Lily', 'Mitchell', '2001-04-29', 'female', '3 Dock Street, Liverpool, L1 8JH', 6),
	('John', 'Doe', '2001-08-31', 'male', '12 Downing Street, London, SW1A 2AA', 5);

UPDATE st_groups
SET fk_group_leader = 1
WHERE st_group_id = 1;

PDATE st_groups
SET fk_group_leader = 4
WHERE st_group_id = 2;

UPDATE st_groups
SET fk_group_leader = 6
WHERE st_group_id = 3;

UPDATE st_groups
SET fk_group_leader = 12
WHERE st_group_id = 4;

UPDATE st_groups
SET fk_group_leader = 16
WHERE st_group_id = 5;

UPDATE st_groups
SET fk_group_leader = 18
WHERE st_group_id = 6;
