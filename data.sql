
create table account(
id int primary key auto_increment,
username varchar(100) unique not null,
firstname varchar(50) not null,
lastname varchar(50) not null,
telephone varchar(20) not null,
email varchar(100) not null,
password varchar(100) not null,
Gender enum('M','F') ,
status int not null default 1,
date timestamp not null default now());


create table tests(
T_ID int primary key auto_increment,
T_Lang1 int not null, 
T_Lang2 int not null,
T_Pic varchar(250) null,
T_Lev int not null default 0,
T_Score int not null default 0,
T_User int not null ,
T_Mode int not null default 0,
T_Raiting int not null default 0,
T_DATE timestamp not null default now(),
T_Question text not null,
T_Answer varchar(200) not null,
T_Description text not null ,
Foreign key(T_USER) references Account(ID)
); 

create table highscore(
user_id int primary key,
Score double default 0.0,
foreign key(user_id) references Account(Id)
);