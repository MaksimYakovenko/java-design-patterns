public class CoffeeShopFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "espresso":
            case "еспресо":
                return new Espresso();
            case "americano":
            case "американо":
                return new Americano();
            case "cappuccino":
            case "капучіно":
                return new Cappuccino();
            case "latte":
            case "латте":
                return new Latte();
            case "mocha":
            case "мокачіно":
                return new Mocha();
            case "flatwhite":
            case "флет вайт":
                return new FlatWhite();
            case "macchiato":
            case "макіато":
                return new Macchiato();
            default:
                System.out.println("Невідомий тип напою: " + type);
                return null;
        }
    }
}

