package Main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Frames {

    final static Logger LOGGER = Logger.getLogger(Frames.class);

    private Stage homeStage;
    Parent root = null;
    private Stage addStage = null;

    public Frames(Stage homeStage) {
        this.homeStage = homeStage;
    }

    public void frames(NumbFrame nf) {
        switch (nf) {
            case Verification:
                verification();
                break;
            case SignUp:
                sign_up();
                break;
            case ExpTracker:
                exp_tracker();
                break;
            case Add:
                add();
                break;
        }
    }

    private void sign_up() {
        root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/GPI/SignUp.fxml"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        if (root != null) {
            homeStage.setResizable(false);
            homeStage.setScene(new Scene(root));
            centerOnScreen();
        }
    }

    private void verification() {
        root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/GPI/Verification.fxml"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        if (root != null) {
            homeStage.setResizable(false);
            homeStage.setScene(new Scene(root));
            centerOnScreen();
        }
    }

    private void exp_tracker() {
        root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/GPI/ExpenseTracker.fxml"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        if (root != null) {
            homeStage.setResizable(false);
            homeStage.setScene(new Scene(root));
            centerOnScreen();
        }
    }

    private void add() {
        root = null;
        addStage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/GPI/AddCosts.fxml"));
        } catch (IOException e) {
            LOGGER.error(e);
        }
        if (root != null) {
            homeStage.setResizable(false);
            addStage.setScene(new Scene(root));
            addStage.setTitle("Add costs");
            addStage.getIcons().add(new Image("/Icons/main_icon.jpg"));
            addStage.show();
        }
    }

    Parent root_assist;

    // load new component
    public Node loadNode(Pane pane) {
        try {

            switch (pane) {
                case Settings:
                    root_assist = FXMLLoader.load(getClass().getResource("/GPI/Settings.fxml"));
//                    root_assist.
                    return root_assist.lookup("#tab_pane");
                case Main:
                    root_assist = FXMLLoader.load(getClass().getResource("/GPI/Main.fxml"));
                    return root_assist.lookup("#main_pane");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void centerOnScreen() {
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        homeStage.setX((primScreenBounds.getWidth() - homeStage.getWidth()) / 2);
        homeStage.setY((primScreenBounds.getHeight() - homeStage.getHeight()) / 2);
    }

    public void closeAdd() {
        addStage.close();
    }

    public enum NumbFrame {
        Verification,
        SignUp,
        ExpTracker,
        Add
    }

    public enum Pane {
        Settings,
        Main
    }
}
