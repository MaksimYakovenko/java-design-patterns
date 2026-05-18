import java.util.ArrayList;
import java.util.List;
public class SalesTeam implements Employee {
    private final String name;
    private final List<Employee> members = new ArrayList<>();
    public SalesTeam(String name) { this.name = name; }
    public void add(Employee e) { members.add(e); }
    @Override
    public void payExpenses() {
        System.out.println("--- Department: " + name + " ---");
        for (Employee e : members) { e.payExpenses(); }
    }
}
