use book_manager;
CREATE TABLE authors (
                author_id INT NOT NULL AUTO_INCREMENT,
                first_name VARCHAR(100) NOT NULL,
                last_name VARCHAR(100) NOT NULL,
                rating DOUBLE PRECISION,
                create_date DATE,
                created_by VARCHAR(100),
                update_date DATE,
                updated_by VARCHAR(100),
                PRIMARY KEY (author_id)
);