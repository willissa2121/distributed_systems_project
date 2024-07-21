-- Enum types
CREATE TYPE CCType AS ENUM ('VISA', 'MASTERCARD', 'AMERICAN EXPRESS');
CREATE TYPE TransactionType AS ENUM ('PURCHASE', 'REFUND', 'REJECTED');

-- User table
CREATE TABLE "User" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    email VARCHAR(255),
    dob DATE,
    sex CHAR(1),
    credits INTEGER
);

-- Payment table
CREATE TABLE Payment (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    CCNumber VARCHAR(19), -- Changed to VARCHAR to handle large numbers
    expires DATE,
    CCType CCType,
    user_id INTEGER REFERENCES "User"(id)
);

-- Transactions table
CREATE TABLE Transactions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    date DATE,
    type TransactionType,
    amount INTEGER,
    approved BOOLEAN,
    user_id INTEGER REFERENCES "User"(id)
);

-- Image table
CREATE TABLE Image (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    tag VARCHAR(255),
    status VARCHAR(255),
    created DATE,
    size INTEGER,
    user_id INTEGER REFERENCES "User"(id)
);

-- Volume table
CREATE TABLE Volume (
    id SERIAL PRIMARY KEY,
    sha VARCHAR(255),
    status VARCHAR(255),
    created DATE,
    size INTEGER
);

-- Container table
CREATE TABLE Container (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    image_id INTEGER REFERENCES Image(id),
    volume_id INTEGER REFERENCES Volume(id),
    status VARCHAR(255),
    ports VARCHAR(255),
    last_started DATE,
    user_id INTEGER REFERENCES "User"(id)
);
