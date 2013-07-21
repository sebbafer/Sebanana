package sebanana.util.grafischeObjecten.figureke;



import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.Tekstvak;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class ActionBenodigdheden {
    private ObjectenOpslag opslag;
    private Rugzak rz;
    private Tekstvak tv;

    public ActionBenodigdheden(Tekstvak tv, ObjectenOpslag opslag, Rugzak rz) {
        this.tv = tv;
        this.opslag = opslag;
        this.rz = rz;
    }

    public Tekstvak getTekstVak() {
        return tv;
    }

    public ObjectenOpslag getObjectenOpslag() {
        return opslag;
    }

    public Rugzak getRugzak() {
        return rz;
    }
    
    
}
