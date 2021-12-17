package Application;

import DatabaseStuff.ExecuteQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Location {

    private String street;
    private Double area;
    private int roomID;
    private int insulated;
    private ArrayList<Appliance> appliances;
    private HashMap<Appliance,ArrayList<Action>> actionsPerAppliance;
    private int strNumber;
    private int zip;
    private String city;
    private String buildingType;
    private String SUsername, LUsername;
    private EConsumption consumption;


    public Location(int roomID,String buildingtype, int insulated,  int strNumber, String street, int zip, String city, Double area, String SUsername, String LUsername) {
        this.street = street;
        this.roomID = roomID;
        appliances = new ArrayList<>();
        this.area = area;
        this.buildingType = buildingtype;
        this.city = city;
        this.insulated = insulated;
        this.zip = zip;
        this.LUsername = LUsername;
        this.SUsername = SUsername;
        actionsPerAppliance = new HashMap<>();

    }

    public Location(String street, int strNumber, String city, int zip, int insulated){
        this.street = street;
        this.strNumber = strNumber;
        this.city = city;
        this.zip = zip;
        this.insulated = insulated;
    }

    public EConsumption getConsumption() {
        return consumption;
    }

    public void setConsumption(EConsumption consumption) {
        this.consumption = consumption;
    }

    public HashMap<Appliance, ArrayList<Action>> getActionsPerAppliance() {
        return actionsPerAppliance;
    }
    public void existsAppliance(Appliance appliance) throws ApplianceException {
        if(appliance==null)
            throw new ApplianceException("This appliance does not exist!");
    }

    private boolean apExists(Appliance appliance) throws ApplianceException {
        if (appliance == null)
            throw new ApplianceException("This appliance does not exist!");
        else
            return true;
    }

    public void addAppliance(Appliance appliance) throws ApplianceException {
        existsAppliance(appliance);
        for(Appliance appliance1: actionsPerAppliance.keySet()){
            if(appliance1.getApName().equals(appliance.getApName())){
                throw new ApplianceException("Appliance is already added!");
            }
        }
        actionsPerAppliance.put(appliance, new ArrayList<>());
        actionsPerAppliance.get(appliance).addAll(appliance.getactions());
    }

    public void removeAppliance(Appliance appliance) throws ApplianceException {
        existsAppliance(appliance);
        if(actionsPerAppliance.containsKey(appliance))
            actionsPerAppliance.remove(appliance);
        else
            throw new ApplianceException("Appliance is not in list!");
    }

    public ArrayList<Appliance> getAppliancesForLocation(){
        return new ArrayList<>(actionsPerAppliance.keySet());
    }
    public ArrayList<Action> getActionsForAppliance(Appliance appliance) throws ApplianceException {
        existsAppliance(appliance);
        return actionsPerAppliance.get(appliance);
    }
    public double calculateConsumptionRoom(){
        double result=0;
        for(Appliance appliance: actionsPerAppliance.keySet()){
            result += appliance.getEel().getKwhAnnum();
        }
        return result;
    }


    public void addAp(Appliance appliance) throws ApplianceException {
        apExists(appliance);
        if (appliances.contains(appliance))
            throw new ApplianceException("This appliance is already listed!");
        else
            appliances.add(appliance);
    }

    public void removeAp(Appliance appliance) throws ApplianceException{
        apExists(appliance);
        if (!appliances.contains(appliance))
            throw new ApplianceException("This appliance is not on the list!");
        else
            appliances.remove(appliance);
    }

    public String getSUsername() {
        return SUsername;
    }

    public String getLUsername() {
        return LUsername;
    }

    public String getAdress() {
        return street;
    }

    public double getArea() {
        return area;
    }

    public int getRoomID() {
        return roomID;
    }

    public int isInsulated() {
        return insulated;
    }

    public ArrayList<Appliance> getAppliances() {
        ExecuteQuery executeQuery = new ExecuteQuery();
        System.out.println("ExecuteQuery object was made");
        ArrayList<Appliance> list = new ArrayList<>();
        try {
            list = executeQuery.getAlleApparaten(getRoomID()); //1 vervangen door RoomID
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return roomID == location.roomID;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", area=" + area +
                ", roomID=" + roomID +
                ", insulated=" + insulated +
                ", appliances=" + appliances +
                ", strNumber=" + strNumber +
                ", zip=" + zip +
                ", city='" + city + '\'' +
                ", buildingType='" + buildingType + '\'' +
                ", SUsername='" + SUsername + '\'' +
                ", LUsername='" + LUsername + '\'' +
                '}';
    }
    public String appliancesToString(){
        String print="";
        int i=1;
        for(Appliance appliance: getAppliancesForLocation()){
            print+=i+") "+appliance.getApName()+"\n";
            i++;
        }
        return print;
    }
}