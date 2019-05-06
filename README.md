# Smarty
A Smart Contract Language based on design by contract and Event-B.

## Structure of Smart Contracts on Smarty

The idea of the Language is to make a representation of the real-life contracts. In real-life contracts there are two or more involucred parts. Contracts have defined conditions and requirements that must be fulfilled by all the parts, also there is a list of specifications that have actions to take in case of breach or violation.

All Smart Contract is composed by:

- Entities: They are very similar to the Tables on SQL Data Models and `struct` Data Structures on C and C++. 
  They have a name and fields with their respectives Types. 
  
  Let's consider an example of a Bank Account.
  
  A Bank Account have attributes such as: Name of Account Owner, Account Balance, for now let's concentrate in just these attributes.
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
  
  - Creational Events: These events begin with `@create_` + **Entity Identifier**. In the body of these events must be specified the *Arguments*, *Invariants* and *Warnings* (These two are optional). If we want that an Account must be charged with a Initial balance. We should use an `@invariant` with an `@warning` that send an Exception if the condition in the Invariant is not accomplished. Creational Events are like the Constructor Methods in the OOP Languages. A Creational Event should look this:
  
  ```java
    @create_Account:
        @args[Name,initial_balance]
        @invariant initial_balance > 0.0
        @warning "Initial balance must be >= 0"
  ```
  The following table shows the optional and mandatory keywords that must contain these event types:

  |         | Optional           | Mandatory  |
  | ------------- |:-------------:| -----:|
  | `@args`      |  | :white_check_mark: |
  | `@invariant`      | centered      |   $12 |
  | `@warning` | are neat      |    $1 |
  | `@action`  |               |       |  



<!--  ![](https://i.imgur.com/5Iy7izf.png) -->
    
  - Custom Events: These events are defined by the user. In the body of these events must be specified the *Arguments*, the relationated entities (*Subjects*), *Preconditions*, the exceptions (*fails*), actions (`@action`) 



