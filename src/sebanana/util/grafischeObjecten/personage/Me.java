package sebanana.util.grafischeObjecten.personage;

import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 * alles over de verplaatsing van het vakje en het vakje blabla 
 */
public class Me {
    private double x;
    private double y;
    private Shape shape;
   
   private static final HashMap<KeyCode,Double> dX;
   private static final HashMap<KeyCode,Double> dY;
   private static final double OFFSET = 10;
 
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
    
    
    
    public Me(double h, double w) {
        //maak vormpje
        this.shape = new Rectangle(h, w);
        shape.setFill(Color.YELLOW);
        this.x = shape.getTranslateX();
        this.y = shape.getTranslateY();
        //standaardPlaats
        verplaats(getOFFSET(), getOFFSET());

    }
    
    public final void verplaats(double x, double y){
        getNode().setTranslateX(x);
        this.x=x;
        getNode().setTranslateY(y);
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Shape getShape() {
        return shape;
    }
    
    public Node getNode(){
        return getShape();
    }
    
    
    public static boolean isVerplaatsing(KeyEvent t){
        return dX.containsKey(t.getCode());
    }
    
    public static double getNX(KeyEvent t){
        return dX.get(t.getCode());
    }
    
    public static double getNY(KeyEvent t){
        return dY.get(t.getCode());
    }
    
    public static double getOFFSET(){
        return OFFSET;
    }
}
