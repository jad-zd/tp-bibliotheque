package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.List;

public class Book {
    private StringProperty title;
    private IntegerProperty publishYear;
    private IntegerProperty id;
    private ListProperty<Author> authors;
    private ObjectProperty<Edition> edition;
    private ListProperty<String> keyWords;
    private BooleanProperty borrowed;

    public String getTitle() {
        return title.get();
    }
    public void setTitle(String title) {
        this.title.set(title);
    }

    public Integer getPublishYear() {
        return publishYear.get();
    }
    public void setPublishYear(Integer publishYear) { this.publishYear.set(publishYear); }

    public Integer getId() {
        return id.get();
    }
    public void setId(Integer id) {
        this.id.set(id);
    }

    public ObservableList<Author> getAuthors() { return authors.get(); }
    public void setAuthors(ObservableList<Author> authors) {
        this.authors.setValue(authors);
    }

    public Edition getEdition() { return edition.get(); }
    public void setEdition(Edition edition) {
        this.edition.setValue(edition);
    }

    public ObservableList<String> getKeyWords() { return keyWords.get(); }
    public void setKeyWords(ObservableList<String> keyWords) {
        this.keyWords.setValue(keyWords);
    }

    public Boolean  getBorrowed() {
        return borrowed.get();
    }
    public void setBorrowed(Boolean borrowed) {
        this.borrowed.set(borrowed);
    }

    public Book(String title, Integer publishYear, Integer id, ObservableList<Author> authors, Edition edition, ObservableList<String> keyWords, Boolean borrowed) {
        this.title = new SimpleStringProperty(title);
        this.publishYear = new SimpleIntegerProperty(publishYear);
        this.id = new SimpleIntegerProperty(id);
        this.authors = new SimpleListProperty<Author>(authors);
        this.edition = new SimpleObjectProperty<Edition>(edition);
        this.keyWords = new SimpleListProperty<String>(keyWords);
        this.borrowed = new SimpleBooleanProperty(borrowed);
    }

    @Override
    public String toString(){
        return "Title: "+this.title.get()
                +", Publish year: "+this.publishYear.get()
                +", ID: "+this.id.get()
                +", Authors: "+this.authors.get() // You can specify get(i) to get the i element in the ListProperty
                +", Edition: "+this.edition.get()
                +", Key words: "+this.keyWords.get() // Same here
                +", Borrowed: "+this.borrowed.get();
    }
}
