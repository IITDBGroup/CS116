---
title: Lab 4
shortdescription: "Exception handling and I/O"
due: 6
tasks:
  - points: 4
    shortdescription: "Extend some of the classes developed in previous assignments to handle exceptional conditions."
  - points: 16
    shortdescription: "Implement a class using file I/O."
---

## {{ page.tasks[0].shortdescription }}

In this task we will revisit some of the classes developed in previous assignments. Your task is to identify exceptional conditions and implement code that deals with these conditions or throws exceptions for conditions that cannot be dealt with in the class itself. Copy the following classes to the package `lecture.lab4`.

* `lecture.lab1.BankAccount`
* `lecture.lab3.BlockWorld` and `lecture.lab3.Ant`

> Add a text file `explanations.txt` into folder `lecture/lab4` in which you explain the exceptional conditions you have identified and how you address them
{: .notice--info }

## {{ page.tasks[1].shortdescription }}

In this class you will implement classes `DataFrame` and `CSVFileAccess` in package `lecture.lab4`.
Class `DataFrame` stores tabular data. `CSVFileAccess` reads such tabular data from a file and can write the data of a table stored in a `DataFrame` to disk using the CSV file format (explained below).


### DataFrame (6 Points)

A table has a list of columns (its schema) and a a sequence of rows (the data). A row has a value of type `String` for each column of the table. The schema of a `DataFrame` should be determined when creating the data frame. That is, you should implement a constructor which takes as input an array of column names:

~~~java
public DataFrame(String[] columnNames);
~~~

Initially, the table stored in a dataframe should be empty. The following methods can be used to access and add data.

* `getNumRows` returns the number of rows in the table

~~~java
public int getNumRows(); // returns the number of rows in the table
~~~

* `getRow` - returns the row at position "pos" or throws an exception if no such row exists.

~~~java
public String[] getRow(int pos) throws Exception;
~~~

* `getCell` - returns the value at cell (a column of a particular row) or throws an exception if no such cell exists.

~~~java
public String getCell(int row, int column) throws Exception;
~~~

* `setCell` - replaces the value at cell (a column of a particular row) with `value` or throws an exception if no such cell exists.

~~~java
public void setCell(int row, int column, String value) throws Exception;
~~~

* `appendRow` add the provided row to the end of the table increasing the number of rows by 1. Throws an exception if `row` does not have the right number of values.

~~~java
public void appendRow(String[] row) throws Exception;
~~~

* `getColumnNames` - returns all column names as a `String[]`.
* `getColumnName` - returns the name of column at position `pos` or throws and exception if no such column exists.
* `getColumnPos` - returns the position of the column `name` named or throws and exception if no such column exists.

~~~java
public String[] getColumnNames();
public String getColumnName(int pos) throws Exception;
public int getColumnPos(String name) throws Exception;
~~~

### CSVFileAccess (10 Points)

The `CSVFileAccess` class should implement two methods:

~~~java
public DataFrame readCSV(File csvFile) throws Exception;
public void writeToCSV(DataFrame f, File csvFile) throws Exception;
~~~

Method `readCSV` reads a table from a CSV file and returns a `DataFrame` storing this table.

> This method needs to deal with both I/O errors (e.g., the file does not exist) and data format errors, e.g., a row does not have the correct number of values.
{: .notice--danger}


Method `writeToCSV` takes a data frame and writes the table is represents to a CSV file.

> This method needs to handle I/O errors. Also if the file already exists an exception should be thrown instead of modifying the file.
{: .notice--danger}

### Test Case

### The CSV File Format

The **CSV** (**C**omma **S**eparated **V**alues) file format is a textual format for storing tabular data. The first line of a CSV file may be a header which lists the names of columns of the table. All the following lines are the data where each line corresponds to a row in the table. Both the column names and column values of a row are separated using comma (`","`), hence the name. For instance, shown below is the content of a CSV file which stores a table with 3 columns (`Name`, `Age`, `Salary`) and three rows. For example, the first row is denotes a person with name `Peter` who is `45` years old and earns `30000`.

~~~shell
Name,Age,Salary
Peter,45,30000
Alice,35,100000
Bob,23,20000
~~~
