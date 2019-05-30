USE book_manager;
CREATE TABLE users (
                user_id INT NOT NULL AUTO_INCREMENT,
                user_name VARCHAR(50) NOT NULL,
                first_name VARCHAR(100) NOT NULL,
                last_name VARCHAR(100) NOT NULL,
                created_by VARCHAR(100),
                create_date DATE,
                updated_by VARCHAR(100),
                update_date DATE,
                PRIMARY KEY (user_id)
);
