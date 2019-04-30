use book_manager;
CREATE TABLE authors (
                author_id NUMERIC NOT NULL,
                first_name VARCHAR(100) NOT NULL,
                last_name VARCHAR(100) NOT NULL,
                rating DOUBLE PRECISION,
                create_Date DATE,
                created_by VARCHAR(100),
                update_Date DATE,
                updated_by VARCHAR(100),
                PRIMARY KEY (author_id)
);