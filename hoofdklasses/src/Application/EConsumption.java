package Application;

import DatabaseStuff.ExecuteQuery;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

public class EConsumption {

    private double water;
    private double gas;
    private double eletricity;

    public EConsumption(double water, double gas, double eletricity) {
        this.water = water;
        this.gas = gas;
        this.eletricity = eletricity;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public void setEletricity(double eletricity) {
        this.eletricity = eletricity;
    }

    public void setEconsumption(double water, double gas, double eletricity) throws SQLException {
        EConsumption eConsumption = new EConsumption(water, gas, eletricity);
        ExecuteQuery query = new ExecuteQuery();
        query.getEconsumption(IngelogdePerson.getPerson().getUsername()).add(eConsumption);
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
        return date.getDayOfMonth() == 1;
    }

    public void reminder(LocalDate date){ //reminder voor de landlord
        if (firstOfTheMonth(date))
            System.out.println("Time to update the energy consumption!");
    }

}