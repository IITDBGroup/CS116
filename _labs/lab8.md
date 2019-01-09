---
title: Lab 8
shortdescription: "Reflection and Generics"
due: 10
tasks:
  - points: 10
    shortdescription: "Implemented a generic Stringifier using reflection, annotations, and recursion."
  - points: 10
    shortdescription: "Use generics to implement a binary tree that can store any kind of object."
---

## {{ page.tasks[0].shortdescription }}

Writing a `toString` method for data objects can be a highly repetitive task since basically most of the time the only thing this method will do is to iterate over the fields of the class and use an appropriate method to output the values of these fields as strings. We will use reflection to write a generic `Stringifier` class in package `lecture.lab4` which implements a static method

~~~java
public static String stringify(Object o);
~~~

which takes an object of any class and serializes that all fields. For fields of a primitive type you should use the `toString` methods of the corresponding wrapper class , e.g., `Integer` for `int`. For reference types, you need to recurse to use `stringify` to serialize the object. The output format should be as follows:

```shell
{ CLASS@id
  field1: value1
  field2: value2
  ...
  field3: valueN
}
```

Here `CLASS` is the name of the class, `id` is the result of calling `System.idenityHashCode(o)` for an object `o`. A null value should be encoded as `NULL`.
Note that if a field is of a reference type then the value created should be indented by an appropriate amount of tabs corresponding to the recursion depth of `stringify`. For instance, for the list datastructure below implemented using the class `ListCell` shown below you should return (assuming the two list cells have ids `XXXXX` and `YYYYY`):

```shell
{ ListCell@XXXXX
  value: 2
  next:
	{ ListCell@YYYYY
	value: 5
	next: NULL
	}
}
```


```java
class ListCell {
	int value;
	ListCell next;
}
```


{% graphviz %}
digraph {

rankdir=LR;
node [style="rounded,filled", fillcolor="lightcyan1"];

n1 [ label="2" ];
n2 [ label="5" ];

n1 -> n2;

}
{% endgraphviz %}



> Note that some datastructures may be have cicular references, e.g., in a doubly linked list a list cell has a reference to the following and the previous cell (as illustrated below). This would lead to endless recursion unless you keep track of which objects have already been serialized. To solve this problem you need to keep track of every Object that stringify has seen already using an appropriate collection datastructure. Then for each object that should be processed you need to first check whether the object has been processed before already. If so, just output `@id` where `id` is the result of `System.identifyHashCode(o)` for the object instead of recursing.
{: .notice--danger }

{% graphviz %}
digraph {

rankdir=LR;
node [style="rounded,filled", fillcolor="lightcyan1"];

n1 [ label="head" ];
n2 [ label="tail" ];

n1 -> n2;
n2 -> n1;

}
{% endgraphviz %}

Assuming that the two list cells have ids `XXXXX` and `YYYYY` and that the links of the list cells are stored in two fields `next` and `previous` this would produce the following output:

```shell
{ ListCell@XXXXX
  value: 2
  next:
  previous: NULL
	{ ListCell@YYYYY
	value: 5
	next: NULL
	previous: @XXXXX
	}
}
```


Furthermore, implement two annotations `StringifiyIgnore` and `StringifyMethodName`.

* `StringifyIgnore` can be placed on a field. Any field with this annotation should be ignored by `Stringify`
* `StringifyToStringMethod(String methodname)` can be placed on a class. If `Stringify` has to serialize an instance of this class, then it does so by calling `methodname` instead of recursing. `methodname` is expected to have no parameters and return a `String`.



## {{ page.tasks[1].shortdescription }}

In this task you will implement a binary tree datastructure as a class `Tree` in package `lecture.lab8` whose nodes can store elements of any class `E`. Use generics to ensure that a tree to store instances of a class `E` can only be used to store instances of this class. A class `TreeNode` should be used to store a value of type `E` (accessible through a method `getValue()` that returns an object of type `E`) and a `left` and `right` reference to the children of the node. The children should be accessible through `getLeft()` and `getRight()` methods of the class `TreeNode`. The `Tree` class should expose a method `iterator` that returns an `Iterator<E>` (see Java documentation for [Iterator](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Iterator.html)) that traverses all the elements in the tree.

> To iterate over all the elements in the tree use one of the traversal methods discussed in class.
{: .notice--warning}

As a test case write a main method that create the following tree of `Person` objects, searches through the elements of the tree using the `iterator()` method of the `Tree` class and prints every Person whose name starts with a `B`, and finally serializes the tree using the `Stringifier` class implemented in the previous task.

{% digraph %}
node [style="rounded,filled", fillcolor="lightcyan1"];

n1 [ label="Bob" ];
n2 [ label="Alice" ];
n3 [ label="Barbara" ];
n4 [ label="Bert" ];
n5 [ label="Adam" ];
n6 [ label="Peter" ];

n1 -> n2;
n1 -> n3;
n2 -> n4;
n2 -> n5
n3 -> n6;
{% enddigraph %}
