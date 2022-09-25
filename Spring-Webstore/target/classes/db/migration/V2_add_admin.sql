INSERT INTO users (id, is_archived, email, name, password, role)
VALUES (1, false, 'mail@gmail.com', 'admin', '$2a$10$.WS65ERxGPwgScY7PYVEKOOrvs5RJaiKF/jkXKjhiBHMX083g.sUq', 'ADMIN');

ALTER SEQUENCE user_seq RESTART WITH 2;