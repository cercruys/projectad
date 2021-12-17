package GUI.Controllers;

import Application.IngelogdeStudent;
import Application.Location;
import DatabaseStuff.ExecuteQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ControllerAddLocation {

    @FXML
    private Button addLocationBtn;
    @FXML
    private TextField streetTxt,
            numberTxt,
            cityTxt,
            ZIPtxt;
    @FXML
    private CheckBox insulatedCheckBox;

    String street, city;
    int number, ZIP, insulated;

    public void setStreet(ActionEvent event) {
        street = streetTxt.getText();
    }

    public void setNumber(ActionEvent event) {
        number = Integer.parseInt(numberTxt.getText());
    }

    public void setCity(ActionEvent event) {
        city = cityTxt.getText();
    }

    public void setZIP(ActionEvent event) {
        ZIP = Integer.parseInt(ZIPtxt.getText());
    }

    public void isInsulated(ActionEvent event) {
        if(insulatedCheckBox.isSelected())
            insulated = 1;
        else
            insulated = 0;
    }


    public void addLocation(ActionEvent event) throws SQLException, IOException {
        Location location;
        ExecuteQuery query = new ExecuteQuery();
        location = new Location(street, number, city, ZIP, insulated);
        //wegschrijven naar database

        Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxml/ApparatenBeheer.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
