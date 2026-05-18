public class ExpensesClient {
    public static void main(String[] args) {
        Manager meatManager = new Manager("Alice", 1500);
        meatManager.add(new Salesperson("Bob", 900));
        meatManager.add(new Salesperson("Charlie", 850));
        meatManager.add(new Salesperson("Diana", 800));
        SalesTeam meatDept = new SalesTeam("Meat Department");
        meatDept.add(meatManager);
        Manager dairyManager = new Manager("Eve", 1500);
        dairyManager.add(new Salesperson("Frank", 900));
        dairyManager.add(new Salesperson("Grace", 870));
        dairyManager.add(new Salesperson("Hank", 820));
        SalesTeam dairyDept = new SalesTeam("Dairy Department");
        dairyDept.add(dairyManager);
        Manager confManager = new Manager("Ivan", 1500);
        confManager.add(new Salesperson("Julia", 910));
        confManager.add(new Salesperson("Kevin", 880));
        confManager.add(new Salesperson("Laura", 860));
        SalesTeam confDept = new SalesTeam("Confectionery Department");
        confDept.add(confManager);
        Manager director = new Manager("Director John", 5000);
        director.add(meatDept);
        director.add(dairyDept);
        director.add(confDept);
        System.out.println("=== Supermarket Payroll ===");
        payExpenses(director);
    }
    private static void payExpenses(Employee employee) {
        System.out.println("Expenses have been requested");
        employee.payExpenses();
        System.out.println("Expenses have been paid");
    }
}
