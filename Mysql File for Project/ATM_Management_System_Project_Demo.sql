create database ATM_Management_System_Project_Demo;
use ATM_Management_System_Project_Demo;

create table signup
(
formno varchar(20), 
name varchar(30), 
fname varchar(30), 
dob varchar(20), 
gender varchar(20), 
email varchar(20), 
marital varchar(20), 
address varchar(40), 
city varchar(20), 
pincode varchar(20), 
state varchar(30)
);

alter table signup
modify email varchar(45);

select * from signup;
describe signup;

create table signup2
(
formno varchar(20), 
religion varchar(20), 
category varchar(30), 
income varchar(30), 
education varchar(20), 
occupation varchar(20), 
pan varchar(20), 
aadhar varchar(20), 
scitizen varchar(40), 
eaccount varchar(20)
);

SET SQL_SAFE_UPDATES = 0;
delete from signup where formno=9422;

select * from signup2;
describe signup2;

create table signup3
(
formno varchar(20), 
atype varchar(20), 
cardno varchar(30), 
pin varchar(20), 
facility varchar(100)
);

alter table signup3
modify atype varchar(50);

select * from signup3;
describe signup3;
delete from signup3 where pin=2831;

create table login
(
formno varchar(20), 
cardno varchar(30), 
pin varchar(20)
);

select * from login;
describe login;

create table bank
(
pin varchar(10), 
date varchar(40), 
mode varchar(30), 
amount varchar(20)
);

select * from bank;
describe bank;

create table login2
(
formno varchar(20), 
cardno varchar(30) 
);

describe login2;
select * from login2;

insert into login2
values
(2513,5040936073496944);

