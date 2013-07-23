
package sebanana.util.grafischeObjecten.personage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ellen
 */
@XmlRootElement(name="player")
public class PlayerInfoLezer {
    private String name;
    private int happiness;
    private int energy;
    private int points;
    private boolean dood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    @XmlElement (name = "dood")
    public void setDood(String dood){
        this.dood = Boolean.parseBoolean(dood);
    }
    
    public String getDood(){
        return Boolean.toString(dood);
    }
    
    public void setDood(boolean dood){
       this.dood=dood;
    }
    
    public boolean isDood(){
        return dood;
    }
}
