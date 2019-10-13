package FXML_Controller;

import Dictionary.Dict_ENG;
import Main.*;
import Service.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ObjectData.*;

import javafx.scene.layout.Pane;
import org.apache.log4j.Logger;


public class Verification_Contr implements Controller {

    Users user;

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Label message;

    @FXML
    public void initialize() {
        Service.frames(Verification_Contr.this);
    }

    public void click(ActionEvent event) {
        Button b = (Button) event.getSource();
        switch (b.getId()) {
            case "signIn":
                user = new Users(-1, null, null, login.getText(), password.getText().toString(), null);
                Client_Socket.socket();
                Service_User.setObject(user, Service_User.unique_numb.verification);
                break;
            case "signUp": // transition to registration
                Main.frames.frames(Frames.NumbFrame.SignUp);
                break;
            case "cancel":
                Main.exit();
                break; // completion of work
        }
    }

    public void next_window(){
        Main.frames.frames(Frames.NumbFrame.ExpTracker);
    }

    public void answer(boolean result, int code) {
            message.setText(Dict_ENG.getMessUser(code, result));
    }





}
