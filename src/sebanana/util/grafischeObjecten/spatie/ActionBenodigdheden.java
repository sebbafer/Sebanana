package sebanana.util.grafischeObjecten.spatie;



import javafx.scene.control.Label;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class ActionBenodigdheden {
    private Label label;
    private ObjectenOpslag opslag;
    private Rugzak rz;

    public ActionBenodigdheden(Label label, ObjectenOpslag opslag, Rugzak rz) {
        this.label = label;
        this.opslag = opslag;
        this.rz = rz;
    }

    public Label getLabel() {
        return label;
    }

    public ObjectenOpslag getObjectenOpslag() {
        return opslag;
    }

    public Rugzak getRugzak() {
        return rz;
    }
    
    
}
