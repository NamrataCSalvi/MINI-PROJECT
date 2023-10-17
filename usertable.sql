-- Active: 1697005752641@@Localhost@3306@mproject
CREATE TABLE itable3 (
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    uimage BLOB,
    passw INT NOT NULL,
    PRIMARY KEY (username)
);

   
 INSERT INTO itable3 (username, email, uimage, passw)
VALUES
    ("namrat", "asd@12", "img/2122", 123);   

