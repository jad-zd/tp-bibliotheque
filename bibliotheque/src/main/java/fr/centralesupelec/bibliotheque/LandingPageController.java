package fr.centralesupelec.bibliotheque;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LandingPageController {
    @FXML
    Label nameLabel;
    public void displayName(String username) {
        nameLabel.setText("Hello: " + username);
    }
}