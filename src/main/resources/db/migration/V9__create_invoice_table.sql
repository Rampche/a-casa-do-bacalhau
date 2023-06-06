CREATE TABLE invoice(
invoice_id int auto_increment primary key,
ordersId int,
FOREIGN KEY (ordersId) REFERENCES orders(orders_id),
total decimal(10,2),
issuedDate date,
issuedTime time(0)
);