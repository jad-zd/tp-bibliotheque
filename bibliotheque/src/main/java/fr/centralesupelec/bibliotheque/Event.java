package fr.centralesupelec.bibliotheque;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Event {
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;
    private BooleanProperty active;

    public LocalDate getStartDate() {
        return startDate.get();
    }
    public void setStartDate(LocalDate startDate) { this.startDate.set(startDate); }

    public LocalDate getEndDate() {
        return endDate.get();
    }
    public void setEndDate(LocalDate endDate) { this.endDate.set(endDate); }

    public Boolean  getActive() {
        return active.get();
    }
    public void setActive(Boolean active) {
        this.active.set(active);
    }

    public Event(LocalDate endDate, Boolean active){
        this.startDate = new SimpleObjectProperty<LocalDate>(LocalDate.now());
        this.endDate = new SimpleObjectProperty<LocalDate>(endDate);
        this.active = new SimpleBooleanProperty(active);
    }

    @Override
    public String toString(){
        return "Start date: "+this.startDate.get()+", End date: "+this.endDate.get()+" Active: "+this.active.get();
    }
}
