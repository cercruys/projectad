package Application;

import java.sql.SQLException;

import DatabaseStuff.ExecuteQuery;
import GUI.Controllers.ControllerRegistratie;

public class IngelogdeStudent extends Student {

    private static Student ingelogdeStudent;

    public IngelogdeStudent(String firstName, String lastName, String TNR, String email, String landlordOfStudent, String username, String password) throws SQLException {
        super(firstName, lastName, TNR, email, landlordOfStudent, username, password);
    }




    public static Student getIngelogdeStudent() throws SQLException {
        return ingelogdeStudent;
    }

    public static void setIngelogdeStudent(Student ingelogdeStudent) {
        IngelogdeStudent.ingelogdeStudent = ingelogdeStudent;
    }

}