CREATE TABLE Driver (
    id INT PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    age INT,
    qualification VARCHAR(20)
);

CREATE TABLE Truck (
    id INT PRIMARY KEY,
    model VARCHAR(50),
    modelYear INT,
    driver_id INT,
    FOREIGN KEY (driver_id) REFERENCES Driver(id)
);
