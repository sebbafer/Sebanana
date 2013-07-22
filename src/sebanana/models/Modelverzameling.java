/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.models;

import java.util.ArrayList;
import java.util.List;
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
    private ObjectenOpslag opslag;
    private Rugzak rz;
    private TekstvakModel tv;
    private PlayerModel pm;

    public Modelverzameling() {
        this.tv = new TekstvakModel();
        this.opslag = new ObjectenOpslag(null);
        this.rz = new Rugzak();
        this.pm = new PlayerModel();
    }
/*
 * getters voor modellen
 */
    public TekstvakModel getTekstVakModel() {
        return tv;
    }

    public ObjectenOpslag getObjectenOpslag() {
        return opslag;
    }

    public Rugzak getRugzak() {
        return rz;
    }

    public PlayerModel getPlayerModel() {
        return pm;
    }

    public void setObjectenOpslag(ObjectenOpslag opslag){
        if(this.opslag != opslag){
            this.opslag=opslag;
            fireInvalidationEvent();
        }
    }
    
    public void doSaveTest(){
        rz.doSaveTest();
        opslag.doSaveTest();
        pm.doSaveTest();
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
