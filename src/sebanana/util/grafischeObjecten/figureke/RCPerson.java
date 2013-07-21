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
@XmlRootElement(name="rcperson")
public class RCPerson extends KlaarPersoon {
    private static final String RC_PERSON = "RCPerson";
    private String geef;
    private Item item;
    private String yes;
    private String no;
    private int idItem;
    private boolean gekregen = false;

    /*
     * krijgen
     */
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
    
    
    /*
     * geven
     */
    
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
        return RC_PERSON;
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(final ActionBenodigdheden ab) {
        if(!isKlaar()){
             Timeline timeline = new Timeline();
             int teller = 0;
            //begroeting
             timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(teller),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                         ab.getTekstVak().setText(getHello());
                                     }
                            })  );
             teller++;
             //krijgen
             if(getIdItem() != 0){
                timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(teller),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                         if(ab.getRugzak().remove(getIdItem())){
                                                ab.getTekstVak().setText(getYes());
                                                idItem=0;
                                                gekregen = true;
                                         }else{
                                               ab.getTekstVak().setText(getNo());
                                               gekregen = false;
                                         }
                                     }
                            })  );
                teller++;
             }
             
             //geven
             if(getItem() != null){
                  timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(teller),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                         if(gekregen){
                                           ab.getTekstVak().setText(getGeef());
                                           ab.getRugzak().add(item);
                                           item=null;
                                           setKlaar(true);
                                         }else{
                                             System.out.println("nog niks gegeven");
                                         }
                                     }
                            })  );
                teller++;
             }
                      
                      
                      
                       timeline.playFromStart();

        }else{
            playSaaieTijdlijn(ab);
        }
    }
    
}
