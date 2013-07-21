package sebanana.util.grafischeObjecten.tekstvak;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ellen
 */
public class Tekstvak extends HBox {
    private Label label;
 
    
    public Tekstvak(){
        label = new Label("Welkom!!!!");
        this.getChildren().add(label);
    }
    
    public void setText(String text){
        label.setText(text);
    }
}
