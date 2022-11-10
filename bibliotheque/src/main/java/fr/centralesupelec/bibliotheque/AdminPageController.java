package fr.centralesupelec.bibliotheque;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController implements Initializable {
    public User theUser;
    @FXML
    private Label nameLabel;
    @FXML
    private ListView<User> borrowersList;

    private User currentUser;
    DataBaseQuery dataBaseQuery = new DataBaseQuery();

    ObservableList<User> allUsers = dataBaseQuery.getAllUsers();
    ObservableList<User> borrowers = dataBaseQuery.getBorrowersList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        borrowersList.getItems().addAll(allUsers);
        borrowersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
            @Override
            public void changed(ObservableValue<? extends User> observableValue, User user, User t1) {
                currentUser = borrowersList.getSelectionModel().getSelectedItem();

            }
        });
    }

    public void ShowBorrowers(){
        borrowersList.getItems().clear();
        borrowersList.getItems().addAll(borrowers);
    }

    public void ShowAllUsers(){
        borrowersList.getItems().clear();
        borrowersList.getItems().addAll(allUsers);
    }

    public void displayName( User user) {
        nameLabel.setText("Hello: " + user.getPrenom());
    }
}
