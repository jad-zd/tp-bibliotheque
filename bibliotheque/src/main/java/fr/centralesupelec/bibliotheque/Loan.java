package fr.centralesupelec.bibliotheque;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Loan extends Redlisted {

        private ObjectProperty<Book> book;

    public Book getBook() { return book.get(); }
    public void setBook(Book book) { this.book.set(book); }

    public Loan(LocalDate endDate, Boolean active, User user, Book book){
        super(endDate, active, user);
        this.book = new SimpleObjectProperty<Book>(book);
        book.setBorrowedOnce(true);
    }

    @Override
    public String toString(){
        return "Start date: "+this.getStartDate()+", End date: "+this.getEndDate()+" Active: "+this.getActive()+", User: "+this.getUser()+", Book: "+this.book.get();
    }
}
