USE book_manager;
CREATE TABLE book_genres (
                book_genres_id NUMERIC NOT NULL,
                genre_id NUMERIC NOT NULL,
                book_id NUMERIC NOT NULL,
                created_by VARCHAR(100),
                create_date DATE,
                updated_by VARCHAR(100),
                update_date DATE,
                PRIMARY KEY (book_genres_id)
);

ALTER TABLE book_genres ADD CONSTRAINT genre_book_genres_fk
FOREIGN KEY (genre_id)
REFERENCES genre (genre_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE book_genres ADD CONSTRAINT books_book_genres_fk
FOREIGN KEY (book_id)
REFERENCES books (book_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;