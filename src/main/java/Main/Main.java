package Main;

import entities.CostsList;
import entities.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage homeStage;
    public static Frames frames = null;
    public static User user = new User();
    public static CostsList costsList = new CostsList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        homeStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/GPI/ExpenseTracker.fxml"));
        homeStage.setTitle("Expense tracker");
        homeStage.getIcons().add(new Image("/Icons/main_icon.jpg"));
        homeStage.setScene(new Scene(root));
        homeStage.show();
        frames = new Frames(homeStage);
    }

    public static void exit() {
        System.exit(0);
    }

}
