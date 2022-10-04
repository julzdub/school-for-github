use sum20welge_5;
select CONCAT(last_name, ", ", first_name) as full_name from customers
where last_name between "M%" and "Z%"
order by last_name;
select product_name, list_price, discount_percent, 
Round(concat(list_price * (0.01 * discount_percent)), 2) as discount_amount, 
Round(concat(list_price - (list_price * (0.01 * discount_percent))), 2) as discount_price 
from products;
select item_id, item_price, discount_amount, quantity,
concat(item_price * quantity) as price_total, concat(discount_amount * quantity) as discount_total,
concat((item_price - discount_amount) * quantity) as item_total
from order_items
where ((item_price - discount_amount) * quantity) > 500
order by item_total DESC;
