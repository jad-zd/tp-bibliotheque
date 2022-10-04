module fr.centralesupelec.bibliotheque {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.centralesupelec.bibliotheque to javafx.fxml;
    exports fr.centralesupelec.bibliotheque;
}