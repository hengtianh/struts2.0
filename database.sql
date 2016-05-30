create database market;
use market;



---------管理员表-------
create table admintbl(
	id int auto_increment primary key not null,
	name varchar(20) not null,
	password varchar(20) not null
);

---------用户表----------
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

----------类别表------------
create table type(
	typeID int auto_increment primary key not null,
	typename varchar(50) not null
);
insert into type(typename) values('学习用品');
insert into type(typename) values('电子产品');
insert into type(typename) values('日常物品');
insert into type(typename) values('出行工具');

----------商品分类表--------------
create table category(
	cateID int auto_increment primary key not null,
	typeID int not null,
	catename varchar(50) not null,
	foreign key (typeID) references type(typeID)
);

-----------商品表-------------------

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

------------评价表-----------------
cteate table comment(
	id int auto_increment primary key not null,
	productID int not null,
	comments varchar(200) not null,
	score int not null
);

-------------订单清单表--------------------
create table orderlist(
	listid int auto_increment primary key not null,
	orderID int not null,
	createtime date not null,
	total double not null,
	address varchar(50) not null,
	id int not null
);

--------------订单信息表-------------------------
create table ordertbl(
	orderID int auto_increment primary key not null,
	productID int not null,
	productname varchar(50) not null,
	amount int not null,
	price double not null
);