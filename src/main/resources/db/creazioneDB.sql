
CREATE DATABASE IF NOT EXISTS academy_db;

USE academy_DB;

CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cognome VARCHAR(50) NOT NULL,
    codice_fiscale CHAR(16) UNIQUE NOT NULL,
    data_nascita DATE NOT NULL,
    stato_nascita VARCHAR(50) DEFAULT 'Italia',
    regione_nascita VARCHAR(50),
    provincia_nascita CHAR(2),
    comune_nascita VARCHAR(100),
    timestamp_inserimento DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS fattura (
    id_fattura INT AUTO_INCREMENT PRIMARY KEY,
    imponibile DECIMAL(10, 2) NOT NULL,
    iva DECIMAL(10, 2) NOT NULL,
    totale DECIMAL(10, 2) NOT NULL,
    data_emissione DATE NOT NULL,
    id_cliente INT NOT NULL,
    timestamp_inserimento DATETIME DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT FK_cliente_fattura
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
    ON DELETE CASCADE 
    ON UPDATE CASCADE 
);

INSERT INTO cliente (nome, cognome, codice_fiscale, data_nascita, regione_nascita, provincia_nascita, comune_nascita) VALUES
    ('Mario', 'Rossi', 'RSSMRA80A01H501W', '1980-01-01', 'Lombardia', 'MI', 'Milano'),
    ('Giulia', 'Bianchi', 'BNCGLI85B42H501X', '1985-02-02', 'Lazio', 'RM', 'Roma'),
    ('Luca', 'Verdi', 'VRDLCU90C03F205Y', '1990-03-03', 'Piemonte', 'TO', 'Torino'),
    ('Elena', 'Neri', 'NRELNE75D44F205Z', '1975-04-04', 'Campania', 'NA', 'Napoli'),
    ('Marco', 'Gialli', 'GLLMRC82E05H501A', '1982-05-05', 'Toscana', 'FI', 'Firenze'),
    ('Sofia', 'Russo', 'RSSSFA88F46H501B', '1988-06-06', 'Veneto', 'VE', 'Venezia'),
    ('Alessandro', 'Ferrari', 'FRRLSN92G07F205C', '1992-07-07', 'Emilia-Romagna', 'BO', 'Bologna'),
    ('Chiara', 'Esposito', 'SPSCHR95H48F205D', '1995-08-08', 'Liguria', 'GE', 'Genova'),
    ('Riccardo', 'Romano', 'RMNRCR70I09H501E', '1970-09-09', 'Sicilia', 'PA', 'Palermo'),
    ('Francesca', 'Gallo', 'GLLFNC83L50H501F', '1983-10-10', 'Puglia', 'BA', 'Bari');

INSERT INTO fattura (imponibile, iva, totale, data_emissione, id_cliente) VALUES
    (100.00, 22.00, 122.00, '2024-01-10', 1),
    (250.50, 55.11, 305.61, '2024-01-15', 2),
    (50.00, 11.00, 61.00, '2024-02-01', 3),
    (1200.00, 264.00, 1464.00, '2024-02-10', 4),
    (330.00, 72.60, 402.60, '2024-03-05', 5),
    (15.00, 3.30, 18.30, '2024-03-12', 6),
    (90.00, 19.80, 109.80, '2024-04-01', 7),
    (450.00, 99.00, 549.00, '2024-04-15', 8),
    (600.00, 132.00, 732.00, '2024-05-02', 9),
    (1000.00, 220.00, 1220.00, '2024-05-10', 10);