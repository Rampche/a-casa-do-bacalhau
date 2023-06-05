CREATE TABLE tables(
tables_id int auto_increment primary key
status varchar(255)
number int
capacity int
)

CREATE TABLE reservation(
reservation_id int auto_increment primary key
reservation_date date
reservation_time time(0)
party_size int
customerId int
tablesId int
FOREIGN KEY (tablesId) REFERENCES tables(tables_id)
FOREIGN KEY (customerId) REFERENCES customer(customer_id)
)

CREATE TABLE menu(
menu_id int auto_increment primary key
name varchar(255)
)

CREATE TABLE items(
item_id int auto_increment primary key
name varchar(255)
price decimal(10,2)
description varchar(255)
menuId int
FOREIGN KEY menuId REFERENCES menu(menu_id)
)

CREATE TABLE orders(
orders_id int auto_increment primary key
reservationId int
FOREIGN KEY (reservationId) REFERENCES reservation(reservation_id)
employeeId int
FOREIGN KEY (employeeId) REFERENCES employee(employee_id)
schedule time(0)
)

CREATE TABLE orderItem(
orderitem int auto_increment primary key
orderId int
FOREIGN KEY (orderId) REFERENCES orders(orders_id)
menuId int
FOREIGN KEY (menuId) REFERENCES menu(menu_id)
quantity int
)

CREATE TABLE invoice(
invoice_id int auto_increment primary key
ordersId int
FOREIGN KEY (ordersId) REFERENCES orders(orders_id)
total decimal(10,2)
issuedDate date
issuedTime time(0)
)

CREATE TABLE employee(
employee_id int auto_increment primary key
name varchar(255)
email varchar(255) unique
role varchar(100)
)

CREATE TABLE costumer(
costumer_id int auto_increment primary key
name varchar(255)
email varchar(255) unique
password varchar(255)
)



