---
title: Lab 1
shortdescription: "Create a simple user-defined class, use control constructs, and use expressions in Java."
due: 2
tasks:
  - points: 12
    shortdescription: "Design, implement, and use a simple class."
  - points: 8
    shortdescription: "Use of control constructs and expressions."
---

## {{ page.tasks[0].shortdescription }}

In this task you will design several classes applying the concept of information hiding. The fields of these classes should be private and only accessible from outside world using **getter** and **setter** methods as discussed in class. You do not necessarily create a getter or setter for fields that do not have to be read or written by a client of the class.
In addition to these basic access methods, some of the classes also have convenience methods that do basic computations using the values of fields. For each class write a main program that tests the functionality of the classes by creating an instance of the class as described below and by retrieving the values from this object.  Also implement a `toString` method for every class you design.

### Bank account (6 Points)
  * Implement a class `BankAccount` in package `lecture.lab1` that models a bank account. For a bank account you should store the `balance`, the owner's `name`, whether this is a `checkings` or `savings` account, and the `overdraw limit`  which is the maxmium amount the account can fall below zero, e.g., if the overdraw limit is `30.0` then the account balance is not allowed to drop below `-30.0`.
  * When the `balance` is set, then make sure that it is greater than or equal to `-withdrawl` limit.
  * It should be possible to withdraw money from an account using a method `double withDraw(double amount)` that you have to implement. This method has to check whether the there is sufficient balance such that after the withdrawal the account balance is still above the `overdraw limit`. In case the withdrawal would cause the balance to drop below the limit, no money should be withdrawn. The return value of the method is the amount of money that was withdrawn. Do not forget to update the `balance` if the withdrawl is successful. If the account is a savings account then the bank charges a `3` dollar fee for each withdrawal. Note that the fee has to be taken into account when calculating the new account balance and when checking the overdraft limit
  * Similarly, it should be possible to deposit money into the account using a method `void deposit(double amount)`. This increases balance by `amount`.
  * It should also be possible to transfer money from one account to another. That should be implemented as a method `boolean transfer(BankAccount to, double amount)`. This method transfers `amount` from the bank account on which this method is called to bank account `to`. If this would cause the balance of the source account to drop below the overdraft limit, then the transfer should be abandonded (no balances are changed). The method returns `true` if the transfer is succcessful and `false` otherwise.

To test your Bank account class, write a class `BankAccountTest` in package `lecture.lab1` which contains a main method that implements the following test case:

Create a savings account for customer `Alice` with a withdrawl limit of `$50.0`. The initial balance of this account should be `$100.0`. Then create a checkings account for `Bob` with a withdrawl limit of `$30.0` and an initial balance of `$350.0`. Then execute the following operations and print their return values to the standard output:
* Withdraw $200 from Bob's account
* Deposit $50 into Alice's account
* Withdraw $1000 from Bob's account (note that this would drop Bob's balance below his withdrawl limit)
* Transfer $75 from Bob to Alice's account
* Print the account information for Bob's and Alice's account using the `toString` method.

### Bob's life (6 Points)

Design and implement a class `BobsLife` in package `lecture.lab1` that simulates a simple virtual world. In this world there is a person called Bob that can be at either one of three locations: At home, at work, or at the gym. Bob has three characteristics: his `hunger`, his `fitness`, and the `dollars` (positive integer number) he owns. The class should have an instance method called `move` that moves Bob from his current location (`home`, `work`, or `gym`) to a new location.
The simulation starts at time `0`. Time moves in steps. The simulation is moved forward by one step manually by calling an instance method `nextTime()`. Depending on Bob's location when `nextTime` is called, the following happens:
* If Bob is at `home`, then his `hunger` is decreased by 3, because he eats a meal. However, the `hunger` can not drop below `0`. Furthermore, his `dollars` are decreased by `1` because food costs money.
* If Bob is at `work`, then his `hunger` is increased by 2, because working makes hungry. Furthermore, his `dollars` are increased by `3` (he earns money at his job). Also he has a desk job and so his `fitness` decreases by 1.
* If Bob is at the `gym`, then his `hunger` is increased by `3` because workout makes hungry. His `dollars` are decrease by `2` since the `gym` costs money. On the positive side his `fitness` increases by `2`.

The virtual world is quite harsh. If Bob's `hunger` goes above 6 then the poor guy starves to death. If his `dollars` drop below zero than he is broke and is thrown into jail for a life time sentence. If his `fitness` is `0` then he dies of a heart attack. The class should keep track of whether Bob is dead or in jail. If this is the case then it should no longer be possible to move Bob to another location and his characteristics do no longer change if the `nextTime` function is called.
The constructor of the  class `BobsLife` should allow all the parameters of the simulation to be set (Bob's initial location and Bob's initial characteristics).

## {{ page.tasks[1].shortdescription }}

In this task you will use control structures and expressions extensively. We will be  extending the `BankAccount` and `BobsLife` classes from the first task.

### Interest calculation (3 Points)

Create a class `InterestCalculator` in package `lecture.lab1` which has a single `static` method `double applyInterest(BankAccount a, int years, double interestRate)` which applies `interestRate` percent interest to the balance of bank account `a` for `years` years and returns the final balance of `a` after the interest has been applied. Recall that for `x%` interest the account balance is updated like this:

{% katex display %}
balance = balance \cdot (1 + \frac{x}{100})
{% endkatex %}

Write a main method that tests `applyInterest` using the following test case:
* Create a savings bank account for Alice with `$110` balance.
* Apply `5%` interest for `8` years and print the final account balance.

### Long live Bob! (5 Points)

Write a class `LongLiveBob` in package `lecture.lab1` which runs a `BobsLife` simulation in its `main` method. You are allowed to write `static` helper methods for this class if need be. The task is to create a new `BobsLife` object with `0` hunger, `5` dollar, and `4` fitness. You have to advance the simulation by `1000` steps without causing Bob to die or go to jail. In each step you have the free choice to move Bob to any of the locations. Using trial-and-error you could come up with a sequence of 1000 moves that do not lead to Bob's demise or imprisonment. However, that would be quite tideous! Instead try to come up with a short sequence of moves that can be repeated abitrarily many times without leading to a bad result. Once you have such a sequence, say of length `n`, then you can repeated it ad infinum to achieve a simulation of arbitrary length! The `main` method should print all 1000 steps. Each step should be printed on a separate line showing the step number, Bob's location, hunger, dollars, fitness, and whether he is dead or in jail. For example, here is some sample output where Bob stays at home without moving:

~~~shell
Step: 1 - Location: home, hunger: 5, dollars: 15, fitness: 3
Step: 2 - Location: home, hunger: 2, dollars: 14, fitness: 3
Step: 3 - Location: home, hunger: 0, dollars: 13, fitness: 3
Step: 4 - Location: home, hunger: 0, dollars: 13, fitness: 3
...
~~~
