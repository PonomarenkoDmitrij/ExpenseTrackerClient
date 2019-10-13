package FXML_Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public interface Controller {

    @FXML
    void click(ActionEvent event);
    void initialize();

}
