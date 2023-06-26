CREATE TABLE orders(
orders_id int auto_increment primary key,
reservationId int,
FOREIGN KEY (reservationId) REFERENCES reservation(reservation_id),
employeeId int,
FOREIGN KEY (employeeId) REFERENCES employee(employee_id),
schedule time(0),
customerId int,
FOREIGN KEY (customerId) REFERENCES customer(customer_id)
);