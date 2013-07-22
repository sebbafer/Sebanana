package sebanana.util.grafischeObjecten.figureke;

import sebanana.models.Modelverzameling;

/**
 *
 * @author Ellen
 */
public interface Tegenloopbaar {
    
    public boolean erTegen(double nx, double ny);
    
    /*
     * kijken of actie heeft
     */
    public  boolean hasAction();

    /*
     * wat het doet
     */
    public  void doAction(Modelverzameling mv);
}
