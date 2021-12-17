package Bin.controllers;

import Bin.ListViewSample;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ControllerBeheer{

    @FXML
    private AnchorPane ItemPane;
    @FXML
    private AnchorPane RootPane;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane PaneBoven;
    @FXML
    private VBox itemholder;
    @FXML
    private HBox item;
    @FXML
    private Label lbitem;
    @FXML
    private Button Toevoegen, Deleten, Wijzigen;
    @FXML
    private ListView list;



    Stage stage;
    Scene scene;

   public void init(AnchorPane pane) throws Exception { //zonder overriden want anders veel errors

       ListViewSample listViewSample = new ListViewSample();
       listViewSample.start((Stage) pane.getScene().getWindow());

}}
