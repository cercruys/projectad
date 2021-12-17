package Bin;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class fxmlLoader {
    private Pane view;
    private AnchorPane box;


    public Pane getPane(String filename, String packageName) {

        try{
            URL fileUrl = MainStart.class.getResource("/" + packageName + "/FXML/" + filename +".fxml");
            System.out.println(fileUrl);
            if(fileUrl == null){
                throw new FileNotFoundException("FXML can't be found");}
            new FXMLLoader();
            view = FXMLLoader.load(fileUrl);

        } catch (Exception e) {
          System.out.println("No page " + filename + " please check FxmlLoader.");}

        return view;
    }
    public AnchorPane laad(String filename, String packageName) throws IOException {

        try{
            URL fileUrl = MainStart.class.getResource("/" + packageName + "/FXML/" + filename +".fxml");
            System.out.println(fileUrl);
            if(fileUrl == null){
                throw new FileNotFoundException("FXML can't be found");}
            new FXMLLoader();
            box = FXMLLoader.load(fileUrl);

        } catch (Exception e) {
            System.out.println("No page " + filename + " please check FxmlLoader.");}

        return box;
    }

}
