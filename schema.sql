CREATE DATABASE IF NOT EXISTS ReservationSystemDB;
USE ReservationSystemDB;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users(username, password) VALUES ('admin', 'admin123');

CREATE TABLE reservations (
    pnr INT AUTO_INCREMENT PRIMARY KEY,
    train_no VARCHAR(20),
    class VARCHAR(10),
    date DATE,
    source VARCHAR(50),
    destination VARCHAR(50),
    status VARCHAR(20)
);