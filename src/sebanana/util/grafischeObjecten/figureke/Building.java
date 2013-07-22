package sebanana.util.grafischeObjecten.figureke;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Ellen
 */
public class Building extends Figureke implements Tegenloopbaar{
   private static final String BUILDING = "building";
   private double height;
   private double width;
   private Shape shape;


   public Building(){
       super.setFill(Color.GRAY);
   }
    
   @Override
   public Shape getShape() {
        if(shape == null){
            shape = new Rectangle(getX(), getY(), width, height);
            shape.setFill(getFill());
        }
        return shape;
    }
   

    
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public Node getNode() {
        return getShape();
    }

   @Override
    public boolean erTegen(double nx, double ny){
         if (nx <= getX()+getWidth() && nx >= getX() 
                    && ny <= getY()+getHeight() && ny >= getY()){
                return true;
            }
         return false;
    }

    @Override
    public String watIsHet() {
        return BUILDING;
    }

    @Override
    public boolean hasAction() {
        return false;
    }

    @Override
    public void doAction() {
        throw new UnsupportedOperationException("heeft geen acite");
    }


}
