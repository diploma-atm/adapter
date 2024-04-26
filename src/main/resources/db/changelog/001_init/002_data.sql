-- Примеры данных для таблицы client
INSERT INTO client (sur_name, name, last_name, phone_number, is_blocked)
VALUES ('Сидоров', 'Сидор', 'Сидорович', '83456789012', false),
       ('Петров', 'Петр', 'Петрович', '84567890123', true);

-- Примеры данных для таблицы admin
INSERT INTO admin (sur_name, name, last_name, phone_number, post, registration)
VALUES ('Иванов', 'Иван', 'Иванович', '81234567890', 'Администратор', '2022-04-27'),
       ('Петров', 'Петр', 'Петрович', '82345678901', 'Менеджер', '2022-04-27');

-- Примеры данных для таблицы product
INSERT INTO product (created_at, pan, pin, cvv, rbs, active, in_access, out_access, is_blocked, client_id)
VALUES ('2022-04-27 12:00:00', '1234567890123456', '1234', '789', 'RBS123', true, true, true, false, 1),
       ('2022-04-27 13:00:00', '9876543210987654', '4321', '456', 'RBS456', true, false, true, true, 2);

-- Примеры данных для таблицы account
INSERT INTO account (account_number, cash, product_id)
VALUES ('123456789', 1000, 1),
       ('987654321', 500, 2);


