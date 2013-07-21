package sebanana.util.wereld;


import java.io.File;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sebanana.util.grafischeObjecten.figureke.Building;
import sebanana.util.grafischeObjecten.figureke.Figureke;
import sebanana.util.grafischeObjecten.figureke.Item;
import sebanana.util.grafischeObjecten.figureke.Spatiebaar;
import sebanana.util.grafischeObjecten.figureke.BoringPerson;
import sebanana.util.grafischeObjecten.figureke.ContainsPerson;
import sebanana.util.grafischeObjecten.figureke.Tegenloopbaar;

/**
 *
 * @author Ellen
 */
public class ObjectenOpslag {
  
    /*
     * 
     * beste manier om verandering weer te geven??
     */
    private List children;
    
    private final ObservableList<Tegenloopbaar> tegenloopbaredingen = FXCollections.observableArrayList();
    private final ObservableList<Spatiebaar> spatiesdingen = FXCollections.observableArrayList();
    
    private World w;

    public ObjectenOpslag(Group root, File file) {
            this.children=root.getChildren();
            
        try {
            JAXBContext jc = JAXBContext.newInstance(World.class);
            if(file == null){
            w = (World) jc.createUnmarshaller().unmarshal(ObjectenOpslag.class.getResource("Wereld.xml"));
            }else{
            w = (World) jc.createUnmarshaller().unmarshal(file);
            }
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
        for(Building b : w.getBuildings()){
           tegenloopbaredingen.add(b);
           children.add(b.getNode());
        }
        
        /*
         * persons
         */
        for(BoringPerson b : w.getPersons()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        
        for(ContainsPerson b : w.getContainsPersons()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        
        for(Item b : w.getItems()){
            spatiesdingen.add(b);
            children.add(b.getNode());
        }
        

    }

    public void verwijder(Item item){
        children.remove(item.getNode());
        spatiesdingen.remove(item);
        w.remove((Figureke) item);
    }
    
    public boolean hitBuilding(double x, double y){
        for (Tegenloopbaar b : tegenloopbaredingen){
            if (b.erTegen(x, y)){
                return true;
            }
        }
        return false;
    }
    
    public Spatiebaar onSpatiebaarDing(double nx, double ny){
        for (Spatiebaar s : spatiesdingen){
            if(s.erOp(nx, ny)){
                return s;
            }
        }
        return null;
    }
    
    public void doSave(File location){
        try {
            //schrijven
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(World.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to File
             m.marshal(w, location);
            /*
             * http://java-buddy.blogspot.be/2012/05/save-file-with-javafx-filechooser.html
             */

        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    }
    
     public void doSaveTest(){
        try {
            //schrijven
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(World.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(w, System.out);


        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    }

}
