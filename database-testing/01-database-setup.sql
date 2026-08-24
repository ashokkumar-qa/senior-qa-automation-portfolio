CREATE DATABASE IS NOT EXISTS insurance_db;
       USE insurance_db;

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    city VARCHAR(50),
    status VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS policies (
    policy_id INT PRIMARY KEY,
    customer_id INT,
    policy_type VARCHAR(50),
    premium_amount DECIMAL(10,2),
    start_date DATE,
    end_date DATE,
    policy_status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
    );

CREATE TABLE IF NOT EXISTS policies (
    policy_id INT PRIMARY KEY,
    customer_id INT,
    policy_type VARCHAR(50),
    premium_amount DECIMAL(10,2),
    start_date DATE,
    end_date DATE,
    policy_status VARCHAR(20),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
    );

CREATE TABLE IF NOT EXISTS claims (
    claim_id INT PRIMARY KEY,
    policy_id INT,
    claim_amount DECIMAL(10,2),
    claim_date DATE,
    claim_status VARCHAR(20),
    FOREIGN KEY (policy_id) REFERENCES policies(policy_id)
    );