package sebanana.util.grafischeObjecten.figureke;



import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.TekstvakModel;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class ActionBenodigdheden {
    private ObjectenOpslag opslag;
    private Rugzak rz;
    private TekstvakModel tv;

    public ActionBenodigdheden(TekstvakModel tv, ObjectenOpslag opslag, Rugzak rz) {
        this.tv = tv;
        this.opslag = opslag;
        this.rz = rz;
    }
    //opslag kan veranderen => setter?
/*
 * getters
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
    
    public void doSaveTest(){
        rz.doSaveTest();
        opslag.doSaveTest();
    }
    
    
}
