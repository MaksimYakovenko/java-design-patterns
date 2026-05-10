package com.mobile.Legacy;

public class MobilePhone {
    private int chargingPercent = 0;
    private MicroUsbCharger charger = null;

    public int getChargingPercent() {
        return chargingPercent;
    }

    public void pluginCharger(MicroUsbCharger charger) {
        this.charger = charger;
        System.out.println("plugin legacy charger!");
    }

    public void unplugCharger() {
        System.out.println("unplug legacy charger!");
        this.charger = null;
    }

    public void charge(int time) {
        if (charger == null) {
            System.out.println("Plugin micro-USB charger");
            return;
        }
        float timeH = time / 9.0f;
        int percent = chargingPercent + (int) (charger.getOutputVoltage() * charger.getOutputAmperage() * timeH);
        chargingPercent = Math.min(percent, 100);
    }
}

