show databases;
create database assignment;
use assignment;
create table country(
country_id int,
country_name varchar(20),
region_id int
);
desc country;

-- question 3

create table job(
job_id int primary key,
job_title text not null,
min_salary float,
max_salary float
);
desc job;
select * from job where (max_salary>25000);

-- question 4
create table job_histry(
employee_id int,
start_date date,
end_date date,
job_id int,
department_id int
);
desc job_histry;

-- question 5
alter table country rename countries;

-- question 6
CREATE TABLE Jobs (
    job_id     INT PRIMARY KEY,
    job_title  VARCHAR(100) DEFAULT '',     -- blank by default
    min_salary DECIMAL(10,2) DEFAULT 8000,  -- default 8000
    max_salary DECIMAL(10,2) DEFAULT NULL   -- default NULL
);
desc Jobs;

-- question 7
create table department(
 department_id decimal(4,0),
 department_name varchar(30),
 manager_id decimal(6,0) ,
 location_id decimal(4,0),
 primary key(department_id,manager_id)
);
desc department;

-- question 8
create table employees0(
employee_id int,
first_name varchar(20),
last_name varchar(20),
email varchar(20) unique,
phone_number long,
hire_date date not null,
job_id int,
salary float,
commission float,
manager_id decimal(4,0),
department_id decimal(6,0),

 CONSTRAINT fk_dept_mgr
        FOREIGN KEY (department_id, manager_id)
        REFERENCES department(department_id, manager_id)
);
desc employees0;
