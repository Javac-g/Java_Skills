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

# Task 1 — Primitive and variable fundamentals

Create:

`src/main/java/com/javacg/skills/basics/PrimitiveExercises.java`

Required public static methods:

```java
int add(int a, int b)
long multiply(int a, int b)
double average(int a, int b)
boolean isEven(int value)
char firstCharacter(String value)
```

Requirements:

- do not use streams;
- do not use collections;
- `firstCharacter(null)` must throw `IllegalArgumentException`;
- `firstCharacter("")` must throw `IllegalArgumentException`.

Be ready to explain:

1. Why can `multiply(int, int)` still overflow even if its return type is `long`?
2. What is the difference between declaration, initialization, and assignment?
3. Which variables receive default values automatically, and which do not?
4. Where do the method parameters conceptually live during a method invocation?

---

# Task 2 — References and copying

Create:

`src/main/java/com/javacg/skills/basics/ReferenceExercises.java`

Required methods:

```java
int[] copyArray(int[] source)
void incrementFirst(int[] values)
boolean sameReference(Object first, Object second)
```

Requirements:

- `copyArray` must return a new independent array;
- changing the returned array must not mutate the source;
- `copyArray(null)` must throw `IllegalArgumentException`;
- `incrementFirst` must mutate the first element of the passed array;
- `incrementFirst(null)` and an empty array must throw `IllegalArgumentException`;
- `sameReference` must test object identity, not logical equality.

Be ready to explain:

- what exactly is copied when an array reference is passed to a method;
- why Java is still pass-by-value;
- the difference between `==` on primitives and references;
- where the array object and the local reference are conceptually stored.

---

# Task 3 — Initialization order

Create:

`src/main/java/com/javacg/skills/basics/InitializationOrderProbe.java`

The class must record initialization events and expose:

```java
static List<String> createAndGetEvents()
```

Calling that method must return exactly:

```text
static-field
static-block
instance-field
instance-block
constructor
```

Constraints:

- the event names must be produced by the corresponding Java mechanisms;
- do not simply return a hard-coded list from `createAndGetEvents()`;
- preserve real static/instance initialization semantics.

Be ready to explain what changes when inheritance is introduced.

---

# Task 4 — Primitive array ↔ Collection conversion

Create:

`src/main/java/com/javacg/skills/basics/ArrayConversions.java`

Required methods:

```java
List<Integer> toList(int[] values)
int[] toPrimitiveArray(List<Integer> values)
```

Requirements:

- preserve element order;
- an empty input produces an empty result;
- `null` input must throw `IllegalArgumentException`;
- `toPrimitiveArray` must reject a list containing `null`;
- returned data structures must be independent from their inputs.

Restrictions for this module:

- do not use third-party libraries;
- implement the conversion explicitly with loops first;
- after review we will compare it with Streams and other approaches.

Be ready to explain why this does **not** work as expected:

```java
int[] numbers = {1, 2, 3};
List<int[]> result = Arrays.asList(numbers);
```

and why Java generics cannot use primitive type arguments such as `List<int>`.

---

# Task 5 — Class layout and naming

Create:

`src/main/java/com/javacg/skills/basics/StudentProfile.java`

Required state:

- constant `DEFAULT_LEVEL`;
- static field counting created instances;
- instance fields: `name`, `level`;
- constructor accepting `name`;
- constructor accepting `name` and `level`;
- getters;
- setter for `level`;
- public method `describe()`;
- private helper method used by `describe()`.

Rules:

- follow conventional Java naming;
- validate invalid names;
- use constructor chaining where appropriate;
- organize members in a clear conventional order;
- do not expose mutable state unnecessarily.

The exact behavioral contract is enforced by the tests.

---

# Self-check

From this directory run:

```bash
gradle test
```

Do not alter a failing assertion to make your solution pass. Fix the implementation.

---

# Submission

When all tests pass:

1. commit your solution;
2. send the commit SHA;
3. answer the engineering questions from this README in your own words;
4. I will review correctness, naming, class organization, Java semantics, readability, tests, and explanations.

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
