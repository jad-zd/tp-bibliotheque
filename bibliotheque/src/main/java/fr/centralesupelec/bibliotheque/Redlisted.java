package fr.centralesupelec.bibliotheque;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Redlisted extends Event {

    private ObjectProperty<User> user;

    public User getUser() {
        return user.get();
    }
    public void setUser(User user) { this.user.set(user); }

    public Redlisted(LocalDate endDate, Boolean active, User user){
        super(endDate, active);
        this.user = new SimpleObjectProperty<User>(user);
    }

    @Override
    public String toString(){
        return "Start date: "+this.getStartDate()+", End date: "+this.getEndDate()+" Active: "+this.getActive()+", User: "+this.user.get();
    }
}
