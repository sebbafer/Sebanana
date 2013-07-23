package sebanana.util.grafischeObjecten.tekstvak;

import java.util.ArrayList;
import java.util.List;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Node;
import sebanana.util.grafischeObjecten.figureke.Person;

/**
 *
 * @author Ellen
 */
public class TekstvakModel  implements Observable{
    private String name;
    private String text;
    private List<Node> list = new ArrayList<>();
    private List<Node> legelijst = new ArrayList<>();
    private Person talking;
    private Timeline t;

    public String getName() {
            return name;
    }

    public Person getTalkingPerson() {
        return talking;
    }
/*
 * de persoon waar je mee aant praten ben zo kan ook later een afbeelding ofzo uit de person halen
 */
    public void setTalkingPerson(Person person) {
        if(!person.equals(talking)){
            talking=person;
            this.name = person.getName();
            fireInvalidationEvent();
        }
    }

    
    
    public String getText() {
        return text;
    }

    public void setText(String tekst) {
        if(!tekst.equals(this.text)){
            this.text = tekst;
            fireInvalidationEvent();
        }
    }

    public List<Node> getList() {
        return list;
    }

    public void setList(List<Node> list) {
        if(list != this.list){
            this.list = list;
            fireInvalidationEvent();
        }
    }
    
    public void makeEmpty(){
        if(!isLeeg()){
            text=null;
            name=null;
            list=legelijst;
            talking=null;
            if(t != null){
                t.stop();
                t=null;
            }
            fireInvalidationEvent();
        }
    }
    
    public boolean isLeeg(){
        return ( list == null || list.isEmpty() )  
                && text == null 
                && name == null && talking == null;
    }

    public void setTimeline(Timeline t){
        this.t=t;
        t.playFromStart();
    }
    
    
/*
 * model
 */
    private List<InvalidationListener> listeners = new ArrayList<>();
        
    @Override
    public void addListener(InvalidationListener il) {
        listeners.add(il);
    }

    @Override
    public void removeListener(InvalidationListener il) {
        listeners.remove(il);
    }
    
    private void fireInvalidationEvent(){
        for (InvalidationListener il : listeners){
            il.invalidated(this);
        }
    }
}
