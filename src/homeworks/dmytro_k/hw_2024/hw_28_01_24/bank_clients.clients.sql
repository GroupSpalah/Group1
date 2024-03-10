CREATE TABLE bank_clients.clients (
	id BIGINT  AUTO_INCREMENT PRIMARY KEY,
	name varchar(100) NOT NULL,
	citizenship varchar(100) DEFAULT 'ukrainian'
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE bank_clients.clients 
ADD account_number BIGINT;
ALTER TABLE bank_clients.clients 
ADD FOREIGN KEY(account_number)REFERENCES account_number(id);