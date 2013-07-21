package sebanana.util.grafischeObjecten.tekstvak;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ellen
 */
public class Tekstvak extends HBox {
    @FXML private Label label;
    @FXML private Label name;
 
    
    public Tekstvak(){
       try {
            FXMLLoader loader = new FXMLLoader(
                    Tekstvak.class.getResource("Tekstvakfxml.fxml"));
            loader.setRoot(this);
            loader.setController(this);

            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        
        this.getStyleClass().add("hbox");
        
    }
    
    
    public void setText(String text){
        label.setText(text);
    }
    
    public void setName(String naam){
        name.setText(naam);
    }
    
    public void makeEmpty(){
        label.setText(null);
        name.setText(null);
    }
}
