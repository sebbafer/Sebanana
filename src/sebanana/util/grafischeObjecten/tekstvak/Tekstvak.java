package sebanana.util.grafischeObjecten.tekstvak;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Ellen
 */
public class Tekstvak extends HBox implements Initializable{
    @FXML private Label label;
    @FXML private Label name;
    @FXML private VBox textbox;
    //rechterbox keuzeboxxe ofzo toevoegen misschien ofzo
    @FXML private VBox otherbox;
    
 
    
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeEmpty();
        label.setText("welcome !!!");
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
        clearRight();
    }
    
    public void addRight(Node n){
        otherbox.getChildren().add(n);
    }
    
    public void addAllRight(List<Node> l){
        for(Node n: l){
            addRight(n);
        }
    }
    
    public void removeRight(Node n){
        otherbox.getChildren().remove(n);
    }
    
    public void clearRight(){
        otherbox.getChildren().clear();
    }
}
