# Theory — Module 01: Java Zero Basics

This file contains the theory required for Module 01. It is intentionally focused on concepts and language rules, not on the task solutions.

## 1. Complete Java source-file structure

For this course, think about Java structure at **two levels**:

1. the structure of the **source file**;
2. the structure of the **type declared inside it**.

A conventional Java source file is organized in this general order:

1. package declaration;
2. import declarations;
3. top-level type declaration;
4. members of that type.

Example:

```java
package com.javacg.skills.basics;

import java.util.List;
import java.util.Objects;

public class StudentProfile {

    // class members
}
```

### 1.1 Package declaration

If present, the package declaration appears before imports and type declarations.

Example:

```java
package com.javacg.skills.basics;
```

There can be at most one package declaration in a source file.

The package name normally follows lowercase reverse-domain naming conventions.

### 1.2 Imports

Imports come after the package declaration and before the top-level type declaration.

Example:

```java
import java.util.List;
import java.util.Map;
```

Static imports are also possible:

```java
import static java.lang.Math.PI;
```

Imports do not "copy" classes into a file. They allow types or static members to be referenced by shorter names.

Types from `java.lang`, such as `String`, `Object`, and `System`, are implicitly available without explicit imports.

### 1.3 Top-level type declaration

After package and imports comes a top-level declaration such as:

- `class`;
- `interface`;
- `enum`;
- `record`;
- annotation interface.

Examples:

```java
public class StudentProfile {}
```

```java
public interface Repository {}
```

```java
public record Point(int x, int y) {}
```

A source file can technically contain multiple top-level types, but at most one top-level public type is normally declared, and its name must match the file name.

Example:

```text
StudentProfile.java
            ↓
public class StudentProfile
```

### 1.4 Complete class header

A class declaration may include:

- annotations;
- access modifier;
- other class modifiers;
- the `class` keyword;
- class name;
- generic type parameters;
- `extends`;
- `implements`;
- `permits` for sealed hierarchies.

Example:

```java
public final class StudentProfile implements Comparable<StudentProfile> {
}
```

More advanced combinations such as `abstract`, `sealed`, `non-sealed`, generics, records, and nested types are covered in later modules.

### 1.5 Conventional order of class members

Inside a class, a common readable layout is:

1. constants (`static final`);
2. static fields;
3. instance fields;
4. static initializer blocks;
5. instance initializer blocks;
6. constructors;
7. public methods;
8. protected methods;
9. package-private methods;
10. private helper methods;
11. getters/setters when explicit accessors are appropriate;
12. nested types.

Example skeleton:

```java
package com.javacg.skills.basics;

import java.util.List;

public class Example {

    // 1. Constants
    public static final int DEFAULT_LIMIT = 10;

    // 2. Static fields
    private static int createdCount;

    // 3. Instance fields
    private String name;

    // 4. Static initializer blocks
    static {
        // class-level initialization
    }

    // 5. Instance initializer blocks
    {
        // object-level initialization
    }

    // 6. Constructors
    public Example(String name) {
        this.name = name;
    }

    // 7. Public methods
    public String describe() {
        return buildDescription();
    }

    // 8. Protected methods
    protected void validateState() {
    }

    // 9. Package-private methods
    void reset() {
    }

    // 10. Private helper methods
    private String buildDescription() {
        return name;
    }

    // 11. Getters/setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 12. Nested types
    static class Helper {
    }
}
```

This ordering is a **style convention**, not a Java compiler requirement. Different teams may use slightly different conventions. The important goals are consistency, readability, and predictability.

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

## 7. Primitive widths, ranges, and numeric conversions

It is important to distinguish two ideas:

1. the **logical width/range of a Java primitive type**;
2. the **actual amount of memory used by a JVM implementation**.

For numeric primitives, Java defines their value ranges precisely. However, the actual memory footprint of fields, array elements, local variables, and stack-frame slots can differ because of JVM implementation details, alignment, object layout, and JIT optimizations.

### 7.1 Primitive types and value ranges

| Type | Logical width | Typical value range |
|---|---:|---|
| `byte` | 8 bits | -128 to 127 |
| `short` | 16 bits | -32,768 to 32,767 |
| `int` | 32 bits | -2^31 to 2^31 - 1 |
| `long` | 64 bits | -2^63 to 2^63 - 1 |
| `float` | 32 bits | IEEE 754 single precision |
| `double` | 64 bits | IEEE 754 double precision |
| `char` | 16 bits | 0 to 65,535 |
| `boolean` | JVM-dependent storage | language values: `true` / `false` |

### 7.2 Important note about `boolean`

The Java language defines only two boolean values:

```java
true
false
```

Do not assume that every boolean always occupies exactly one byte in memory.

Its physical storage depends on context and JVM implementation.

### 7.3 `char` is not a full Unicode character

A Java `char` stores a single UTF-16 code unit.

That means some Unicode characters require two `char` values called a surrogate pair.

So:

```java
char
```

is not always equivalent to "one human-visible character".

### 7.4 Integer literal defaults

An integer literal such as:

```java
100
```

is normally an `int`.

A long literal normally uses `L`:

```java
100L
```

Prefer uppercase `L`, because lowercase `l` can look like the digit `1`.

### 7.5 Floating-point literal defaults

A floating-point literal such as:

```java
3.14
```

is a `double` by default.

A `float` literal requires `F` or `f`:

```java
3.14F
```

### 7.6 Widening primitive conversions

Java can perform many widening conversions automatically because the destination type can represent a broader category of values.

The common integral widening chain is:

```text
byte -> short -> int -> long -> float -> double
```

For `char`:

```text
char -> int -> long -> float -> double
```

Examples:

```java
byte b = 10;
int i = b;
long l = i;
double d = l;
```

No explicit cast is required.

### 7.7 Widening does not always mean exact precision

This is subtle.

A conversion can be a valid widening conversion even when exact numeric precision may be lost.

For example:

```java
long value = 9_007_199_254_740_993L;
double converted = value;
```

The conversion is legal, but `double` may not represent every `long` value exactly.

### 7.8 Narrowing primitive conversions

Moving to a smaller or incompatible primitive type usually requires an explicit cast.

Example:

```java
int value = 130;
byte result = (byte) value;
```

This can lose information.

A cast does not make the conversion safe; it tells the compiler that you accept the conversion.

### 7.9 Special compile-time constant assignments

Java allows some constant integer expressions to be assigned to smaller integral types without a cast when the value fits.

Example:

```java
byte b = 100;
short s = 30_000;
char c = 65;
```

But this does not generally apply to arbitrary runtime values:

```java
int x = 100;
// byte b = x; // compile error without cast
```

### 7.10 Binary numeric promotion

Arithmetic on small integral types often promotes operands to `int`.

Example:

```java
byte a = 10;
byte b = 20;

// byte c = a + b; // compile error
int c = a + b;
```

The expression `a + b` is evaluated as `int`.

This applies to `byte`, `short`, and `char` in many arithmetic expressions.

### 7.11 Promotion with mixed numeric types

A useful mental model for ordinary binary arithmetic is:

- if either operand is `double`, promote the other to `double`;
- otherwise, if either is `float`, promote the other to `float`;
- otherwise, if either is `long`, promote the other to `long`;
- otherwise, both are promoted to `int`.

Examples:

```java
int + long    -> long
long + float  -> float
float + double -> double
byte + byte   -> int
char + short  -> int
```

### 7.12 Why return type does not control expression type

This is critical for Task 1.

```java
long result = intA * intB;
```

The multiplication happens first.

Because both operands are `int`, the multiplication itself is performed as `int`.

Only afterward is the result widened to `long`.

Therefore overflow can already have happened.

To force long arithmetic:

```java
long result = (long) intA * intB;
```

Now one operand is `long`, so binary numeric promotion makes the other operand `long` before multiplication.

### 7.13 Compound assignment has implicit narrowing behavior

This:

```java
byte b = 10;
b += 1;
```

is legal.

But this:

```java
byte b = 10;
// b = b + 1; // compile error
```

is not equivalent from the compiler's type-checking perspective.

The compound assignment performs an implicit conversion back to the left-hand type.

This can hide narrowing and possible information loss, so understand it rather than memorizing the syntax.

### 7.14 Unary numeric promotion

Unary operators such as `+`, `-`, and `~` can promote smaller integral types to `int`.

Example:

```java
byte b = 10;
int x = -b;
```

### 7.15 Primitive width vs actual JVM memory

Do not use this oversimplified rule:

```text
"int always occupies exactly 4 bytes everywhere in memory"
```

The `int` value range is defined as 32-bit signed.

But actual memory use depends on context:

- object fields can be affected by object alignment and padding;
- arrays have object headers plus aligned element storage;
- stack frames are JVM implementation details;
- the JIT may optimize variables away entirely;
- compressed references affect reference size, not primitive widths.

Later JVM modules will examine object layout, stack frames, alignment, compressed ordinary object pointers, escape analysis, and JOL-style inspection in detail.

### 7.16 Conversion map to remember

For automatic widening:

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double

char
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

There is no automatic numeric conversion between `boolean` and numeric types.

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
