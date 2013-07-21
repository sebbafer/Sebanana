package sebanana.util.grafischeObjecten.figureke;

import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Ellen
 */
public class BoringPerson extends Person implements Spatiebaar {
    private static final String BORING_PERSON = "BoringPerson";
    private List<String> zinnen;

   

    @XmlElementWrapper (name = "zinnen")
    @XmlElement (name = "zin")
    public List<String> getZinnen() {
        return zinnen;
    }

    public void setZinnen(List<String> zinnen) {
        this.zinnen = zinnen;
    }
    
    
    
    
    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(final ActionBenodigdheden ab) {
        Timeline timeline = new Timeline();
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
        
           timeline.playFromStart();
        ab.getTekstVak().setText(zinnen.get(0));
    }

    @Override
    public String watIsHet() {
        return BORING_PERSON;
    }
    
}
