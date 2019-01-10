---
title: Lab 2
shortdescription: "Using collections and arrays."
due: 3
tasks:
  - points: 3
    shortdescription: "Block world"
  - points: 3
    shortdescription: "Infinite Block world"
  - points: 14
    shortdescription: "Ant Simulator"
---

## {{ page.tasks[0].shortdescription }}

{% katexmm %}
In this task you are implementing a class `BlockWorld` in package `lecture.lab2` that simulates a blockworld. The blockworld is an $n \times n$ grid two-dimensional grid whose cells can either be colored black or white.
$n$ is a parameter that can be set when a blockworld is created. Initially, when a block world is created all cells are black. The `BlockWorld` class should have two constructors. One that takes parameter $n$ and a second one that takes no parameters and creates a grid with $n=10$. The block world should provide methods for changing the color at a certain position and to get the color at a certain position which have the following signatures. Assume that the color of a cell is represented as a `boolean` value where `true` means white and `false` means black.
{% endkatexmm %}

~~~java
public boolean getCellColor(int x, int y);
public void setCellColor(int x, int y, boolean setWhite)
~~~

The class should override the `toString` method to return the current state of the grid where each row of the grid should be printed on a separate line while each cell whould be encoded as a single character:

* `" "` (a space) if the cell is white
* `"X"` (an X if the cell is black

For example, a 3 x 3 grid where only the top-left and the bottom-right cells are white should be represented as:

~~~shell
 XX
XXX
XX
~~~

Test your block world by adding a main method which creates the above example 3-by-3 grid and prints the state:

```java
BlockWorld n = new BlockWorld(3);
n.setCellColor(0,0,true); // set top-left cell
n.setCellColor(2,2,true); // set bottom-right cell
System.out.println(n.toString());
```


## {{ page.tasks[1].shortdescription }}

In this task you are implementing a class `InfiniteBlockWorld` in package `lecture.lab2` that is a subclass of `BlockWorld`. The difference is that as the name suggests an `InfiniteBlockWorld` is an infinite grid. We make the assumption that only finitely many cells in this grid are colored white. Obviously, you cannot store an infinite grid directly. However, given the assumption it is sufficient to only record which cells are colored white. The class should provide the same type of `toString` representation as the `BlockWorld` above. Since you cannot print an infinite grid, you should only print the minimal sized grid that contains all white cells. Note that the infinite grid should span between negative infinitity and positive infinitity in both directions. That is the get and set methods for cells should also allow negative integers as `x` and `y` coordinates.

Test your infinite block world by adding a main method which creates the above example 3-by-3 grid:

```java
BlockWorld n = new BlockWorld(3);
n.setCellColor(-1,-1,true); // set cell at [-1,-1]
n.setCellColor(1,1,true); // set cell at [1,1]
System.out.println(n.toString());
```

The expected result is:

~~~shell
 XX
XXX
XX
~~~




## {{ page.tasks[2].shortdescription }}

{% katexmm %}
In this task you are implementing a class `BlockWorld` in package `lecture.lab2` that simulates a blockworld. The blockworld is an $n \times n$ grid two-dimensional grid whose cells can either be colored black or white.
$n$ is a parameter that can be set when a blockworld is created. Initially, when a block world is created all cells are black. The block world
{% endkatexmm %}
