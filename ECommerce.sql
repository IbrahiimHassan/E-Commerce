-- Step 1: Create login at the SQL Server level
CREATE LOGIN ibrahim WITH PASSWORD = 'ibrahim';

CREATE DATABASE ECommerce;

-- Step 2: Switch to your database (ECommerce)
USE ECommerce;

-- Step 3: Create a user inside the database for that login
CREATE USER ibrahim FOR LOGIN ibrahim;

-- Step 4: Grant full access
EXEC sp_addrolemember 'db_owner', 'ibrahim';



CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    address VARCHAR(100)
);

CREATE TABLE CustomerAccounts (
    account_id INT PRIMARY KEY,
    customer_id INT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);

CREATE TABLE Product (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    price DECIMAL(10, 2),
    stock_quantity INT
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    total_amount DECIMAL(10, 2),
    status VARCHAR(50),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

INSERT INTO Customers VALUES (1, 'Ibrahim', 'Hassan', 'ibrahim@email.com', '0123456789', 'Cairo, Egypt');
INSERT INTO CustomerAccounts VALUES (100, 1, 'ibrahimhassan', '123', 'CUSTOMER');
INSERT INTO Product VALUES (10, 'T-shirt', 'Blue cotton T-shirt', 200.00, 50);
INSERT INTO Orders VALUES (500, 1, 10, 2, '2025-07-23', 400.00, 'PAID');

SELECT * FROM Customers
SELECT SUSER_NAME(), SYSTEM_USER;

SELECT name FROM sys.sql_logins WHERE name = 'ibrahim';
SELECT name FROM sys.database_principals WHERE name = 'ibrahim';

EXEC xp_instance_regread
  N'HKEY_LOCAL_MACHINE',
  N'Software\Microsoft\MSSQLServer\MSSQLServer',
  N'LoginMode';



