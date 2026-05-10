public class Vehicle {
    protected String model;
    protected int age;
    protected float damaged; // від 0.0 до 1.0 (0% - 100%)
    protected int mileage;

    public Vehicle(String model, int age, float damaged, int mileage) {
        this.model = model;
        this.age = age;
        this.damaged = damaged;
        this.mileage = mileage;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

    public float getDamaged() {
        return damaged;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return String.format("%s (age=%d, damaged=%.2f, mileage=%d)", model, age, damaged, mileage);
    }
}

