package FXML_Controller;

import Main.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class Main_Controller {
    ObservableList<String> langs = FXCollections.observableArrayList("1 day", "7 days", "30 days");
    @FXML
    private ChoiceBox<String> choice_box;

    public void initialize(){
        choice_box = new ChoiceBox<String>();
        choice_box.setItems(langs);
        choice_box.setValue("1 day");
    }

    public void click(ActionEvent event){
        Button b = (Button) event.getSource();
        switch (b.getId()){
            case "add":
                Main.frames.frames(Frames.NumbFrame.Add);
                break;
        }
    }

}
