use assignment;
create table information(
Member_Id Integer,
Member_Name Varchar(30),
Member_address Varchar(50),
Acc_Open_Date Date,
Membership_type Varchar(20),
Fees_paid Integer,
Max_Books_Allowed Integer,
Penalty_Amount Decimal(7,2)
);
desc information;

-- Books table
create table Books(
Book_No Integer,
Book_Name VarChar(30),
Author_name varchar(30),
Cost decimal(7,2),
Category char(10)
);
desc Books;

-- issue books table
create table issue_books(
Lib_issue_id int,
Book_no int,
Member_Id int,
issue_date date,
return_date date
);
desc issue_books;

-- question 2
desc information;
desc Books;
desc issue_books;

-- question 3
drop table information;

-- question 4
create table Member(
Lib_issue_id int,Integer primary key,
Member_Name Varchar(30),
Member_address Varchar(50),
Acc_Open_Date Date,
Membership_type Varchar(20) check (Membership_type in('Lifetime',' Annual', 'Half Yearly','Quarterly')),
Fees_paid Integer,
Max_Books_Allowed Integer,
Penalty_Amount Decimal(7,2)
);
desc Member;

-- question 5
alter table Member modify Member_Name Varchar(40);

-- question 6
alter table issue_books add Book_name varchar(30);

-- question 7

-- question 8
rename table issue_books to lib_issue;
desc lib_issue;

-- question 9
insert into Member(Member_id,Member_Name,Member_address,Acc_Open_Date,Membership_type,Fees_paid,Max_Books_Allowed,Penalty_Amount) values
                  (1,'Richa Sharma', 'Pune', '10-12-05', 'Lifetime', 25000, 5, 50),
                  (2,'Garima Sen', 'Pune', curdate(), ' Annual', 1000, 3, null);

select * from Member;

-- question 10
insert into Member(Member_id,Member_Name,Member_address,Acc_Open_Date,Membership_type,Fees_paid,Max_Books_Allowed,Penalty_Amount) values
                  (3,'pragya verma','indore', curdate(), 'Half Yearly', 9000, 4, 60),
                  (4,'hiteshi', 'indore', '10-12-05', 'Quarterly', 4000, 5, 40),
                  (5,'harshu', 'mumbai', '10-12-05', 'Quarterly', 44000, 7, 30),
                  (6,'Richa Sharma', 'Pune', '10-12-05', 'Lifetime', 25000, 5, 50),
                  (7,'Garima Sen', 'Pune', curdate(), ' Annual', 1000, 3, null);
                  
   -- question 11
alter table Member modify Member_Name varchar(20);

  -- question 12
  
-- question 13
CREATE TABLE Member101 AS SELECT *FROM Member;
desc Member101;

-- question 14
alter table Books add constraint chk_max_book check(Max_Books_Allowed < 100);

-- question 15
drop table Books;

-- question 16
create table Books(
Book_No Integer primary key,
Book_Name VarChar(30) not null,
Author_name varchar(30),
Cost decimal(7,2),
Category varchar(10) check(Category in('System','Fiction','Database','RDBMS','Others'))
);
desc Books;

-- question 17
insert into Books(Book_No,Book_Name, Author_name, Cost,Category) values
                (101,'Let us C','Denis Ritchie',450 ,'System'),
                (102,'Oracle–Complete Ref','Loni',550 ,'Database'),
				(103,'Mastering SQL','Loni',250 ,'Database'),
                (104,'PL SQL-Ref','Scott Urman',750 ,'Database');
                
select* from Books;
   
-- question 18
insert into Books(Book_No,Book_Name, Author_name, Cost,Category) values
                (105, 'Database System Concepts', 'Korth', 600, 'Database'),
(106, 'RDBMS Essentials', 'Date C.J.', 700, 'RDBMS'),
(107, 'Fictional Reality', 'John Smith', 300, 'Fiction'),
(108, 'Operating System Concepts', 'Silberschatz', 800, 'System'),
(109, 'Learning Java', 'Herbert Schildt', 500, 'Others');

-- question 19
select* from Books;

-- question 20
insert into Books(Book_No,Book_Name, Author_name, Cost,Category) values
     (110, 'National Geographic', 'Adis Scott', 1000, 'scienc');

-- question 21
rename table lib_issue to issue;

-- question 22
drop table issue;

-- question 23
create table issue(
 Lib_issue_id int primary key,
 Book_No int,
 Member_Id int,
 issue_date date,
 return_date date,
 
 constraint fk_book foreign key(Book_no) references Books(Book_no),
constraint fk_member foreign key(Member_Id) references Member(Member_Id)
);
desc issue;

-- question 24
insert into issue(Lib_issue_id,Book_No, Member_Id,issue_date) values
   (7001, 101, 1,'2006-12-10'),
   (7002, 102, 4,'2006-12-25'),
   (7003, 104, 1,'2006-12-15'),
   (7004, 101, 1,'2006-12-04'),
   (7005, 104, 2,'2006-12-15'),
   (7006, 101, 3,'2006-12-18');
   
select * from issue;

-- question 25
alter table issue
drop primary key,
drop foreign key fk_book,
drop foreign key fk_member;

   
   
   
   