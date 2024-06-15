-- Insert image metadata
INSERT INTO image_metadata (description, author, created_date) VALUES ('Nginx web server', 'Docker Inc.', '2021-01-01');
INSERT INTO image_metadata (description, author, created_date) VALUES ('MySQL database server', 'Oracle Corporation', '2021-01-01');

-- Insert docker images
INSERT INTO docker_image (name, tag, repository) VALUES ('nginx', 'latest', 'library/nginx');
INSERT INTO docker_image (name, tag, repository) VALUES ('mysql', '5.7', 'library/mysql');
