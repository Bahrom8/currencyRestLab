INSERT INTO users (first_name, last_name, phone_number, email, username, password)
VALUES
('John', 'Doe', '123456789', 'john.doe@cydeo.com', 'john_doe', 'password123'),
('Jane', 'Doe', '987654321', 'jane.doe@cydeo.com', 'jane_doe', 'password456'),
('Alice', 'Smith', '345678901', 'alice.smith@cydeo.com', 'alice_smith', 'password789'),
('Bob', 'Johnson', '456789012', 'bob.johnson@cydeo.com', 'bob_johnson', 'passwordabc'),
('Emily', 'Wilson', '567890123', 'emily.wilson@cydeo.com', 'emily_wilson', 'passwordxyz');

INSERT INTO accounts (account_number, account_type, base_currency, balance, user_id)
VALUES
(1234567890, 'CHECKING', 'USD', 5000.00, 1),
( 0987654321, 'SAVING', 'USD', 10000.00, 1),
( 2345678901, 'CHECKING', 'USD', 3000.00, 2),
(9876543210, 'SAVING', 'USD', 7500.00, 2),
(3456789012, 'CHECKING', 'USD', 7000.00, 3),
( 8765432109, 'SAVING', 'USD', 12000.00, 3),
(4567890123, 'CHECKING', 'USD', 4500.00, 4),
( 7654321098, 'SAVING', 'USD', 8000.00, 4),
( 5678901234, 'CHECKING', 'USD', 6000.00, 5),
( 6543210987, 'SAVING', 'USD', 9500.00, 5);
