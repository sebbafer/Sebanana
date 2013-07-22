/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.views;

import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
public class StandaardBeeld extends Pane{
    
    private  ObjectenOpslag opslag; 
    private  Me me;
    private  Tekstvak label;
    private  Rugzak rz;
    private  ActionBenodigdheden ab;
    private  PersonageInfoBox pib;
    private final TekstvakModel tvmodel;


    public StandaardBeeld() {
        opslag = new ObjectenOpslag(null);
        label = new Tekstvak();
        tvmodel = label.getModel();
        tvmodel.setText("Welcome!!!");
        rz = new Rugzak();
        ab = new ActionBenodigdheden(label.getModel(), opslag, rz);
        pib = new PersonageInfoBox();
        me = new Me(5.0, 10.0);
        
        this.getChildren().addAll(
                opslag, label, rz, pib, me.getNode()
                );
        
        

        
         /*
         * beweging
         */
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
    
    
    
}
