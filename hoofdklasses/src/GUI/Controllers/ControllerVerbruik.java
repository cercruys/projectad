package GUI.Controllers;

import Application.IngelogdePerson;
import Application.Person;
import DatabaseStuff.ExecuteQuery;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import Application.EConsumption;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerVerbruik implements Initializable {

    @FXML
    private TextField waterCons, gasCons, elecCons;
    @FXML
    private Button generateChartBtn;
    @FXML
    private PieChart consumptionChart;
    @FXML
    private Label warningLabel;

    private double
            water,
            gas,
            electricity;

    Person person;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        ExecuteQuery query = new ExecuteQuery();

        //persoon ophalen in database
        try {
            person = query.getPerson(IngelogdePerson.getPerson().getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //initializeren waardes
        try {
            EConsumption eConsumption;
            eConsumption = query.getEconsumption(url.getQuery()).get(0);

            water = eConsumption.getWater();
            gas = eConsumption.getGas();
            electricity = eConsumption.getEletricity();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //waardes weergeven in txtfield
        if(water > 0 && gas > 0 && electricity > 0) {
            waterCons.setText(String.valueOf(water));
            gasCons.setText(String.valueOf(gas));
            elecCons.setText(String.valueOf(electricity));
        }
        else
            warningLabel.setText("Put in positive values!");

    }

    public void generateChart(ActionEvent event) {
        //data genereren en piechart opstellen
        ObservableList<PieChart.Data> verbruikData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Water", Double.parseDouble(waterCons.getText())),
                        new PieChart.Data("Gas", Double.parseDouble(gasCons.getText())),
                        new PieChart.Data("Electricity", Double.parseDouble(elecCons.getText()))
                );
        verbruikData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(data.getName())
                ));

        consumptionChart.getData().addAll(verbruikData);
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
