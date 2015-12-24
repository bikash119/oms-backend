create database order_mgmt
use order_mgmt

--Create table scripts
create table if not exists Product( id varchar(100) not null primary key,description varchar(100),price float(8,2),quantity int);
create table if not exists Customer(id varchar(100) not null primary key,name varchar(100),currentCredit float(8,2), phoneNumber varchar(50));
create table if not exists SalesOrder(id varchar(100) not null primary key,totalPrice float(8,2),customerId varchar(100),
foreign key customer(customerId) references Customer(id));
create table if not exists OrderLine(id varchar(100) not null primary key,productQuantity int,price float(8,2),productId varchar(100),
salesOrderId varchar(100), foreign key product(productId) references Product(id),foreign key salesOrder(salesOrderId) references SalesOrder(id));

--Dummy Data Insert Scripts
--Customer
insert into Customer (id,name,currentCredit,phoneNumber) values("01","Customer 1",23.9,"+201011121314");
insert into Customer (id,name,currentCredit,phoneNumber) values("02","Customer 2",386.98,"+201011121314");
insert into Customer (id,name,currentCredit,phoneNumber) values("03","Customer 3",10098.09,"+201011121314");
insert into Customer (id,name,currentCredit,phoneNumber) values("04","Customer 4",767896.19,"+201011121314");

--Product
insert into Product(id,description,price,quantity) values("01","Product 1",34.8,9);
insert into Product(id,description,price,quantity) values("02","Product 2",34434.8,90);
insert into Product(id,description,price,quantity) values("03","Product 3",221212.98,19);
insert into Product(id,description,price,quantity) values("04","Product 4",232322.45,43);