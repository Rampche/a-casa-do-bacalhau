CREATE TABLE orderItem(
orderitem_id int auto_increment primary key,
orderId int,
FOREIGN KEY (orderId) REFERENCES orders(orders_id),
itemId int,
FOREIGN KEY (itemId) REFERENCES items(item_id),
quantity int
);