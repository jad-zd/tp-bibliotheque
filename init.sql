/*
 * SQL script to initialize the DataBase needed for our application.
 * You need to run the script as an authorized user.
 * Either run from your shell : mysql -u <username> -p -vvv < path/to/init.sql
 * or enter the mysql server and run : SOURCE path/to/init.sql
*/

CREATE DATABASE IF NOT EXISTS  library_app; -- Create the database
USE librabry_app; -- Use it

/* Create user related tables */

CREATE TABLE IF NOT EXISTS roles (
    role VARCHAR(255) NOT NULL,
    borrow BOOLEAN NOT NULL,
    check_availability BOOLEAN NOT NULL,
    check_borrowed BOOLEAN NOT NULL,
    check_borrowors BOOLEAN NOT NULL,
    PRIMARY KEY (role)
);

CREATE TABLE IF NOT EXISTS categories (
    category VARCHAR(255) NOT NULL,
    max_books INT NOT NULL,
    max_time INT NOT NULL,
    PRIMARY KEY (category)
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    max_books INT,
    max_time INT,
    PRIMARY KEY (id),
    FOREIGN KEY (role) REFERENCES roles(role),
    Foreign KEY (category) REFERENCES categories(category)
);

/* Create book related tables */


CREATE TABLE IF NOT EXISTS authors (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS editions (
    isbn INT NOT NULL,
    editor_name VARCHAR(255) NOT NULL,
    edition_year INT NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE IF NOT EXISTS key_words (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS books (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    edition_id INT NOT NULL,
    published_year INT NOT NULL,
    kw_id1 INT NOT NULL,
    kw_id2 INT,
    kw_id3 INT,
    kw_id4 INT,
    kw_id5 INT,
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES authors(id),
    FOREIGN KEY (edition_id) REFERENCES editions(isbn),
    FOREIGN KEY (kw_id1) REFERENCES key_words(id),
    FOREIGN KEY (kw_id2) REFERENCES key_words(id),
    FOREIGN KEY (kw_id3) REFERENCES key_words(id),
    FOREIGN KEY (kw_id4) REFERENCES key_words(id),
    FOREIGN KEY (kw_id5) REFERENCES key_words(id)
);

/* Create managment related tables */

CREATE TABLE IF NOT EXISTS loans (
    id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    ended BOOLEAN NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS black_list (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);