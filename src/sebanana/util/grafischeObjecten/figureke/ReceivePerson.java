package sebanana.util.grafischeObjecten.figureke;

/**
 *
 * @author Ellen
 * 
 * persoon waar je iets van krijgt
 */
public class ReceivePerson extends KlaarPersoon{
    public static final String RECEIVE_PERSON = "ReceivePerson";

    
    @Override
    public String watIsHet() {
        return RECEIVE_PERSON;
    }

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(ActionBenodigdheden ab) {
        System.out.println("blabla");
    }
    
}
