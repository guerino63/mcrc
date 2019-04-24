/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ma.main;

import javafx.application.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author maria
 */
public class Prop extends Properties{

    private final static Log LOGGER = LogFactory.getLog(Prop.class);
    static final Path PROP_PATH = 
            Paths.get(System.getProperty("user.home"),
                    ".maprops",
                    //cambiarla a seconda del progetto
                    "macrcfx");
    
    static final Path PROP_FILE = 
            Paths.get(PROP_PATH.toString(),"properties.xml"); 

    public Prop() {
        /*
          some System info
         */
        LOGGER.info("Application directory->" + System.getProperty("user.dir"));
        LOGGER.info("JAVA Version->" + System.getProperty("java.runtime.version"));
        if(Files.notExists(PROP_FILE)){
            try {
                Files.createDirectories(PROP_PATH);
            } catch (IOException ex) {
                LOGGER.error( null, ex);
                //non riesco a creare il file di proprieta...impossibile...
                Platform.exit();
            }
        }
    }
    
    //use overload
    public synchronized void loadFromXML() throws IOException, InvalidPropertiesFormatException {
        loadFromXML(new FileInputStream(PROP_FILE.toFile())); //To change body of generated methods, choose Tools | Templates.
    }
    //use overload
    public void storeToXML() throws IOException {
        storeToXML(new FileOutputStream(PROP_FILE.toFile()), "Property File", "UTF-8");
    }
}
