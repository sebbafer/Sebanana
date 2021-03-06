package sebanana.views;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sebanana.models.Modelverzameling;
import sebanana.util.grafischeObjecten.figureke.Spatiebaar;
import sebanana.util.grafischeObjecten.figureke.Tegenloopbaar;
import sebanana.util.grafischeObjecten.personage.Me;
import sebanana.util.grafischeObjecten.personage.PersonageInfoBox;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.Tekstvak;
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
    private  PersonageInfoBox pib;
    private  Modelverzameling mv;


    public StandaardBeeld() {
        mv = new Modelverzameling();
        mv.addListener(this);
        /*
         * speelveld
         */
        opslag = mv.getObjectenOpslag();
        me = opslag.getMe();
        /*
         * tekstgedeelte
         */
        label = new Tekstvak(mv.getTekstVakModel());
        label.getModel().setText("Welcome!!!");
        /*
         * rugzak
         */
        rz = mv.getRugzak();
        /*
         * personage info
         */
        pib = new PersonageInfoBox(mv.getPlayerModel());
        mv.getPlayerModel().setName("Sebanana");

        
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
                if(mv.getPlayerModel().isDood()){
                    return;
                }
                
                if(Me.isVerplaatsing(t)){
                    mv.getTekstVakModel().makeEmpty();
                    double nx = me.getX() + Me.getNX(t);
                    double ny = me.getY() + Me.getNY(t);
                    Tegenloopbaar op = opslag.ergensTegen(nx, ny);
                    if (op == null){
                        me.verplaats(nx, ny);
                    }else{ 
                        if(op.hasAction()){
                        op.doAction(mv);
                    }}
                    
                    
                }else if(t.getCode() == KeyCode.SPACE){
                    Spatiebaar b = opslag.opIets(me.getX(),me.getY());
                    
                    if(b != null && b.hasAction()){
                        b.doAction(mv);
                    }
                    
                    
                }
                
                
            }
            
        });
        
        
        
    }

    @Override
    public void invalidated(Observable observable) {
        getChildren().remove(opslag);
        this.opslag=mv.getObjectenOpslag();
        this.me=mv.getObjectenOpslag().getMe();
        getChildren().add(opslag);
    }

    public Modelverzameling getModel(){
        return mv;
    }
    
}
