package FXML_Controller;

import Main.Frames;
import Main.*;
import ObjectData.Users;
import Service.Service;
import Service.Service_User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.sql.Date;

public class SignUp implements Controller {

    @FXML
    private TextField full_name;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private DatePicker birthday;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private Label label_error;

    private String error = "Passwords doesn't equals";

    @FXML
    public void initialize() {
        Service.frames(SignUp.this);
        label_error.setVisible(false);
    }

    public void click(ActionEvent event) {
        Button b = (Button) event.getSource();
        switch (b.getId()) {
            case "add": // send request with data and wait response
                if (password1.getText().equals(password2.getText()) && !password1.getText().equals("") && !password2.getText().toString().equals("")) {
                    Users u = new Users(
                            -1, full_name.getText(), email.getText(), login.getText(), password1.getText(), Date.valueOf(birthday.getValue())
                    );
                    Client_Socket.socket();
                    Service_User.createMessage(u, Service.NAME_OPERATION.create);
                } else {
                    // определять пустые поля
                    //            error();
                }
                break;
            case "cancel":
                Main.frames.frames(Frames.NumbFrame.Verification);
                break;
        }
    }

    private void error() {
        label_error.setText(error);
        label_error.setVisible(true);
    }

}
