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
