---
title: Lab 3
shortdescription: "Using collections and arrays."
due: 5
tasks:
  - points: 5
    shortdescription: "Block world"
  - points: 5
    shortdescription: "Infinite Block world"
  - points: 10
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

In this task you are implementing a class `InfiniteBlockWorld` in package `lecture.lab2` that is a subclass of `BlockWorld`. The difference is that as the name suggests an `InfiniteBlockWorld` is an infinite grid. We make the assumption that only finitely many cells in this grid are colored white. Obviously, you cannot store an infinite grid directly. However, given the assumption it is sufficient to only record which cells are colored white. The class should provide the same type of `toString` representation as the `BlockWorld` above. Since you cannot print an infinite grid, you should only print the minimal sized grid that contains all white cells. Note that the infinite grid should span between negative infinitity and positive infinitity in both directions. That is the get and set methods for cells should also allow negative integers as `x` and `y` coordinates. The `InfiniteBlockWorld` class should provide this additional method:

```java
public int[] getBounds();
```
{% katexmm %}
This methods returns an array with 4 elements $[ x_{low}, x_{high}, y_{low}, y_{high} ]$ representing a minimal bounding box around the white cells in the blockworld. That is, $x_{low}$ is the lowest x-coordinate (the left-most white cell), $x_{high}$ is the highest x-coordinate (the right-most white cell), $y_{low}$ is the lowest y-coordinate of any  white cell (0 is the first row of the matix!), and $y_{high}$ is the higehst  y-coordinate of any white cell.
{% endkatexmm %}

> Note that the `InfiniteBlockWorld`'s bounding box is a rectangle, but not necessarily a square.
{: .notice--info }


Test your infinite block world by adding a main method which creates the above example 3-by-3 grid:

```java
BlockWorld n = new BlockWorld(3);
n.setCellColor(-1,-1,true); // set cell at [-1,-1]
n.setCellColor(2,1,true); // set cell at [2,1]
System.out.println(n.toString());
```

The expected result is:

~~~shell
 XXX
XXXX
XXX
~~~

## {{ page.tasks[2].shortdescription }}

{% katexmm %}
In this task you are implementing a class `Ant` in package `lecture.lab4` that simulates an ant that moves around in the `InfiniteBlockWorld` and modifies its environment. The behaviour of an ant is controlled using a set of states. In each step of the simulation the ant

* modifies its environment by changing the color of the cell it is sitting on based on the current color of the cell and the state it is in
* then it either moves to the *left*, to the *top*, to the *right*, or to the *bottom* neighbor of the cell it is standing on. The direction is determined based on its current state and the color of the cell it is standing on (before the change).
* furthermore, it changes its state to a new state which again is determined based on the current state and the color observed by the end.

Initially, the ant is in a designed start state (one of its states) and

Formally, an ant can be described as a tuple

$$M = (Q, \Gamma, b, \delta, q_0, F)$$

* $Q$ is the set of states of the ant
* $\Gamma$ is a set of cell colors. In our case $\Gamma = \{0,1\}$ where `0` represents black and `1` represents white
* $b$ is the initial color of every cell before the start of the simulation (`0`) in our case
* $\delta$ is a function with signature $(Q - F) \times \Gamma \to Q \times \Gamma \times \{ L,R,T,B \}$ that is called the transition function. Given a current state of the ant and current color of the cell it standing on as input  the transition function returns the new state, the new color, and a direction to move to:
  * $L$ is left, $R$ is right, $T$ is top, and $B$ is bottom
* $q_0$ is the initial state of the ant at the start of the simulation
* $F$ is a set of *final states*. Whenever the ant reaches one of these states, the simulation stops.

When creating an ant, the states and transition function should be provided to the constructor. Furthermore, the initial state and set of final states should be specified. The `Ant` class should provide the following  methods

* `void step()` that moves the simulation one step forward.
* `String getAntState()` which returns the current state of the ant
* `int[] getAntPosition()` which returns the current `x,y` coordinate of the cell where the ant currently resides
* `InfiniteBlockWorld getWorldState()` which returns the current state of the block world

To test the ant class, write a `main` method which creates the ant described below and iteratively prints the state of the world using the same representation as the one used for `toString` of the `InfiniteBlockWorld` except that the position of the ant is shown as character `A`. The simulation should be progressed by a step if the user inputs any string followed by newline  except for the following strings that have special meanings:

* strings starting with `d` - progress the ant by 10 steps at a time
* strings starting with `h` - progress the ant by 100 steps at a time
* strings starting with `t` - progress the ant by 1000 steps at a time
* strings that are integer numbers - parse the number and progress the ant by this many steps
* strings starting with `q` which stop the program

> To avoid excessive output on the terminal, you can clear the terminal using `System.out.print(String.format("\033[2J"));`
{: .notice--info }

> For convenience it may also be useful to show the ant's current state after each step.
{: .notice--info }

> The ant described below shows some incredible complex behavior. For testing purposes you many want to use a simpler ant, e.g., one that just goes to the right replacing black with white.
{: .notice--info }

## Our Ant

The ant we will be using for testing is called [Langton's ant](https://en.wikipedia.org/wiki/Langton%27s_ant). It has four states recording the direction it is facing to. It's behaviour is governed by the following simple rules:

* If it stands on a *black* cell, then it changes the color to *white* and turns $90^{\circ}$ to the right and moves in the new direction it is facing
* If it stands on a *white* cell, then it changes the color to *black* and turns $90^{\circ}$ to the left and moves in the new direction it is facing

> Langton's ant a famous example for how a simple set of rules can produce complex behaviour as you will see when running your ant.
{: .notice--info }


This behaviour is realized by the transition function shown below. The initial state of the and is `FacesTop` and it has no final states (it runs forever).

| Current State  |Current Color|New State  |New Color|Move to  |
|--------------|-------------|-------------|---------|---------|
| FacesLeft    | Black       | FacesBottom | White   | Bottom  |
| FacesLeft    | White       | FacesTop    | Black   | Top     |
| FacesRight   | Black       | FacesBottom | White   | Bottom  |
| FacesRight   | White       | FacesTop    | Black   | Top     |
| FacesTop     | Black       | FacesRight  | White   | Right   |
| FacesTop     | White       | FacesLeft   | Black   | Left    |
| FacesBottom  | Black       | FacesLeft   | White   | Left    |
| FacesBottom  | White       | FacesRight  | Black   | Right   |


{% graphviz %}
digraph {
node [shape="circle",style="filled", fillcolor="lightcyan1"];

n1 [ label="FaceLeft",  pos="0,1!" ];
n2 [ label="FaceRight", pos="2,1!" ];
n3 [ label="FaceTop", shape="doublecircle", pos="1,2!" ];
n4 [ label="FaceBottom", pos="1,0!" ];

n1 -> n4 [label="0"];
n1 -> n3 [label="1"];

n2 -> n3 [label="0"];
n2 -> n4 [label="1"];

n3 -> n1 [label="0"];
n3 -> n2 [label="1"];

n4 -> n1 [label="1"];
n4 -> n2 [label="0"];
}
{% endgraphviz %}



> Note that ants are two-dimensional versions of **Turing machines** which are a universal model of computation on which complexity theory is based on. You will learn more about Turing Machines in the future in theoretical CS courses.
{: .notice--info }

{% endkatexmm %}
