package GUI.Controllers;

import Application.IngelogdeHuisbaas;
import Application.IngelogdePerson;
import Application.Location;
import DatabaseStuff.ExecuteQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerKotBeheer implements Initializable {

    @FXML
    private Label warningLabel1,
            warningLabel2,
            warningLabel3;


    @FXML
    private CheckBox insulatedCheck;
    @FXML
    private TextField streetTxt,
            numberTxt,
            cityTxt,
            zipTxt;
    @FXML
    private Button addLocationBtn,
            removeLocationBtn,
            homepageBtn;
    @FXML
    private ListView locationList;

    ArrayList<Location> locations;
    String street, city;
    int number, ZIP, insulated;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ExecuteQuery query = new ExecuteQuery();
        try {
            locations = query.getLocationsOfLandlord(IngelogdeHuisbaas.getIngelogdeHuisbaas().getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Location> locationData = FXCollections.observableArrayList(locations);
        locationList.setItems(locationData);
    }


    public void addLocation(ActionEvent event) throws SQLException {
        ExecuteQuery query = new ExecuteQuery();
        if (streetTxt.getText().equals("")
                || numberTxt.getText().equals("")
                || cityTxt.getText().equals("")
                || zipTxt.getText().equals("")){
            warningLabel1.setText("Please enter ALL values");
            warningLabel2.setText("To add location");
        }
        else{
            Location location = new Location(street, number, city, ZIP, insulated);
            query.getLocationsOfLandlord(IngelogdePerson.getPerson().getUsername()).add(location);
        }
    }

    public void removeLocation(ActionEvent event) throws SQLException {
        ExecuteQuery query = new ExecuteQuery();
        Location removeLocation = (Location) locationList.getSelectionModel().getSelectedItem();
        if (locations.contains(removeLocation))
            query.getLocationsOfLandlord(IngelogdePerson.getPerson().getUsername()).remove(removeLocation);
        else
            warningLabel3.setText("This location is not on the list");

    }

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
        ZIP = Integer.parseInt(zipTxt.getText());
    }

    public void isInsulated(ActionEvent event) {
        if(insulatedCheck.isSelected())
            insulated = 1;
        else
            insulated = 0;
    }


    public void toHomepage(ActionEvent event) throws IOException {
        //home student openen
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeLandlord.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
