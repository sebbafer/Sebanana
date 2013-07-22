package sebanana.util.grafischeObjecten.personage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import sebanana.models.PlayerModel;

/**
 *
 * @author Ellen
 */
public class PersonageInfoBox extends GridPane implements Initializable, InvalidationListener{
    @FXML
    private Label name;
    @FXML
    private ProgressBar energybar;
    @FXML
    private Label energylabel;
    @FXML
    private Label happinesslabel;
    @FXML
    private Label points;
    @FXML
    private ProgressBar happinessbar;
    @FXML
    private ImageView personimage;
    private PlayerModel pm;

    public PersonageInfoBox() {
            laadFXML();
            this.getStyleClass().add("personageinfobox");
            pm = new PlayerModel();
            pm.addListener(this);
    }

    public PersonageInfoBox(PlayerModel pm) {
            laadFXML();
            this.getStyleClass().add("personageinfobox");
            this.pm=pm;
            pm.addListener(this);
    }
    

    public PlayerModel getPlayerModel() {
        return pm;
    }

    
    
    
    
    
    /*
     * private methode
     */
            
    private void laadFXML() throws RuntimeException {
        try {
             FXMLLoader loader = new FXMLLoader(
                     PersonageInfoBox.class.getResource("PersonageInfoFXML.fxml"));
             loader.setRoot(this);
             loader.setController(this);

             loader.load();
         } catch (IOException exception) {
             throw new RuntimeException(exception);
         }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @Override
    public void invalidated(Observable observable) {
        happinessbar.setProgress(getWaarde(pm.getHappiness()));
        energybar.setProgress(getWaarde(pm.getEnergy()) );
        name.setText(pm.getName());
        points.setText(""+pm.getPoints());
    
    }

    private double getWaarde(int waarde) {
        return (double) waarde/100;
    }
}
