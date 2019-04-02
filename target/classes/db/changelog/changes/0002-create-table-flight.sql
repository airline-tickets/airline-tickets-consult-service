CREATE TABLE tb_flight(
  id         INT NOT NULL AUTO_INCREMENT,
  to_where   INT NOT NULL,
  from_where INT NOT NULL,
  depart     DATETIME NOT NULL,
  arrival    DATETIME NOT NULL,
  capacity   INT NOT NULL,
  price      NUMERIC(10, 2)NOT NULL,
version INT NOT NULL,
CONSTRAINT flight_pk PRIMARY KEY(id),
CONSTRAINT to_where_pk FOREIGN KEY(to_where)REFERENCES tb_airport(id),
CONSTRAINT from_where_pk FOREIGN KEY(from_where)REFERENCES tb_airport(id),
)