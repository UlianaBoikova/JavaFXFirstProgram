module com.example.javafxfirst {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens com.example.javafxfirst to javafx.fxml;
    exports com.example.javafxfirst;
}