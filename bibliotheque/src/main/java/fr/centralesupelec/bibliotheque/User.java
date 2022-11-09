package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;

public class User extends Person {
//    private StringProperty nom;
//    private StringProperty prenom;
    private StringProperty email;
//    private IntegerProperty id;
    private ObjectProperty<Category> category;
    private ObjectProperty<Role> role;

//    public String getNom() {
//        return nom.get();
//    }
//    public void setNom(String nom) {
//        this.nom.set(nom);
//    }
//    public StringProperty nomProperty() {
//        return nom;
//    }

//    public String getPrenom(){
//        return this.prenom.get();
//    }
//    public void setPrenom(String prenom){
//        this.prenom.set(prenom);
//    }
//    public StringProperty prenomProperty() {
//        return prenom;
//    }

    public String getEmail(){
        return this.email.get();
    }
    public void setEmail(String email){
        this.email.set(email);
    }
    public StringProperty emailProperty() {
        return email;
    }

//    public Integer getId(){
//        return this.id.get();
//    }
//    public void setId(Integer id){
//        this.id.set(id);
//    }
//    public IntegerProperty idProperty() {
//        return id;
//    }

    public Category getCategory() {
        return category.get();
    }
    public void setCategory(Category category) {
        this.category.set(category);
    }
    public ObjectProperty<Category> categoryProperty() {
        return category;
    }

    public Role getRole() {
        return role.get();
    }
    public void setRole(Role role) {
        this.role.set(role);
    }
    public ObjectProperty<Role> roleProperty() {
        return role;
    }

    public User(String nom, String prenom, String email, Integer id, Category category, Role role){
        super(nom, prenom, id);
//        this.nom = new SimpleStringProperty(nom);
//        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
//        this.id = new SimpleIntegerProperty(id);
        this.category = new SimpleObjectProperty<Category>(category);
        this.role = new SimpleObjectProperty<Role>(role);
    }
    @Override
    public String toString(){
        return "First name: "+this.getPrenom()+", Last name: "+this.getNom()+", Email: "+this.email.get()+", ID: "+this.getId()+ ", Category: "+this.category.get()+", Role: "+this.role.get();
    }
}
