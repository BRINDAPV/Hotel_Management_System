# Hotel_Management_System
CREATE DATABASE hotel_db; 
USE hotel_db;
CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(15) NOT NULL,
    id_proof VARCHAR(50) NOT NULL,
    room_type VARCHAR(20) DEFAULT NULL
);
CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_type VARCHAR(20) NOT NULL,
    status ENUM('Available', 'Occupied') DEFAULT 'Available'
);
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_status ENUM('Paid', 'Pending') NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES customers(id) ON DELETE CASCADE
); 
CREATE TABLE food_orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    food_item VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES customers(id) ON DELETE CASCADE
);
CREATE TABLE feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    review TEXT NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES customers(id) ON DELETE CASCADE
);
