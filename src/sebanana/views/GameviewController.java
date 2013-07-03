package sebanana.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sebastiaan
 */
public class GameviewController implements Initializable {
    
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
    
    // getter ook nog enzoo
}
