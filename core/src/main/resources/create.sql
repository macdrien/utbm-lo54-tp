-- Tables creation --

CREATE TABLE actors (
    id_actor INTEGER PRIMARY KEY SERIAL,
    lastname VARCHAR(256) NOT NULL,
    firstname VARCHAR(256) NOT NULL
);

CREATE TABLE movies (
    id_movie INTEGER PRIMARY KEY SERIAL,
    title VARCHAR(256) NOT NULL,
    copies INTEGER NOT NULL DEFAULT(100),
    movie_type VARCHAR(256) NOT NULL,
    main_actor_id INTEGER,
    CONSTRAINT movie_fk_main_actor FOREIGN KEY (main_actor_id) REFERENCES actors(id_actor)
);

CREATE TABLE movie_sec_actors (
    id_movie INTEGER NOT NULL,
    id_actor INTEGER NOT NULL,
    PRIMARY KEY (id_movie, id_actor),
    CONSTRAINT movie_sec_actors_fk_movie FOREIGN KEY (id_movie) REFERENCES movies(id_movie),
    CONSTRAINT movie_sec_actors_fk_actor FOREIGN KEY (id_actor) REFERENCES actors(id_actor),
);

CREATE TABLE USERS (
    id_user INTEGER PRIMARY KEY SERIAL,
    name VARCHAR(256) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT(FALSE)
);

-- Data insertions --

INSERT INTO actors (lastname, firstname) VALUES
('De Funes', 'Louis'),
('Reno', 'Jean'),
('Garcia', 'José'),
('Gere', 'Richard'),
('Stalone', 'Sylvester'),
('Bullock', 'Sandra'),
('Waver', 'Sigourney'),
('Di Caprio', 'Leonardo'),
('Winslett', 'Kate'),
('Barymore', 'Drew'),
('Statham', 'Jason'),
('Schwarzenegger', 'Arnold'),
('Roberts', 'Julia'),
('Pitt', 'Brad '),
('Clooney', 'George'),
('Ford', 'Harrison'),
('Hamill', 'Mark'),
('Dujardin', 'Jean'),
('Hanks', 'Tom'),
('Damon', 'Mat')
;

INSERT INTO movies VALUES
('Titanic', 8, 'Romance', 8),
('Demolition man', 2, 'Action', 5),
('Alien', 5, 'Fantastique', 7),
('Expendables', 7, 'Action', 5),
('Lucky luke', 410, 'Western', 18),
('Star Wars', 4010, 'Fiction', 17),
('Ocean''s Eleven', 0, 'Action', 15),
('Da Vinci Code', 2, 'Aventure', 19),
('Pretty Woman', 5, 'Romance', 13),
('a', 1, 'a', NULL),
('titre', 1000, 'perdu', NULL)
;

INSERT INTO movie_sec_actors VALUES
(8, 2),
(9, 4),
(2, 6),
(1, 9),
(4, 11),
(7, 13),
(7, 14),
(6, 16),
(7, 20)
;

INSERT INTO users (name, enabled) VALUES
('jeanmi', TRUE),
('gégé', FALSE)
;