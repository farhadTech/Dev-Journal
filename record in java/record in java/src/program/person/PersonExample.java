package program.person;

import java.util.Objects;

/** A Regular Class: Without using record **/
public class PersonExample {
    public String name;
    public int age;

    public PersonExample(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonExample person = (PersonExample) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + "}";
    }
}
/*
Lines of code: ~30
Boilerplate: A lot! Especially for equals, hashCode, toString, getters, and constructor.Override
 */
