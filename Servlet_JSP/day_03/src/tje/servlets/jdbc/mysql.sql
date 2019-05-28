create database test;

use test;

create table member (
	id varchar(20) primary key,
    password varchar(20) not null,
    name varchar(20) not null,
    age int,
    tel varchar(20),
    address varchar(100)
);

select * from member;

