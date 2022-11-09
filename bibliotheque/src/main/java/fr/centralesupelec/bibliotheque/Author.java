package fr.centralesupelec.bibliotheque;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Author extends Person{
    private ObjectProperty<LocalDate> birthdate;

    public LocalDate getBirthdate() {
        return birthdate.get();
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate.set(birthdate);
    }
    public ObjectProperty<LocalDate> birthdateProperty() {
        return birthdate;
    }

    public Author(String nom, String prenom, Integer id, LocalDate birthdate) {
        super(nom, prenom, id);
        this.birthdate = new SimpleObjectProperty<LocalDate>(birthdate);
    }

    @Override
    public String toString(){
        return "First name: "+this.getPrenom()+", Last name: "+this.getNom()+", ID: "+this.getId()+", Birthdate: "+this.birthdate.get();
    }
}
