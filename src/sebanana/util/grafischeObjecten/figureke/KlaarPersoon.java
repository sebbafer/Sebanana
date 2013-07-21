package sebanana.util.grafischeObjecten.figureke;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Ellen
 */
public abstract class KlaarPersoon extends Person {
    private boolean klaar; // al met gesproken
    private String hello;

    @XmlElement (name = "hello")
    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
    
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
