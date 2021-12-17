package GUI.Controllers;

import Application.EConsumption;

import DatabaseStuff.ExecuteQuery;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerVerbruikHuisbaas implements Initializable {

    @FXML
    private PieChart pieChartVerbruik;
    @FXML
    private TextField waterTxt;
    @FXML
    private TextField gasTxt;
    @FXML
    private TextField electricityTxt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        ExecuteQuery query = new ExecuteQuery();
        try {
            // variabelen initializeren
            EConsumption econsumption = query.getEconsumption(url.getQuery()).get(0);
            double water = econsumption.getWater();
            double gas = econsumption.getGas();
            double electricity = econsumption.getEletricity();

            //tekstfields invullen om te gebruiken voor piechart
            waterTxt.setText(String.valueOf(water));
            gasTxt.setText(String.valueOf(gas));
            electricityTxt.setText(String.valueOf(electricity));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void generateChart(ActionEvent event) {

        //Data inlezen obv ingevulde textfields
        ObservableList<PieChart.Data> verbruikData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Water", Double.parseDouble(waterTxt.getText())),
                        new PieChart.Data("Gas", Double.parseDouble(gasTxt.getText())),
                        new PieChart.Data("Electricity", Double.parseDouble(electricityTxt.getText()))
                );

        //namen zetten bij piechart
        verbruikData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(data.getName())
                ));

        //data toevoegen aan piechart
        pieChartVerbruik.getData().addAll(verbruikData);
    }


}
