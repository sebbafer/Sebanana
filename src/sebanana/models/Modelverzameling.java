package sebanana.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.TekstvakModel;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class Modelverzameling implements Observable{
    //alle items personen en bebouwen etc
    private String opslag;
    //al verzamelde items
    private final Rugzak rz;
    //tekst die op label moet staan
    private final TekstvakModel tv;
    //informatie over speler, energy, punten etc
    private final PlayerModel pm;
    private final InstellingenModel im;
    
    private Map<String, ObjectenOpslag> map;

    public Modelverzameling() {
        this.im = new InstellingenModel();
        this.tv = new TekstvakModel();
        
        map = new HashMap<>();
        opslag = "Wereld.xml";
        map.put(opslag,new ObjectenOpslag(opslag, im));
        
        this.rz = new Rugzak(this);
        this.pm = new PlayerModel();
    }
/*
 * getters voor modellen
 */
    public TekstvakModel getTekstVakModel() {
        return tv;
    }

    public ObjectenOpslag getObjectenOpslag() {
        return map.get(opslag);
    }

    public Rugzak getRugzak() {
        return rz;
    }

    public PlayerModel getPlayerModel() {
        return pm;
    }

    public InstellingenModel getInstellingenModel() {
        return im;
    }

    public void setObjectenOpslag(String locatie){
        // if(this.opslag != opslag){
        //  this.opslag=new ObjectenOpslag( locatie);
        //  fireInvalidationEvent();
        //}
        //ok netbeans zokant ook :p
        if(locatie == null ? this.opslag != null : !locatie.equals(this.opslag)){
            ObjectenOpslag get = map.get(locatie);
            if(get == null){
                map.put(locatie, new ObjectenOpslag(locatie, im));
                opslag = locatie;
                fireInvalidationEvent();
            }else{
                this.opslag=locatie;
                fireInvalidationEvent();
            }
        }
    }
    
    public void doSaveTest(){
        rz.doSaveTest();
        for(ObjectenOpslag o: map.values()){
            o.doSaveTest();
        }
        pm.doSaveTest();
    }
    
    public void newGame(){
        
        pm.newGame();
        
        //objectenopslag houd te veel bij dus dees is ff gemakkelijker
        for(ObjectenOpslag m : map.values()){
            m.newGame();
        }
        map.clear();
        opslag = "Wereld.xml";
        map.put(opslag,new ObjectenOpslag(opslag, im));
        
        rz.newGame();

        tv.makeEmpty();
        tv.setText("Welcome");
        
        fireInvalidationEvent();
        
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
