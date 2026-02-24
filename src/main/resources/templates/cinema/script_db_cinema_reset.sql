DROP DATABASE IF EXISTS cinema;

CREATE DATABASE cinema;

USE cinema;

DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS movie_theater;
DROP TABLE IF EXISTS movie_show;
DROP TABLE IF EXISTS ticket;

CREATE TABLE customer(
                         id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                         customer_name varchar(255) NOT NULL,
                         customer_surname varchar(255) NOT NULL,
                         score int UNSIGNED,
                         membership_card enum ('BRONZE','SILVER','GOLD')
);

CREATE TABLE movie(
                      id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      movie_name varchar(255) UNIQUE NOT NULL,
                      director varchar(255) NOT NULL,
                      genre enum('FANTASY','SCI_FI','ACTION','THRILLER','WESTERN','CRIME','HORROR','CARTOON'),
                      rating decimal(2,1) UNSIGNED NOT NULL,
                      price decimal(5,2) UNSIGNED NOT NULL,
                      length int UNSIGNED NOT NULL,
                      revenue decimal(10,2) UNSIGNED
);

CREATE TABLE movie_theater(
                              id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                              theater_name varchar(255) NOT NULL,
                              number_rows int UNSIGNED NOT NULL,
                              number_seats int UNSIGNED NOT NULL
);

CREATE TABLE movie_show(
                           id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           theater_id int UNSIGNED NOT NULL,
                           movie_id int UNSIGNED NOT NULL,
                           number_free_seats int UNSIGNED,
                           show_begin datetime,
                           show_end datetime,

                           CONSTRAINT fk_theater
                               FOREIGN KEY (theater_id)
                                   REFERENCES movie_theater (id),

                           CONSTRAINT fk_movie
                               FOREIGN KEY (movie_id)
                                   REFERENCES movie (id)
);

CREATE TABLE ticket(
                       id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       customer_id int UNSIGNED NOT NULL,
                       show_id int UNSIGNED NOT NULL,
                       row_letter varchar(1),
                       seat_number int UNSIGNED NOT NULL,
                       price decimal(5,2) UNSIGNED NOT NULL,

                       CONSTRAINT fk_show
                           FOREIGN KEY (show_id)
                               REFERENCES movie_show (id),

                       CONSTRAINT fk_customer
                           FOREIGN KEY (customer_id)
                               REFERENCES customer (id)
);