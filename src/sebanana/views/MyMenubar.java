/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.views;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sebanana.models.Modelverzameling;
import sebanana.views.aboutwin.AboutWindow;

/**
 *
 * @author Ellen
 */
public class MyMenubar extends MenuBar{
    private Stage aboutwin = null;
    
    @FXML
    private MenuBar menubar;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem cheat1;
    @FXML
    private MenuItem over;
    private final Modelverzameling mv;
    
    
    public MyMenubar(Modelverzameling mv) {
        this.mv=mv;
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
    
    //fxml => over
     public void showAboutWindow(){
        if(aboutwin == null){
            aboutwin = new Stage();
            aboutwin.initModality(Modality.APPLICATION_MODAL);
            try {
                Scene scene = new Scene(new AboutWindow());
                aboutwin.setScene(scene);
            } catch (IOException ex) {
                // TODO: Vang de exceptie op
            }
            
            aboutwin.setTitle("Over het spel");
            aboutwin.setResizable(false);
        }
        
        aboutwin.showAndWait();
    }
     
     //fxml => save
     public void doSave(){
         mv.doSaveTest();
     }
     
     public void exit(){
         Platform.exit();
     }
}