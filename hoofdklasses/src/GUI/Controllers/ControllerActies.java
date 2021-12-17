package GUI.Controllers;

import Application.*;
import DatabaseStuff.ExecuteQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import javax.management.Query;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;
import java.util.ResourceBundle;

public class ControllerActies implements Initializable{

    @FXML
    private ListView actionPreSet;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField apName, otherActionTxt;
    @FXML
    private Button homepageBtn,
            addBtn,
            removeBtn;



    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private AnchorPane ActiesRoot;

    @FXML
    private Label ActionsPerAppliance, actionsLabel;

    LocalDate localDate;
    java.util.Date date;
    java.sql.Date sqlDate;
    ArrayList<Action> acties;
    EnergyConservationAction selectedAction;
    String alternativeAction;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acties = new ArrayList<>();
        ObservableList<EnergyConservationAction> presetActions = FXCollections.observableArrayList(
                EnergyConservationAction.values());
        actionPreSet.setItems(presetActions);
        selectedAction = (EnergyConservationAction) actionPreSet.getSelectionModel().getSelectedItem();
    }

    public void add(ActionEvent event) throws IOException, SQLException {
        Action action = new Action(sqlDate, selectedAction);
        ExecuteQuery query = new ExecuteQuery();
        query.getActions(IngelogdeStudent.getIngelogdeStudent().getUsername()).add(action);
    }

    public void remove(ActionEvent event) throws IOException, SQLException {
        actionPreSet.getItems().remove(selectedAction);
        ExecuteQuery query = new ExecuteQuery();
        query.getActions(IngelogdeStudent.getIngelogdeStudent().getUsername()).remove(selectedAction);
    }

    public void toHomepage(ActionEvent event) throws IOException {
        //home student openen
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeStudent.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void pickDate(ActionEvent event) {
        localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        date = Date.from(instant);
        sqlDate = new Date(date.getTime());
    }


    public void otherAction(ActionEvent event) {
        alternativeAction = otherActionTxt.getText();
        new Action(sqlDate, alternativeAction);
    }

    public void addApName(ActionEvent event) {
        String applianceName = apName.getText();
    }
}

