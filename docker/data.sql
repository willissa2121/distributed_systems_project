-- -- Insert image metadata
-- INSERT INTO image_metadata (description, author, created_date) VALUES ('Nginx web server', 'Docker Inc.', '2021-01-01');
-- INSERT INTO image_metadata (description, author, created_date) VALUES ('MySQL database server', 'Oracle Corporation', '2021-01-01');

-- -- Insert docker images
-- INSERT INTO docker_image (name, tag, repository) VALUES ('nginx', 'latest', 'library/nginx');
-- INSERT INTO docker_image (name, tag, repository) VALUES ('mysql', '5.7', 'library/mysql');

-- Insert test data into User table
INSERT INTO "User" (name, username, password, email, dob, sex, credits) VALUES
('John Doe', 'johndoe', 'password123', 'john@example.com', '1980-01-01', 'M', 100);
INSERT INTO "User" (name, username, password, email, dob, sex, credits) VALUES
('Jane Smith', 'janesmith', 'password456', 'jane@example.com', '1990-02-02', 'F', 200);

-- Insert test data into Payment table
INSERT INTO Payment (name, CCNumber, expires, CCType, user_id) VALUES
('John Doe', 1234567890123456, '2025-01-01', 'VISA', 1);
INSERT INTO Payment (name, CCNumber, expires, CCType, user_id) VALUES
('Jane Smith', 2345678901234567, '2026-02-02', 'MASTERCARD', 2);

-- Insert test data into Transactions table
INSERT INTO Transactions (name, date, type, amount, approved, user_id) VALUES
('Purchase1', '2024-07-19', 'PURCHASE', 100, TRUE, 1);
INSERT INTO Transactions (name, date, type, amount, approved, user_id) VALUES
('Refund1', '2024-07-20', 'REFUND', 50, FALSE, 2);

-- Insert test data into Image table
INSERT INTO Image (name, tag, status, created, size, user_id) VALUES
('Image1', 'v1.0', 'active', '2024-07-19', 2048, 1);
INSERT INTO Image (name, tag, status, created, size, user_id) VALUES
('Image2', 'v2.0', 'inactive', '2024-07-20', 4096, 2);

-- Insert test data into Volume table
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:abcd1234', 'available', '2024-07-19', 1024);
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:efgh5678', 'in use', '2024-07-20', 2048);

-- Insert test data into Container table
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, user_id) VALUES
('Container1', 1, 1, 'running', '8080:80', '2024-07-19', 1);
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, user_id) VALUES
('Container2', 2, 2, 'stopped', '9090:90', '2024-07-20', 2);

