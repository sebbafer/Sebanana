/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.views;

import java.util.HashMap;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import sebanana.util.grafischeObjecten.figureke.ActionBenodigdheden;
import sebanana.util.grafischeObjecten.personage.Me;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.Tekstvak;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class StandaardBeeld extends Pane{
    
   private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private static ObjectenOpslag opslag; 
    private static Me me;
    private static Tekstvak label;
    private static Rugzak rz;
    private static ActionBenodigdheden ab;
    
    static {
        dX = new HashMap<>();
        dY = new HashMap<>();
        
        dX.put(KeyCode.RIGHT, OFFSET);
        dY.put(KeyCode.RIGHT, 0.0);
        
        dX.put(KeyCode.LEFT, -OFFSET);
        dY.put(KeyCode.LEFT, 0.0);
        
        dX.put(KeyCode.UP, 0.0);
        dY.put(KeyCode.UP, -OFFSET);
        
        dX.put(KeyCode.DOWN, 0.0);
        dY.put(KeyCode.DOWN, OFFSET);
    }
    public StandaardBeeld() {
    
    
    
    
    }
    
    
    
}
