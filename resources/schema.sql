-- Remove old tables to start again
DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS users;

-- Users Table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(20) NOT NULL, -- 'CANDIDATE' or 'RECRUITER'
    additional_info VARCHAR(255)
);

-- Jobs Table
CREATE TABLE jobs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    recruiter_id INT,
    FOREIGN KEY (recruiter_id) REFERENCES users(id) ON DELETE CASCADE
);