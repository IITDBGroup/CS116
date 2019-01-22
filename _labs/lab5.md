---
title: Lab 5
shortdescription: "Debugging, Testing, and Logging"
due: 7
tasks:
  - points: 6
    shortdescription: "Debug a class"
  - points: 8
    shortdescription: "Add logging to classes"
  - points: 8
    shortdescription: "Writing unit testcases"
---

## {{ page.tasks[0].shortdescription }}

In this task we will debug an error in a provided class using either `jdb` (see [here]({{ site.baseurl }}/lectures/java_tools.html)), the debugger in `Eclipse`, or any other Java debugger.
We have uploaded a java file `` to your git repository.

Your task is to use a debugger to determine the cause of the errors and fix them.


## {{ page.tasks[1].shortdescription }}

In this task you will adding logging facilities to classes produced in previous assignments. Enhance the following classes:

* `lecture.lab4.DataFrame`
* `lecture.lab4.CSVFileReader`
* `lecture.lab4.TestDataFrameCSV`

## {{ page.tasks[2].shortdescription }}

In this task you will apply unit testing with **JUnit**. Create a class `lecture.lab5.TestDataFrame` with several unit tests for `lecture.lab4.DataFrame`. It is up to you to come up with meaningful test cases. Here are a few examples of what you may want to test:

* after appending `n` rows, `getNumRows` should return `n`
* adding a row with to many or not enough columns results in an exception being thrown by `appendRow`
* `getColumnName(getColumnPos(name)) == name`
