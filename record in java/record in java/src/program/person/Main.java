package program.person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Abdul", 23);
        // we use name() instead of getName() in record
        System.out.println(person.name());
        // we use age() instead of getAge() in record
        System.out.println(person.age());

        Person person2 = new Person("Karim", 100);
        System.out.println(person2.name());
        System.out.println(person2.age());
    }
}
