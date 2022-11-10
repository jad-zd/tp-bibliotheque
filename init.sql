/*
 * SQL script to initialize the DataBase needed for our application.
 * You need to run the script as an authorized user.
 * Either run from your shell : mysql -u <username> -p -vvv < path/to/init.sql
 * or enter the mysql server and run : SOURCE path/to/init.sql
*/

CREATE DATABASE IF NOT EXISTS  tp_bibliotheque; -- Create the database
USE tp_bibliotheque; -- Use it

/* Create user related tables */

CREATE TABLE IF NOT EXISTS Users (
    user_id INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    max_borrow_count INT,
    max_borrow_time INT,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS Red_list (
    event_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (event_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

/* Create book related tables */

CREATE TABLE IF NOT EXISTS Authors (
    author_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    PRIMARY KEY (author_id)
);

CREATE TABLE IF NOT EXISTS Editions (
    isbn BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    year INT NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE IF NOT EXISTS Key_words (
    kw_id INT NOT NULL AUTO_INCREMENT,
    key_word VARCHAR(255) NOT NULL,
    PRIMARY KEY (kw_id)
);

CREATE TABLE IF NOT EXISTS Books (
    book_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    publish_year INT NOT NULL,
    edition_isbn BIGINT NOT NULL,
    kw_id1 INT NOT NULL,
    kw_id2 INT,
    kw_id3 INT,
    kw_id4 INT,
    kw_id5 INT,
    borrowed BOOLEAN NOT NULL,
    PRIMARY KEY (book_id),
    FOREIGN KEY (edition_isbn) REFERENCES Editions(isbn),
    FOREIGN KEY (kw_id1) REFERENCES Key_words(kw_id),
    FOREIGN KEY (kw_id2) REFERENCES Key_words(kw_id),
    FOREIGN KEY (kw_id3) REFERENCES Key_words(kw_id),
    FOREIGN KEY (kw_id4) REFERENCES Key_words(kw_id),
    FOREIGN KEY (kw_id5) REFERENCES Key_words(kw_id)
);

CREATE TABLE IF NOT EXISTS Book_author (
    book_id INT NOT NULL,
    author_id INT NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);

/* Create managment related tables */

CREATE TABLE IF NOT EXISTS Loans (
    event_id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    active BOOLEAN NOT NULL,
    PRIMARY KEY (event_id),
    FOREIGN KEY (book_id) REFERENCES Books(book_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

/* Add examples */

-- INSERT INTO Users VALUES (1234, 'Jack', 'Rayan', 'jack.rayan@student.com', 'Light', 'User', 2, 14);
-- INSERT INTO Users VALUES (3763, 'Bernard', 'Arnoult', 'bernard.arnoult@student.com', 'Moderate', 'User', 4, 21);
-- INSERT INTO Users VALUES (1111, 'Gerome', 'Cartier', 'gerome.cartier@e-library.com', 'Heavy', 'Admin', 6, 28);

-- INSERT INTO Authors(first_name, last_name, birth_date) VALUES ('JK', 'Rowlings', '1987-03-11');
-- INSERT INTO Authors(first_name, last_name, birth_date) VALUES ('DJ', 'Khaled', '1993-05-28');
-- INSERT INTO Authors(first_name, last_name, birth_date) VALUES ('Eric', 'Baldwin', '1979-10-07');

-- INSERT INTO Editions VALUES (2972698269, 'Hachette', 2013);
-- INSERT INTO Editions VALUES (3798363678, 'Ellipse', 2015);

-- INSERT INTO Key_words(key_word) VALUES ('Love');
-- INSERT INTO Key_words(key_word) VALUES ('Action');
-- INSERT INTO Key_words(key_word) VALUES ('Science');
-- INSERT INTO Key_words(key_word) VALUES ('Drama');

-- INSERT INTO Books(title, publish_year, edition_isbn, kw_id1, kw_id2, borrowed) VALUES ('Harry Potter', 1999, 2972698269, 1, 2, FALSE);
-- INSERT INTO Books(title, publish_year, edition_isbn, kw_id1, borrowed) VALUES ('Beep boop', 2004, 3798363678, 3, FALSE);
-- INSERT INTO Books(title, publish_year, edition_isbn, kw_id1, borrowed) VALUES ('Babar', 2006, 3798363678, 4, FALSE);

-- INSERT INTO Book_author VALUES (1,1);
-- INSERT INTO Book_author VALUES (2,2);
-- INSERT INTO Book_author VALUES (2,3);
-- INSERT INTO Book_author VALUES (3,2);
