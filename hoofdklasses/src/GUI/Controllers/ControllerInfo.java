package GUI.Controllers;

import Application.IngelogdePerson;
import Application.IngelogdeStudent;
import Application.Person;
import DatabaseStuff.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class ControllerInfo implements Initializable {

    @FXML
    private Button homePageBtn;

    @FXML
    private Label firstNameLabel,
            userNameLabel,
            telephoneNrLabel,
            emailLabel,
            lastNameLabel,
            userTypeLabel;

    Person person;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExecuteQuery query = new ExecuteQuery();
        try {
            person = query.getPerson(IngelogdePerson.getPerson().getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        firstNameLabel.setText(person.getFirstName());
        lastNameLabel.setText(person.getLastName());
        userNameLabel.setText(person.getUsername());
        telephoneNrLabel.setText(person.getTNR());
        emailLabel.setText(person.getEmail());
        userTypeLabel.setText(person.getLandlordOfStudent());

    }

    public void backToHome(ActionEvent event) throws IOException {
        Parent root;

        //bepalen welk homescherm
        if(person.getLandlordOfStudent().equalsIgnoreCase("Student")) {
            root = FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeStudent.fxml"));
        }
        else
            root = FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeLandlord.fxml"));

        //homescherm laden
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
