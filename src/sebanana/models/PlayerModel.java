package sebanana.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import sebanana.util.grafischeObjecten.personage.PlayerInfoLezer;

/**
 *
 * @author Sebastiaan
 */
public class PlayerModel implements Observable{
     // gegevens over de speler
     // waarde tussen 0 en 100
    private int happiness;
    private int energy;
     // behaald aantal punten in het spel
    private int points;
     // naam van de speler
    private String name;
    private boolean dood;

    public PlayerModel() {
        leesmxl();
    }
        

    
    private boolean juisteWaarde(int waarde, int huidige){
//        if(!(huidige+waarde >=0 && huidige+waarde <=100)){
//            throw new IllegalArgumentException("waarde " + waarde + " te hoog");
//        }
        return waarde != 0 ;
    }
    
    private int controlleer(int waarde) {
        if (waarde <= 0)
            return 0;
        if (waarde >=100)
            return 100;
        
        return waarde;
        
    }
    
    public int getHappiness() {
        return happiness;
    }

    public void addHappiness(int happiness) {
        if(juisteWaarde(happiness, this.happiness)){
        this.happiness += happiness;
        this.happiness=controlleer(this.happiness);
        fireInvalidationEvent();
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void addEnergy(int energy) {
        if(juisteWaarde(energy,this.energy)){
        this.energy += energy;
        this.energy=controlleer(this.energy);
        fireInvalidationEvent();
        }
    }

    
    
    public int getPoints() {
        return points;
    }

//    public void setPoints(int points) {
//        if(this.points != points){
//        this.points = points;
//        fireInvalidationEvent();
//        }
//    }

    public void addPoints(int add){
        if( add != 0){
        this.points +=add;
        fireInvalidationEvent();
        }
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if( (this.name == null && name != null)  ||  !this.name.equals(name)  ){
        this.name = name;
        fireInvalidationEvent();
        }
    }
    
    
    
    
    /*
     * levend of dood
     */
    public boolean isDood(){
        return dood;
    }
    
    public boolean isLevend(){
        return !dood;
    }
   
    @XmlElement (name = "dood")
    public void setDood(String dood){
        this.dood = Boolean.parseBoolean(dood);
    }
    
    public String getSaai(){
        return Boolean.toString(dood);
    }
    
    public void setDood(boolean dood){
       this.dood=dood;
    }
    
    /*
 * model
 */
    private List<InvalidationListener> listeners = new ArrayList<>();
        
    @Override
    public void addListener(InvalidationListener il) {
        listeners.add(il);
    }

    @Override
    public void removeListener(InvalidationListener il) {
        listeners.remove(il);
    }
    
    private void fireInvalidationEvent(){
        for (InvalidationListener il : listeners){
            il.invalidated(this);
        }
    }
    
    /*
     * xml
     */
    public void doSaveTest(){
          try {
              PlayerInfoLezer pi = new PlayerInfoLezer();
              pi.setName(name);
              pi.setPoints(points);
              pi.setEnergy(energy);
              pi.setHappiness(happiness);
            //schrijven
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(PlayerInfoLezer.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(pi, System.out);


        } catch (JAXBException ex) {
            System.err.println(ex);
        }    
    }
    
    private void leesmxl() throws RuntimeException {
        try {
            JAXBContext jc = JAXBContext.newInstance(PlayerInfoLezer.class);
            PlayerInfoLezer pi = (PlayerInfoLezer) jc.createUnmarshaller().unmarshal(PlayerInfoLezer.class.getResource("PlayerInfo.xml"));
            name = pi.getName();
            points = pi.getPoints();
            happiness = pi.getHappiness();
            energy = pi.getEnergy();
            fireInvalidationEvent();
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
    }



    
}
