package sebanana.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author Ellen
 */
public class InstellingenModel implements Observable{
   /*
    * toon afbeelding of shape => items
    */
    private boolean toonShape=false;

    public boolean getToonShape() {
        return toonShape;
    }

    public void setToonShape(boolean toonShape) {
        if(toonShape != this.toonShape){
        this.toonShape = toonShape;
        fireInvalidationEvent();
        }
    }
   

   
    
    /*
 * model
 */
    private List<InvalidationListener> listeners = new ArrayList<>();
        
    @Override
    public void addListener(InvalidationListener il) {
        listeners.add(il);
    }

    @Override
    public void removeListener(InvalidationListener il) {
        listeners.remove(il);
    }
    
    private void fireInvalidationEvent(){
        for (InvalidationListener il : listeners){
            il.invalidated(this);
        }
    }
}
