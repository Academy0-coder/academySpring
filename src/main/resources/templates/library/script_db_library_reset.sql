drop database if exists library;

create database library;

use library;

drop table if exists editor;
drop table if exists book;
drop table if exists sale;
drop table if exists orders;

create table editor(
                       id int unsigned not null primary key auto_increment,
                       editor_name varchar(255) unique not null,
                       average_time_delivering decimal(5,2),
                       email varchar(255) unique not null
);

create table book(
                     id int unsigned not null primary key auto_increment,
                     book_name varchar(255) unique not null,
                     author_name varchar(255) not null,
                     book_year int unsigned,
                     price decimal(8,2) unsigned not null,
                     quantity_sold int unsigned,
                     quantity_in_stock int unsigned,
                     threshold int unsigned not null,
                     restock int unsigned not null,
                     editor_id int unsigned not null,

                     constraint fk_editor
                         foreign key (editor_id)
                             references editor (id)
);

create table sale(
                     id int unsigned not null primary key auto_increment,
                     month_sale int unsigned not null,
                     week_sale int unsigned not null,
                     book_id int unsigned not null,

                     constraint fk_book_sale
                         foreign key (book_id)
                             references book (id)
);

create table orders(
                       id int unsigned not null primary key auto_increment,
                       day_order datetime,
                       day_deliver datetime,
                       delivered boolean not null,
                       book_id int unsigned not null,

                       constraint fk_book_order
                           foreign key (book_id)
                               references book (id)
);