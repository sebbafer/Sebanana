package sebanana.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sebastiaan
 */
public class GameviewController implements Initializable {
    
    private Stage stage;
    
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
    
}
