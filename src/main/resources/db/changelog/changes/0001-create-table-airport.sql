CREATE TABLE tb_airport(
    id INT NOT NULL AUTO_INCREMENT,
    initial VARCHAR(5) NOT NULL,
    name VARCHAR(200) NOT NULL,
    city VARCHAR(50) NOT NULL,
    uf VARCHAR(20) NOT NULL,
    version INT NOT NULL,
    CONSTRAINT airport_pk PRIMARY KEY (id),
)
