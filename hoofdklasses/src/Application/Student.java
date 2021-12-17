package Application;

import DatabaseStuff.ExecuteQuery;

import java.sql.SQLException;
import java.util.ArrayList;

public class Student extends Person {

    ArrayList<Appliance> apparaten = new ArrayList<>();
    Person persoon;

    public ArrayList<Appliance> getApparaten() {
        return apparaten;
    }

    public Student(String firstName, String lastName, String TNR, String email, String landlordOfStudent , String username, String password) throws SQLException {
        super(firstName, lastName, TNR, email, landlordOfStudent, username, password);
    }

    public Student(Person persoon) {
        super(persoon);
        this.persoon = persoon;
    }



    public void apparaatToevoegen(Appliance apparaat){
        if (apparaat != null && !apparaten.contains(apparaat)){
            apparaten.add(apparaat);
        }
        else
            System.out.println("Appliance toevoegen lukte niet.");
    }

    public void apparaatVerwijderen(Appliance apparaat){
        if (apparaat != null && apparaten.contains(apparaat)) {
            apparaten.remove(apparaat);
        }
        else
            System.out.println("Appliance verwijderen lukte niet.");
    }

    public int getRoomID() throws SQLException {
        int roomID;
        ExecuteQuery query = new ExecuteQuery();
        roomID = query.getLocationOfStudent(persoon.getUsername()).getRoomID();
        return roomID;
    }




    @Override
    public String getUsername() {
        return persoon.getUsername();
    }


    @Override
    public String toString() {
        return "Student{ persoon=" + persoon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}