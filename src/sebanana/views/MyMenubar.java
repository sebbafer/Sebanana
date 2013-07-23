/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.views;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;

/**
 *
 * @author Ellen
 */
public class MyMenubar extends MenuBar{

    public MyMenubar() {
        laadFXML();
    
    }
    
    
    
    
    private void laadFXML() throws RuntimeException {
        try {
             FXMLLoader loader = new FXMLLoader(
                     MyMenubar.class.getResource("Menubar.fxml"));
             loader.setRoot(this);
             loader.setController(this);

             loader.load();
         } catch (IOException exception) {
             throw new RuntimeException(exception);
         }
    }
}
