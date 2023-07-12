Table of Contents

- [Select](#select)
  - [Distinct](#distinct)
- [Dates](#dates)
  - [Converting String to Date](#converting-string-to-date)
  - [Formatting Date](#formatting-date)
- [Functions](#functions)
  - [LENGTH Functions](#length-functions)
- [Miscellaneous Operations](#miscellaneous-operations)
  - [Using Update Statement and CASE statement](#using-update-statement-and-case-statement)
- [Miscellaneous](#miscellaneous)
  - [Pivot](#pivot)
  - [LISTAGG](#listagg)

# Select

## Distinct

https://www.oracletutorial.com/oracle-basics/oracle-select-distinct/

```sql
Truncate table DailySales;

-- Add Data
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '1', '0');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'toyota', '0', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'toyota', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'honda', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'honda', '2', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '2', '1');

-- Query Data
SELECT
    DISTINCT(TO_CHAR(date_id,'yyyy-mm-dd')) as "modified_distinct_date"
FROM
	DailySales
;
```

# Dates

## Converting String to Date

To do this, we have two methods

- `TO_DATE(<date_string>,<format_of_date_string>)` function : Reference : https://www.oracletutorial.com/oracle-date-functions/oracle-to_date/
- `DATE` : The format of date which should be provided is **yyyy-mm-dd**

```sql
-- Create Table
CREATE TABLE lmao(
    date_id DATE
);

-- Insert values
INSERT INTO lmao VALUES (DATE '2020-10-05') ;
INSERT INTO lmao VALUES (DATE '2021-10-25') ;
INSERT INTO lmao VALUES (DATE '2020-12-15') ;
INSERT INTO lmao VALUES (DATE '2023-10-27') ;

-- Query
SELECT
    *
FROM
	lmao;
```

## Formatting Date

To format Date, we use `TO_DATE()` function. The syntax to format date is
`TO_CHAR(<date>,<format_string>)`

The format specifiers for changing format of date can be accessed from [here](https://www.techonthenet.com/oracle/functions/to_date.php).

For example

```sql
-- Creating Table
Create Table DailySales
(
    date_id date,
    make_name varchar(20),
    lead_id int,
    partner_id int
);

Truncate table DailySales;

-- Add Data
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '1', '0');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'toyota', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'toyota', '0', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'toyota', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'honda', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-8', 'honda', '2', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '0', '1');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '1', '2');
insert into DailySales (date_id, make_name, lead_id, partner_id) values (DATE '2020-12-7', 'honda', '2', '1');

-- Query Data
SELECT
    DISTINCT(TO_CHAR(date_id,'yyyy-mm-dd')) as "modified_distinct_date"
FROM
	DailySales
;
```

# Functions

## LENGTH Functions

Inspired from this leetcode question https://leetcode.com/problems/invalid-tweets/description/ and https://stackoverflow.com/questions/1734334/mysql-length-vs-char-length?rq=1 , I shall discuss LENGTH() function in detail

The stackoverflow post and leetcode solution are in MySQL but in this, I will be discussing from the point of view of Oracle SQL

- [`LENGTH()`](https://docs.oracle.com/en/database/oracle/oracle-database/19/sqlrf/LENGTH.html#GUID-8F97F652-5AE8-4457-AFD7-7A6F25551E0C) : It measures length in terms of number of characters. It is equivalent to `CHAR_LENGTH()` of MySQL
- [`LENGTHB()`](https://docs.oracle.com/en/database/oracle/oracle-database/19/sqlrf/LENGTH.html#GUID-8F97F652-5AE8-4457-AFD7-7A6F25551E0C) : It measures length in terms of number of bytes. It is equivalent to `LENGTH()` of MySQL

As quoted in the stackoverflow answer

> This is especially relevant for Unicode, in which most characters are encoded in two bytes. Or UTF-8, where the number of bytes varies. For example:

```sql
select length(_utf8 '€'), char_length(_utf8 '€')
-- Output = 3, 1
```

As you can see the Euro sign occupies 3 bytes (it's encoded as 0xE282AC in UTF-8) even though it's only one character.

# Miscellaneous Operations

## Using Update Statement and CASE statement

```sql
Create table Salary (id int, name varchar(100), sex char(1), salary int);
Truncate table Salary;
insert into Salary (id, name, sex, salary) values ('1', 'A', 'm', '2500');
insert into Salary (id, name, sex, salary) values ('2', 'B', 'f', '1500');
insert into Salary (id, name, sex, salary) values ('3', 'C', 'm', '5500');
insert into Salary (id, name, sex, salary) values ('4', 'D', 'f', '500');

-- Write an SQL query to swap all 'f' and 'm' values (i.e., change all 'f' values to 'm' and vice versa) with a single update statement and no intermediate temporary tables. Note that you must write a single update statement, do not write any select statement for this problem.

UPDATE Salary
    SET sex = CASE
        WHEN sex = 'm' THEN 'f'
        ELSE 'm'
    END
;
```

# Miscellaneous

## Pivot

- Video Tutorial : https://www.youtube.com/watch?v=smCBBgN8nEE
- Question to practice on : https://leetcode.com/problems/reformat-department-table/description/

```sql
DROP TABLE myTable;

CREATE TABLE myTable (
  name varchar2(255) default NULL,
  email varchar2(255) default NULL,
  country varchar2(100) default NULL,
  joindate varchar2(255)
);

INSERT INTO myTable (name,email,country,joindate)
VALUES ('Alisa Wilson','a@aol.ca','Colombia','12-04-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Reese Boyer','quis.pede@yahoo.edu','Indonesia','21-04-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Vladimir Thornton','amet.nulla@icloud.net','Vietnam','06-09-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Xanthus Webster','orci.donec.nibh@aol.com','Costa Rica','27-12-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Thor Santana','et.euismod@icloud.ca','Russian Federation','25-06-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Sylvia Tucker','id.enim@aol.com','Peru','30-12-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Ronan Mclean','lobortis.quam.a@aol.edu','Ukraine','27-10-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Colby Lindsey','arcu.eu@aol.net','Philippines','03-04-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Tate Ortiz','luctus.vulputate.nisi@yahoo.ca','Italy','08-03-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Susan Blair','non@hotmail.net','Spain','14-04-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Gage Brock','donec.egestas@protonmail.edu','India','28-11-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('India Roy','rutrum.lorem@outlook.couk','Germany','12-06-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Stone Strong','taciti.sociosqu@aol.edu','Peru','14-07-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Jorden Knapp','sed.tortor@protonmail.org','Singapore','11-10-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Yvette Harding','lorem@google.net','South Korea','28-05-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Hu Stevenson','erat.volutpat@yahoo.net','United States','18-09-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Samantha Rios','risus.in@outlook.ca','Ireland','05-06-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Kevin Berger','proin.sed@yahoo.com','Canada','24-10-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Hedley Hernandez','odio.auctor@icloud.org','Peru','29-12-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Kevin Rosa','ipsum@outlook.com','United Kingdom','06-03-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Walter Frederick','blandit@hotmail.ca','Ireland','09-01-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Carl Murray','aliquam.vulputate@google.ca','Sweden','30-01-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Blake Pittman','pellentesque.ut@hotmail.com','Norway','01-11-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Cara Henry','pede.suspendisse.dui@hotmail.net','Vietnam','05-05-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Fulton Griffin','dolor.nonummy.ac@google.org','France','12-04-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Deanna Hughes','libero.mauris.aliquam@google.couk','Vietnam','20-04-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Ezra Hampton','malesuada.fames.ac@aol.edu','Australia','26-11-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Timothy Mack','suspendisse.dui@icloud.edu','Mexico','13-10-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Norman Johnson','semper.egestas@yahoo.ca','Chile','19-02-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Branden Cardenas','libero.morbi@outlook.edu','Chile','02-12-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Lynn Mueller','malesuada.vel@outlook.edu','Philippines','27-03-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Marshall Michael','phasellus.vitae@aol.ca','Brazil','02-01-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Madeline Navarro','mollis@yahoo.net','Russian Federation','11-05-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Yvette Bradshaw','vulputate.risus.a@protonmail.org','Philippines','12-04-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Tad Whitfield','dignissim.tempor@outlook.ca','Pakistan','02-12-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Jackson Branch','vestibulum@hotmail.ca','United States','05-10-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Colby Mack','lobortis.class@icloud.com','Germany','24-01-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Drake Chapman','imperdiet@icloud.net','Costa Rica','01-10-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Anne Holman','habitant@google.ca','Austria','28-11-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Jonas Frederick','tempor@google.com','Belgium','29-06-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Kirsten Harris','nonummy.ut.molestie@hotmail.net','Mexico','18-06-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Montana Kennedy','leo@icloud.ca','Poland','27-01-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Brett Dodson','mauris@hotmail.net','Philippines','28-05-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Uriah Stanley','augue@google.com','South Africa','02-09-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Vladimir French','pede.cum.sociis@google.edu','India','02-01-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Teagan Ballard','vel.lectus.cum@protonmail.couk','India','09-09-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Deirdre Stout','lorem@google.couk','Spain','13-03-24');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Beck Walters','at.velit@aol.couk','Austria','17-08-23');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Hayfa Leonard','nec.tellus.nunc@icloud.couk','Poland','18-12-22');
INSERT INTO myTable (name,email,country,joindate)
VALUES ('Brenda Fields','metus.in@yahoo.com','South Africa','24-04-23');

SELECT TO_CHAR(TO_DATE(joinDate,'dd-mm-yy'),'Mon') FROM MyTable;

SELECT * FROM(
    SELECT
        T.*,
        TO_CHAR(TO_DATE(joinDate,'dd-mm-yy'),'Mon') actual_month
    FROM
        MyTable T
)
PIVOT(
    COUNT(country)
    FOR actual_month IN (
        'Jan','Feb',
        'Mar','Apr',
        'May','Jun',
        'Jul','Aug',
        'Sep','Oct',
        'Nov','Dec'
    )
)
;
```

## LISTAGG

- Tutorial : https://youtu.be/XmkQLqxSLgQ
- Question to practice : https://leetcode.com/problems/group-sold-products-by-the-date/description/
