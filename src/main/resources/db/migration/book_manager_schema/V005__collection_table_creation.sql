USE book_manager;
CREATE TABLE collection (
                collection_id NUMERIC NOT NULL,
                name VARCHAR(250) NOT NULL,
                description TEXT,
                rating DOUBLE PRECISION,
                create_date DATE,
                update_date DATE,
                created_by VARCHAR(100),
                updated_by VARCHAR(100),
                PRIMARY KEY (collection_id)
);