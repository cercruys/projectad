package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerHomeStudent {

    @FXML
    private Button Apparatenbeheer;

    @FXML
    private Button btnActies;

    @FXML
    private Button btnEnergieverbruik;

    @FXML
    private BorderPane mainPane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private HBox hboxRoot;


    @FXML
    void ApparatenbeheerBtnClicked(ActionEvent event) throws Exception {

        //Verwijzen naar window apparatenbeheer
        root = FXMLLoader.load(getClass().getResource("/GUI/fxml/ApparatenBeheer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void btnActiesBtnClicked(ActionEvent event) throws IOException {

        //verwezen naar window acties
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUI/fxml/Acties.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnEnergieverbruikBtnClicked(ActionEvent event) throws IOException {

        //verwijzen naar window verbruik
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/GUI/fxml/Verbruik.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public void infoStudent(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/GUI/fxml/Info.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}