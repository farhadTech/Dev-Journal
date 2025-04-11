
# Set in Java

A **Set** is a collection that contains no duplicate elements. It models the mathematical set abstraction and is part of the **Java Collections Framework**.

## 🔑 Key Characteristics of a Set

- ✅ **No Duplicates**: Automatically ignores duplicate elements.
- 🔄 **Unordered** (in most implementations): Does not guarantee the order of elements.
- ⚡ **Efficient Operations**: Depending on the implementation, operations like `add`, `remove`, and `contains` can be very fast.

## 📦 Set Interface & Its Implementations

Set is an interface in the `java.util` package:

```java
public interface Set<E> extends Collection<E>
```

## 🧪 How to Use Set in Java?

### Example with `HashSet`

```java
import java.util.*;

public class SetExample {
  public static void main(String[] args) {
    Set<String> fruits = new HashSet<>();

    // Adding elements (duplicate will be ignored)
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Orange");
    fruits.add("Banana");

    // Display elements
    System.out.println("Fruits: " + fruits);

    // Check if contains/present
    System.out.println("Contains Apple? " + fruits.contains("Apple"));

    // Remove an element
    fruits.remove("Orange");

    // Size of set
    System.out.println("Size: " + fruits.size());

    // Iterate using for-each loop
    for (String fruit : fruits) {
      System.out.println(fruit);
    }

    /** Iteration Techniques **/
    Set<String> names = new HashSet<>();

    // For-each loop
    for (String name : names) {
      System.out.print(name);
    }

    // Iterator
    Iterator<String> it = names.iterator();
    while(it.hasNext()) {
      System.out.print(it.next());
    }

    // Lambda expression
    names.forEach(name -> System.out.print(name));
  }
}
```

### Creating a Set from an Existing Collection

This creates a new `HashSet` object that contains all the **unique** elements in the list:

```java
List<String> myList = new ArrayList<>();
// Add some elements to the list
Set<String> mySet = new HashSet<>(myList);
```

### Set Operations
```java
Set<Integer> hashSet1 = new HashSet<>();
hashSet1.add(7);
hashSet1.add(4);
hashSet1.add(2);
hashSet1.add(6);
hashSet1.add(9);
hashSet1.add(1);

Set<Integer> hashSet2 = new HashSet<>();
hashSet2.add(1);
hashSet2.add(6);

// Union
hashSet1.addAll(hashSet2);

// Intersection
hashSet1.retainAll(hashSet2);

// difference
hashSet1.removeAll(hashSet2);

// subset
boolean isSubset = hashSet1.containsAll(hashSet2);
System.out.print(isSubset);
```

# Java Set Interface & Implementations

## Interface Hierarchy

```
             ┌────────────┐
             │   Set<E>   │
             └─────┬──────┘
                   │
        ┌──────────┴──────────┐
        │                     │
   ┌────▼────┐          ┌─────▼─────┐
   │ HashSet │          │ SortedSet │
   └────┬────┘          └─────┬─────┘
        │                     │
 ┌──────▼─────────┐     ┌─────▼────┐
 │ LinkedHashSet  │     │ TreeSet  │
 └────────────────┘     └──────────┘
```

## Types of Set Implementations

### 1. HashSet – Most Common

- Unordered collection (no guaranteed order)
- Allows 1 null
- Backed by a HashMap
- Best for fast lookups, insertions, deletions

```java
Set<String> countries = new HashSet<>();
countries.add("India");
countries.add("USA");
countries.add("Dubai");
countries.add("Singapore");
countries.add("France");
countries.add("Italy");
countries.add("USA"); // duplicate ignored

// removing an element
countries.remove("Italy");
```

---

### 2. LinkedHashSet – Maintains Insertion Order

- Maintains the order in which elements are inserted
- Good when order matters
- Slightly slower than HashSet

```java
Set<String> countries = new LinkedHashSet<>();
countries.add("India");
countries.add("USA");
countries.add("Dubai");
countries.add("Singapore");
countries.add("France");
countries.add("Italy");
countries.add("USA");
countries.add("Germany");

countries.remove("Dubai");
System.out.print("Size of LinkedHashSet: " + countries.size());
System.out.print("First element of the set: " + countries.first());
System.out.print("Last element of the set: " + countries.last());
System.out.print("Add first in the set: ");
countries.addFirst("SA");
System.out.print("Add last in the set: ");
countries.addLast("Bangladesh");
System.out.print("Reverse the set: " + countries.reverse());
System.out.print("Remove first from the set: ");
countries.removeFirst();
System.out.print("Remove last from the set: ");
countries.removeLast();

Iterator<String> it = countries.iterator();
while(iterator.hasNext()) {
  String countries = iterator.next();
  System.out.print(countries.toUpperCase());
}
```

#### Set Operations

```java
Set<Integer> linkedHashSet = new LinkedHashSet<>();
linkedHashSet.add(7);
linkedHashSet.add(4);
linkedHashSet.add(2);
linkedHashSet.add(6);
linkedHashSet.add(9);
linkedHashSet.add(1);

Set<Integer> linkedHashSet2 = new LinkedHashSet<>();
linkedHashSet2.add(1);
linkedHashSet2.add(6);

// Union
linkedHashSet1.addAll(linkedHashSet2);

// Intersection
linkedHashSet1.retainAll(linkedHashSet2);

// Difference
linkedHashSet1.removeAll(linkedHashSet2);

// Subset
boolean isSubset = linkedHashSet1.containsAll(linkedHashSet2);
System.out.print(isSubset);
```

---

### 3. TreeSet

- Keeps elements in natural sorted order (e.g., ascending for numbers, alphabetical for strings)
- Implements NavigableSet and SortedSet
- Doesn't allow nulls
- Backed by a Red-Black Tree
- Slower than HashSet, but great for range queries and ordered data

```java
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(50);
treeSet.add(10);
treeSet.add(30);

System.out.print(treeSet); // [10, 30, 50]
```
