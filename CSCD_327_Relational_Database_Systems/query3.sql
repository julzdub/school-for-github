use sum20welge_3;

select distinct Order_num, FirstName, LastName, OrderDate
from ORDERS natural join CUSTOMERS
where ORDERS.ShipDate is NULL
order by OrderDate;

select Customer_num, FirstName, LastName
from CUSTOMERS
where State = 'FL' and Customer_num in 
	(select Customer_num
    from ORDERS
    where Order_num in 
		(select Order_num
        from ORDERITEMS
        where ISBN in 
			(select ISBN
            from BOOKS
            where Category = 'COMPUTER')
		)
	);

select Title
from BOOKS
where ISBN in 
	(select ISBN
    from ORDERITEMS
    where Order_num in
		(select Order_num
        from ORDERS
        where Customer_num in 
			(select Customer_num
            from CUSTOMERS
            where FirstName = 'JAKE' and LastName = 'LUCAS')
		)
	);

select Title, Cost, PaidEach, concat(PaidEach - Cost) as Profit
from BOOKS natural join ORDERITEMS natural join ORDERS
where Customer_num in 
	(select Customer_num 
    from CUSTOMERS
	 where FirstName = 'JAKE' and LastName = 'LUCAS')
order by OrderDate;

select Title, BOOKS.ISBN
from BOOKS, BOOKAUTHOR, AUTHOR
where BOOKS.ISBN = BOOKAUTHOR.ISBN and BOOKAUTHOR.AuthorID = AUTHOR.AuthorID and AUTHOR.Lname = 'ADAMS';

select concat(AUTHOR.Lname, " ", AUTHOR.Fname) as Author, Title
from CUSTOMERS, ORDERS, BOOKS, ORDERITEMS, BOOKAUTHOR, AUTHOR
where CUSTOMERS.Customer_num = ORDERS.Customer_num
and ORDERS.Order_num = ORDERITEMS.Order_num
and ORDERITEMS.ISBN = BOOKS.ISBN
and BOOKS.ISBN = BOOKAUTHOR.ISBN
and BOOKAUTHOR.AuthorID = AUTHOR.AuthorID
and CUSTOMERS.LastName = 'NELSON'
and CUSTOMERS.FirstName = 'BECCA';

select BOOKS.Title, ORDERS.Order_num, ORDERS.ShipState
from BOOKS, ORDERITEMS, ORDERS
where (ORDERITEMS.Order_num = ORDERS.Order_num and BOOKS.ISBN = ORDERITEMS.ISBN);

select COUNT(*)
from BOOKS
where retail > 30;

select MAX(pubdate)
from BOOKS;

select SUM((retail-cost)*quantity)
from ORDERS natural join ORDERITEMS natural join BOOKS
where Customer_num = 1017;

select MIN(retail)
from BOOKS
where Category = 'CHILDREN';

select Customer_num, COUNT(*)
from ORDERS
group by Customer_num;

select name, category, AVG(retail)
from BOOKS join PUBLISHER using(pubid)
where Category in ('COMPUTER', 'CHILDREN')
group by name, Category;

select firstname, lastname, Order_num
from CUSTOMERS join ORDERS using (Customer_num) join ORDERITEMS using (Order_num) 
join BOOKS using (ISBN)
where (State = 'FL' or State = 'GA')
group by Order_num, firstname, lastname
having SUM(retail*quantity)>80
order by SUM(retail*quantity);


select MAX(retail)
from BOOKS join BOOKAUTHOR using(ISBN) join AUTHOR using (AuthorID)
where lname = 'WHITE' and fname = 'LISA';
