package fr.centralesupelec.bibliotheque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml")); // Define the root node
        Scene scene = new Scene(root); // Create the scene with the root node
        stage.setTitle("Log In to e-Library");
        stage.setResizable(false);
//        stage.setFullScreen(true);
        stage.setScene(scene); // Add the scene to the stage
        stage.show(); // Show the stage
    }

    public static void main(String[] args) {
        launch(args); // launch method of the Application class
    }
}
