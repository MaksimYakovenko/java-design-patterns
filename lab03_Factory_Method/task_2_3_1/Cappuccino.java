public class Cappuccino extends Beverage {
    public Cappuccino() {
        super("Капучіно", 22.0, 50.0);
    }

    @Override
    public String getDescription() {
        return "Еспресо з гарячим молоком та пінкою. Компоненти: кавові зерна (7г), молоко (100мл), вода (30мл)";
    }
}

