-- question 1
use assignment;
create table employee(
employee_id int,
first_name varchar(20),
last_name varchar(20),
email varchar(100) unique,
phone_number  varchar(20),
hire_date date not null,
job_id int,
salary decimal(10,2),
commission_pct decimal(5,2),
manager_id int,
department_id int
);
insert into employee (employee_id,first_name,last_name,email ,phone_number ,hire_date ,job_id ,salary ,commission_pct ,manager_id ,department_id )
values (100, 'steven', 'king', 'sking', '515.123.4567', '1987-06-17', 'ad_pres', 24000.00, 0.00, 200, 10),
(101, 'neena', 'kochhar', 'nkochhar', '515.123.4568', '1987-06-18', 'ad_vp', 17000.00, 0.00, 200, 10),
(102, 'lex', 'de haan', 'ldehaan', '515.123.4569', '1987-06-19', 'ad_vp', 17000.00, 0.00, 200, 10),
(103, 'alexander', 'hunold', 'ahunold', '590.423.4567', '1987-06-20', 'it_prog', 9000.00, 0.00, 103, 60),
(104, 'bruce', 'ernst', 'bernst', '590.423.4568', '1987-06-21', 'it_prog', 6000.00, 0.00, 103, 60),
(105, 'david', 'austin', 'daustin', '590.423.4569', '1987-06-22', 'it_prog', 4800.00, 0.00, 103, 60),
(106, 'valli', 'pataballa', 'vpataballa', '590.423.4560', '1987-06-23', 'it_prog', 4800.00, 0.00, 103, 60),
(107, 'diana', 'lorentz', 'dlorentz', '590.423.5567', '1987-06-24', 'it_prog', 4200.00, 0.00, 114, 30),
(108, 'nancy', 'greenberg', 'ngreenbe', '515.124.4569', '1987-06-25', 'sa_man', 12000.00, 0.00, 145, 80),
(109, 'daniel', 'faviet', 'dfaviet', '515.124.4169', '1987-06-26', 'sa_man', 9000.00, 0.00, 145, 80);

alter table employee modify column job_id varchar(20);
select * from employee;
-- =========================================================
-- question 2
desc department;
INSERT INTO DEPARTMENT (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES
(10, 'Administration', 200, 1700),
(20, 'Marketing', 201, 1800),
(30, 'Purchasing', 114, 1700),
(40, 'Human Resources', 203, 2400),
(50, 'Shipping', 121, 1500),
(60, 'IT', 103, 1400),
(70, 'Public Relations', 204, 2700),
(80, 'Sales', 145, 2500);

select * from department;
-- ====================================================================
-- question 3;
desc jobs;
INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
VALUES
('AD_PRES', 'President', 20000, 40000),
('AD_VP', 'Administration Vice President', 15000, 30000),
('AD_ASST', 'Administration Assistant', 3000, 6000),
('FI_MGR', 'Finance Manager', 8200, 16000),
('FI_ACCOUNT', 'Accountant', 4200, 9000),
('AC_MGR', 'Accounting Manager', 8200, 16000),
('AC_ACCOUNT', 'Public Accountant', 4200, 9000),
('SA_MAN', 'Sales Manager', 10000, 20000);

alter table jobs modify job_id varchar(20);

-- ====================================================================
-- question 4;
update employee set salary=salary*1.10;

-- question 5;
show indexes from employee;
alter table employee drop index email;
desc employee;

update employee set email='not available' 
where department_id=80 and commission_pct<0.2;

-- question 6;
update employee set email='not available'
where department_name='Purchasing';

-- question 7;
UPDATE employee
SET email = 'not available',
    commission_pct = 0.10;