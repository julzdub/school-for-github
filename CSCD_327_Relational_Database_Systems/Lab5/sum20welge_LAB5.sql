use sum20welge_3;

select title, retail
from BOOKS
where retail < (select avg(retail) from BOOKS);

select a.title, b.category, a.cost
from BOOKS a, (select category, avg(cost) average from BOOKS group by category) b
where a.category = b.category and a.cost < b.average;

select order_num 
from ORDERS 
where shipstate = (select shipstate from ORDERS where order_num = 1014);

select order_num, sum(quantity*paideach)
from ORDERITEMS
group by order_num
having sum(quantity*paideach) > (select sum(quantity * paideach)
								from ORDERITEMS
                                where order_num = 1002);
                                
select title
from BOOKS
where category in (select distinct category
					from BOOKS join ORDERITEMS using (ISBN) join ORDERS using (order_num)
                    where customer_num = 1007) and 
                    ISBN not in (select ISBN
					from ORDERS join ORDERITEMS using (order_num)
                    where customer_num = 1007);

select shipcity, shipstate
from ORDERS
where datediff(shipdate, orderdate) = (select max(datediff(shipdate, orderdate))
									from ORDERS);

select customer_num
from ORDERS join ORDERITEMS using (order_num) join BOOKS using (ISBN)
where retail = (select min(retail)
				from BOOKS);

select count(distinct customer_num)
from ORDERS join ORDERITEMS using (order_num) join BOOKAUTHOR using (ISBN)
where authorID = (select authorID
					from AUTHOR
                    where lname = "Austin" and fname = "James");
                    
use sum20welge_5;

select product_name, list_price
from products 
where list_price > (select avg(list_price)
						from products)
order by list_price DESC;

select category_name
from categories
where category_id not in (select category_id from products);

select email_address, order_id, order_date
from customers t join orders using (customer_id)
where order_date = (select min(order_date)
					from orders s
                    where t.customer_id = s.customer_id);

use sum20welge_4;
show tables;

select id, name, salary
from instructor
where salary = (select max(salary)
				from instructor);

select id, name, salary
from instructor
where salary = (select max(salary)
				from instructor
                where salary < (select max(salary)
								from instructor));
                                

select instructor_id, name, max(cnt)
from (select id as instructor_id, count(distinct course_id) as cnt
	from teaches 
    group by id) t, instructor;
