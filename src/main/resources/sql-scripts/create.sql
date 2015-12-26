drop database if exists order_mgmt;
create database order_mgmt;
create user 'oms-user'@'localhost' identified by 'oms-user';
grant all privileges on 'oms-user'.* to 'oms-user'@'localhost';
FLUSH PRIVILEGES;

use order_mgmt;
--drop table scripts
drop table if exists OrderLine;
drop table if exists SalesOrder;
drop table if exists Customer;
drop table if exists Product;
drop 
--Create table scripts
create table if not exists Product( id BIGINT not null AUTO_INCREMENT primary key,description varchar(100),price double(10,2),quantity int);
create table if not exists Customer(id BIGINT not null AUTO_INCREMENT primary key,name varchar(100),phoneNumber1 varchar(50),phoneNumber2 varchar(50),
address varchar(100),creditLimit double(10,2), currentCredit double(10,2));
create table if not exists SalesOrder(id BIGINT not null AUTO_INCREMENT primary key,totalPrice float(8,2),customerId BIGINT not null,
foreign key customer(customerId) references Customer(id));
create table if not exists OrderLine(id BIGINT not null AUTO_INCREMENT primary key,productQuantity int,price float(8,2),productId BIGINT not null,
salesOrderId BIGINT not null, foreign key product(productId) references Product(id),foreign key salesOrder(salesOrderId) references SalesOrder(id));

--Dummy Data Insert Scripts
--Customer
insert into Customer (id,name,phoneNumber1,phoneNumber2,address,creditLimit,currentCredit) values(01,"Customer 1","+201011121314",null,"USA",1000,1000);
insert into Customer (id,name,phoneNumber1,phoneNumber2,address,creditLimit,currentCredit) values(02,"Customer 2","+201011121314",null,"INDIA",10000,1000);
insert into Customer (id,name,phoneNumber1,phoneNumber2,address,creditLimit,currentCredit) values(03,"Customer 3","+201011121314",null,"USA",2000.98,1000);
insert into Customer (id,name,phoneNumber1,phoneNumber2,address,creditLimit,currentCredit) values(04,"Customer 4","+201011121314",null,"INDIA",100.0,99.90);

--Product
insert into Product(id,description,price,quantity) values(01,"Product 1",34.8,9);
insert into Product(id,description,price,quantity) values(02,"Product 2",34434.8,90);
insert into Product(id,description,price,quantity) values(03,"Product 3",221212.98,19);
insert into Product(id,description,price,quantity) values(04,"Product 4",232322.45,43);