package Application;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EConsumption {

    private double water;
    private double gas;
    private double eletricity;

    public EConsumption(double water, double gas, double eletricity) {
        this.water = water;
        this.gas = gas;
        this.eletricity = eletricity;
    }

    public double getWater() {
        return water;
    }

    public double getGas() {
        return gas;
    }

    public double getEletricity() {
        return eletricity;
    }

    public String getEConsumption() { //toont voor alle afzonderlijke aspecten het verbruik
        String s = "";
        s += "Water: " + water + " m3 \n";
        s += "Gas: " + gas + " kWh \n";
        s += "Electricity: " + eletricity + " kWh \n";
        return s;
    }

    public boolean firstOfTheMonth(LocalDate date){ //methode checkt of het de eerste van de maand is
        if (date.getDayOfMonth() == 01)
            return true;
        else
            return false;
    }

    public void reminder(LocalDate date){ //reminder voor de landlord
        if (firstOfTheMonth(date))
            System.out.println("Time to update the energy consumption!");
    }

}