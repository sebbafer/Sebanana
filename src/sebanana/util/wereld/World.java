package sebanana.util.wereld;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import sebanana.util.grafischeObjecten.figureke.BasicPerson;
import sebanana.util.grafischeObjecten.figureke.Building;
import sebanana.util.grafischeObjecten.figureke.Figureke;
import sebanana.util.grafischeObjecten.figureke.Item;


/**
 *
 * @author Ellen
 */
@XmlRootElement(name="wereld")
public class World {
    private List<BasicPerson> bp;
    private List<Building> buildings;
    private List<Item> items;
    private int id;
    
    /*
     * hashmap om te weten uit welke lijst een figureke moet verwijderd worden
     */
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

    @XmlElementWrapper (name = "basicpersons")
    @XmlElement (name = "person")
    public List<BasicPerson> getBasicPersons() {
        return bp;
    }

    public void setBasicPersons(List<BasicPerson> basicpersons) {
        this.bp = basicpersons;
        voegToe(bp);
    }
    
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
