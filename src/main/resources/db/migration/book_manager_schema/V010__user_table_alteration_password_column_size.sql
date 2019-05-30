-- adding password column
use book_manager;
ALTER TABLE users MODIFY COLUMN password VARCHAR(100);