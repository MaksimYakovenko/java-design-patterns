public class Engine implements Cloneable {
    private double power; // Потужність (к.с.)
    private double displacement; // Робочий об'єм (л)
    private double torque; // Крутний момент (Нм)
    private String fuelType; // Тип пального (бензин, дизель, електро, гібрид)

    public Engine(double power, double displacement, double torque, String fuelType) {
        this.power = power;
        this.displacement = displacement;
        this.torque = torque;
        this.fuelType = fuelType;
    }

    @Override
    public Engine clone() {
        try {
            return (Engine) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return String.format("Engine{power=%.1f к.с., displacement=%.1f л, torque=%.1f Нм, fuelType='%s'}",
                power, displacement, torque, fuelType);
    }

    public double getPower() { return power; }
    public double getDisplacement() { return displacement; }
    public double getTorque() { return torque; }
    public String getFuelType() { return fuelType; }

    public void setPower(double power) { this.power = power; }
    public void setDisplacement(double displacement) { this.displacement = displacement; }
    public void setTorque(double torque) { this.torque = torque; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
}

