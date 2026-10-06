# Theory — Module 01: Java Zero Basics

This file contains the theory required for Module 01. It is intentionally focused on concepts and language rules, not on the task solutions.

## 1. Java source structure

A Java source file may contain package declarations, imports, type declarations, fields, constructors, methods, initializer blocks, comments, and nested types.

A common class layout convention is:

1. constants;
2. static fields;
3. instance fields;
4. static initializer blocks;
5. instance initializer blocks;
6. constructors;
7. public methods;
8. protected/package-private methods;
9. private helper methods;
10. getters/setters;
11. nested types.

This is a convention, not a compiler requirement.

## 2. Identifiers and naming conventions

Identifiers can contain letters, digits, underscores, and dollar signs, but cannot start with a digit and cannot be a Java keyword.

Typical conventions:

- class / interface / enum / record: `PascalCase`;
- method / variable / parameter: `camelCase`;
- constant: `UPPER_SNAKE_CASE`;
- package: lowercase, usually reverse-domain style.

Examples:

```java
class PaymentService {}
int retryCount;
static final int MAX_RETRIES = 3;
package com.javacg.skills.basics;
```

## 3. Declaration, initialization, assignment

Declaration introduces a variable:

```java
int count;
```

Initialization gives it its first value:

```java
int count = 10;
```

Assignment changes the value later:

```java
count = 20;
```

## 4. Variable categories

### Local variables

Declared inside methods, constructors, or blocks.

They do **not** receive default values automatically.

```java
void run() {
    int count;
    // System.out.println(count); // compile error
}
```

### Parameters

Variables declared in a method or constructor parameter list.

They receive values from the caller.

### Instance fields

Belong to an object.

Each instance has its own copy unless the field is static.

### Static fields

Belong to the class itself, not to each instance.

## 5. Default initialization

Fields are default-initialized:

- numeric primitives → `0` / `0.0`;
- `boolean` → `false`;
- `char` → `'\u0000'`;
- references → `null`.

Local variables are not automatically initialized.

## 6. Primitive types

Java primitive types:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

Primitive variables store primitive values directly.

## 7. Reference types

Reference variables store references to objects.

Examples:

```java
String name = "Java";
int[] numbers = {1, 2, 3};
StudentProfile profile = new StudentProfile("Alex");
```

The reference variable and the referenced object are conceptually distinct.

## 8. Java is pass-by-value

Java always passes arguments by value.

For primitives, the primitive value is copied.

For objects, the **reference value** is copied.

That means a method can mutate the object reached through the copied reference, but assigning a new object to the method parameter does not replace the caller's variable.

## 9. Identity vs equality

For primitives, `==` compares values.

For references, `==` compares whether two references point to the same object.

Logical equality is usually expressed through `equals()`, which will be covered in a later module.

## 10. Arrays

Arrays are objects in Java.

```java
int[] values = new int[3];
```

The array object is allocated separately from the local reference variable.

Array length is fixed after creation.

Primitive arrays store primitive values directly.

Reference arrays store references.

## 11. Primitive arrays and collections

Collections cannot use primitive type arguments:

```java
List<Integer> values; // valid
// List<int> values;  // invalid
```

This requires boxing between `int` and `Integer`.

An important pitfall:

```java
int[] numbers = {1, 2, 3};
List<int[]> list = Arrays.asList(numbers);
```

This produces a list containing one element: the entire `int[]` array.

## 12. Boxing and unboxing

Boxing:

```java
Integer x = 10;
```

The primitive `int` is converted to `Integer`.

Unboxing:

```java
int y = x;
```

Be careful: unboxing `null` throws `NullPointerException`.

## 13. Static vs instance members

Static members belong to the class:

```java
StudentProfile.getCreatedCount();
```

Instance members belong to an object:

```java
profile.getName();
```

Calling a static method through an instance is legal Java syntax but discouraged because it hides the fact that the method is class-level.

## 14. Initialization order

For a class used for the first time:

1. static fields are initialized in textual order;
2. static initializer blocks run in textual order.

When an object is created:

1. memory is allocated and fields receive default values;
2. instance field initializers run in textual order;
3. instance initializer blocks run in textual order;
4. the constructor body runs.

With inheritance, superclass initialization happens before subclass initialization. We will cover the full hierarchy rules later.

## 15. Constructors

A constructor:

- has the same name as the class;
- has no return type;
- initializes a new object.

Constructor chaining inside the same class uses `this(...)`.

A superclass constructor is invoked with `super(...)`.

## 16. Heap and call stack — first model

For this stage, use this simplified model:

- objects and arrays are typically allocated on the heap;
- each thread has its own call stack;
- method calls create stack frames;
- parameters and local variables belong to the active method frame conceptually;
- reference variables can point to objects on the heap.

Later we will refine this model with JVM internals, escape analysis, scalar replacement, stack frames, operand stacks, and JIT behavior.

## 17. Scope and lifetime

Scope means where a variable name is visible in source code.

Lifetime means how long the variable or object exists during execution.

These are related but not identical.

A local variable can go out of scope while the referenced object remains reachable elsewhere.

## 18. Common mistakes

- assuming local variables get default values;
- confusing reference copying with object copying;
- using `==` when logical equality is intended;
- assuming changing a method parameter reference changes the caller's variable;
- assuming arrays and collections behave the same way;
- forgetting integer overflow;
- calling static methods through instances;
- exposing mutable fields directly;
- mixing class-level state and instance-level state unnecessarily.

## 19. Integer overflow

Arithmetic with `int` operands is normally performed as `int`.

Therefore this can overflow before being assigned to a `long`:

```java
int a = 2_000_000;
int b = 3_000;
long result = a * b;
```

One operand must be promoted before multiplication:

```java
long result = (long) a * b;
```

## 20. What you should be able to explain after this module

You should be able to explain, without memorized wording:

- what a variable is;
- primitive vs reference semantics;
- local vs field initialization;
- static vs instance state;
- scope vs lifetime;
- pass-by-value;
- object identity;
- arrays as objects;
- boxing/unboxing;
- initialization order;
- constructor purpose and chaining;
- the simplified heap/call-stack model;
- why class organization and naming conventions matter.
