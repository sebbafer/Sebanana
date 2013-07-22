package sebanana.views;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sebanana.util.grafischeObjecten.figureke.ActionBenodigdheden;
import sebanana.util.grafischeObjecten.figureke.Spatiebaar;
import sebanana.util.grafischeObjecten.figureke.Tegenloopbaar;
import sebanana.util.grafischeObjecten.personage.Me;
import sebanana.util.grafischeObjecten.personage.PersonageInfoBox;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.Tekstvak;
import sebanana.util.grafischeObjecten.tekstvak.TekstvakModel;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class StandaardBeeld extends Pane implements InvalidationListener {
    
    private  ObjectenOpslag opslag; 
    private  Me me;
    private  Tekstvak label;
    private  Rugzak rz;
    private  ActionBenodigdheden ab;
    private  PersonageInfoBox pib;
    private final TekstvakModel tvmodel;


    public StandaardBeeld() {
        opslag = new ObjectenOpslag(null);
        me = opslag.getMe();
        label = new Tekstvak();
        tvmodel = label.getModel();
        tvmodel.setText("Welcome!!!");
        rz = new Rugzak();
        ab = new ActionBenodigdheden(label.getModel(), opslag, rz);
        pib = new PersonageInfoBox();
        
        this.getChildren().addAll(
                opslag, label, rz, pib
                );
        
        

        
         /*
         * beweging
         */
        //WAAROMMMMMMMMMMMMMMMMMM :'(
                rz.getTabel()
                        .setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                
                if(Me.isVerplaatsing(t)){
                    double nx = me.getX() + Me.getNX(t);
                    double ny = me.getY() + Me.getNY(t);
                    Tegenloopbaar op = opslag.ergensTegen(nx, ny);
                    if (op == null){
                        me.verplaats(nx, ny);
                    }else if(op.hasAction()){
                        op.doAction();
                    }
                    tvmodel.makeEmpty();
                    
                    
                }else if(t.getCode() == KeyCode.SPACE){
                    Spatiebaar b = opslag.opIets(me.getX(),me.getY());
                    
                    if(b != null && b.hasAction()){
                        b.doAction(ab);
                    }
                    
                    
                }
                
                
            }
            
        });
        
        
        
    }

    @Override
    public void invalidated(Observable observable) {
        /*
         * het enige dat veranderd is de objectenopslag moet ergens bijgehouden worden => actiebenodigdheden is een soort bundel van model (rz en opslag zijn model en view ineen want da lijkt meest efficient denk ik)
         * opslag = model.getobjectenopslag();
         */
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
