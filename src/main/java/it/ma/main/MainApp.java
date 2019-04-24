package it.ma.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.IOException;


public class MainApp extends Application {
    private final static Log LOGGER = LogFactory.getLog(MainApp.class);
    final static Prop PROP = new Prop();
    public MainApp() {
        try {
            PROP.loadFromXML();
        } catch (IOException ex) {
            LOGGER.error( null, ex);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Crc Checksum");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        PROP.storeToXML();
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
