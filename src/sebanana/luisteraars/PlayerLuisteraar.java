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
    
    
    /*
     * jaja veel ifs
     */
    @Override
    public void invalidated(Observable observable) {
        if(pm.getHappiness()<=0 || pm.getEnergy()<=0){
            mv.getTekstVakModel().makeEmpty();
            mv.getTekstVakModel().setText("Game over");
            mv.getPlayerModel().setDood(true);
            return;
        }
        if(mv.getPlayerModel().isDood() && pm.getHappiness()>=0 && pm.getEnergy()>=0 ){
            mv.getPlayerModel().setDood(false);
            mv.getTekstVakModel().makeEmpty();
            return;
        }
//        if(pm.getEnergy()<25){
//            mv.getTekstVakModel().setText("Weinig energy");
//            return;
//        }
//        if(pm.getHappiness()<25){
//            mv.getTekstVakModel().setText("Ongelukkig");
//            return;
//        }
        
    }
    
}
