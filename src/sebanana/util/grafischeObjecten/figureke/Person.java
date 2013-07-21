package sebanana.util.grafischeObjecten.figureke;

import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Ellen
 */
public abstract class Person extends Figureke implements Spatiebaar{
    private double radius;
    private Shape shape;
    private List<String> zinnen;
    private Timeline timeline;
    
    
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
    public boolean erOp(double nx, double ny){
        if(getX()+2*getRadius()>nx && getX()-2*getRadius()<nx
                    &&
               getY()+2*getRadius()>ny && getY()-2*getRadius()<ny 
                    ){
                return true;
            }
        return false;
    }
    
    
    
    /*
     * tekst
     */
    @XmlElementWrapper (name = "zinnen")
    @XmlElement (name = "zin")
    public List<String> getZinnen() {
        return zinnen;
    }

    public void setZinnen(List<String> zinnen) {
        this.zinnen = zinnen;
    }
    
    public void playSaaieTijdlijn(final ActionBenodigdheden ab){
       if(zinnen.size() == 1){
         ab.getTekstVak().setText(zinnen.get(0));
          
       }else{
            if(timeline == null){
                    timeline = new Timeline();
                    for(int i=0; i < zinnen.size(); i++){
                      final int hulp = i;
                      timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(hulp),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                            ab.getTekstVak().setText(zinnen.get(hulp));
                                     }
                            }));
                        }
                 }

                timeline.playFromStart();
       }
    }
    
}
