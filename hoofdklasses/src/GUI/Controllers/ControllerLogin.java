package GUI.Controllers;

import Application.*;
import DatabaseStuff.ExecuteQuery;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Application.Landlord;
import Application.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class ControllerLogin {
    @FXML
    private Label message;

    @FXML
    private Button CancelBtn;

    @FXML
    private Button LoginBtn;

    @FXML
    private PasswordField PasswordTextfield;

    @FXML
    private TextField UsernameTextfield;

    @FXML
    private Label registreerHier;

    @FXML
    void Cancel(ActionEvent event) {

    }

    @FXML
    void Login(ActionEvent event) throws IOException, SQLException {
        Parent root;
        ExecuteQuery executeQuery = new ExecuteQuery();
        HashMap<String,String> hashMapLogin = executeQuery.getUsernameAndPassword();
        boolean flag = false;


        if(hashMapLogin.containsKey(UsernameTextfield.getText()) && hashMapLogin.get(UsernameTextfield.getText()).equals(PasswordTextfield.getText())) {
            flag = true;
        }

        if (flag){  //inloggen gaat sws gebeuren

            ExecuteQuery executeQuery1 = new ExecuteQuery();
            Person person = executeQuery1.getPerson(UsernameTextfield.getText());
            IngelogdePerson.setPerson(person); //lukt
            System.out.println("person was set");

            if (person.getLandlordOfStudent().equals("student")){
                Student student = new Student(IngelogdePerson.getPerson());
                System.out.println(student.toString()); //lukt
                IngelogdeStudent.setIngelogdeStudent(student);
                System.out.println("student was set"); //lukt
                root = FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeStudent.fxml")); }
            else{
                Landlord landLord = new Landlord(IngelogdePerson.getPerson());
                IngelogdeHuisbaas.setIngelogdeHuisbaas(landLord);
                System.out.println("loading homelandlord...");
                root =  FXMLLoader.load(getClass().getResource("/GUI/fxml/HomeLandlord.fxml"));}
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 750, 500));
            stage.show();
            stage.setOnCloseRequest(e -> Platform.exit());}

        if (!flag)
            message.setText("Username of password is niet juist");
    }


    @FXML
    void RegistreerHier(MouseEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/GUI/fxml/RegistratieScherm.fxml"));
        stage.setScene(new Scene(root, 750, 500));
        stage.show();
        stage.setOnCloseRequest(e -> Platform.exit());
    }

}