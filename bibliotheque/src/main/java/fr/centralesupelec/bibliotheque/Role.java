package fr.centralesupelec.bibliotheque;

public enum Role {
    User,
    Admin,
    ;

    public String toString(){
        return switch (this){
            case User -> "User";
            case Admin -> "Admin";
        };
    }
}
