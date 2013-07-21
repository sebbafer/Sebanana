
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
     * todo: misschien een klasse voor maken
     */
    public  void doAction(ActionBenodigdheden ab);
}
