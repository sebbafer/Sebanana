/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.util.grafischeObjecten.rugzak;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import sebanana.util.grafischeObjecten.figureke.Item;

/**
 *
 * @author Ellen
 */
@XmlRootElement(name="rugzak")
public class RugzakLezer {
    private List<Item> items;
    
    @XmlElementWrapper (name = "items")
    @XmlElement (name = "item")
    public void setItems(List<Item> items){
        this.items=items;
    }
    
    public List<Item> getItems(){
        return items;
    }
}
