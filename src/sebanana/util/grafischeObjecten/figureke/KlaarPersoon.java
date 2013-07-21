package sebanana.util.grafischeObjecten.figureke;

/**
 *
 * @author Ellen
 */
public abstract class KlaarPersoon extends Person {
    private boolean klaar; // al met gesproken

    public boolean isKlaar(){
        return klaar;
    }
    
    public void setKlaar(String klaar){
        this.klaar= Boolean.getBoolean(klaar);
    }
    
    public String getKlaar(){
        return Boolean.toString(klaar);
    }
    
    public void setKlaar(boolean klaar){
       this.klaar=klaar;
    }

}
