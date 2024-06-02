CREATE TABLE IF NOT EXISTS auth_keys (
                                     id SERIAL PRIMARY KEY,
                                     start_date TIMESTAMP,
                                     expiry_date TIMESTAMP,
                                     terminated_date TIMESTAMP,
                                     phone_number VARCHAR(255),
                                     api_key VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS admin (
                                     id SERIAL PRIMARY KEY,
                                     sur_name VARCHAR(255),
    name VARCHAR(255),
    last_name VARCHAR(255),
    phone_number VARCHAR(255) UNIQUE,
    post VARCHAR(255),
    password VARCHAR(255),
    registration VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS client (
                                      id SERIAL PRIMARY KEY,
                                      sur_name VARCHAR(255),
    name VARCHAR(255),
    last_name VARCHAR(255),
    phone_number VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    is_blocked BOOLEAN
    );

CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       created_at TIMESTAMP,
                                       pan VARCHAR(255) UNIQUE NOT NULL,
    pin VARCHAR(255),
    cvv VARCHAR(255),
    rbs VARCHAR(255),
    active BOOLEAN,
    expired_date timestamp,
    in_access BOOLEAN,
    out_access BOOLEAN,
    is_blocked BOOLEAN,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES client (id)
    );

CREATE TABLE IF NOT EXISTS account (
                                       id SERIAL PRIMARY KEY,
                                       account_number VARCHAR(255) UNIQUE,
    cash BIGINT,
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES product (id)
    );