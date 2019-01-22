---
title: Lab 7
shortdescription: "Searching and Sorting"
due: 9
tasks:
  - points: 20
    shortdescription: "Searching for friends."
---

## {{ page.tasks[0].shortdescription }}

{% katexmm %}
In this task we are desining classes for searching for persons within a social network (think Facebook). The social network should be represented as a undirected graph consisting of nodes (the people that participate in the social network) and undirected edges that representing friendship relationships. There is an edge from node $p_1$ to node $p_2$ if the persons $p_1$ and $p_2$ are friends. Create classes in package `lecture.lab7` to store such a social network. There should be a main class `SocialNetwork` representing the full network. How you design classes for Persons and edges of the network to is up to you. For each person in the network you need to store their *name*, a *nickname* that identifies them within the social network, their *age*, and *gender*. We call these the *characteristics* of a person. The class `SocialNetwork` should expose a method `public boolean search(Condition e)` which return `true` if the social network *matches* the condition.

## Search conditions

### Syntax

Conditions check for existance of nodes and edges with certain characteristics. It is probably best to organize all expression types in a class hierarchy. Expressions are defined recursively as follows:

A **term** is one of the following:
* **Variable**: A variable $x$ is a term of type *node*
* **Charateristics**: If $x$ is a variable and $c$ is a charaterstic (`name`, `nickname`, `age`, or `gender`), then $x.c$ is a value term of a type depending on the characteristic (`int` for *age* and `String` for all other charateristics)
* **Literal**: A literal **string** or **integer**

A **condition** is one of the following:
* **Terms**: Any term $t$ is an expression with the same type of term
* **Comparisons**: If $t_1$ and $t_2$ are value terms of the same type, then $t_1 = t_2$ is an expression of type *boolean*
* **Connectivity**:  If $x_1$ and $x_2$ are variables, then $x_1 \leftrightarrow x_2$ is an expression of type *boolean*
* **Logical Connectives**:  If $e_1$ and $e_2$ are expressions of type boolean then $e_1 \wedge e_2$, $e_1 \vee e_2$, and $\neg e_1$ are expressions of type *boolean*

For example, a pattern that returns true if there exists a person that is `50` years old can be written as
$$
x.age = 50
$$

We use $vars(e)$ for an expression $e$ to the set of all variables appearing in expression $e$.


### Semantics

Given a network $n$ and a search condition $e$ of type boolean, the result of the condition depends on the existance of a successful *valuation* of the condition. A **valuation** assigns the variables of the condition ($vars(e)$) to nodes in the network. A valuation $\mu$ is successful if it evaluates to `true` according to the following rules:

* **Variable term** $x$ evaluates to the node assigned to the variable by the valuation: $\mu(x)$
* **Charateristic term** $x.c$ evaluate to the value $\mu(x)$ has in characteristic $c$
* **Literal term** evaluates to itself
* **Comparion** $t_1 = t_2$ evaluate to `true` if $t_1$ and $t_2$ evaluate to the same value
* **Connectivity** $x_1 \leftrightarrow x_2$ evaluates to `true` if there exists an edge in the network between nodes $\mu(x_1)$ and $\mu(x_2)$
* **Logical connectives** follow the standard rules of boolean logic

> Note that edges in the network are undirected!
{: .notice--danger }

## Evaluating Search Conditions

To make progress with the implementation it is probably best to start with designing classes to model expressions. Once you have a solid model for such expressions, you need to think about how to evaluate such expressions over a graph. It may be good idea to split the problem into two pieces:
* A component that generates *valuations*, i.e., assignments of nodes to the variables of a condition
* A component that takes a **valuation** and evaluates whether the condition is successful for this valuation

Start designing a brute force algorithm that tries out all possible assignments of nodes to variables. Then think about whether there better strategies then just trying all combinations.
{% endkatexmm %}

## Test case

As a test case create the graph shown below for the following persons:

| Name  | Nickname | Age  | Gender |
|--------------|-------------|-------------|---------|
| Peter | Petey | 50 | male |
| Alice | AA43 | 23 | female |
| Bob   | theguy | 44 | male |
| Ann   | efeffe | 33 | female |

{% graphviz %}
graph {
rankdir=LR;
node [style="filled", fillcolor="lightcyan1"];

n1 [ label="Peter" ];
n2 [ label="Alice" ];
n3 [ label="Bob" ];
n4 [ label="Ann" ];

n1 -- n2;
n1 -- n3;
n2 -- n3;
n3 -- n4;

}
{% endgraphviz %}

{% katexmm %}

Evaluate the following conditions:

* $x.age = 50$ - which should return `true` because *Peter* is 50 years old
* $x.name=Ann \wedge x \leftrightarrow y$ - which returns `true`, because Ann has a friend (edges are undirected).

{% endkatexmm %}
