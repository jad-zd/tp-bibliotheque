package fr.centralesupelec.bibliotheque;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class LandingPageController implements Initializable {
    public User theUser;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField searchText;
    @FXML
    private ChoiceBox searchType;
    DataBaseQuery dataBaseQuery = new DataBaseQuery();

    ObservableList<Book> allBooks = dataBaseQuery.getAllBooks();
    ObservableList<Book> availableBooks = dataBaseQuery.getAvailableBooks();
    @FXML
    private ListView<Book> booksListView;
    Book currentBook;
    @FXML
    private Button allBooksButton;
    @FXML
    private Button availableBooksButton;
    @FXML
    private Button borrowBookButton;
    @FXML
    AnchorPane anchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        booksListView.getItems().addAll(allBooks);
        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Book>() {
            @Override
            public void changed(ObservableValue<? extends Book> observableValue, Book book, Book t1) {
                currentBook = booksListView.getSelectionModel().getSelectedItem();

            }
        });
    }

    public void ListAllBooks(){
        booksListView.getItems().clear();
        booksListView.getItems().addAll(allBooks);
    }

    public void ListAvailableBooks(){
        booksListView.getItems().clear();
        booksListView.getItems().addAll(availableBooks);
    }

    public void BorrowCurrentBook(){
        if (currentBook != null) {
        if (availableBooks.contains(currentBook)) {
            Loan loan = new Loan(LocalDate.now().plusDays(theUser.getMaxBorrowTime()), true, theUser, currentBook);
            dataBaseQuery.BorrowBook(loan);
            availableBooks = dataBaseQuery.getAvailableBooks();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("BOOK ALREADY BORROWED");
            alert.setHeaderText("You cannot borrow this book.");
            alert.setContentText("You cannot borrow this book at the current time, please wait till it gets returned.");
            if (alert.showAndWait().get() == ButtonType.OK){}
        }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("PLEASE SELECT A BOOK");
            alert.setHeaderText("Select a book by clicking on one in the list!");
            alert.setContentText("You cannot borrow nothing, please select a book!");
            if (alert.showAndWait().get() == ButtonType.OK) {}
        }
    }
    public void goToAdminPage(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminPage.fxml"));
        root = loader.load();

        AdminPageController adminPageController = loader.getController();
        adminPageController.theUser=theUser;
        adminPageController.displayName(theUser);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Welcome to the Admin page");
        stage.setScene(scene);
        stage.show();

    }
    public void displayName( User user) {
        nameLabel.setText("Hello: " + user.getPrenom());
        if (user.getRole().toString()=="Admin") {
            Button adminButton= new Button("Admin");
            adminButton.setLayoutX(500);
            adminButton.setLayoutY(20);
            adminButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        goToAdminPage(event);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            anchorPane.getChildren().add(adminButton);
        };

    }

}