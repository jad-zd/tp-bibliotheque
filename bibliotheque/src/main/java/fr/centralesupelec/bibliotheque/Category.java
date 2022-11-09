package fr.centralesupelec.bibliotheque;

public enum Category {
    Light,
    Moderate,
    Heavy,
    ;

    public String toString(){
        return switch (this) {
            case Light -> "Light";
            case Moderate -> "Moderate";
            case Heavy -> "Heavy";
        };
    }
}
