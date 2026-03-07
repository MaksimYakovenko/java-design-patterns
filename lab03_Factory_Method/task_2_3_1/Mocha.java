public class Mocha extends Beverage {
    public Mocha() {
        super("Мокачіно", 28.0, 60.0);
    }

    @Override
    public String getDescription() {
        return "Кава з молоком та шоколадом. Компоненти: кавові зерна (7г), молоко (120мл), шоколадний сироп (20мл), вода (30мл)";
    }
}

