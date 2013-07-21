/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.util.grafischeObjecten.figureke;

/**
 *
 * @author Ellen
 */
public abstract class Spatiebaar extends Figureke{
    
    /*
     * kijken of men op het ding staat
     */
    public abstract boolean hit(double nx, double ny);
    
     /*
     * kijken of actie heeft
     */
    public abstract boolean hasAction();

    /*
     * todo: misschien een klasse voor maken
     */
    public abstract void doAction(ActionBenodigdheden ab);
}
