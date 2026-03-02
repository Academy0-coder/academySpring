USE library;

INSERT INTO editor (editor_name, average_time_delivering, email) VALUES
                                                                     ('Einaudi', null, 'info@einaudi.com'),
                                                                     ('Feltrinelli', null, 'info@feltrinelli.com'),
                                                                     ('Garzanti', null, 'info@garzanti.com'),
                                                                     ('Adelphi', null, 'info@adelphi.com'),
                                                                     ('Rizzoli', null, 'info@rizzoli.com');

INSERT INTO book (book_name, author_name, book_year, price, quantity_sold, quantity_in_stock, threshold, restock, editor_id) VALUES
                                                                                                                                 ('Il nome della rosa', 'Umberto Eco', 1980, 18.50, 0, 60, 40, 30, 1),
                                                                                                                                 ('1984', 'George Orwell', 1949, 14.90, 0, 90, 50, 30, 2),
                                                                                                                                 ('Il Signore degli Anelli', 'J.R.R. Tolkien', 1954, 25.00, 0, 130, 70, 50, 4),
                                                                                                                                 ('La coscienza di Zeno', 'Italo Svevo', 1923, 16.80, 0, 140, 100, 50, 2),
                                                                                                                                 ('Orgoglio e pregiudizio', 'Jane Austen', 1813, 12.50, 0, 100, 40, 50, 5),
                                                                                                                                 ('Il grande Gatsby', 'F. Scott Fitzgerald', 1925, 13.40, 0, 90, 20, 70, 3),
                                                                                                                                 ('Moby Dick', 'Herman Melville', 1851, 17.20, 0, 80, 40, 30, 1),
                                                                                                                                 ('Guerra e pace', 'Lev Tolstoj', 1869, 21.90, 0, 115, 45, 80, 5),
                                                                                                                                 ('I promessi sposi', 'Alessandro Manzoni', 1827, 19.00, 0, 120, 60, 70, 1),
                                                                                                                                 ('Il piccolo principe', 'Antoine de Saint-Exupéry', 1943, 11.99, 0, 130, 80, 70, 3),
                                                                                                                                 ('Delitto e castigo', 'Fëdor Dostoevskij', 1866, 15.75, 0, 70, 50, 20, 3),
                                                                                                                                 ('Il codice Da Vinci', 'Dan Brown', 2003, 14.50, 0, 90, 60, 30, 5),
                                                                                                                                 ('Harry Potter e la pietra filosofale', 'J.K. Rowling', 1997, 16.00, 0, 80, 40, 60, 4),
                                                                                                                                 ('Il cacciatore di aquiloni', 'Khaled Hosseini', 2003, 13.90, 0, 50, 25, 25, 2),
                                                                                                                                 ('Il conte di Montecristo', 'Alexandre Dumas', 1844, 20.00, 0, 70, 35, 30, 2),
                                                                                                                                 ('Uno, nessuno e centomila', 'Luigi Pirandello', 1926, 14.20, 0, 90, 20, 70, 1),
                                                                                                                                 ('La metamorfosi', 'Franz Kafka', 1915, 10.80, 0, 110, 60, 50, 2),
                                                                                                                                 ('Il vecchio e il mare', 'Ernest Hemingway', 1952, 12.90, 0, 125, 75, 25, 3),
                                                                                                                                 ('Siddhartha', 'Hermann Hesse', 1922, 13.60, 0, 75, 40, 30, 5),
                                                                                                                                 ('La ragazza con il tatuaggio del drago', 'Stieg Larsson', 2005, 18.30, 0, 75, 30, 50, 4);