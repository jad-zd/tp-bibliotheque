package fr.centralesupelec.bibliotheque;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DataBaseQuery {

    public ObservableList<Book> getBooksByQuery(String sql1) {
        ObservableList<Book> books = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tp_bibliotheque", "tp_bibliotheque", "2TheE-Library");
            PreparedStatement preparedStatement1 = connnection.prepareStatement(sql1);
            ResultSet rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                Integer book_id = Integer.valueOf(rs1.getString("book_id"));
                String sql2 = "SELECT a.author_id,a.first_name,a.last_name,a.birth_date FROM Books as b JOIN Book_author as ba ON b.book_id=ba.book_id JOIN Authors as a ON ba.author_id=a.author_id WHERE b.book_id=?;";
                PreparedStatement preparedStatement2 = connnection.prepareStatement(sql2);
                preparedStatement2.setString(1, String.valueOf(book_id));
                ResultSet rs2 = preparedStatement2.executeQuery();
                ObservableList<Author> authors = FXCollections.observableArrayList();
                while (rs2.next()) {
                    Author author = new Author(
                            rs2.getString("last_name"),
                            rs2.getString("first_name"),
                            Integer.valueOf(rs2.getString("author_id")),
                            LocalDate.parse(rs2.getString("birth_date"))
                    );
                    authors.add(author);
                }
                Edition edition = new Edition(
                        rs1.getString("name"),
                        Integer.valueOf(rs1.getString("year")),
                        Integer.valueOf("276")
                );

                ObservableList<String> keyWords = FXCollections.observableArrayList();
                for (int i = 1; i < 6; i++) {
                    String keyWord = rs1.getString("kw_id" + i);
                    if (keyWord != "NULL") {
                        keyWords.add(keyWord);
                    }
                }

                Book book = new Book(
                        rs1.getString("title"),
                        Integer.valueOf(rs1.getString("publish_year")),
                        Integer.valueOf(rs1.getString("book_id")),
                        authors,
                        edition,
                        keyWords,
                        Boolean.valueOf(rs1.getString("borrowedOnce"))
                );
                books.add(book);
            }
            connnection.close();
        } catch (Exception e) { System.out.println(e); }
        return books;
    }

    public ObservableList<Book> getAllBooks() {
        String sql1 = "SELECT b.book_id,b.title,b.publish_year,b.kw_id1,b.kw_id2,b.kw_id3,b.kw_id4,b.kw_id5,b.borrowedOnce,e.isbn,e.year,e.name FROM Books as b JOIN Editions as e ON b.edition_isbn=e.isbn;";
        return getBooksByQuery(sql1);
    }

    public ObservableList<Book> getBorrowedBooks() {
        String sql1 = "SELECT b.book_id,b.title,b.publish_year,b.kw_id1,b.kw_id2,b.kw_id3,b.kw_id4,b.kw_id5,b.borrowedOnce,e.isbn,e.year,e.name FROM Books as b JOIN Editions as e ON b.edition_isbn=e.isbn JOIN Loans as l ON b.book_id=l.book_id WHERE l.active=TRUE;";
        return getBooksByQuery(sql1);
    }

    public ObservableList<Book> getAvailableBooks() {
        String sql1 = "SELECT b.book_id,b.title,b.publish_year,b.kw_id1,b.kw_id2,b.kw_id3,b.kw_id4,b.kw_id5,b.borrowedOnce,e.isbn,e.year,e.name FROM Books as b JOIN Editions as e ON b.edition_isbn=e.isbn JOIN Loans as l ON b.book_id=l.book_id WHERE l.active=FALSE;";
        String sql2 = "SELECT b.book_id,b.title,b.publish_year,b.kw_id1,b.kw_id2,b.kw_id3,b.kw_id4,b.kw_id5,b.borrowedOnce,e.isbn,e.year,e.name FROM Books as b JOIN Editions as e ON b.edition_isbn=e.isbn WHERE b.borrowedOnce=FALSE;";
        ObservableList<Book> books = getBooksByQuery(sql1);
        ObservableList<Book> otherBooks = getBooksByQuery(sql2);
        otherBooks.stream().forEach((book) -> books.add(book));
        return books;
    }

    public ObservableList<User> getUserByQuery(String sql1){
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tp_bibliotheque", "tp_bibliotheque", "2TheE-Library");
            PreparedStatement preparedStatement1 = connnection.prepareStatement(sql1);
            ResultSet rs1 = preparedStatement1.executeQuery();
            while (rs1.next()){
                Category category = Category.valueOf(rs1.getString("category"));
                Role role = Role.valueOf(rs1.getString("role"));
                User user = new User(
                  rs1.getString("u.last_name"),
                  rs1.getString("u.first_name"),
                  rs1.getString("u.email"),
                  Integer.valueOf(rs1.getString("u.user_id")),
                        category,
                        role
                );
                Integer max_borrow_count = Integer.valueOf(rs1.getString("max_borrow_count"));
                Integer max_borrow_time = Integer.valueOf(rs1.getString("max_borrow_time"));
                if (category.maxBorrowCount() != max_borrow_count ){ user.setMaxBorrowCount(max_borrow_count); }
                if (category.maxBorrowTime() != max_borrow_time ){ user.setMaxBorrowTime(max_borrow_time); }
                users.add(user);
            }
            connnection.close();
        }
        catch (Exception e){ System.out.println(e); }
        return users;
    }

    public ObservableList<User> getAllUsers(){
        String sql1 = "SELECT u.user_id,u.first_name,u.last_name,u.email,u.category,u.role,u.max_borrow_count,u.max_borrow_time FROM Users as u;";
        return getUserByQuery(sql1);
    }
    public User getUserById(String user_id) {
        String sql1 = "SELECT u.user_id,u.first_name,u.last_name,u.email,u.category,u.role,u.max_borrow_count,u.max_borrow_time FROM Users as u WHERE u.user_id="+user_id+";";
        return getUserByQuery(sql1).get(0);
    }

    public ObservableList<User> getBorrowersList() {
        String sql1 = "SELECT u.user_id,u.first_name,u.last_name,u.email,u.category,u.role,u.max_borrow_count,u.max_borrow_time FROM Users as u JOIN Loans as l ON u.user_id=l.user_id";
        return getUserByQuery(sql1);
    }

    public void BorrowBook(Loan loan){
        //Loan loan = new Loan(LocalDate.now().plusDays(user.getMaxBorrowTime()), true, user, book);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tp_bibliotheque", "tp_bibliotheque", "2TheE-Library");

            String sql1 = "INSERT INTO Loans(book_id, user_id, start_date, end_date, active) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement1 = connnection.prepareStatement(sql1);
            preparedStatement1.setString(1, String.valueOf(loan.getBook().getId()));
            preparedStatement1.setString(2, String.valueOf(loan.getUser().getId()));
            preparedStatement1.setString(3, String.valueOf(loan.getStartDate()));
            preparedStatement1.setString(4, String.valueOf(loan.getEndDate()));
            //System.out.println(loan.getActive());
            preparedStatement1.setString(5, String.valueOf(1));
            Integer rs1 = preparedStatement1.executeUpdate();

            String sql2 = "SELECT borrowedOnce FROM Books WHERE book_id=?;";
            PreparedStatement preparedStatement2 = connnection.prepareStatement(sql2);
            preparedStatement2.setString(1, String.valueOf(loan.getBook().getId()));
            ResultSet rs2 = preparedStatement2.executeQuery();

            if (rs2.next()){
            if (!Boolean.valueOf(rs2.getString("borrowedOnce"))) {
                loan.getBook().setBorrowedOnce(true);
                String sql3 = "UPDATE Books SET borrowedOnce=TRUE WHERE book_id=?;";
                PreparedStatement preparedStatement3 = connnection.prepareStatement(sql3);
                preparedStatement3.setString(1, String.valueOf(loan.getBook().getId()));
                Integer rs3 = preparedStatement3.executeUpdate();
            }}
            connnection.close();
        } catch (Exception e) {System.out.println(e);}
    }
}

