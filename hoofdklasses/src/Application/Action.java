package Application;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Action {
    private Date actionDatum;
    private String actionNR;
    private EnergyConservationAction option;
    private String description;
    int nr=1;

    public Action(Date actionDatum, EnergyConservationAction option) {
        this.actionDatum = actionDatum;
        this.option = option;
        actionNR="Action-"+nr;
        nr++;
    }

    public Action(Date actionDate) {
        actionDatum = actionDate;
    }

    public Action(Date actionDate, String otherAction){
        description = otherAction;
        this.actionDatum = actionDate;
    }

    public Date getactionDatum() {
        return actionDatum;
    }

    public void setactionDatum(Date actionDatum) {
        this.actionDatum = actionDatum;
    }

    public EnergyConservationAction getoption() {
        return option;
    }

    public void setoption(EnergyConservationAction option) {
        this.option = option;
    }

    public String getactionNR() {
        return actionNR;
    }
}
