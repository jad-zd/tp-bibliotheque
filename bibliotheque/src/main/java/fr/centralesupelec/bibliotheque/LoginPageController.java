package fr.centralesupelec.bibliotheque;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPageController {
    @FXML
    TextField nameTextField;
    @FXML
    PasswordField passTextField;
    @FXML
    private GridPane gridPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void login(ActionEvent event) throws IOException {
        String username = nameTextField.getText(); // Get the inserted text
        DataBaseQuery dataBaseQuery = new DataBaseQuery();

        try {
            User theUser = dataBaseQuery.getUserById(username);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml")); // Create a FXML loader for the next page
            root = loader.load(); // Set the root node as the next page's

            LandingPageController landingPageController = loader.getController(); // Import the controller of the next page
            landingPageController.theUser=theUser;
            landingPageController.displayName(theUser);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Welcome to e-Library");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UNAUTHORIZED USER");
            alert.setHeaderText("You are about to be kicked out!");
            alert.setContentText("Contact the e-library admins to authorize your access");

            if(alert.showAndWait().get() == ButtonType.OK) {
                stage = (Stage) gridPane.getScene().getWindow();
                stage.close();
            }
        }
    }
}
