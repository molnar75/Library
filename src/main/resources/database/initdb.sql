INSERT INTO address VALUES
(1, 3580, 'Tiszaújváros', 'Példa utca', '32.');
INSERT INTO address VALUES
(2, 3580, 'Tiszaújváros', 'Példa utca', '42.');
INSERT INTO address VALUES
(3, 3580, 'Tiszaújváros', 'Példa utca', '8.');

INSERT INTO authors VALUES
(1,'Example Cheese', '1965-02-04');
INSERT INTO authors VALUES
(2,'Another Cheese', '1972-11-08');
INSERT INTO authors VALUES
(3,'Third Cheese', '1985-05-22');

INSERT INTO role VALUES
(1, 'admin');
INSERT INTO role VALUES
(2, 'user');

INSERT INTO libraries VALUES
(1, 'Cheese Library', 1);
INSERT INTO libraries VALUES
(2, 'Another Cheese Library', 2);
INSERT INTO libraries VALUES
(3, 'OMG ONE MORE Cheese Library', 3);

INSERT INTO users VALUES
(1, 'cheese', 'cheese', 'cheese@cheese.che', 'Cheese Example', '065347285', 1, 1, 1);
INSERT INTO users VALUES
(2, 'cheese2', 'cheese2', 'cheese2@cheese.che', 'Cheese2 Example', '067088743', 2, 3, 2);
INSERT INTO users VALUES
(3, 'cheese3', 'cheese3', 'cheese3@cheese.che', 'Cheese3 Example', '063067857', 2, 2, 3);

INSERT INTO books VALUES
(1, 'Cheese is coming', '2018-05-22',1,1);
INSERT INTO books VALUES
(2, 'Cheese is here', '2018-07-22',2,1);
INSERT INTO books VALUES
(3, 'Cheese has gone', '2018-09-22',3,1);

INSERT INTO borrowed_books VALUES
(1,'2018-06-15','2018-07-24',1,1,1);
INSERT INTO borrowed_books VALUES
(2,'2018-07-30','2018-08-10',2,2,2);
INSERT INTO borrowed_books VALUES
(3,'2019-01-02','2019-01-20',3,1,2);
