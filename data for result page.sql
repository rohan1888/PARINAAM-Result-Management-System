create database result_database;
use result_database;

create table result
(
roll_no int ,
 year int ,
 subject_name varchar(50),
 subject_grades varchar(50)
);


describe result;

insert into result
values(111,2,"DAA","A" ),
(111,2,"JAVA","B"),
(111,2,"COA","A"),
(111,2,"SOFTWARE ENGINEERING","A"),
(112,3,"DBMS","B"),
(112,3,"DISCRETE MATHEMATICS","A"),
(112,3,"DATA MINIG","C");



select *
from result;
