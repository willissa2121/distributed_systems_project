-- Insert test data into Client table
INSERT INTO Client (name, username, password, email, dob, sex, credits) VALUES
('John Doe', 'johndoe', 'password123', 'john@example.com', '1980-01-01', 'M', 100);
INSERT INTO Client (name, username, password, email, dob, sex, credits) VALUES
('Jane Smith', 'janesmith', 'password456', 'jane@example.com', '1990-02-02', 'F', 200);
INSERT INTO Client (name, username, password, email, dob, sex, credits) VALUES
('Alice Johnson', 'alicej', 'password789', 'alice@example.com', '1985-03-03', 'F', 150);
INSERT INTO Client (name, username, password, email, dob, sex, credits) VALUES
('Bob Brown', 'bobbrown', 'passwordabc', 'bob@example.com', '1975-04-04', 'M', 250);
INSERT INTO Client (name, username, password, email, dob, sex, credits) VALUES
('Charlie Davis', 'charlied', 'passworddef', 'charlie@example.com', '2000-05-05', 'M', 300);

-- Insert test data into Payment table
INSERT INTO Payment (name, CCNumber, expires, CCType, client_id) VALUES
('John Doe', 1234567890123456, '2025-01-01', 'VISA', 1);
INSERT INTO Payment (name, CCNumber, expires, CCType, client_id) VALUES
('Jane Smith', 2345678901234567, '2026-02-02', 'MASTERCARD', 2);
INSERT INTO Payment (name, CCNumber, expires, CCType, client_id) VALUES
('Alice Johnson', 3456789012345678, '2027-03-03', 'MASTERCARD', 3);
INSERT INTO Payment (name, CCNumber, expires, CCType, client_id) VALUES
('Bob Brown', 4567890123456789, '2028-04-04', 'VISA', 4);
INSERT INTO Payment (name, CCNumber, expires, CCType, client_id) VALUES
('Charlie Davis', 5678901234567890, '2029-05-05', 'VISA', 5);

-- Insert test data into Transactions table
INSERT INTO Transactions (name, date, type, amount, approved, client_id) VALUES
('Purchase1', '2024-07-19', 'PURCHASE', 100, TRUE, 1);
INSERT INTO Transactions (name, date, type, amount, approved, client_id) VALUES
('Refund1', '2024-07-20', 'REFUND', 50, FALSE, 2);
INSERT INTO Transactions (name, date, type, amount, approved, client_id) VALUES
('Purchase2', '2024-07-21', 'PURCHASE', 200, TRUE, 3);
INSERT INTO Transactions (name, date, type, amount, approved, client_id) VALUES
('Refund2', '2024-07-22', 'REFUND', 75, FALSE, 4);
INSERT INTO Transactions (name, date, type, amount, approved, client_id) VALUES
('Purchase3', '2024-07-23', 'PURCHASE', 150, TRUE, 5);

-- Insert test data into Image table
INSERT INTO Image (name, tag, status, created, size, client_id) VALUES
('Image1', 'v1.0', 'active', '2024-07-19', 2048, 1);
INSERT INTO Image (name, tag, status, created, size, client_id) VALUES
('Image2', 'v2.0', 'inactive', '2024-07-20', 4096, 2);
INSERT INTO Image (name, tag, status, created, size, client_id) VALUES
('Image3', 'v3.0', 'active', '2024-07-21', 1024, 3);
INSERT INTO Image (name, tag, status, created, size, client_id) VALUES
('Image4', 'v4.0', 'inactive', '2024-07-22', 512, 4);
INSERT INTO Image (name, tag, status, created, size, client_id) VALUES
('Image5', 'v5.0', 'active', '2024-07-23', 2048, 5);

-- Insert test data into Volume table
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:abcd1234', 'available', '2024-07-19', 1024);
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:efgh5678', 'in use', '2024-07-20', 2048);
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:ijkl9012', 'available', '2024-07-21', 3072);
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:mnop3456', 'in use', '2024-07-22', 4096);
INSERT INTO Volume (sha, status, created, size) VALUES
('sha256:qrst7890', 'available', '2024-07-23', 5120);

-- Insert test data into Container table
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, client_id) VALUES
('Container1', 1, 1, 'running', '8080:80', '2024-07-19', 1);
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, client_id) VALUES
('Container2', 2, 2, 'stopped', '9090:90', '2024-07-20', 2);
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, client_id) VALUES
('Container3', 3, 3, 'running', '7070:70', '2024-07-21', 3);
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, client_id) VALUES
('Container4', 4, 4, 'stopped', '6060:60', '2024-07-22', 4);
INSERT INTO Container (name, image_id, volume_id, status, ports, last_started, client_id) VALUES
('Container5', 5, 5, 'running', '5050:50', '2024-07-23', 5);