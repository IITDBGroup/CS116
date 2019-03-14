---
title: Lab 6
shortdescription: "Recursion"
due: 8
tasks:
  - points: 12
    shortdescription: "Traveling between Cities"
  - points: 3
    shortdescription: "Ping Pong (Mutual Recursion)"
  - points: 5
    shortdescription: "Feed the Mouse"
---


## {{ page.tasks[0].shortdescription }}

In this task you will write a class `Reachability` with a  static method `getReachableCities(RoadNetwork r, String startCity)` that given a road network (connections between cities as described below) determines which cities can be reached by car from a given input city.

```java
public static Set<String> getReachableCities(RoadNetwork r, String startCity);
```


### Road Network

The class `RoadNetwork` that is available in your repository stores connections between cities. You can use the method `boolean isConnectedDirectly(String fromCity, String toCity)` that returns `true` if there is a road that directly connects city `fromCity` to city `toCity`. You can also use the method `Set<String> getDirectlyReachableCities(String startCity)` to get a set of all cities which are directly connected by road to `startCity`. When creating a `RoadNetwork` you can provide all the direct connections as a `List` of `String[]` where each element in the list is a `String[]` with two elements (the start and end point of the road).

For example, consider the following road network:

{% graphviz %}
graph {
node [shape="ellipse",style="filled", fillcolor="lightcyan1"];

n1 [ label="Chicago" ];
n2 [ label="New York" ];
n3 [ label="Madison" ];
n4 [ label="Indianapolis" ];
n5 [ label="Boston"];
n6 [ label="Seattle" ];
n7 [ label="San Francisco" ];

n1 -- n3;
n1 -- n4;
n4 -- n5;
n5 -- n2;
n6 -- n7;
}
{% endgraphviz %}



### Reachability

The class `RoadNetwork` only considers direct connections between cities. For instance, in the above example there is a direct connection between *Chicago* and *Madison*, but no direct connection between *Chicago* and *Boston*. The method `getReachableCities` you should implement, however, should return not just directly connected cities, but also indirectly connected cities. For example, *Chicago* is indirectly connected to *New York* (Chicago to Indianapolis to Boston to New York). As another example, the complete set of cities reachable from *Chicago* is:

* Chicago
* Madison
* New York
* Indianapolis
* Boston

> Note that reachbility has a natural recursive formulation.
{: .notice--info }


### Testing

 Write a `main` method for class `Reachability` that prints all cities reachable from `Chicago` using the road network shown above.

## {{ page.tasks[1].shortdescription }}

Write a class `PingPong` with two methods `ping` and `pong`. `ping` waits for 1 second, prints `ping`, and calls `pong`. `pong` waits for 1 second, prints `pong`, and calls `ping`.

## {{ page.tasks[2].shortdescription }}

Consider a square grid of cells which are either blocked or empty (you can use the `BlockWorld` class from lab 3 to store such a grid, e.g., consider white as blocked).
Write a class `TheMouse` that stores a position of a mouse on the grid and the position of a cell with a piece of cheese on it. Furthermore, this class should have a method `findTheCheese` that calculates a sequence of movements  (the move can move left, up, down, or right) from the mouse's current position to the cell with the cheese. The mouse is not allowed to move to a blocked cell.

> The mouse task is harder than the other two task. To maximize your points start with the first two tasks before attempting to feed the mouse!
{: .notice--danger }

> Notice that paths can be defined recursively to consist of a starting point followed by a path. Thus, the problem of searching all possible paths between the mouses current position and the cell with the cheese can be broken down into moving into one direction by one cell and then trying all possible paths that start from this cell.
{: .notice--info }

> To avoid following infinite paths the revisit the same cell over and over again, make sure that when extending a path does not contain the same cell more than once. Also you want to ensure that once you have considered a cell as an intermediate point of a path, that you do not consider this cell for future paths.
{: .notice--info }

### Test case

Use the following configuration as your test case (the mouse is shown as `M`, the cheese as `C`, and blocked cells as `X`):

```
      CXX
 XXXXXXXX
 XX XXX X
 X    X X
 XXX XX X
  XX X  X
X XX XX X
X       X
XXXMXXXXX
```

> Creating such a large `BlockWorld` programatically is very tedious. Instead you could write a method that takes such a textual description (`String[]`) and creates the corresponding `BlockWorld`.
{: .notice--info }
