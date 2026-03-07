public abstract class Beverage {
    protected String name;
    protected double costPrice;
    protected double sellingPrice;

    public Beverage(String name, double costPrice, double sellingPrice) {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getProfit() {
        return sellingPrice - costPrice;
    }

    public abstract String getDescription();

    @Override
    public String toString() {
        return String.format("%s - Собівартість: %.2f грн, Ціна: %.2f грн, Прибуток: %.2f грн",
                name, costPrice, sellingPrice, getProfit());
    }
}

