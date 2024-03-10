CREATE TABLE bank_clients.account_number (
	id BIGINT  AUTO_INCREMENT PRIMARY KEY,
	amount BIGINT NOT NULL,
	account_number BIGINT NOT NULL
	);

	INSERT INTO bank_clients.account_number (amount, account_number) VALUES(2000, 0987654321);   
