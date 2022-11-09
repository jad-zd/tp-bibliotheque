package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;

public class Person {
    private StringProperty nom;
    private StringProperty prenom;
    private IntegerProperty id;

    public String getNom() {
        return nom.get();
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom(){
        return this.prenom.get();
    }
    public void setPrenom(String prenom){
        this.prenom.set(prenom);
    }
    public StringProperty prenomProperty() {
        return prenom;
    }

    public Integer getId(){
        return this.id.get();
    }
    public void setId(Integer id){
        this.id.set(id);
    }
    public IntegerProperty idProperty() {
        return id;
    }

    public Person(String nom, String prenom, Integer id){
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.id = new SimpleIntegerProperty(id);
    }

    public String toString(){
        return "First name: "+this.prenom.get()+", Last name: "+this.nom.get()+", ID: "+this.id.get();
    }
}
