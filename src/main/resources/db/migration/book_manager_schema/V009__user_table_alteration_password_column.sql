-- adding password column
use book_manager;
ALTER TABLE users ADD COLUMN password VARCHAR(25) AFTER last_name;