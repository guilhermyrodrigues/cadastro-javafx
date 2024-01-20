module com.pezao {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens com.pezao to javafx.fxml;
    exports com.pezao;
}
