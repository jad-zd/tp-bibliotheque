package fr.centralesupelec.bibliotheque;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LandingPageController {
    @FXML
    Label nameLabel;
    @FXML
    TextField searchText;

    @FXML
    ChoiceBox searchType;

    public void displayName(String username) {
        nameLabel.setText("Hello: " + username);
    }
}