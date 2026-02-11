DROP DATABASE IF EXISTS store;

CREATE DATABASE store;

USE store;

DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS invoice;

CREATE TABLE customer(
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    surname varchar(255)
);

CREATE TABLE product(
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    price decimal(10,2),
    quantity int UNSIGNED,
    quantity_sold int UNSIGNED
);

CREATE TABLE invoice(
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    quantity int UNSIGNED NOT NULL,
    taxable decimal(10,2),
    total decimal(10,2),
    execution_instance TIMESTAMP NOT NULL,
    customer_id int UNSIGNED NOT NULL,
    product_id int UNSIGNED NOT NULL,
    
    CONSTRAINT fk_customer
    FOREIGN KEY (customer_id)
    REFERENCES customer (id),
    
    CONSTRAINT fk_product
    FOREIGN KEY (product_id)
    REFERENCES product (id)
);


