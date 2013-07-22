package sebanana.util.grafischeObjecten.tekstvak;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
public class Tekstvak extends HBox implements Initializable, InvalidationListener{
    @FXML private Label label;
    @FXML private Label name;
    @FXML private VBox textbox;
    //rechterbox keuzeboxxe ofzo toevoegen misschien ofzo
    @FXML private VBox otherbox;
    private TekstvakModel model;
    
 
    
    public Tekstvak(TekstvakModel model){
        laadFXML();
        
        this.getStyleClass().add("tekstvak");
        
        this.model=model;
        this.model.addListener(this);
    }
    
    public Tekstvak(){
        laadFXML();
        
        this.getStyleClass().add("tekstvak");
        
        this.model=new TekstvakModel();
        this.model.addListener(this);
    }
    
    

    public TekstvakModel getModel(){
        return model;
    }
    
    /*
     * implementaties
     */
    @Override
    public void invalidated(Observable observable) {
        setText(model.getText());
        setName(model.getName());
        setList(model.getList());
    }
        
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    
    
    /*
     * setters
     */
    private void setText(String text){
        label.setText(text);
    }
    
    private void setName(String naam){
        name.setText(naam);
    }
    
    private void setList(List<Node> list){
        //maakt leeg en voegt alles toe
        otherbox.getChildren().setAll(list);
    }

    
    /*
     * private methode
     */
            
    private void laadFXML() throws RuntimeException {
        try {
             FXMLLoader loader = new FXMLLoader(
                     Tekstvak.class.getResource("Tekstvakfxml.fxml"));
             loader.setRoot(this);
             loader.setController(this);

             loader.load();
         } catch (IOException exception) {
             throw new RuntimeException(exception);
         }
    }


}
