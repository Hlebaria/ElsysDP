CREATE TABLE account(

    id INT PRIMARY KEY NOT NULL,
    username TEXT,
    password TEXT,
    phone TEXT

);

INSERT INTO account (id, username, password, phone) VALUES (1, 'Ivan', 'uehcpoec22', '+359 555555555');

SELECT * FROM account;