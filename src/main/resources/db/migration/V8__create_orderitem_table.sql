CREATE TABLE orderItem(
orderitem_id int auto_increment primary key,
orderId int,
FOREIGN KEY (orderId) REFERENCES orders(orders_id),
menuId int,
FOREIGN KEY (menuId) REFERENCES menu(menu_id),
quantity int
);