-- Schema for DockerImage
CREATE TABLE IF NOT EXISTS docker_image (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    tag VARCHAR(255) NOT NULL,
    repository VARCHAR(255) NOT NULL
);

-- Schema for ImageMetadata
CREATE TABLE IF NOT EXISTS image_metadata (
    id BIGSERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    created_date DATE NOT NULL
);