# var in Java (Local Variable Type Inference)

In Java 10, the `var` keyword was introduced to allow local variable type inference. This means the compiler automatically determines the type of a variable based on the value assigned to it. It helps reduce verbosity while maintaining strong type checking.

## ✅ Syntax:
```java
var variableName = value;
```
The type of `variableName` is inferred from `value` at compile time.

## 🔥 Example 1: Using `var` in a Method
```java
public class VarExample {
    public static void main(String[] args) {
        var message = "Hello, Java!";
        var number = 42;

        System.out.println(message); // Hello, Java!
        System.out.println(number);  // 42
    }
}
```
Here, the compiler automatically infers `message` as a `String` and `number` as an `int`.

## 📌 Rules and Restrictions
- **Only for local variables**: `var` can be used inside methods, blocks, and loops, but **not** for class fields or method parameters.
- **Must be initialized**: `var` requires an initializer; you **cannot** declare `var` without assigning a value.

```java
var x; // ❌ Compilation Error: Cannot infer type for local variable
```
- **Cannot be `null` without an explicit type**:

```java
var data = null; // ❌ Error: Cannot infer type from `null`
```
You must specify a type explicitly:

```java
String data = null; // ✅ Works fine
```
- **Cannot be used with Lambda Expressions**:

```java
var func = () -> System.out.println("Hello"); // ❌ Error
```

## 🏆 Example 2: Using `var` with Loops
```java
import java.util.List;

public class VarLoopExample {
    public static void main(String[] args) {
        var list = List.of("Apple", "Banana", "Cherry");

        for (var fruit : list) {
            System.out.println(fruit);
        }
    }
}
```
✅ The `var` keyword infers `list` as `List<String>` and `fruit` as `String`.

## 🚀 Example 3: Using `var` with Collections
```java
import java.util.HashMap;

public class VarMapExample {
    public static void main(String[] args) {
        var map = new HashMap<String, Integer>();
        map.put("Alice", 25);
        map.put("Bob", 30);

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
```
✅ The `var` keyword infers `map` as `HashMap<String, Integer>` and `entry` as `Map.Entry<String, Integer>`.

## ❌ When NOT to Use `var`
### When it reduces readability:
```java
var x = processData(); // ❌ What type is `x`?
```
Instead, prefer:
```java
String x = processData(); // ✅ Clearer
```

### When declaring fields in a class:
```java
class Person {
    var name; // ❌ Error: Cannot use `var` for instance fields
}
```

## 🔥 Comparison: `var` vs Explicit Types
| Feature          | `var` ✅                        | Explicit Type ✅ |
|-----------------|--------------------------------|----------------|
| Less verbose   | ✅ Yes                          | ❌ No |
| Type clarity   | ❌ Less clear (sometimes)       | ✅ More readable |
| IDE Autocomplete | ✅ Works fine                  | ✅ Works fine |
| Works for fields | ❌ No                          | ✅ Yes |
| Works for loops | ✅ Yes                          | ✅ Yes |

## 🎯 Conclusion
✅ Use `var` when it improves readability and reduces redundancy.
❌ Avoid `var` when it makes code harder to understand.

