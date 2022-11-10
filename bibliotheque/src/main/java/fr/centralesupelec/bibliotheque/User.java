package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;

public class User extends Person {
    private StringProperty email;
    private ObjectProperty<Category> category;
    private ObjectProperty<Role> role;
    private IntegerProperty maxBorrowCount;
    private IntegerProperty maxBorrowTime;

    public String getEmail(){
        return this.email.get();
    }
    public void setEmail(String email){
        this.email.set(email);
    }

    public Category getCategory() { return category.get(); }
    public void setCategory(Category category) {
        this.category.set(category);
    }

    public Role getRole() { return role.get(); }
    public void setRole(Role role) {
        this.role.set(role);
    }

    public Integer getMaxBorrowCount() { return maxBorrowCount.get(); }
    public void setMaxBorrowCount(Integer maxBorrowCount) { this.maxBorrowCount.set(maxBorrowCount); }

    public Integer getMaxBorrowTime() { return maxBorrowTime.get(); }
    public void setMaxBorrowTime(Integer maxBorrowTime) { this.maxBorrowTime.set(maxBorrowTime); }

    public User(String nom, String prenom, String email, Integer id, Category category, Role role){
        super(nom, prenom, id);
        this.email = new SimpleStringProperty(email);
        this.category = new SimpleObjectProperty<Category>(category);
        this.role = new SimpleObjectProperty<Role>(role);
        this.maxBorrowCount = new SimpleIntegerProperty(category.maxBorrowCount());
        this.maxBorrowTime = new SimpleIntegerProperty(category.maxBorrowTime());
    }

    @Override
    public String toString(){
        return "First name: "+this.getPrenom()+", Last name: "+this.getNom()+", Email: "+this.email.get()+", ID: "+this.getId()+ ", Category: "+this.category.get()+", Role: "+this.role.get()+", Max borrow count: "+this.maxBorrowCount.get()+", Max borrow time (days): "+this.maxBorrowTime.get();
    }
}
