# Lab 17
# author: Michael Chan
#
# ---------------------------------------------------------------------- #
# 1) Selecting all records from the Customers table
# ---------------------------------------------------------------------- #

Select * from Customers;

# ---------------------------------------------------------------------- #
# 2) Get distinct countries from the Customers table
# ---------------------------------------------------------------------- #

Select distinct country from Customers;

# ---------------------------------------------------------------------- #
# 3) Get distinct countries from the Customers table
# ---------------------------------------------------------------------- #

Select * from customers where customerid like 'bl%';

# ---------------------------------------------------------------------- #
# 4) Get the first 100 records of the orders table
# ---------------------------------------------------------------------- #

Select * from orders limit 100;

# ---------------------------------------------------------------------- #
# 5) Get all customers that live in the postal codes 1010, 3012, 12209, 05023
# ---------------------------------------------------------------------- #

Select * from customers where postalcode = '1010' or postalcode = '3012' or postalcode = '12209' or postalcode = '05023';

# ---------------------------------------------------------------------- #
# 6) Get all orders where the ShipRegion is not equal to NULL
# ---------------------------------------------------------------------- #

Select * from orders where shipregion is not null;

# ---------------------------------------------------------------------- #
# 7) Get all customers ordered by the country, then by the city.
# ---------------------------------------------------------------------- #

Select * from customers order by country, city;

# ---------------------------------------------------------------------- #
# 8) Add a new customer to the customers table. You can use whatever values.
# ---------------------------------------------------------------------- #

insert into customers values ('Mike', 'Grand Circus', "Michael", "Java Student", "1570 Woodward", "Detroit", "MI", "48103", "USA", "234-234-2344", null);

# ---------------------------------------------------------------------- #
# 9) Update all ShipRegion to the value 'EuroZone' in the Orders table, where ShipCountry is equal to France.
# ---------------------------------------------------------------------- #

update orders set shipregion = 'EuroZone' where shipcountry = 'France';

# ---------------------------------------------------------------------- #
# 10) Delete all orders from 'order details' that have quantity of 1.
# ---------------------------------------------------------------------- #

delete from `order details` where quantity = 1;

# ---------------------------------------------------------------------- #
# 11) Calculate the average, max, and min of the quantity at the 'order details' table.
# ---------------------------------------------------------------------- #

select avg(quantity), max(quantity), min(quantity) from `order details`;

# ---------------------------------------------------------------------- #
# 12) Calculate average, max, and min of the quantity at the 'order details' table grouped by order id.
# ---------------------------------------------------------------------- #

select avg(quantity), max(quantity), min(quantity) from `order details` group by orderid;

# ---------------------------------------------------------------------- #
# 13) Find the CustomerID that placed order 10290 (orders table)
# ---------------------------------------------------------------------- #

select customerid from orders where orderid = 10290;

# ---------------------------------------------------------------------- #
# 14) Do an inner join, left join, right join on orders and customers tables.
# ---------------------------------------------------------------------- #

select * from orders left join customers on orders.customerid = customers.customerid;

select * from orders right join customers on orders.customerid = customers.customerid;

select * from orders inner join customers on orders.customerid = customers.customerid;

# ---------------------------------------------------------------------- #
# 15) Get employees' firstname for all employees who report to no one.
# ---------------------------------------------------------------------- #

select firstname from employees where ReportsTo is null;

# ---------------------------------------------------------------------- #
# 16) Get employees' firstname for all employees who report to Andrew
# ---------------------------------------------------------------------- #

select firstname from employees where ReportsTo is 'Andrew';