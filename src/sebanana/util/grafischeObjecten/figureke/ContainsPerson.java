package sebanana.util.grafischeObjecten.figureke;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellen
 */
@XmlRootElement(name="containsperson")
public class ContainsPerson extends Person{
    private String hello;
    private String yes;
    private String no;
    private int idItem;
 
    
    @XmlElement (name = "hello")
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
    
    @XmlElement (name = "yes")
    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @XmlElement (name = "iditem")
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    
    @Override
    public void doAction(final ActionBenodigdheden ab) {
        Timeline timeline = new Timeline();
        
        
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.seconds(0),
                  new EventHandler() {
                         @Override
                          public void handle(Event event) {
                                ab.getLabel().setText(hello);
                         }
                }),
                new KeyFrame(Duration.seconds(1),
                  new EventHandler() {
                         @Override
                          public void handle(Event event) {
                             if(ab.getRugzak().remove(idItem)){
                                    ab.getLabel().setText(yes);
                             }else{
                                   ab.getLabel().setText(no);
                             }
                             
                             
                         }
                })
                
                
                
                
                );
         timeline.playFromStart();
        
      
    }

    @Override
    public String watIsHet() {
        return "ContainsPerson";
    }

    @Override
    public boolean hasAction() {
        return true;
    }

}
