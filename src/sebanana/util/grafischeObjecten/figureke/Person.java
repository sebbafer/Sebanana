package sebanana.util.grafischeObjecten.figureke;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public abstract class Person extends Spatiebaar{
    private double radius;
    private Shape shape;

    public Person() {
    super.setFill(Color.BLUE);
    }

   
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Circle(getX(), getY(), getRadius());
            shape.setFill(getFill());
        }
        return shape;
    }
   
    @Override
   public Node getNode(){
       return getShape();
   }
   
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public boolean hit(double nx, double ny){
        if(getX()+2*getRadius()>nx && getX()-2*getRadius()<nx
                    &&
               getY()+2*getRadius()>ny && getY()-2*getRadius()<ny 
                    ){
                return true;
            }
        return false;
    }
    
    
}
