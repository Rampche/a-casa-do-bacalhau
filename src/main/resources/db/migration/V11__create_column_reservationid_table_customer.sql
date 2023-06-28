ALTER TABLE customer
ADD COLUMN reservation_id int,
ADD FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id)
