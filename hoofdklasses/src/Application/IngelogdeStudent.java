package Application;

import java.sql.SQLException;

public class IngelogdeStudent extends Student {

    private static Student ingelogdeStudent;

    public IngelogdeStudent(String firstName, String lastName, String TNR, String email, String landlordOfStudent, String username, String password) throws SQLException {
        super(firstName, lastName, TNR, email, landlordOfStudent, username, password);
    }

    public static Student getIngelogdeStudent() {
        return ingelogdeStudent;
    }

    public static void setIngelogdeStudent(Student ingelogdeStudent) {
        IngelogdeStudent.ingelogdeStudent = ingelogdeStudent;
    }
}