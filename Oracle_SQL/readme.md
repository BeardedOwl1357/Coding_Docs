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
