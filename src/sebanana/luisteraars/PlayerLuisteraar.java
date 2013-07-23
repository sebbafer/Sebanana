/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.luisteraars;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import sebanana.models.Modelverzameling;
import sebanana.models.PlayerModel;

/**
 *
 * @author Ellen
 */
public class PlayerLuisteraar implements InvalidationListener{
    private final Modelverzameling mv;
    private final PlayerModel pm;

    public PlayerLuisteraar(Modelverzameling mv) {
        this.mv = mv;
        pm = mv.getPlayerModel();
        pm.addListener(this);
    }
    
    
    
    @Override
    public void invalidated(Observable observable) {
        if(pm.getHappiness()<=0 || pm.getEnergy()<=0){
            mv.getTekstVakModel().setText("Game over");
            mv.getPlayerModel().setDood(true);
            return;
        }
        if(pm.getEnergy()<25){
            mv.getTekstVakModel().setText("Weinig energy");
            return;
        }
        if(pm.getHappiness()<25){
            mv.getTekstVakModel().setText("Ongelukkig");
            return;
        }
        
    }
    
}
