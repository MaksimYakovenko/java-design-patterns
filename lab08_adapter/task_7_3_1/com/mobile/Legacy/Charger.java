package com.mobile.Legacy;

public class Charger implements MicroUsbCharger {
    private final float voltage;
    private final float amperage;

    public Charger(float voltage, float amperage) {
        this.voltage = voltage;
        this.amperage = amperage;
    }

    @Override
    public float getOutputVoltage() {
        return voltage;
    }

    @Override
    public float getOutputAmperage() {
        return amperage;
    }
}

