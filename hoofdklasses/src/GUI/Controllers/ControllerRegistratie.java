package GUI.Controllers;

import Application.Person;
import DatabaseStuff.ExecuteQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import Application.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ControllerRegistratie implements Initializable {

    @FXML
    private TextField StudentOfHuisbaas;

    @FXML
    private TextField achternaam;

    @FXML
    private TextField email;

    @FXML
    private TextField telefoon;

    @FXML
    private TextField voornaam;
    @FXML
    private ChoiceBox<String> ChoiceBox;
    @FXML
    private TextField username;
    @FXML
    private PasswordField Password;
    @FXML
    private Label message;
    @FXML
    private TextField ContactPerson;


    private String[] keuze = {"student", "landlord"};





    @FXML
    void BtnRegistreren(ActionEvent event) throws SQLException, IOException {

        String password = this.Password.getText();
        String username = this.username.getText();
        String mijnKeuze = ChoiceBox.getValue();
        String voornaam = this.voornaam.getText();
        String acternaam = this.achternaam.getText();
        String telefoon = this.telefoon.getText();
        String email = this.email.getText();
        ExecuteQuery executeQuery = new ExecuteQuery();
        HashMap<String, String> lijst =executeQuery.getUsernameAndPassword(); //hashmap
        if (mijnKeuze.equals("landlord"))
            ContactPerson = null;

        Person persoon;
        boolean flag = true;
        for (String string:lijst.keySet()) {
            if(username.equals(string)) {
                message.setText("Username al in gebruik");
                flag = false;
            }
        }
        if(flag){
            persoon = new Person(voornaam, acternaam, telefoon, email, mijnKeuze ,username, password); //gaat naar database
            executeQuery = new ExecuteQuery();
            executeQuery.setPersoon(persoon.toString());
        }

        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxml/LoginScreen.fxml"));
        stage.setScene(new Scene(root, 550, 400));
        stage.show();
    }

    @FXML
    void btnTerugNaarLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxml/LoginScreen.fxml"));
        stage.setScene(new Scene(root, 550, 400));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> keuze = FXCollections.observableArrayList("Student", "Landlord");
        ChoiceBox.setItems(keuze);
    }
}