USE cinema;


INSERT INTO customer (customer_name, customer_surname, score, membership_card) VALUES
    ('Mario', 'Rossi', 0, 'BRONZE'), ('Laura', 'Bianchi', 0, 'BRONZE'), ('Luca', 'Verdi', 0, 'BRONZE'),
    ('Giulia', 'Neri', 0, 'BRONZE'), ('Marco', 'Gialli', 0, 'BRONZE'), ('Sofia', 'Rizzo', 0, 'BRONZE'),
    ('Francesco', 'Ferrari', 0, 'BRONZE'), ('Elena', 'Marino', 0, 'BRONZE'), ('Alessandro', 'Bruno', 0, 'BRONZE'),
    ('Chiara', 'Gallo', 0, 'BRONZE'), ('Roberto', 'Conti', 0, 'BRONZE'), ('Alice', 'Mancini', 0, 'BRONZE'),
    ('Stefano', 'Costa', 0, 'BRONZE'), ('Marta', 'Fontana', 0, 'BRONZE'), ('Giovanni', 'Russo', 0, 'BRONZE'),
    ('Paola', 'Greco', 0, 'BRONZE'), ('Federico', 'Lombardi', 0, 'BRONZE'), ('Silvia', 'Barbieri', 0, 'BRONZE'),
    ('Davide', 'Serra', 0, 'BRONZE'), ('Anna', 'Vitale', 0, 'BRONZE'), ('Pietro', 'Rossini', 0, 'BRONZE'),
    ('Beatrice', 'D Amico', 0, 'BRONZE'), ('Matteo', 'Riva', 0, 'BRONZE'), ('Sara', 'Donati', 0, 'BRONZE'),
    ('Antonio', 'Leone', 0, 'BRONZE'), ('Erica', 'Longhi', 0, 'BRONZE'), ('Valerio', 'Gatti', 0, 'BRONZE'),
    ('Martina', 'D Angelo', 0, 'BRONZE'), ('Claudio', 'Moretti', 0, 'BRONZE'), ('Simona', 'Pellegrini', 0, 'BRONZE');

INSERT INTO movie_theater (theater_name, number_rows, number_seats)
VALUES
    ('Sala Astra', 7, 20),
    ('Cinema Paradiso', 11, 18),
    ('Auditorium Lux', 5, 16),
    ('The Space Red', 6, 15),
    ('Sala Visioni', 9, 12);


INSERT INTO movie (movie_name, director, genre, rating, price, length, revenue)
VALUES
    ('Interstellar Journey', 'Christopher Nolan', 'SCI_FI', 9.2, 12.50, 169, 0.0),
    ('The Dark Knight', 'Christopher Nolan', 'ACTION', 9.0, 10.00, 152, 0.0),
    ('Spirited Away', 'Hayao Miyazaki', 'CARTOON', 8.6, 8.50, 125, 0.0),
    ('Inception', 'Christopher Nolan', 'SCI_FI', 8.8, 11.00, 148, 0.0),
    ('Pulp Fiction', 'Quentin Tarantino', 'CRIME', 8.9, 9.50, 154, 0.0),
    ('The Hateful Eight', 'Quentin Tarantino', 'WESTERN', 7.8, 10.50, 168, 0.0),
    ('Alien Resurgence', 'Ridley Scott', 'HORROR', 7.5, 9.00, 117, 0.0),
    ('The Matrix', 'Lana Wachowski', 'SCI_FI', 8.7, 9.00, 136, 0.0),
    ('Shutter Island', 'Martin Scorsese', 'THRILLER', 8.2, 10.00, 138, 0.0),
    ('Blade Runner 2049', 'Denis Villeneuve', 'SCI_FI', 8.0, 12.00, 164, 0.0),
    ('Django Unchained', 'Quentin Tarantino', 'WESTERN', 8.4, 10.00, 165, 0.0),
    ('Toy Story 4', 'Josh Cooley', 'CARTOON', 7.7, 7.50, 100, 0.0),
    ('Seven', 'David Fincher', 'THRILLER', 8.6, 9.00, 127, 0.0),
    ('The Conjuring', 'James Wan', 'HORROR', 7.5, 8.50, 112, 0.0),
    ('Mad Max: Fury Road', 'George Miller', 'ACTION', 8.1, 11.50, 120, 0.0),
    ('John Wick', 'Chad Stahelski', 'ACTION', 7.4, 9.50, 101, 0.0),
    ('Lord of the Rings', 'Peter Jackson', 'FANTASY', 8.9, 13.00, 178, 0.0),
    ('Harry Potter', 'Chris Columbus', 'FANTASY', 7.6, 11.00, 152, 0.0),
    ('Goodfellas', 'Martin Scorsese', 'CRIME', 8.7, 9.50, 145, 0.0),
    ('Coco', 'Lee Unkrich', 'CARTOON', 8.4, 8.00, 105, 0.0);