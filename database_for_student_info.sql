create database result_management;
use result_management;
create table student_info
(roll_no int,
password int,
first_name varchar(20),
last_name varchar(20),
email_id varchar(100),
dob date,
mobile_no bigint,
branch varchar(40),
semester int,
year int,
pincode int,
state varchar(20),
city varchar(20));
alter table student_info add primary key(roll_no);
insert into student_info 
values (101,20011012,"aman","gupta","aman123@gamil.com","2001-11-12",9876543210,"computer engineering",2,1,136119,"harayana","kurukshetra"),
(102,20001108,"shash","gupta","shash4563@yahoo.com","2000-11-08",3214578610,"Electronics and communication engg",3,2,800004,"jharkahand","ranchi"),
(103,20010423,"prox","booby","pr37326@bewkof.com","2001-04-23",9541236987,"information technology",4,2,136034,"haryana","cheeka"),
(104,20020228,"rohan","kumar","royalRohan@icloud.com","2002-02-28",8708322262,"mechanical engineering",5,3,136061,"haryana","kaithal"),
(105,20030131,"sanyam","khapra","khaprasanyam@gmail.com","2003-01-31",8572863401,"civil engineering",1,1,136035,"punjab","patiala");
