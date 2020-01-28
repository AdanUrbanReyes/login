INSERT IGNORE INTO rol (id, description) 
VALUES (1, 'USER')
	, (2, 'ADMIN');
	
-- 	password was hashed with Bcrypt using next tool https://www.browserling.com/tools/bcrypt
INSERT IGNORE INTO user (id, password, rol) 
VALUES ('user', '$2a$10$qp08nRAAK6y7EoLIZTFM5eDVuNBH.jhhcj0gXyuNf8s93TC87T8em', 1)
	, ('admin', '$2a$10$2j02UiPZ.Afe4npKinPcfObzLbYgM.oT3RDrM0vYQ93x55MFY6k6.', 2);