module org.mohamed.crypto {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.mohamed.crypto to javafx.fxml;
    exports org.mohamed.crypto;
    opens org.mohamed.crypto.Controller to javafx.fxml;
}