package sebanana.util.grafischeObjecten.rugzak;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import sebanana.models.Modelverzameling;
import sebanana.util.grafischeObjecten.figureke.Item;

/**
 *
 * @author Ellen
 */
public class Rugzak extends VBox{
    private TableView<Item> tabel;
    private final ObservableList<Item> lijst = FXCollections.observableArrayList();
    private RugzakLezer rl;

    public Rugzak(Modelverzameling mv) {
        leesmxl(); 
        
        tabel = new TableView<>(lijst);

        TableColumn k = new TableColumn("Rugzak");

        k.setCellValueFactory( new PropertyValueFactory<Item,Image>("ImageView"));

      //  k.setCellValueFactory( new PropertyValueFactory<Item,Image>("Node"));
        
        ItemImageCellFactory cf = new ItemImageCellFactory(mv);
        k.setCellFactory(cf);
        k.setEditable(false);
       // k.setMinWidth(75);
        tabel.getColumns().add(k);

        
        this.getStyleClass().add("rugzak");
        
        this.getChildren().add(tabel);
        
        //menu
//        ContextMenu menu = new ContextMenu();
//        MenuItem item = new MenuItem("you can click me");
//          item.setOnAction(new EventHandler<ActionEvent>() {
//               @Override
//               public void handle(ActionEvent event) {
//                    System.out.println("you've clicked the menu item");
//               }
//          });
//          menu.getItems().add(item);
//          tabel.setContextMenu(menu);
        
    
    }
    
    public void doSaveTest(){
          try {
            //schrijven
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(RugzakLezer.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out
            m.marshal(rl, System.out);


        } catch (JAXBException ex) {
            System.err.println(ex);
        }
    }
   
    public Node getTabel(){
        return tabel;
    }
    
    
    public void add(Item i){
        lijst.add(i);
        rl.getItems().add(i);
    }
    
    public boolean remove(Item i){
        rl.getItems().remove(i);
        return lijst.remove(i);
    }
    
    public Item getSelected(){
        int i = tabel.getSelectionModel().getSelectedIndex();
        return lijst.get(i);
    }
    
    public boolean contains(Item i){
        return  lijst.contains(i);
    }
    
    public boolean contains(int id){
        for(Item i: lijst){
            if(i.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(int id){
        Iterator<Item> it = lijst.iterator();
        int teller = 0;
        while(it.hasNext()){
            if(it.next().getId() == id){
                //verwijderen uit rugzaklezer
                rl.getItems().remove(lijst.get(teller));
                it.remove();
                return true;
            }
            teller++;
        }
        return false;
    }

    private void leesmxl() throws RuntimeException {
        try {
            JAXBContext jc = JAXBContext.newInstance(RugzakLezer.class);
            rl = (RugzakLezer) jc.createUnmarshaller().unmarshal(RugzakLezer.class.getResource("Rugzak.xml"));
        } catch (JAXBException ex) {
            throw new RuntimeException("JAXB:" + ex);
        } 
        
        for( Item i : rl.getItems()){
            lijst.add(i);
        }
    }
    
    public void newGame(){
        lijst.clear();
        leesmxl();
    }
}
