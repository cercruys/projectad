package Application;

import DatabaseStuff.ExecuteQuery;

import java.sql.SQLException;
import java.util.ArrayList;

public class Person {

    private String FirstName;
    private String LastName;
    private String TNR; //telefoonnummer
    private String Email;
    private String Username;
    private String Password;
    private String LandlordOfStudent;
    private Person person;

    public Person(String firstName, String lastName, String TNR, String email,String landlordOfStudent ,String username, String password) throws SQLException {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.TNR = TNR;
        this.Email = email;
        this.Username = username;
        this.Password = password;
        this.LandlordOfStudent = landlordOfStudent;
    }

    public Person(Person person) {
        this.person = person;
    }


    public boolean PersonExists(){
        ExecuteQuery executeQuery = new ExecuteQuery();
        return true;
    }

    public Person getPerson(Person person){
        return person;
    }

    public String getPassword() {
        return Password;
    }

    public String getUsername() {
        return Username;
    }

    public String getLandlordOfStudent() {
        return LandlordOfStudent;
    }

    @Override
    public String toString() {
        return getFirstName()+ " " + getLastName()+ " " +getTNR()+ " " + getEmail()+ " "+ getLandlordOfStudent()+ " " + getUsername()+ " " + getPassword();
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getTNR() {
        return TNR;
    }

    public String getEmail() {
        return Email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setTNR(String TNR) {
        this.TNR = TNR;
    }

    public void setEmail(String email) {
        Email = email;
    }


}