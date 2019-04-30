USE book_manager;
CREATE TABLE series (
                series_id NUMERIC NOT NULL,
                author_id NUMERIC NOT NULL,
                name VARCHAR(250) NOT NULL,
                description TEXT,
                rating DOUBLE PRECISION,
                create_date DATE,
                created_by VARCHAR(100),
                update_date DATE,
                updated_by VARCHAR(100),
                PRIMARY KEY (series_id)
);

ALTER TABLE series ADD CONSTRAINT authors_series_fk
FOREIGN KEY (author_id)
REFERENCES authors (author_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;