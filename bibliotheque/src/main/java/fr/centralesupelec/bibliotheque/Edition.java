package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Edition {
    private StringProperty name;
    private IntegerProperty year;
    private IntegerProperty isbn;

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }

    public Integer getYear() {
        return year.get();
    }
    public void setYear(Integer year) {
        this.year.set(year);
    }

    public Integer getIsbn() {
        return isbn.get();
    }
    public void setIsbn(Integer isbn) { this.isbn.set(isbn); }

    public Edition(String nom, Integer year, Integer isbn){
        this.name = new SimpleStringProperty(nom);
        this.year = new SimpleIntegerProperty(year);
        this.isbn = new SimpleIntegerProperty(isbn);
    }

    @Override
    public String toString(){
        return "Edition: "+this.name.get()+", Year: "+this.year.get()+", ISBN: "+this.isbn.get();
    }
}