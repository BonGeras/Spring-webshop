

--USER
DROP SEQUENCE IF EXISTS user_seq;
CREATE SEQUENCE user_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users
(
    id        int8 NOT NULL,
    archive   boolean NOT NULL,
    email     varchar(255),
    name      varchar(255),
    password  varchar(255),
    role      varchar(255),
    PRIMARY KEY (id)
);



--BUCKET
DROP SEQUENCE IF EXISTS bucket_seq;
CREATE SEQUENCE bucket_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS buckets CASCADE;
CREATE TABLE buckets
(
    id      int8 NOT NULL,
    user_id int8,
    PRIMARY KEY (id)
);


--LINK BETWEEN BUCKET AND USER
ALTER TABLE IF EXISTS buckets
   ADD CONSTRAINT buckets_fk_user
   FOREIGN KEY (user_id) REFERENCES users;



--CATEGORY
DROP SEQUENCE IF EXISTS category_seq;
CREATE SEQUENCE category_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS categories CASCADE;
CREATE TABLE categories
(
    id     int8 NOT NULL,
    title  varchar(255),
    PRIMARY KEY (id)
);


--PRODUCT
DROP SEQUENCE IF EXISTS product_seq;
CREATE SEQUENCE product_seq START 1 INCREMENT 1;

CREATE TABLE products
(
    id    int8 NOT NULL,
    price numeric(19,2),
    title varchar(255),
    PRIMARY KEY (id)
);


--CATEGORY AND PRODUCT
DROP TABLE IF EXISTS products_categories CASCADE;
CREATE TABLE products_categories
(
    product_id int8 NOT NULL,
    category_id int8 NOT NULL
);
ALTER TABLE IF EXISTS products_categories
   ADD CONSTRAINT products_categories_fk_category
   FOREIGN KEY (category_id) REFERENCES categories;

ALTER TABLE IF EXISTS products_categories
    ADD CONSTRAINT products_categories_fk_products
    FOREIGN KEY (product_id) REFERENCES products;


--PRODUCT IN BUCKET
DROP TABLE IF EXISTS buckets_products CASCADE;
CREATE TABLE buckets_products
(
    bucket_id int8 NOT NULL,
    product_id int8 NOT NULL
);



--ORDERS
DROP SEQUENCE IF EXISTS order_seq;
CREATE SEQUENCE order_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
    id      int8 not null ,
    address varchar(255),
    updated timestamp,
    created timestamp,
    status  varchar(255),
    sum     numeric(19,2),
    user_id int8,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS orders
ADD CONSTRAINT orders_fk_user
FOREIGN KEY (user_id) references users;


--ORDERS DETAILS
DROP SEQUENCE IF EXISTS order_details_seq;
CREATE SEQUENCE order_details_seq START 1 INCREMENT 1;

DROP TABLE IF EXISTS orders_details CASCADE;
CREATE TABLE orders_details
(
    id         int8 not null,
    amount     numeric(19, 2),
    price      numeric(19, 2),
    order_id   int8,
    product_id int8,
    details_id int8 not null,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS orders_details
    ADD CONSTRAINT orders_details_fk_order
    FOREIGN KEY (order_id) REFERENCES orders;

ALTER TABLE IF EXISTS orders_details
    ADD CONSTRAINT orders_details_fk_products
    FOREIGN KEY (product_id) REFERENCES products;

