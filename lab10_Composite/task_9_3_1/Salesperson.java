public class Salesperson implements Employee {
    private final String name;
    private final int salary;
    public Salesperson(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
    @Override
    public void payExpenses() {
        System.out.println(name + " (Salesperson) has been paid $" + salary);
    }
}