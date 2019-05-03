USE book_manager;

CREATE TABLE genre (
                genre_id INT NOT NULL AUTO_INCREMENT,
                name VARCHAR(250) NOT NULL,
                description TEXT,
                created_by VARCHAR(100),
                updated_by VARCHAR(100),
                create_date DATE,
                update_date DATE,
                PRIMARY KEY (genre_id)
);