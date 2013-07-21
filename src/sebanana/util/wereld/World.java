package sebanana.util.wereld;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import sebanana.util.grafischeObjecten.figureke.Building;
import sebanana.util.grafischeObjecten.figureke.Figureke;
import sebanana.util.grafischeObjecten.figureke.Item;
import sebanana.util.grafischeObjecten.figureke.BoringPerson;
import sebanana.util.grafischeObjecten.figureke.ContainsPerson;


/**
 *
 * @author Ellen
 */
@XmlRootElement(name="wereld")
public class World {
    
    private List<Building> buildings;
    private List<BoringPerson> boringpersons;
    private List<ContainsPerson> containspersons;
    private List<Item> items;
    
    private Map<String, List> map;
    
    public World(){
        map = new HashMap<>();
    }
    
    private void voegToe(List l){
        if(l != null && l.size() > 0){
        Figureke s = (Figureke) l.get(0);
        map.put(s.watIsHet(), l);
        }
    }
    
    @XmlElementWrapper (name = "buildings")
    @XmlElement (name = "building")
    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
        voegToe(buildings);
    }

    
    
    @XmlElementWrapper (name = "boringpersons")
    @XmlElement (name = "boringperson")
    public List<BoringPerson> getPersons() {
        return boringpersons;
    }

    public void setPersons(List<BoringPerson> persons) {
        this.boringpersons = persons;
        voegToe(persons);
    }

    
    @XmlElementWrapper (name = "containspersons")
    @XmlElement (name = "containsperson")
    public List<ContainsPerson> getContainsPersons() {
        return containspersons;
    }

    public void setContainsPersons(List<ContainsPerson> p) {
        this.containspersons = p;
        voegToe(p);
    }

    
    
    @XmlElementWrapper (name = "items")
    @XmlElement (name = "item")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        voegToe(items);
    }

    public void remove(Figureke f) {
        map.get(f.watIsHet()).remove(f);
    }


    
    
}
