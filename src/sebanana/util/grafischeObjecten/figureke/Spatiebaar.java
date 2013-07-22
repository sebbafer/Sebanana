
package sebanana.util.grafischeObjecten.figureke;

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
    public  void doAction(ActionBenodigdheden ab);
}
