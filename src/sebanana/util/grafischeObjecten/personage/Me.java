package sebanana.util.grafischeObjecten.personage;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Me {
    private double x;
    private double y;
    private Shape shape;

    public Me(double h, double w) {
        //maak vormpje
        this.shape = new Rectangle(h, w);
        shape.setFill(Color.YELLOW);
        this.x = shape.getTranslateX();
        this.y = shape.getTranslateY();
    }
    
    public void verplaats(double x, double y){
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
    
}
