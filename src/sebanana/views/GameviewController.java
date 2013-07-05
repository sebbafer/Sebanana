package sebanana.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sebanana.views.aboutwin.AboutWindow;

/**
 * FXML Controller class
 *
 * @author Sebastiaan
 */
public class GameviewController implements Initializable {
    
    private Stage stage;
    private Stage aboutwin = null;
    
    @FXML
    private Label content;
    @FXML
    private Label roomLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setContent(String content) {
        this.content.setText(content);
    }
    
    public String getContent(){
        return content.getText();
    }
    
    public void setRoomName(String name){
        roomLabel.setText(name);
    }
    
    public String getRoomName(){
        return roomLabel.getText();
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void closeStage(){
        stage.close();
    }
    
    public void showAboutWindow(){
        if(aboutwin == null){
            aboutwin = new Stage();
            
            try {
                Scene scene = new Scene(new AboutWindow());
                aboutwin.setScene(scene);
            } catch (IOException ex) {
                // TODO: Vang de exceptie op
            }
            
            aboutwin.setTitle("Over het spel");
            aboutwin.setResizable(false);
        }
        
        aboutwin.show();
    }
    
}
