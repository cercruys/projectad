package GUI.Controllers;
import Application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class ControllerAddAction {
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label Appliances;

    @FXML
    void switchToHome(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/GUI/fxml/Acties.fxml"));
        root = loader.load();

        ControllerActies controllerActies=loader.getController();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void displayAppliances() throws ApplianceException {
        Location location= new Location(1,"House",2,18,"Steenstraat",8000,"Brugge",20.0,"test","test");
        Appliance appliance1= new Appliance("frigo", new EEL(new QR(),18, 'C'));
        Appliance appliance2= new Appliance("micro",new EEL(new QR(),20,'A'));
        location.addAppliance(appliance1);
        location.addAppliance(appliance2);
        Appliances.setText(location.appliancesToString());
    }

}
