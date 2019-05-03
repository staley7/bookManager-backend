USE book_manager;
CREATE TABLE books (
                book_id INT NOT NULL AUTO_INCREMENT,
                series_id INT,
                collection_id INT,
                author_id INT NOT NULL,
                title VARCHAR(500),
                description TEXT,
                rating DOUBLE PRECISION,
                create_date DATE,
                created_by VARCHAR(100),
                update_date DATE NOT NULL,
                updated_by VARCHAR(100),
                PRIMARY KEY (book_id)
);

ALTER TABLE books ADD CONSTRAINT collection_books_fk
FOREIGN KEY (collection_id)
REFERENCES collection (collection_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE books ADD CONSTRAINT authors_books_fk
FOREIGN KEY (author_id)
REFERENCES authors (author_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE books ADD CONSTRAINT series_books_fk
FOREIGN KEY (series_id)
REFERENCES series (series_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;