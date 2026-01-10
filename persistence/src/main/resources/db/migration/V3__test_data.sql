INSERT INTO books (title, author, pub_year) VALUES ('The Witcher', 'Andrzej Sapkowski', 1993);
INSERT INTO books (title, author, pub_year) VALUES ('1984', 'George Orwell', 1949);
INSERT INTO books (title, author, pub_year) VALUES ('Kobzar', 'Taras Shevchenko', 1840);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (1, 'Artem', 'Коментар 1', CURRENT_TIMESTAMP);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (1, 'Ivan', 'Коментар 2', CURRENT_TIMESTAMP);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (2, 'Ivan', 'Коментар 3', CURRENT_TIMESTAMP);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (2, 'Artem', 'Коментар 4', CURRENT_TIMESTAMP);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (3, 'Dmytro', 'Коментар 5', CURRENT_TIMESTAMP);

INSERT INTO comments (book_id, author, text, created_at)
VALUES (3, 'Artem', 'Коментар 6', CURRENT_TIMESTAMP);