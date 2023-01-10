module com.concurrente.dev01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.concurrente.dev01 to javafx.fxml;
    exports com.concurrente.dev01;
}