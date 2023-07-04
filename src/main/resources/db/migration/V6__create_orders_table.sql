CREATE TABLE orders(
orders_id int auto_increment primary key,
reservation_id int,
FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id),
employee_id int,
FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
schedule time(0),
customer_id int,
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);