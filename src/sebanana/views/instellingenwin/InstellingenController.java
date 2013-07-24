package sebanana.views.instellingenwin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sebanana.models.Modelverzameling;

/**
 * FXML Controller class
 *
 * @author Ellen
 */
public class InstellingenController implements Initializable {
    @FXML
    private Button toepassen;
    @FXML
    private Button annuleren;
    @FXML
    private Label label1;
    @FXML
    private ChoiceBox<Boolean> box1;
    @FXML
    private Label tittel;
    
    private Modelverzameling mv;

    public InstellingenController(Modelverzameling mv) {
            this.mv = mv;
    }

    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        box1.getItems().clear();
        box1.getItems().add(Boolean.TRUE);
        box1.getItems().add(Boolean.FALSE);
        box1.getSelectionModel().select(mv.getInstellingenModel().getToonShape());
        
        toepassen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                mv.getInstellingenModel().setToonShape(box1.getSelectionModel().getSelectedItem());
                 Stage window = (Stage) annuleren.getScene().getWindow();
                 window.close();               
            }
        });
        
        annuleren.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage window = (Stage) annuleren.getScene().getWindow();
                window.close();
            }
        });
        
    }

    
    
    

    
    
    
    
}
