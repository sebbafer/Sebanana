package sebanana.util.wereld;


import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sebanana.util.grafischeObjecten.figureke.BasicPerson;
import sebanana.util.grafischeObjecten.figureke.Building;
import sebanana.util.grafischeObjecten.figureke.Figureke;
import sebanana.util.grafischeObjecten.figureke.Item;
import sebanana.util.grafischeObjecten.figureke.Spatiebaar;
import sebanana.util.grafischeObjecten.figureke.Tegenloopbaar;
import sebanana.util.grafischeObjecten.personage.Me;

/**
 *
 * @author Ellen
 */
public class ObjectenOpslag extends Group{
    int height = 400;
    int width = 550;
    private final ObservableList<Tegenloopbaar> tegenloopbaredingen = FXCollections.observableArrayList();
    private final ObservableList<Spatiebaar> spatiesdingen = FXCollections.observableArrayList();
    
    private World w;
    private final Me me;

    public ObjectenOpslag( File file) {            
        /*
         * lezen
         */
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

        /*
         * tegenloopbaar
         */
        for(Building b : w.getBuildings()){
           tegenloopbaredingen.add(b);
           this.getChildren().add(b.getNode());
        }
        
        tegenloopbaredingen.add(new randen());
        
        /*
         * spatiebaar
         */
         for(BasicPerson b : w.getBasicPersons()){
            spatiesdingen.add(b);
            this.getChildren().add(b.getNode());
        }
        
        for(Item b : w.getItems()){
            spatiesdingen.add(b);
            this.getChildren().add(b.getNode());
        }
       /*
        * me blokje
        */
        me = new Me(5.0, 10.0);
        me.verplaats(w.getXme(), w.getYme());
        this.getChildren().add(me.getNode());
    }

    public void verwijder(Item item){
        //verwijderen van beeld
        this.getChildren().remove(item.getNode());
        //verwijderen uit spatie lijst
        spatiesdingen.remove(item);
        //verwijderen uit world
        w.remove((Figureke) item);
    }
    
    /*
     * geeft terug waar tegen loopt
     * als niks geeft null terug
     */
    public Tegenloopbaar ergensTegen(double x, double y){
        for (Tegenloopbaar b : tegenloopbaredingen){
            if (b.erTegen(x, y)){
                return b;
            }
        }
        return null;
    }
    
    /*
     * geeft terug waar het opstaat
     * als op niks geeft null terug
     */
    public Spatiebaar opIets(double nx, double ny){
        for (Spatiebaar s : spatiesdingen){
            if(s.erOp(nx, ny)){
                return s;
            }
        }
        return null;
    }
    
    public void doSave(File location){
        w.setXme(me.getX());
        w.setYme(me.getY());
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
        w.setXme(me.getX());
        w.setYme(me.getY());
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

    public Me getMe() {
        return me;
    }


     
     
     
     
     
     
     
     
     
     /*
      * de randen
      */
     private class randen implements Tegenloopbaar{

        @Override
        public boolean erTegen(double nx, double ny) {
            return nx <= 0 || ny <= 0 ||ny >= getHeight() || nx >= getWidth();
            
        }

        @Override
        public boolean hasAction() {
            return false;
        }

        @Override
        public void doAction() {
            /* TODO:
             * code voor het verplaatsen van alles 
             */
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
     
     
}
