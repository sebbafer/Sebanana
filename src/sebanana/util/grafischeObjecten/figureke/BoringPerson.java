package sebanana.util.grafischeObjecten.figureke;

/**
 *
 * @author Ellen
 */
public class BoringPerson extends Person implements Spatiebaar {
    private static final String BORING_PERSON = "BoringPerson";
    private String zin;

   
   /*
    * todo: array van maken met meerdere zinnen die er om de beurt op kopen
    */
    public String getZin() {
        return zin;
    }

    public void setZin(String zin) {
        this.zin = zin;
    }
    
    
    @Override
    public boolean hasAction() {
        return true;
    }

    @Override
    public void doAction(ActionBenodigdheden ab) {
        ab.getTekstVak().setText(zin);
    }

    @Override
    public String watIsHet() {
        return BORING_PERSON;
    }
    
}
