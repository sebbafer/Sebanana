package sebanana.util.grafischeObjecten.figureke;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Ellen
 */

/*
 * !! waarde mogen niet meer aangepast worden na aanmaak !!
 * exception laten gooien? 
 */
public abstract class Figureke {
   private double x;
   private double y;
   private String name;
   private Color fill = Color.BLACK;
   private static final String IMAGELOCATION = "sebanana/images/";


   public Figureke(){
   }

   /*
    * weten uit welke lijst te verwijderen ofzo
    */
   public abstract String watIsHet();
    
    public abstract Shape getShape();
    /*
     * veel ruimer als shape + enkel doel is visueel weergeven
     * node moet altijd hetzelfde object teruggeven
     */
    public abstract Node getNode();

    
    /*
     * gegevens figuur
     */
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getFill() {
        return fill;
    }

    protected void setFill(Color fill) {
        this.fill = fill;
    }

    
    
    
    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    /*
     * map waar de afbeeldingen opgeslagen zijn
     */
    protected String getImageLocation(){
        return IMAGELOCATION;
    }
   
}
