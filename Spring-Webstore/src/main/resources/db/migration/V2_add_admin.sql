INSERT INTO users (id, is_archived, email, name, password, role, bucket_id)
VALUES (1, false, 'mail@gmail.com', 'admin', 'password', 'ADMIN', null);

ALTER SEQUENCE user_seq RESTART WITH 2;