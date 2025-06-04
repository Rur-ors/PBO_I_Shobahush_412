module Action.tugas_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens tugas_javafx to javafx.fxml;
    opens data;
    opens Users;
    opens Action;
    exports tugas_javafx;
}