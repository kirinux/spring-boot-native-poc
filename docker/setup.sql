CREATE
DATABASE IF NOT EXISTS dev;
USE
dev;
CREATE TABLE IF NOT EXISTS person
(
    person_id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    id
    VARCHAR
(
    255
) NOT NULL,
    firstName VARCHAR
(
    255
) NOT NULL,
    lastName VARCHAR
(
    255
) NOT NULL,
    birthDate DATE
    ) ENGINE=INNODB;


INSERT INTO person(id, firstName, lastName, birthDate)
VALUES ('11111', 'firstName', 'lastName', '2012-01-03');