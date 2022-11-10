package fr.centralesupelec.bibliotheque;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

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

        // Tests
//        Author author1 = new Author("Olivier", "Gerard",96297, LocalDate.of(2001, 02,24));
//        Author author2 = new Author("Balim", "ali",2839, LocalDate.of(1999, 04,11));
//        System.out.println(author2);
//        ObservableList<Author> authors = FXCollections.observableArrayList(author1, author2);
//        System.out.println(authors.get(0));
//        System.out.println(authors); // Cannot use authors.get cz here it is an observable list
//        Edition edition1 = new Edition("Hachette", 2003, 2896389);
//        ObservableList<String> keyWords = FXCollections.observableArrayList("He", "K", "hk");
//        System.out.println(keyWords);
//        Book book1 = new Book("Hello from the other side", 2012, 28630, authors, edition1, keyWords,false);
//        System.out.println(book1.getAuthors()); // Can use authors.get cz here it is an ListProperty
//        System.out.println(book1.toString());
//        User user1 = new User("Z","J","j@v",2872,Category.Light, Role.User);

        DataBaseQuery dataBaseQuery = new DataBaseQuery();
//        System.out.println(dataBaseQuery.getBorrowersList());
//        System.out.println(dataBaseQuery.getAllBooks());

//        System.out.println(dataBaseQuery.getUserById("1111"));
        ObservableList<Book> books = dataBaseQuery.getAllBooks();
        ObservableList<User> users = dataBaseQuery.getAllUsers();
//        System.out.println(books);
//        System.out.println(users);
//        Loan loan = new Loan(LocalDate.now().plusDays(users.get(0).getMaxBorrowTime()), true, users.get(0), books.get(1));
//        System.out.println(loan);
//        dataBaseQuery.BorrowBook(loan);

       // System.out.println(user1.toString());
    }

    public static void main(String[] args) {
        launch(args); // launch method of the Application class
    }
}
