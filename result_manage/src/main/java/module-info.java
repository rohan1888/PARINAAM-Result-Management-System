module com.result.result_manage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.result.result_manage to javafx.fxml;
    exports com.result.result_manage;
}