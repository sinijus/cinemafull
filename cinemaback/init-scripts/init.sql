CREATE SCHEMA IF NOT EXISTS cinema ;
SELECT 'Creating schema cinema' AS status;
GRANT ALL ON SCHEMA cinema TO postgres;
GRANT ALL ON SCHEMA cinema TO PUBLIC;

-- tables
CREATE TABLE cinema.director
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT director_pk PRIMARY KEY (id)
);
-- Table: restriction
CREATE TABLE cinema.restriction
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT restriction_pk PRIMARY KEY (id)
);


-- Table: cinema_user
CREATE TABLE cinema.cinema_user
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT cinema_user_pk PRIMARY KEY (id)
);

-- Table: country
CREATE TABLE cinema.country
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT country_pk PRIMARY KEY (id)
);

-- Table: genre
CREATE TABLE cinema.genre
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT genre_pk PRIMARY KEY (id)
);

-- Table: hall
CREATE TABLE cinema.hall
(
    id       serial       NOT NULL,
    name     varchar(255) NOT NULL,
    seats_no int          NOT NULL,
    CONSTRAINT hall_pk PRIMARY KEY (id)
);

-- Table: seat
CREATE TABLE cinema.seat
(
    id      serial NOT NULL,
    hall_id int    NOT NULL,
    row     int    NOT NULL,
    number  int    NOT NULL,
    CONSTRAINT seat_pk PRIMARY KEY (id)
);


-- Table: language
CREATE TABLE cinema.language
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT language_pk PRIMARY KEY (id)
);

-- Table: movie
CREATE TABLE cinema.movie
(
    id           serial        NOT NULL,
    title        varchar(255)  NOT NULL,
    description  varchar(2047) NOT NULL,
    length       int           NOT NULL,
    release_year int           NOT NULL,
    CONSTRAINT movie_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.movie_director
(
    id         serial NOT NULL,
    movie_id   int    NOT NULL,
    director_id int    NOT NULL,
    CONSTRAINT movie_director_pk PRIMARY KEY (id)
);

-- Table: screening
CREATE TABLE cinema.screening
(
    id       serial NOT NULL,
    movie_id int    NOT NULL,
    hall_id  int    NOT NULL,
    date     date   NOT NULL,
    time     time   NOT NULL,
    CONSTRAINT screening_pk PRIMARY KEY (id)
);

-- Table: movie_country
CREATE TABLE cinema.movie_country
(
    id         serial NOT NULL,
    movie_id   int    NOT NULL,
    country_id int    NOT NULL,
    CONSTRAINT movie_country_pk PRIMARY KEY (id)
);

-- Table: movie_genre
CREATE TABLE cinema.movie_genre
(
    id       serial NOT NULL,
    movie_id int    NOT NULL,
    genre_id int    NOT NULL,
    CONSTRAINT movie_genre_pk PRIMARY KEY (id)
);

-- Table: movie_language
CREATE TABLE cinema.movie_language
(
    id          serial NOT NULL,
    movie_id    int    NULL,
    language_id int    NOT NULL,
    CONSTRAINT movie_language_pk PRIMARY KEY (id)
);

-- Table: movie_restriction
CREATE TABLE cinema.movie_restriction
(
    id             serial NOT NULL,
    restriction_id int    NOT NULL,
    movie_id       int    NULL,
    CONSTRAINT movie_restriction_pk PRIMARY KEY (id)
);

-- Table: movie_subtitles
CREATE TABLE cinema.movie_subtitles
(
    id          serial NOT NULL,
    movie_id    int    NOT NULL,
    language_id int    NOT NULL,
    CONSTRAINT movie_subtitles_pk PRIMARY KEY (id)
);

-- Table: reservation
CREATE TABLE cinema.reservation
(
    id           serial  NOT NULL,
    screening_id int     NOT NULL,
    cinema_user_id      int     NOT NULL,
    paid         boolean NOT NULL,
    active       boolean NOT NULL,
    CONSTRAINT reservation_pk PRIMARY KEY (id, paid)
);

-- Table: reserved_seat
CREATE TABLE cinema.reserved_seat
(
    id               serial  NOT NULL,
    screening_id     int     NOT NULL,
    seat_id          int     NOT NULL,
    reservation_id   int     NOT NULL,
    reservation_paid boolean NOT NULL,
    CONSTRAINT reserved_seat_pk PRIMARY KEY (id)
);


-- foreign keys

ALTER TABLE cinema.movie_language
    ADD CONSTRAINT language_id
        FOREIGN KEY (language_id)
            REFERENCES cinema.language (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_language
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_subtitles
    ADD CONSTRAINT language_id
        FOREIGN KEY (language_id)
            REFERENCES cinema.language (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_subtitles
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_country
    ADD CONSTRAINT country_id
        FOREIGN KEY (country_id)
            REFERENCES cinema.country (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_country
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_director
    ADD CONSTRAINT director_id
        FOREIGN KEY (director_id)
            REFERENCES cinema.director (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_director
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_genre
    ADD CONSTRAINT genre_id
        FOREIGN KEY (genre_id)
            REFERENCES cinema.genre (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_genre
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_restriction
    ADD CONSTRAINT movie_id
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.movie_restriction
    ADD CONSTRAINT movie_restriction_restriction
        FOREIGN KEY (restriction_id)
            REFERENCES cinema.restriction (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.reservation
    ADD CONSTRAINT reservation_screening
        FOREIGN KEY (screening_id)
            REFERENCES cinema.screening (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.reservation
    ADD CONSTRAINT reservation_user
        FOREIGN KEY (cinema_user_id)
            REFERENCES cinema.cinema_user (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.reserved_seat
    ADD CONSTRAINT reserved_seat_reservation
        FOREIGN KEY (reservation_id)
            REFERENCES cinema.reservation (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.reserved_seat
    ADD CONSTRAINT reserved_seat_screening
        FOREIGN KEY (screening_id)
            REFERENCES cinema.screening (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.reserved_seat
    ADD CONSTRAINT reserved_seat
        FOREIGN KEY (seat_id)
            REFERENCES cinema.seat (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.screening
    ADD CONSTRAINT screening_hall
        FOREIGN KEY (hall_id)
            REFERENCES cinema.hall (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.screening
    ADD CONSTRAINT screening_movie
        FOREIGN KEY (movie_id)
            REFERENCES cinema.movie (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

ALTER TABLE cinema.seat
    ADD CONSTRAINT hall_id
        FOREIGN KEY (hall_id)
            REFERENCES cinema.hall (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

