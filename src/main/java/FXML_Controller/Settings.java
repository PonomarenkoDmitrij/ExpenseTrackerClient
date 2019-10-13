package FXML_Controller;

import Main.Frames;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Settings {

    public void click(ActionEvent event) {
        Button b = (Button) event.getSource();

        switch (b.getId()) {
            case "setting_save":
                break;
            case "setting_cancel":
                Main.frames.frames(Frames.NumbFrame.ExpTracker);
                break;
        }

    }
}
