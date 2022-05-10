use master
go
if exists(select * from sysdatabases where name='zhygcbook')
	drop database zhygcbook
go
create database zhygcbook
go
use zhygcbook
go
--���νṹ���
create table bookType(
	bookTypeId int identity primary key,
	parentId int not null,
	bookTypeName varchar(20) not null,
	isDelete int not null,--1Ϊ���ã�2Ϊ������
	context varchar(40)
)
alter table bookType 
	add constraint DF_isDelete default (1) FOR isDelete
go


create table bookInfo(
	bookId int identity primary key,
	bookName varchar(20) not null,
	booktypeId int not null,
	pbName varchar(20) not null,
	author varchar(20) not null,
	context varchar(40) ,
	smallImg varchar(20) ,
	bigImg varchar(20) ,
	price money not null,
	pbdate datetime not null,
	bookStates int not null,--1Ϊ���ã�2Ϊ�ϼܣ�3Ϊ������
	ygcprice money not null
)
go
alter table bookInfo
add constraint FK_booktypeId 
	FOREIGN KEY(booktypeId) REFERENCES bookType(booktypeId)
alter table bookInfo 
	add constraint DF_bookInfo default ('nullSmall.png') FOR smallImg
alter table bookInfo 
	add constraint DF_bigImg default ('nullImg.png') FOR bigImg
alter table bookInfo 
	add constraint DF_bookStates default (1) FOR bookStates
go

create table customerInfo(
	customerId int identity primary key,
	customerName varchar(20) not null,
	pwd varchar(20)not null,
	email varchar(20) not null
	
)
go

create table customerDetailInfo(
	customerId int not null,
	tel varchar(13),
	address varchar(20),
	sex varchar(10),
	age int,
	qq int
	
)
alter table customerDetailInfo
	add constraint FK_customerId 
	foreign key(customerId) references customerInfo(customerId)

go

--������
create table bookDiscuss(
	disId int identity primary key , 
	bookId int not null,
	customerId int not null ,
	context varchar(50) not null, 
	states int not null       --����״̬����˺�ſɼ�
)
alter table bookDiscuss
add constraint FK_bookDiscuss_bookId
    FOREIGN KEY(bookId) REFERENCES bookInfo(bookId)
alter table bookDiscuss
add constraint FK_bookDiscuss_customerId
    FOREIGN KEY(customerId) REFERENCES customerInfo(customerId)
--����
go
create table bookStock(
	stockId  int identity primary key ,
	bookId   int not null ,
	bookCount    int ,
	minNum   int not null 
)
alter table bookStock
add constraint FK_bookStock_bookId
    FOREIGN KEY(bookId) REFERENCES bookInfo(bookId)
go

--����Ա��
create table sysadmin
(
	id int identity primary key ,
	adminName varchar(20) not null ,
	pwd varchar(20) , 
	type int not null          --����Ա����
)
go

--�ղؼб�
create table favorite
(
	favoriteId int identity primary key ,
	bookId int not null,
	customerId int not null ,
	date datetime not null,
	context varchar(50) 
)
go
alter table favorite
add constraint FK_favorite_bookId
    FOREIGN KEY(bookId) REFERENCES bookInfo(bookId)
alter table favorite
add constraint FK_favorite_customerId
    FOREIGN KEY(customerId) REFERENCES customerInfo(customerId)

insert into booktype(parentId, bookTypeName, context) values(0,'С˵','С˵')
insert into booktype(parentId, bookTypeName, context) values(1,'�й�С˵','�й�С˵')
insert into booktype(parentId, bookTypeName, context) values(1,'���С˵','���С˵')
insert into booktype(parentId, bookTypeName, context) values(2,'����С˵','����С˵')
insert into booktype(parentId, bookTypeName, context) values(2,'�ƻ�С˵','�ƻ�С˵')
insert into booktype(parentId, bookTypeName, context) values(2,'ССС˵','ССС˵')
insert into booktype(parentId, bookTypeName, context) values(0,'�Ƽ�','�Ƽ�')
insert into booktype(parentId, bookTypeName, context) values(7,'�����','�����')
	


insert into bookInfo(bookName,booktypeId,pbName,author,context,smallImg,bigImg,price,pbdate,ygcprice)
values('��������ʦѧjava',8,'�ƹ���������','������ʦ','����',default,default,50,'2011/1/1',30)
insert into bookInfo(bookName,booktypeId,pbName,author,context,smallImg,bigImg,price,pbdate,ygcprice)
values('��������ʦѧjava',8,'�ƹ���������','������ʦ','����',default,default,50,'2011/1/1',30)
insert into bookInfo(bookName,booktypeId,pbName,author,context,smallImg,bigImg,price,pbdate,ygcprice)
values('��������ʦѧjava',8,'�ƹ���������','������ʦ','����',default,default,50,'2011/1/1',30)
insert into bookInfo(bookName,booktypeId,pbName,author,context,smallImg,bigImg,price,pbdate,ygcprice)
values('��������ʦѧjava',8,'�ƹ���������','������ʦ','����',default,default,50,'2011/1/1',30)

insert into customerInfo(customerName,pwd,email)
	values('key','123','key@126.com')
insert into customerInfo(customerName,pwd,email)
	values('key2','123','key@126.com')
insert into customerInfo(customerName,pwd,email)
	values('key3','123','key@126.com')

insert into customerDetailInfo(customerId,tel,address,sex,age,qq)
	values(1,'564565','δ����','��',12,3456)
insert into customerDetailInfo(customerId,tel,address,sex,age,qq)
	values(2,'564565','δ����','��',3,5656)
insert into customerDetailInfo(customerId,tel,address,sex,age,qq)
	values(3,'564565','δ����','��',22,5456)

insert into bookDiscuss(bookId,customerId,context,states)
	values(1,1,'safas',1)
insert into bookDiscuss(bookId,customerId,context,states)
	values(2,1,'safas',1)	
insert into bookDiscuss(bookId,customerId,context,states)
	values(3,1,'safas',1)

insert into bookStock(bookId,bookCount,minNum)
	values(1,20,10)
insert into bookStock(bookId,bookCount,minNum)
	values(2,20,10)
insert into bookStock(bookId,bookCount,minNum)
	values(3,20,10)



update bookStock
	set bookId=2,bookCount=30,minNum=40
	where stockId=2
--update customerDetailInfo
--	set tel='sf',address='fas',sex='nv',age=123,qq=3213
--	where customerId=1
--update customerDetailInfo
--	set tel='sf',address='fas',sex='nv',age=123,qq=3213
--	where customerId=2
--update customerDetailInfo
--	set tel='sf',address='fas',sex='nv',age=123,qq=3213
--	where customerId=3

--update bookDiscuss
--	set bookId=2,customerId=2,context='sadf',states=2
--	where disId=1

select * from booktype
select * from bookinfo
select * from customerInfo
select * from bookDiscuss
select customerId,tel,address,sex,age,qq from customerDetailInfo

--delete booktype where booktypeId=1

--select customerId,customerName,pwd ,email from customerInfo��
--select bookTypeId,parentId,bookTypeName,isDelete,context from bookType where bookTypeId=8

--update bookType set isDelete=2 where bookTypeId=9
--delete bookType where bookTypeId=9
--update userInfo set
--bookId,bookName,booktypeId,pbName,author,context,smallImg,bigImg,price,pbdate,bookStates,ygcprice
--select userId,userName,pwd,userType,email,accMoney,address,tel from userInfo where userId=2 