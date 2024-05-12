USE goods;

 CREATE TABLE country(
 name VARCHAR(50) PRIMARY KEY
 );

 INSERT INTO country (name) VALUES
 ('USA'),
 ('South Korea'),
 ('China'),
 ('Finland'),
 ('Japan'),
 ('Taiwan');

 CREATE TABLE producer(
 manufacturer_id INT AUTO_INCREMENT PRIMARY KEY,
 Product_producer ENUM('Apple', 'Samsung', 'Google', 'OnePlus', 'Motorola',
 'Nokia', 'Sony','Huawei', 'Xiaomi', 'Oppo', 'Realme', 'Asus', 'ZTE', 'Vivo',
 'TCL', 'Lenovo', 'Black Shark', 'Nubia', 'Meizu', 'Honor'),
 country_of_production VARCHAR(50),
-- FK_Producer_Country
 FOREIGN KEY (country_of_production) REFERENCES Country(name)
 );

 INSERT INTO producer (Product_producer, country_of_production) VALUES
 ('Apple',        'USA'),
('Samsung',      'South Korea'),
('Google',       'USA'),
('OnePlus',      'China'),
('Motorola',     'USA'),
('Nokia',        'Finland'),
('Sony',         'Japan'),
('Huawei',       'China'),
('Xiaomi',       'China'),
('Oppo',         'China'),
('Realme',       'China'),
('Asus',         'Taiwan'),
('ZTE',          'China'),
('Vivo',         'China'),
('TCL',          'China'),
('Lenovo',       'China'),
('Black Shark',  'China'),
('Nubia',        'China'),
('Meizu',        'China'),
('Honor',        'China');

 CREATE TABLE item(
 name VARCHAR(30),
 production_date DATE,
 manufacturer_id INT,
 fragility TINYINT(1),
 price INT,
 FOREIGN KEY (manufacturer_id) REFERENCES Producer(manufacturer_id)
 );

INSERT INTO item (name, production_date, manufacturer_id, fragility, price) VALUES
('iPhone 13',                  '2022-05-23', 1 , 0, 600 ),
('Samsung Galaxy S21',         '2022-10-25', 2 , 1, 268 ),
('Google Pixel 6',             '2022-02-28', 3 , 0, 100 ),
('OnePlus 9',                  '2022-11-12', 4 , 1, 200 ),
('Motorola Edge 20',           '2022-12-01', 5 , 0, 300 ),
('Nokia G20',                  '2022-01-14', 6 , 1, 400 ),
('Sony Xperia 5 III',          '2022-03-03', 7 , 0, 500 ),
('Huawei P40 Pro',             '2022-04-04', 8 , 1, 600 ),
('Xiaomi Mi 11',               '2022-05-05', 9 , 0, 700 ),
('Oppo Find X3 Pro',           '2022-06-06', 10, 1, 800 ),
('Realme GT',                  '2022-07-07', 11, 0, 900 ),
('Asus Zenfone 8',             '2022-08-08', 12, 1, 1000),
('ZTE Axon 30 Ultra',          '2022-09-09', 13, 0, 1100),
('Vivo X60 Pro',               '2022-10-10', 14, 1, 1200),
('TCL 20 Pro 5G',              '2022-11-11', 15, 0, 1300),
('Lenovo Legion Phone Duel 2', '2022-12-12', 16, 1, 1400),
('Black Shark 4',              '2022-01-13', 17, 0, 1500),
('Nubia Red Magic 6',          '2022-02-14', 18, 1, 1600),
('Meizu 18',                   '2022-03-15', 19, 0, 1700),
('Honor 50',                   '2022-04-16', 20, 1, 1800);

