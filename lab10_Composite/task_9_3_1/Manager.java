import java.util.ArrayList;
import java.util.List;
public class Manager implements Employee {
    private final String name;
    private final int salary;
    private final List<Employee> subordinates = new ArrayList<>();
    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    public void add(Employee employee) {
        subordinates.add(employee);
    }
    @Override
    public void payExpenses() {
        System.out.println(name + " (Manager) has been paid $" + salary);
        for (Employee e : subordinates) {
            e.payExpenses();
        }
    }
}