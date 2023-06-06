CREATE TABLE reservation(
reservation_id int auto_increment primary key,
reservation_date date,
reservation_time time(0),
party_size int,
customerId int,
tablesId int,
FOREIGN KEY (tablesId) REFERENCES tables(tables_id),
FOREIGN KEY (customerId) REFERENCES customer(customer_id)
);