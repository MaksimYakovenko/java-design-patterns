public abstract class BeverageFactory {

    public abstract Beverage createBeverage(String type);

    public Beverage orderBeverage(String type) {
        Beverage beverage = createBeverage(type);
        if (beverage != null) {
            System.out.println("Приготування: " + beverage.getName());
            System.out.println("Деталі: " + beverage.getDescription());
        }
        return beverage;
    }
}

