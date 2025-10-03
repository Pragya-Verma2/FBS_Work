-- 1) List all the books written by Author Loni and with price less than 600.
-- SQL:
    use assignment;
   select * from books where author_name='loni' and cost<600;
   
-- 2) List the Issue details for the books that are not returned yet.
-- SQL:
    select * from issue where return_date is null ;
    
-- 3) Update all blank return_date with 31-Dec-06 excluding book IDs 7005 and 7006.
-- SQL:
  update issue set return_date='2006-12-31' where book_no not in(7005,7006);
  select * from issue;
-- 4) List all the Issue details that have books issued for more than 30 days.
-- SQL:
    select * from issue where datediff(curdate(),issue_date)>30 ;
    
-- 5) List all the books with price in range 500 to 750 and category as Database.
-- SQL:
select * from books where cost between 500 and 750 and categories='database';

-- 6) List all the books that belong to categories: Science, Database, Fiction, Management.
-- SQL:
   select * from books where category in('Science', 'Database', 'Fiction', 'Management');
   
-- 7) List all members in descending order of penalty due.
-- SQL:
  select * from member order by penalty_amount desc;
  
-- 8) Modify the price of book with ID 103 to Rs 300 and category to RDBMS.
-- SQL:
  update  books set cost=300,category='rdbms' where book_no=103;
  
-- 9) List all books in ascending order of category and descending order of price.
-- SQL:
select * from books order by category asc ,cost desc;
-- 10) List all books that contain the word SQL in the book name.
-- SQL:
select * from books where book_name like'%sql%';
-- 11) List Lib_Issue_Id, Issue_Date, Return_Date, and number of days the book was issued.
-- SQL:
select Lib_Issue_Id, Issue_Date, Return_Date,datediff(return_date,issue_date) as day_issued from issue;

-- 12) Find the details of members in the order of their joining the library.
-- SQL:
select * from member order by join_date;

-- 13) Display the count of total number of books issued to Member 101.
-- SQL:
  select count(*) from issue where member_id=101;
  select * from member;
  
-- 14) Display the total penalty due for all members.
-- SQL:
select sum(penalty_amount) from member;

-- 15) Display the total number of members.
-- SQL:
select count(member_id) from member;

-- 16) Display the total number of books issued.
-- SQL:
select count(*) from issue;

-- 17) Display the average membership fees paid by all members.
-- SQL:
 select avg(fees_paid) from member;
 
-- 18) List various categories and count of books in each category.
-- SQL:
 select count(*) from books group by category;
 
-- 19) List Book_No and number of times each book is issued in descending order.
-- SQL:
select book_no,count(*) from issue group by book_no order by count(*) desc;

-- 20) Find maximum, minimum, total, and average penalty amount in member table.
-- SQL:
select max(penalty_amount),min(penalty_amount),sum(penalty_amount),avg(penalty_amount) from member;

-- 21) Display Member ID and number of books for members who issued more than 2 books.
-- SQL:
select member_id ,count(*) from issue group by member_id having count(*)>2;

-- 22) Display Member ID, Book No, and number of times the same book is issued in descending order.
-- SQL:
 select member_id,book_no, count(*) from issue group by member_id,book_no order by count(*) desc;
 
-- 23) Display month and number of books issued each month in descending order.
-- SQL:
select month(issue_date) ,count(*) from issue group by  month(issue_date) order by count(*);

-- 24) List Book_No of books not issued to any member so far.
-- SQL:
select book_no from books where book_no not in (select distinct book_no from issue);
select * from issue;
select * from books;

-- 25) List Member IDs that exist and have issued at least one book.
-- SQL:
 select distinct  member_id from issue; 
 
-- 26) List Member ID with highest and lowest number of books issued.
-- SQL:
select member_id ,count(*) from issue group by member_id order by count(*) desc limit 1;

-- 27) List all Issue_details for books issued in December and July without using arithmetic, logical, or comparison operators.
-- SQL:
select * from issue where month(issue_date) in (7,12);

-- 28) List Book_No, Book_Name, and Issue_Date for books issued in December and belong to category Database.
-- SQL:
select Book_No, Book_Name,Issue_Date from books where month(issue_date) in (12) and category= 'Database';

-- 29) List Member ID, Member Name, and max books allowed in descending order of max books allowed.
-- SQL:
select  Member_ID, Member_Name, max_books_allowed from member order by max_books_allowed desc;
select * from member;

-- 30) List Book No, Book Name, Issue_Date, and Return_Date for books issued by Richa Sharma.
-- SQL:
select Book_No, Book_Name, Issue_Date,Return_Date from issue ;

-- 31) List details of all members who have issued books in Database category.
-- SQL:
select * from issue where book_name='Database';

-- 32) List all books that have highest price in their own category.
-- SQL:


-- 33) List all Issue_Details where Issue_Date is not within Acc_open_date and Return_Date for that member.
-- SQL:

-- 34) List all members who have not issued a single book so far.
-- SQL:
select * from member where member_id not in (select distinct member_id from issue); 
select * from issue;

-- 35) List all members who have issued the same book as issued by Garima.
-- SQL:

-- 36) List Book_Name and Price of books not returned for more than 30 days.
-- SQL:
select Book_Name, Price from books where return_id<30;
-- 37) List all authors and book_name for authors who have written more than 1 book.
-- SQL:
select authors_name,book_name from books where authors_name in(select authors_name from books group by authors_name having count(*)>1);

-- 38) List Member ID and Member Name of people with highest and lowest number of books issued.
-- SQL:
 
-- 39) List details of the top 3 highest-priced books.
-- SQL:
select * from books order by cost desc limit 3;

-- 40) List total cost of all books currently issued but not returned.
-- SQL:
select sum(cost) from books where book_no in(select book_no from issue where return_date is null);

-- 41) List details of the book issued the maximum number of times.
-- SQL:

-- 42) List how many books are issued to lifetime members.
-- SQL:

-- 43) List all member types and count of members in each type.
-- SQL:

-- 44) List first 5 members who joined the library.
-- SQL:

-- 45) List members with their member type who issued books between 1st December and 31st December.
-- SQL:

-- 46) List all members who have not returned books yet.
-- SQL:

-- 47) List all members who joined the library on the same date as Garima.
-- SQL:

-- 48) List members who issued books from author “Loni” in December.
-- SQL:
 select ;
-- 49) List names of authors whose books are least issued by lifetime members.
-- SQL:
Select count(i.book_no),0	25	00:15:43	select 
 -- 49) List names of authors whose books are least issued by lifetime members.
 -- SQL:
 Select * from member m
  inner join issue i  join books b
  on m.member_id=i.member_id where Membership_type="lifetime"	Error Code: 1064. You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'Select * from member m
  inner join issue i  join books b
  on m.member_id=i.membe' at line 4	0.000 sec from member m
 inner join issue i inner join books b
 on m.member_id=i.member_id where Membership_type="lifetime";

-- 50) List members who issued books costing more than 300 rupees and authored by “Scott Urman”.
-- SQL:

-- 51) List lifetime members who joined between 1st Jan 2006 and 31st Dec 2006 and issued only one book.
-- SQL:

-- 52) Modify Penalty_Amount for Garima Sen to Rs 100.
-- SQL: