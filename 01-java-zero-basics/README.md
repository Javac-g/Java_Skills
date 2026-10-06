# Module 01 — Java Zero Basics

## Stage

**J0/J1 — Absolute fundamentals**

This module deliberately starts below normal "junior Java" level. The goal is to verify that basic syntax, variables, scopes, primitive/reference behavior, initialization, arrays, and class organization are precise rather than assumed.

## Learning objectives

By the end of this module you should be able to explain and demonstrate:

- valid Java identifiers and standard naming conventions;
- local, parameter, instance, and static/class variables;
- declaration vs initialization vs assignment;
- default initialization rules;
- primitive types vs reference types;
- value copying vs reference copying;
- scope and lifetime;
- conventional class member ordering;
- static fields and static initialization blocks;
- instance fields and instance initializer blocks;
- constructor execution;
- initialization order;
- one-dimensional arrays;
- primitive arrays vs wrapper collections;
- boxing/unboxing involved in conversions;
- basic heap vs thread call-stack reasoning.

Use **Java 21+**.

---

# Task 1 — Primitive operations and variable fundamentals

## What to create

Create:

`src/main/java/com/javacg/skills/basics/PrimitiveExercises.java`

Create a public class named `PrimitiveExercises`.

## What to implement

Implement these **public static** methods:

```java
int add(int a, int b)
long multiply(int a, int b)
double average(int a, int b)
boolean isEven(int value)
char firstCharacter(String value)
```

### Method behavior

#### `add(int a, int b)`

Return the mathematical sum of `a` and `b`.

Example:

```text
add(3, 4) -> 7
```

#### `multiply(int a, int b)`

Return the mathematical product of `a` and `b` as `long`.

The method must work correctly when the result does not fit into an `int`.

Example:

```text
multiply(2_000_000, 3_000) -> 6_000_000_000L
```

#### `average(int a, int b)`

Return the arithmetic mean of the two integers as a `double`.

Example:

```text
average(2, 3) -> 2.5
```

Do not truncate the fractional part.

#### `isEven(int value)`

Return `true` when the value is even, otherwise return `false`.

Examples:

```text
isEven(4)  -> true
isEven(7)  -> false
isEven(-4) -> true
```

#### `firstCharacter(String value)`

Return the first character of the supplied string.

Examples:

```text
firstCharacter("Java") -> 'J'
firstCharacter("A")    -> 'A'
```

If `value == null`, throw `IllegalArgumentException`.

If `value` is an empty string, throw `IllegalArgumentException`.

## Restrictions

- do not use streams;
- do not use collections;
- do not change the required method signatures.

## Engineering questions

Be ready to explain:

1. Why can `multiply(int, int)` still overflow even if its return type is `long`?
2. What is the difference between declaration, initialization, and assignment?
3. Which variables receive default values automatically, and which do not?
4. Where do method parameters conceptually live during a method invocation?

---

# Task 2 — References, mutation, copying, and identity

## What to create

Create:

`src/main/java/com/javacg/skills/basics/ReferenceExercises.java`

## What to implement

Implement these methods:

```java
int[] copyArray(int[] source)
void incrementFirst(int[] values)
boolean sameReference(Object first, Object second)
```

### `copyArray(int[] source)`

Create and return a **new independent array** containing the same values as `source`.

Requirements:

- the returned object must not be the same array instance as `source`;
- modifying the returned array later must not modify `source`;
- if `source == null`, throw `IllegalArgumentException`.

Example:

```text
source = [1, 2, 3]
copyArray(source) -> [1, 2, 3]
```

but the result must be a separate array object.

### `incrementFirst(int[] values)`

Increase the first element of the passed array by exactly `1`.

Example:

```text
[10, 20, 30] -> [11, 20, 30]
```

Requirements:

- mutate the passed array itself;
- if `values == null`, throw `IllegalArgumentException`;
- if the array is empty, throw `IllegalArgumentException`.

### `sameReference(Object first, Object second)`

Return whether both parameters contain the **same object reference**.

This task is about identity, not logical equality.

Examples:

```text
sameReference(object, object) -> true
sameReference(new String("java"), new String("java")) -> false
sameReference(null, null) -> true
```

## Engineering questions

Be ready to explain:

- what exactly is copied when an array reference is passed to a method;
- why Java is still pass-by-value;
- the difference between `==` on primitives and references;
- where the array object and local reference are conceptually stored.

---

# Task 3 — Prove Java initialization order

## What to create

Create:

`src/main/java/com/javacg/skills/basics/InitializationOrderProbe.java`

## Goal

Build a class that **demonstrates real Java initialization order**.

Your code must record these events in this exact order:

```text
static-field
static-block
instance-field
instance-block
constructor
```

Expose:

```java
static List<String> createAndGetEvents()
```

Calling this method must create an instance and return the recorded events.

## Important constraint

Do **not** simply return this hard-coded list:

```java
List.of(
    "static-field",
    "static-block",
    "instance-field",
    "instance-block",
    "constructor"
)
```

Each event must actually be added by the corresponding Java mechanism:

- static field initialization;
- static initializer block;
- instance field initialization;
- instance initializer block;
- constructor.

The purpose is to prove the language execution order, not reproduce the expected answer manually.

## Engineering question

Explain what changes when a superclass and subclass are involved.

---

# Task 4 — Convert primitive arrays and collections manually

## What to create

Create:

`src/main/java/com/javacg/skills/basics/ArrayConversions.java`

## What to implement

```java
List<Integer> toList(int[] values)
int[] toPrimitiveArray(List<Integer> values)
```

### `toList(int[] values)`

Convert an `int[]` into a `List<Integer>`.

Example:

```text
[1, 2, 3] -> [1, 2, 3]
```

Requirements:

- preserve order;
- an empty array returns an empty list;
- if `values == null`, throw `IllegalArgumentException`;
- the returned list must be independent from the source array;
- implement the conversion explicitly with a loop.

### `toPrimitiveArray(List<Integer> values)`

Convert a `List<Integer>` into an `int[]`.

Example:

```text
[4, 5, 6] -> [4, 5, 6]
```

Requirements:

- preserve order;
- an empty list returns an empty array;
- if `values == null`, throw `IllegalArgumentException`;
- if any list element is `null`, throw `IllegalArgumentException`;
- the returned array must be independent from the input list;
- implement the conversion explicitly with a loop.

## Restrictions

- no Streams for this module;
- no third-party libraries.

## Engineering questions

Explain why this:

```java
int[] numbers = {1, 2, 3};
List<int[]> result = Arrays.asList(numbers);
```

creates a list with **one element** rather than `List<Integer>`.

Also explain why Java does not allow:

```java
List<int>
```

---

# Task 5 — Build a conventionally structured class

## What to create

Create:

`src/main/java/com/javacg/skills/basics/StudentProfile.java`

## Goal

Create a small class that demonstrates:

- naming conventions;
- constants;
- static state;
- instance state;
- overloaded constructors;
- constructor chaining;
- validation;
- getters/setters;
- public behavior;
- private helper methods;
- conventional member organization.

## Required state

Create:

```java
DEFAULT_LEVEL
```

as a class constant.

Create a static field that counts how many valid `StudentProfile` instances have been created.

Create instance fields:

```java
name
level
```

## Constructors

Implement:

```java
StudentProfile(String name)
StudentProfile(String name, int level)
```

The one-argument constructor must use `DEFAULT_LEVEL`.

Use constructor chaining where appropriate.

Invalid names must throw `IllegalArgumentException`.

The following names are invalid:

- `null`;
- `""`;
- whitespace-only strings such as `"   "`.

## Required methods

Implement getters for `name` and `level`.

Implement:

```java
void setLevel(int level)
```

Implement:

```java
static int getCreatedCount()
```

Implement:

```java
String describe()
```

Expected format:

```text
Maksym [level=1]
Alex [level=5]
```

`describe()` must use at least one private helper method.

## Class-structure requirement

Organize the class in a clear conventional order.

Do not expose fields publicly.

---

# Self-check

From this directory run:

```bash
gradle test
```

If you have a Gradle Wrapper later, prefer:

```bash
./gradlew test
```

Do not alter a failing assertion merely to make your solution pass. Fix the implementation.

---

# Submission

When all tests pass:

1. commit your solution on `task/01-java-zero-basics`;
2. push the branch;
3. send the commit SHA;
4. answer the engineering questions from this README in your own words;
5. I will perform code review and grading.

## Evaluation

| Area | Weight |
|---|---:|
| Correctness | 30% |
| Java fundamentals | 25% |
| Naming / class structure | 15% |
| Error handling | 10% |
| Code clarity | 10% |
| Engineering explanation | 10% |

A passing test suite is necessary, but **not sufficient** for a high score.
