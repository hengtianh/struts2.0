create database market;
use market;



---------����Ա��-------
create table admintbl(
	id int auto_increment primary key not null,
	name varchar(20) not null,
	password varchar(20) not null
);

---------�û���----------
create table usertbl(
	id int auto_increment primary key not null,
	username varchar(50) not null,
	password varchar(20) not null,
	sex varchar(10) not null,
	stuID varchar(12) not null,
	address varchar(50) not null,
	phone varchar(11) not null,
	isBoss bit not null,
	email varchar(50) not null
);

----------����------------
create table type(
	typeID int auto_increment primary key not null,
	typename varchar(50) not null
);
insert into type(typename) values('ѧϰ��Ʒ');
insert into type(typename) values('���Ӳ�Ʒ');
insert into type(typename) values('�ճ���Ʒ');
insert into type(typename) values('���й���');

----------��Ʒ�����--------------
create table category(
	cateID int auto_increment primary key not null,
	typeID int not null,
	catename varchar(50) not null,
	foreign key (typeID) references type(typeID)
);

-----------��Ʒ��-------------------

drop table product;
create table product(
	productID int auto_increment primary key not null,
	id int not null,
	cateID int not null,
	productname varchar(50) not null,
	price double not null,
	number int not null,
	image varchar(200) not null,
	description varchar(200) not null,
	foreign key (id) references usertbl(id)
);

------------���۱�-----------------
cteate table comment(
	id int auto_increment primary key not null,
	productID int not null,
	comments varchar(200) not null,
	score int not null
);

-------------�����嵥��--------------------
create table orderlist(
	listid int auto_increment primary key not null,
	orderID int not null,
	createtime date not null,
	total double not null,
	address varchar(50) not null,
	id int not null
);

--------------������Ϣ��-------------------------
create table ordertbl(
	orderID int auto_increment primary key not null,
	productID int not null,
	productname varchar(50) not null,
	amount int not null,
	price double not null
);