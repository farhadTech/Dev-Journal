class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        var emp = new Employee("Alice", 50000);
        System.out.println(emp.name + " earns " + emp.salary);
    }
}
