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
    private MenuItem newgame;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem exit;
    @FXML
    private MenuItem cheat1;
    @FXML
    private MenuItem cheat2;
    @FXML
    private MenuItem cheat3;
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

     //fxml => newgame
     public void newGame(){
         mv.newGame();
     }
     
     //fxml => open
     public void open(){
         System.out.println("klik open");
     }     
     //fxml => save
     public void doSave(){
         mv.doSaveTest();
     }
     
     //fxml exit
     public void exit(){
         Platform.exit();
     }
     
     //fxml cheat1
     public void extraEnergy(){
         mv.getPlayerModel().addEnergy(25);
     }
     
     public void extraHappiness(){
         mv.getPlayerModel().addHappiness(25);         
     }
     
     public void addPoints(){
         mv.getPlayerModel().addPoints(100);                  
     }
     

}
