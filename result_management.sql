create database result_management;
use result_management;
create table teacher_info (
t_id int PRIMARY KEY,
first_name varchar(20),
last_name Varchar(20),
mobile_no bigint,
email_id Varchar(100),
course_id1 varchar(7),
course_id2 varchar(7),
course_id3 varchar(7),
password varchar(8)
);

select * from teacher_info;
-- drop table teacher_info;

insert into teacher_info values
(17411616,"Saritha","Sinha",7018259126,"Sinhasaritha3457@gmail.com","CSPC12","CSPC21","CSPC31","sari7018"),
(17886187,"Vandana","Saxena",9988305696,"VandanaSn96@gmail.com","MAIR11","MAIR12","MAIR24","vand9988"),
(22046790,"Rajib","Mustafa","9140694778","Mrajib8891@gmail.com","CSPC27","CSPE31","CSPC35","raji9140"),
(87198288,"DEEPAK","Chatterjee",8894124522,"DeepakCh482@gmail.com","CSPC10","CSPC29","CSPC22","deep8894"),
(94709278,"Aashish","ARORA",9816912358,"Ashisharrora3445@gmail.com","CSPC25","CSPE64","CSPE71","aash9816"),
(30277021,"Manoj","KAPOOR",9817282667,"manojkumar981@gmail.com","CSPC23","CSPE20","CSPE35","mano9817"),
(52712813,"Anant","PANDEY",8988199949,"Apandey819@gmail.com","CSPC20","CSPC43","CSPE44","anan8988"),
(19514270,"Danish","NAZIR",9816220802,"danishmnz873@gmail.com","CSPC26","CSPE37","CSPC45","dani9816"),
(31487561,"Madhuri","CHAUHAN",9416401398,"missmadhurichauhan83@gmail.com","CSPC40","CSPC41","CSPE46","madh9416"),
(15311790,"CHHATRAPAL","REDDY",9816656619,"creddyarp542@gmail.com","CSPC27","CSPC43","CSPE71","chha9816"),
(31964225,"SAMIR","Jha",7807430162,"samjha7782@gmail.com","CSPC35","CSPC23","CSPC29","sami7807");

create table result (
semster int,
roll_no int,
dob date,
pf enum('pass','fail'),
course_id varchar(7),
grade varchar(2),
credit int,
foreign key (roll_no) references student_info(roll_no)
);

drop table result;

select * from result where roll_no = 1240618;

insert into result values
(7,1140185,13/11/1999,1,"CSPC41","B",4),
(7,1140185,13/11/1999,1,"CSPC45","B",4),
(7,1140185,13/11/1999,1,"CSPC71","B",4),
(4,1240618,16/09/2002,1,"CSPC23","B",4),
(4,1240618,16/09/2002,1,"CSPC25","B",5),
(4,1240618,16/09/2002,1,"CSPC27","B",4),
(7,1211858,21/10/2004,1,"CSPC41","B",4),
(7,1211858,21/10/2004,1,"CSPC45","A",4),
(7,1211858,21/10/2004,1,"CSPC71","B",4),
(4,2130004,07/07/2002,1,"CSPC23","C",4),
(4,2130004,07/07/2002,1,"CSPC25","B",5),
(4,2130004,07/07/2002,1,"CSPC27","B",4),
(4,1130356,19/09/2000,1,"CSPC23","C",4),
(4,1130356,19/09/2000,1,"CSPC25","B",5),
(4,1130356,19/09/2000,1,"CSPC27","A",4),
(7,1211082,05/05/2004,1,"CSPC41","B",4),
(7,1211082,05/05/2004,1,"CSPC45","B",4),
(7,1211082,05/05/2004,1,"CSPC71","B",4),
(4,2412259,26/04/2004,1,"CSPC23","B",4),
(4,2412259,26/04/2004,1,"CSPC25","B",5),
(4,2412259,26/04/2004,1,"CSPC27","C",4),
(4,1310389,23/12/2004,1,"CSPC23","C",4),
(4,1310389,23/12/2004,1,"CSPC25","B",5),
(4,1310389,23/12/2004,1,"CSPC27","A+",4),
(7,2110666,22/02/2002,1,"CSPC41","C",4),
(7,2110666,22/02/2002,1,"CSPC45","B",4),
(7,2110666,22/02/2002,1,"CSPC71","B",4),
(4,1140051,06/12/2003,1,"CSPC23","B",4),
(4,1140051,06/12/2003,1,"CSPC25","B",5),
(4,1140051,06/12/2003,1,"CSPC27","D",4);

create table student_info (
roll_no int PRIMARY KEY,
password varchar(8),
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
city varchar(20)
);

select * from student_info;

insert into student_info values
(1140185,"gaje0185","Gajender","SINGH","Gajendersingh1140@gmail.com","1999-11-13",9427706747,"Computer Engineering ",7,4,400013,"Maharashtra","Mumbai"),
(1240618,"mayu0618","MAYUR","Manchanda","Mayurmanchanda1240@gmail.com","2002-09-16",9825416137,"Computer Engineering ",4,2,380026,"Gujarat","Ahmedabad"),
(1211858,"abhi1858","ABHISHEK","Agrahari","Abhishekagrahari1211@gmail.com","2004-10-21",8849679902,"Computer Engineering ",7,4,400011,"Maharashtra","Mumbai"),
(2130004,"utta0004","UTTAM","Khurana","Uttamkhurana2130@gmail.com","2002-07-07",8690152573,"Computer Engineering ",4,2,121001,"Delhi","Delhi"),
(1130356,"chir0356","CHIRAG","MAHESHWARI","Chiragmaheshwari1130@gmail.com","2000-09-19",8141814781,"Computer Engineering ",4,2,641041,"Tamil Nadu","Coimbatore"),
(1211082,"anki1082","ANKIT","Bansal","Ankitbansal1211@gmail.com","2004-05-05",9925748780,"Computer Engineering ",7,4,560001,"Karnataka","Bangalore"),
(2412259,"gour2259","GOURI","Yadav","Gouriyadav2412@gmail.com","2001-04-26",9054037218,"Computer Engineering ",4,2,600014,"Tamil Nadu","Chennai"),
(1310389,"dipi0389","DIPIKA","MUDULI","Dipikamuduli1310@gmail.com","2004-12-23",7359171601,"Computer Engineering ",4,2,500095,"Andhra Pradesh","Hyderabad"),
(2110666,"pala0666","PALAK","Kashyap","PalakKashyap2110@gmail.com","2002-02-22",8401434241,"Computer Engineering ",7,4,452001,"Madhya Pradesh","Indore"),
(1140051,"hima0051","HIMANI","Bhatia","Himanibhatia1140@gmail.com","2002-01-31",6354864442,"Computer Engineering ",4,2,781021,"Assam","Guwahati");



create table subject (
course_id varchar(7),
sub_name varchar(40),
check_prac bool,
credits int,
primary key(course_id)
);

-- drop table subject;




insert into subject values
("CSPC41","Cloud and Grid Computing",1,4),
("CSPC45","Computer Vision",1,4),
("CSPC71","Advanced Database Systems",1,4),
("CSPC23","Java Programming ",1,4),
("CSPC25","Database Systems ",1,5),
("CSPC27","Software Engineering",0,4);

select * from subject where course_id = "CSPC23";

create table marks (roll_no int,
course_id varchar(6),
semester int,
int_1_prac int,
int_2_prac int,
viva_ex int,
ext_prac int,
int_1_thy int,
int_2_thy int,
ext_thy int,
attendance int,
class_perf int);

alter table marks ADD PRIMARY KEY (roll_no, course_id,semester);
alter table marks ADD
FOREIGN KEY (roll_no) REFERENCES student_info(roll_no);

alter table marks ADD
FOREIGN KEY (course_id) REFERENCES subject(course_id);

insert into marks values
(1140185,"CSPC41",7,20,8,5,40,4,8,37,10,7),
(1140185,"CSPC45",7,16,16,5,38,8,8,36,9,9),
(1140185,"CSPC71",7,17,16,18,27,14,14,25,9,8),
(1240618,"CSPC23",4,16,14,16,27,6,13,35,9,9),
(1240618,"CSPC25",4,14,13,17,28,10,13,46,9,7),
(1240618,"CSPC27",4,null,null,null,null,4,11,34,10,9),
(1211858,"CSPC41",7,6,11,16,28,4,12,34,9,10),
(1211858,"CSPC45",7,16,12,18,27,13,5,48,9,8),
(1211858,"CSPC71",7,13,14,19,28,11,4,36,10,9),
(2130004,"CSPC23",4,8,18,11,21,10,3,33,9,8),
(2130004,"CSPC25",4,20,11,12,21,8,5,37,9,7),
(2130004,"CSPC27",4,null,null,null,null,13,12,31,10,8),
(1130356,"CSPC23",4,10,14,13,27,12,6,29,9,8),
(1130356,"CSPC25",4,8,8,16,38,5,13,31,8,8),
(1130356,"CSPC27",4,null,null,null,null,8,14,41,9,9),
(1211082,"CSPC41",7,10,20,15,34,7,6,36,10,9),
(1211082,"CSPC45",7,12,11,12,33,7,10,37,9,7),
(1211082,"CSPC71",7,12,10,8,35,8,4,35,10,8),
(2412259,"CSPC23",4,13,14,7,35,4,9,47,9,8),
(2412259,"CSPC25",4,11,16,11,35,4,5,36,9,8),
(2412259,"CSPC27",4,null,null,null,null,9,4,32,10,9),
(1310389,"CSPC23",4,12,16,2,18,5,9,33,8,9),
(1310389,"CSPC25",4,20,11,18,15,13,5,35,10,10),
(1310389,"CSPC27",4,null,null,null,null,13,12,42,10,10),
(2110666,"CSPC41",7,10,12,17,21,8,6,34,8,10),
(2110666,"CSPC45",7,8,14,19,29,1,13,37,8,8),
(2110666,"CSPC71",7,14,16,11,28,7,11,38,9,8),
(1140051,"CSPC23",4,13,14,15,31,11,5,29,9,9),
(1140051,"CSPC25",4,11,12,16,31,1,12,42,9,7),
(1140051,"CSPC27",4,null,null,null,null,8,6,17,9,8);




select *
from marks
where roll_no = 1240618;

select * 
from marks 
;