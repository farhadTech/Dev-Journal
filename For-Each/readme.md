# Java For-Each Loop (Enhanced For Loop)

In Java, the `for-each` loop (also called the enhanced `for` loop) is used to iterate over arrays and collections like `ArrayList`, `HashSet`, and `HashMap`. It simplifies iteration by eliminating the need for an explicit index or iterator.

## Syntax:
```java
for (Type variable : collection) {
  // code to be executed
}
```
- **Type** → The data type of elements in the collection.
- **variable** → A temporary variable that holds each element in each iteration.
- **collection** → The array or collection to iterate over.

---

## Example 1: Iterating Over an Array
```java
public class ForEachExample {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};

    for (int num : numbers) {
      System.out.println(num);
    }
  }
}
```
**Output:**
```
1
2
3
4
5
```

---

## Example 2: Iterating Over an ArrayList
```java
import java.util.ArrayList;

public class ForEachListExample {
  public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("Alice");
    names.add("Bob");
    names.add("Charlie");

    for (String name : names) {
      System.out.println(name);
    }
  }
}
```
**Output:**
```
Alice
Bob
Charlie
```

---

## Example 3: Iterating Over a HashMap
When working with a `HashMap`, we can use a `for-each` loop with `entrySet()`, `keySet()`, or `values()`.
```java
import java.util.HashMap;

public class ForEachMapExample {
  public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();
    map.put("Alice", 25);
    map.put("Bob", 30);
    map.put("Charlie", 22);

    for (var entry : map.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }
  }
}
```
**Output:**
```
Alice : 25
Bob : 30
Charlie : 22
```

---

## Limitations of the For-Each Loop
1. **No access to the index** → You cannot modify or track indices directly.
2. **Cannot modify the collection while iterating** → If you try to remove elements, you'll get `ConcurrentModificationException`.

---

## Comparison: For-Each vs Traditional For Loop
The `for-each` loop simplifies iteration but lacks some features of a traditional `for` loop.

### 1. Iterating Over an Array
✅ **Using `for-each` (Simpler & Readable)**
```java
public class ForEachArray {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        for (int num : numbers) {
            System.out.println(num);
        }
    }
}
```
**Output:**
```
10
20
30
40
```

🔄 **Using Traditional `for` Loop (More Control)**
```java
public class ForLoopArray {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
    }
}
```
**Output:**
```
Index 0: 10
Index 1: 20
Index 2: 30
Index 3: 40
```
✅ **Use Traditional `for` If:**
- You need the **index** of the element.
- You want to **modify elements** in an array.

---

### 2. Modifying Elements in an Array
🔴 **`for-each` CANNOT modify elements (only modifies the copy):**
```java
public class ForEachModify {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        for (int num : numbers) {
            num += 5;  // Modifying num, but does NOT change array
        }

        System.out.println(numbers[0]);  // Still 10
    }
}
```

✅ **Using Traditional `for` to Modify Elements:**
```java
public class ModifyArray {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] += 5;  // Modifies original array
        }

        System.out.println(numbers[0]);  // 15
    }
}
```
✅ **Use Traditional `for` If:**
- You need to **change the original array**.

---

### Summary: When to Use Which Loop?
| Feature                | `for-each` Loop ✅ | Traditional `for` Loop ✅ |
|------------------------|------------------|------------------|
| Simple and readable ✅  | ✅ Yes | ❌ No |
| Need index access ❌   | ❌ No | ✅ Yes |
| Modify array elements ❌  | ❌ No (modifies copy) | ✅ Yes (modifies original) |
| Remove elements safely ❌ | ❌ No (causes error) | ✅ Yes (use `Iterator` or manual loop) |
| Works with arrays ✅ | ✅ Yes | ✅ Yes |
| Works with `ArrayList` ✅ | ✅ Yes | ✅ Yes |
| Works with `HashMap` ✅ | ✅ Yes (`entrySet()`) | ✅ Yes (`keySet()` + `get()`) |

---

## Conclusion
✅ **Use `for-each`** when you just need to iterate and read values.
✅ **Use `for` or `Iterator`** when you need to modify, remove, or track indices.

Would you like to see more advanced cases or specific use cases? 😊

