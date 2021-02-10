CREATE
DATABASE IF NOT EXISTS persons;
CREATE
USER 'plop' IDENTIFIED BY 'plop';
ALTER
DATABASE persons DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON plop.* TO
'plop'@'%';