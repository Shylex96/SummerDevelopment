-- SNAKE GAME

CREATE DATABASE SnakeMVC;
USE snakemvc;
-- DROP TABLE Ranking;

CREATE USER 'snakemvc'@'localhost' IDENTIFIED BY 'SnakingSummer2023';
GRANT ALL PRIVILEGES ON snakemvc.* TO 'snakemvc'@'localhost' WITH GRANT OPTION;

CREATE TABLE Ranking (
	idRanking INT NOT NULL AUTO_INCREMENT,
    nickname_player VARCHAR(15) NOT NULL,
    score_player INT,
    score_at TIMESTAMP NOT NULL DEFAULT (NOW()),
    PRIMARY KEY (idRanking)
);

SELECT * FROM snakemvc.ranking;
SELECT * FROM snakemvc.ranking ORDER BY score_player DESC LIMIT 3;
