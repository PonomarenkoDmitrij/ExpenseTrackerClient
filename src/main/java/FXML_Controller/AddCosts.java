package FXML_Controller;

import Form.DoubleFormer;
import Main.*;
import entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCosts {

    Costs costs;

    @FXML
    private TextField total_money;
    @FXML
    private TextField travel;
    @FXML
    private TextField food;
    @FXML
    private TextField clothes;
    @FXML
    private TextField other;

    public void click(ActionEvent e){
        Button b = (Button) e.getSource();
        switch (b.getId()){
            case "add":
//                 costs = new Costs(-1, Main.user.users.getid,-1,-1,-1,
//                         (total_money.getText()!= null)?DoubleFormer.parse(total_money.getText()):-1,
//                         DoubleFormer.parse(travel.getText()),DoubleFormer.parse(food.getText()),DoubleFormer.parse(clothes.getText()),
//                         DoubleFormer.parse(other.getText()));
                Main.frames.closeAdd();
                break;
            case "back":
                Main.frames.closeAdd();
                break;
        }
    }



}
