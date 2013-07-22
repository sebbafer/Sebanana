
package sebanana.util.grafischeObjecten.figureke;

import sebanana.models.Modelverzameling;

/**
 *
 * @author Ellen
 */
public  interface Spatiebaar {
    
    /*
     * kijken of men op het ding staat
     */
    public  boolean erOp(double nx, double ny);
    
     /*
     * kijken of actie heeft
     */
    public  boolean hasAction();

    /*
     * 
     */
    public  void doAction(Modelverzameling ab);
}
