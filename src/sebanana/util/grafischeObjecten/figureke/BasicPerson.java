package sebanana.util.grafischeObjecten.figureke;

import java.util.Objects;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javax.xml.bind.annotation.XmlElement;
import sebanana.models.Modelverzameling;

/**
 *
 * @author Ellen
 */
public class BasicPerson extends Person {
    private static final String RC_PERSON = "RCPerson";
    private String geef;
    private Item item;
    private String yes;
    private String no;
    private int idItem;
    private boolean gekregen = false;
    private String hello;


    @XmlElement (name = "hello")
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
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
    public void doAction(final Modelverzameling ab) {
        ab.getTekstVakModel().setTalkingPerson(this);
        if(!isSaai()){
             Timeline timeline = new Timeline();
             int teller = 0;
            //begroeting
             timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(teller),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                         ab.getTekstVakModel().setText(getHello());
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
                                                ab.getTekstVakModel().setText(getYes());
                                                idItem=0;
                                                deelEenOk(ab);
                                                setSaai(true);
                                         }else{
                                               ab.getTekstVakModel().setText(getNo());
                                               gekregen = false;
                                         }
                                     }


                            })  );
                teller++;
             }else{
                 deelEenOk(ab);
             }
             
             //geven
             if(getItem() != null){
                  timeline.getKeyFrames().add(
                            new KeyFrame(Duration.seconds(teller),
                              new EventHandler() {
                                     @Override
                                      public void handle(Event event) {
                                         if(gekregen){
                                           ab.getTekstVakModel().setText(getGeef());
                                           ab.getRugzak().add(item);
                                           item=null;
                                           setSaai(true);
                                         }
                                     }
                            })  );
                teller++;
             }
                      
                      
                      

             ab.getTekstVakModel().setTimeline(timeline);
        }else{
            ab.getTekstVakModel().setTimeline(getSaaieTijdlijn(ab));
        }
    }
    
     private void deelEenOk(Modelverzameling ab) {
        gekregen = true;
        ab.getPlayerModel().addPoints(getPoints());
        ab.getPlayerModel().addEnergy(getEnergy());
        ab.getPlayerModel().addHappiness(getHappiness());
    }
/*
 *  als namen gelijk zijn is het dezelfde
 *  TODO: msch wat uitgebrijder maken
 */
    @Override
    public boolean equals(Object o) {
        if( o == null ||o.getClass() != this.getClass()) {return false;}
        BasicPerson cast = (BasicPerson) o;
        return cast.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getName());
        return hash;
    }
    
}
