# Smarty
A Smart Contract Language based on design by contract and Event-B.

## Structure of Smart Contracts on Smarty

The idea of the Language is to make a representation of the real-life contracts. In real-life contracts there are two or more involucred parts. Contracts have defined conditions and requirements that must be fulfilled by all the parts, also there is a list of specifications that have actions to take in case of breach or violation.

All Smart Contract is composed by:

- Entities: They are very similar to the Tables on SQL Data Models and `struct` Data Structures on C and C++. 
  They have a name and fields with their respectives Types. 
  
  Let's consider an example of a Bank Account.
  
  A Bank Account have attributes such as: Account owner name, Account balance, for now let's concentrate in just these attributes.
  A Entity should look like this:

  ```haskell
    Account:{Name:string,Balance:decimal}
  ```  
  All attributes must have defined a type.
  
  ### Data Types on Smarty
  
  - Boolean: bool
  - Integer: integer
  - Float or Double: decimal
  - String: string
  
- Events: They are analagous to the Functions and Methods on many Programming Languages. There are two Events Types:
  
  - Creational Events: These events begin with `@create_` + **Entity Identifier**. In the body of these events must be specified the *Arguments*, *Invariants* and *Warnings* (These two are optional). If we want that an Account must be charged with a Initial balance. We should use an `@invariant` with an `@warning` that send an Exception if the condition in the Invariant is not accomplished (for each invariant, exists a warning). Creational Events are like the Constructor Methods in the OOP Languages. A Creational Event should look this:
  
  ```java
    @create_Account:
        @args[Name,initial_balance]
        @invariant initial_balance > 0.0
        @warning "Initial balance must be >= 0"
  ```
  The following table shows the optional and mandatory keywords that must contain these event types:

  |               | Optional           | Mandatory          |
  | :------------ | :----------------: | :----------------: |
  | `@args`       |                    | :white_check_mark: |
  | `@invariant`  | :white_check_mark: |                    |
  | `@warning`    | :white_check_mark: |                    |
  | `@action`     | :white_check_mark: |                    |  
  


<!--  ![](https://i.imgur.com/5Iy7izf.png) -->
    
  - Custom Events: These events are defined by the user. In the body of these events must be specified the *Arguments*, the relationated entities (*Subjects*), *Preconditions* with the exceptions, *actions* and *Postconditions*.

    - Arguments: Parameters need by the Event.
    - Subjects: Entities relationated by the Event.
    - Preconditions: Necessary conditions for the Event execution. They are similar to the invariants of the creational events. Preconditions must be written with their respective exceptions using the keyword `@fails`.
    - Actions: Expressions that update states of the attributes of an instance. An action not only can be an assigments, also can show Messages. For example, a Hello World:

    ```java
        @event hello_world:
            @action Write "Hello World"
    ```
    
    -  __(WIP)__ Postconditions: Guard conditions that check if an action has failed. If the result is *false*, then an action can be reverted using the keyword `@reverts`.

    The following table shows the optional and mandatory keywords that must contain these event types:
    
    |               | Optional           | Mandatory          |
    | :------------ | :----------------: | :----------------: |
    | `@args`       | :white_check_mark: |                    |
    | `@subjects`   | :white_check_mark: |                    |
    | `@pre`        | :white_check_mark: |                    |
    | `@action`     |                    | :white_check_mark: |
    | `@post`       | :white_check_mark: |                    |


Let's consider the example of an Account System and **transfer** operation. A Custom Event for this operation should look like this:

```java
    @event transfer_to:
        @args[from,to,amount]
        @subjects[Account => Account]
        @pre amount > 0.0
        @fails "Negative Transaction Amount"
        @pre from.Balance >= amount
        @fails "Insufficient Funds"
        @action from.Balance := from.Balance - amount
        @action to.Balance := to.Balance + amount
        @post @after.from.Balance = @before.from.Balance - amount
        @reverts
        @post @after.to.Balance = @before.to.Balance + amount
        @reverts
```

If the relationated entities are the same type, we can re-write `@subjects` on the following way: 
```java 
    @subjects[Account]
```

We are ready to invoke some events.

```ocaml
    create_Account [Jose,100.25]
    create_Account [Nestor,250.0]
    Jose transfer_to Nestor [25.0]
    get_info_Account [Nestor, Jose]
```

If we want to retrieve Information from an Entity instance, we must use Getters Events (They are defined inside the Language, so they can't be specified as the creational and custom events). The sintaxis of these Events is the following:
    `get_info_` + **Entity Identifier** `[Instance1,...,InstanceN]`.

**Note:** If a Custom Event has Arguments, the first two Parameters represent two instance of the two relationated entities. For example `Jose` and `Nestor` represent the two instances of the `Account` Entity. The `transfer_to` Event, is the Event that matches these instances, like a real contract does. Between the Brackets, the remaining Parameters are received.

---
For more examples, please go to:

[Examples](/examples)

