package FXML_Controller;

import Main.Frames;
import Main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class ExpenseTracker implements Controller {
//    ObservableList<String> langs = FXCollections.observableArrayList("1 day", "7 days", "30 days");
//
//    @FXML
//    private ChoiceBox<String> choice_box;
//    private Button add;

    @FXML
    private AnchorPane apane;


    @FXML
    public void initialize() {
        apane.getChildren().add(Main.frames.loadNode(Frames.Pane.Main));
    }

    public void click(ActionEvent e) {
        Button b = (Button) e.getSource();
        switch (b.getId()) {
            case "main_menu":
                Main.frames.frames(Frames.NumbFrame.ExpTracker);
                break;
            case "settings":
//                apane.getChildren().removeAll(add, choice_box);
                apane.getChildren().add(Main.frames.loadNode(Frames.Pane.Settings));
                break;
            case "person":
                break;
        }

    }

//    private void button() {
//        ImageView im = new ImageView(new Image("Icons/plus.png"));
//        im.setFitHeight(17);
//        im.setFitWidth(23);
//
//        add = new Button("Add");
//        add.setGraphic(im);
//        add.setLayoutX(452);
//        add.setLayoutY(14);
//        add.setMinWidth(44);
//        add.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Main.frames.frames(Frames.NumbFrame.Add);
//            }
//        });
//
//
//        choice_box = new ChoiceBox<String>();
//        choice_box.setItems(langs);
//        choice_box.setValue("1 day");
//        choice_box.setLayoutX(14);
//        choice_box.setLayoutY(15);
//
//
//        apane.getChildren().addAll(add, choice_box);
//    }

}
