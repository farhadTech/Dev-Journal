package program.person;

/** record version: Person with a record class */

public record Person(String name, int age) {
    public Person {
        if(age < 0 || age > 100) {
            throw new IllegalArgumentException("Age must be between 0 and 100");
        }
    }
    public String displayName() {
        return name.toUpperCase();
    }
}


/**
 * Lines of code: 1
 * Boiler plate gone java generates everything for us.
 **/
