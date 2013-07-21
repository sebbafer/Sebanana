package sebanana.util.grafischeObjecten.figureke;

/**
 *
 * @author Ellen
 */
public class BoringPerson extends Person implements Spatiebaar {
    private static final String BORING_PERSON = "BoringPerson";

    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(final ActionBenodigdheden ab) {
        playSaaieTijdlijn(ab);
    }

    @Override
    public String watIsHet() {
        return BORING_PERSON;
    }
    
}
