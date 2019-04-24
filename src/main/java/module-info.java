module mcrc.main {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.apache.commons.codec;
    requires commons.logging;
    requires log4j;
    opens it.ma.main to javafx.fxml;
    exports it.ma.main;
}