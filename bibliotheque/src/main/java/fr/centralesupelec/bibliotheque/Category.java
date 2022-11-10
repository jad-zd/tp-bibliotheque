package fr.centralesupelec.bibliotheque;

public enum Category {
    Light,
    Moderate,
    Heavy,
    ;

    public Integer maxBorrowCount(){
      return switch (this) {
          case Light -> 2;
          case Moderate -> 4;
          case Heavy -> 6;
      };
    }

    public Integer maxBorrowTime(){
        return switch (this) {
            case Light -> 14;
            case Moderate -> 21;
            case Heavy -> 28;
        };
    }


    public String toString(){
        return switch (this) {
            case Light -> "Light";
            case Moderate -> "Moderate";
            case Heavy -> "Heavy";
        };
    }
}
