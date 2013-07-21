package sebanana.util.grafischeObjecten.figureke;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellen
 * 
 * persoon waar je iets van krijgt
 */
@XmlRootElement(name="receiveperson")
public class ReceivePerson extends KlaarPersoon{
    private static final String RECEIVE_PERSON = "ReceivePerson";
    private String geef;
    private Item item;

    public String getGeef() {
        return geef;
    }

    public void setGeef(String geef) {
        this.geef = geef;
    }

    public void setItem(Item item){
        this.item=item;
    }
 
    public Item getItem(){
        return item;
    }
    
    
    
    
    @Override
    public String watIsHet() {
        return RECEIVE_PERSON;
    }

    

    
    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(final ActionBenodigdheden ab) {
        if(!isKlaar()){
             Timeline timeline = new Timeline();
                      timeline.getKeyFrames().addAll(
                            new KeyFrame(Duration.seconds(0),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                            ab.getTekstVak().setText(getHello());
                                     }
                            }),
                            new KeyFrame(Duration.seconds(1),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                       ab.getTekstVak().setText(getGeef());
                                       ab.getRugzak().add(item);
                                       item=null;
                                       setKlaar(true);


                                     }
                            })
                            );


                       timeline.playFromStart();

        }else{
            playSaaieTijdlijn(ab);
        }
    }
    
}
