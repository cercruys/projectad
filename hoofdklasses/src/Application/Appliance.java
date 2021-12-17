package Application;
import java.util.ArrayList;

public class Appliance {
    private String apName;
    private String apID;
    private EEL eel;
    private String eec;
    private int kwh, roomID;
    private int nr=1;
    private ArrayList<Action> actions;

    public Appliance(String apName, EEL eel) {
        apID="Appliance-"+nr;
        this.apName = apName;
        this.eel = eel;
        nr++;
        actions = new ArrayList<>();
    }

    public Appliance(String apName, String eec, int kwh, int roomID){
        apID = "Appliance-" + nr;
        this.apName = apName;
        this.eec = eec;
        this.kwh = kwh;
        this.roomID = roomID;
        nr++;
        actions = new ArrayList<>();
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public EEL getEel() {
        return eel;
    }

    public void setEel(EEL eel) {
        this.eel = eel;
    }

    public String getApID() {
        return apID;
    }

    public ArrayList<Action> getactions() {
        return actions;
    }

    public void existAction(Action action) throws ApplianceException {
        if(action==null)
            throw new ApplianceException("This action does not exist!");
    }
    public boolean containsAction(Action action) throws ApplianceException {
        existAction(action);
        for(Action action1 : actions){
            if(action1.getoption().equals(action.getoption()))
                return true;
        }
        return false;
    }
    private void addAction(Action action) throws ApplianceException {
        existAction(action);
        if(containsAction(action))
            throw new ApplianceException("Action is already added!");
        else
            actions.add(action);
    }
    private void removeAction(Action action) throws ApplianceException {
        existAction(action);
        if(containsAction(action))
            actions.remove(action);
        else
            throw new ApplianceException("List does not contain action!");
    }

    public void setEEC(String eec) {
        this.eec = eec;
    }

    public void setKWH(int kwh) {
        this.kwh = kwh;
    }

    public String getEEC() {
        return eec;
    }

    public int getKWH() {
        return kwh;
    }

    public int getRoomid() {
        return roomID;
    }


}