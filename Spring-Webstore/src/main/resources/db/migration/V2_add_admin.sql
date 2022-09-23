INSERT INTO users (id, is_archived, email, name, password, role)
VALUES (1, false, 'mail@gmail.com', 'admin', 'password', 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;