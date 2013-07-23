package sebanana.util.grafischeObjecten.figureke;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import sebanana.models.Modelverzameling;
import sebanana.util.grafischeObjecten.personage.Me;

/**
 *
 * @author Ellen
 */
public class Teleport extends Figureke implements Tegenloopbaar{
    private static final String TELEPORT = "teleport";
    private Shape shape;
    private double height;
    private double width;
    private String Location;

    public Teleport() {
    setFill(Color.AQUA);
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
    @Override
    public String watIsHet() {
        return TELEPORT;
    }

    @Override
    public Shape getShape() {
         if(shape == null){
            shape = new Rectangle(getX(), getY(), width, height);
            shape.setFill(getFill());
        }
        return shape;
    }

    @Override
    public Node getNode() {
        return getShape();
    }

    @Override
    public boolean erTegen(double nx, double ny) {
        // return nx > getX() && ny > getY() && nx < getX()+getWidth() && ny < getY() + getHeight();
        double o = Me.getOFFSET();
        return     nx >= getX() +o
                && nx <= getX() + getWidth() -o
                
                && ny >= getY() +o
                && ny <= getY() + getHeight() -o;
      //  return nx==getX() && ny==getY();
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(Modelverzameling mv) {
        System.out.println("teleport");
        mv.setObjectenOpslag(getLocation());
    }
    
}
