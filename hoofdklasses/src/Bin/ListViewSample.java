package Bin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ListViewSample{
    @FXML
    private Rectangle cell;
    @FXML
    private Text GuiApparaatnaam;

    ListView<String> list = new ListView<String>();
    ObservableList<String> data = FXCollections.observableArrayList( //hier komen alle String apparaten
            "blue", "white", "gold", "coral", "darkorchid",
            "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
            "blueviolet", "brown");


    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 750, 500); //root node = box
        stage.setScene(scene);
        stage.setTitle("Apparatenbeheer");
        box.getChildren().addAll(list);
        VBox.setVgrow(list, Priority.ALWAYS);

        list.setItems(data);

        list.setCellFactory(new Callback<ListView<String>,
                                    ListCell<String>>() {
                                @Override
                                public ListCell<String> call(ListView<String> list) {
                                    return new ColorRectCell(list);
                                }
                            }
        );


        stage.show();
    }

    public Text getGuiApparaatnaam() {
        return GuiApparaatnaam;
    }

    static class ColorRectCell extends ListCell<String> {

        ListView<String> list = null;

        public ColorRectCell(ListView<String> list) {
            this.list = list;
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            System.out.println(super.getItem());
            StackPane stack = null;

            try {
                stack = FXMLLoader.load(getClass().getResource("/Bin/FXML/Rectangle cell.fxml"));
                stack.getChildren().set(1,new TextField());

            } catch (IOException exception) {
                exception.printStackTrace();
            }

            if (item != null) {
                assert stack != null;

                setGraphic(stack);
            }
        }
    }
}