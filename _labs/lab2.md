---
title: Lab 2
shortdescription: "Advanced Object-Oriented Concepts."
due: 3
tasks:
  - points: 5
    shortdescription: "Design an interface"
  - points: 12
    shortdescription: "Implement an inheritance hierarchy"
  - points: 3
    shortdescription: "Use anonymous classes"
---

In this assignment we develop a class that stores text documents and classes that implement operations on such text data. For that first design a class `TextDoc` which store a text document which is essentially a `String`. The constructor of `TextDoc` should take a `String` with the documents text:

~~~java
public TextDoc(String content);
~~~

The class should also implement a method `getContent` which returns the content of the document as a `String`.


## {{ page.tasks[0].shortdescription }}

We want to implement multiple text manipulation operations that work on text stored using our `TextDoc` class. We want to be able to apply any sequence of operations to a `TextDoc` object using **method chaining** (explained below). For that you should

* design an interface `TextOp` to be implemented by any text mainpulation operation which has a single method `apply` which takes a document as an input and returns the result of applying the operation to the document.
```java
public TextDoc apply(TextDoc input)
```
* extend the `TextDoc` class with a method `transform` which takes a `TextOp` as input, applies it to the object, and returns the modified document
```java
public TextDoc transform(TextOp operator)
```

By letting `transform` return a `TextDoc` we can chain several operations together without the need to use temporary variables to store the result of each operation. This is called **method chaining**. Say we have three references `o1`, `o2`, and `o3` to instances from classes that implements `TextOp` that we want to apply to an input document `doc`. Compare the two code examples below which  implement this requirement with and without method chaining.

```java
// with method chaining
TextDoc finalResult = doc.transform(o1).transform(o2).transform(o3);

// without method chaining
TextDoc result = doc.transform(o1);
result = result.transform(o2);
result = result.transform(o3);
```

## {{ page.tasks[1].shortdescription }}

Given our shiny new interface `TextOp`, you should implement several text operations.

>Some of these operations require overlapping functionality. In this case you should use inheritance to avoid repeated code!
{: notice--danger }

* **UpperCase** - turns the whole text into upper case
* **ExtractFirstReturn** - returns the first word of the text
* **ExtractNthWord** - return the nth word of the text. Parameter `n` should be given to the constructor of `ExtractNthWord`
* **ReplaceFirst** - replaces the first occurrence of `search` with `replace`. `search` and `replace` should be passed as parameters to the constructor of `ReplaceFirst`
* **ReplaceAll** - replace all occurrences of `search` with `replace`
* **Palindrom** - turns a word into a palindrome which is a string which does not change when it is reversed. You should achieve this by reversing the sequence of characters in the document and appending it to the end. For instance, `abc` the operator returns `abccba`.

Write a class with a  `main` method that tests these operators. It is up to you to come up with reasonable test cases.

## {{ page.tasks[2].shortdescription }}

Our `TextOp` transformations lend themselves to the use of anonmous class. Consider the case where we want to define one-off transformations. It would be excessive to create class files for such operations.
In this task we write a class `AnonTest` which has a `main` method that creates sample text document (any text you like), prints the content of this text document, and then applies a `TextOp` that is defined using an anonymous class.
The `TextOp` should remove delete the first 3 characters of the input document.
