package sebanana.util.grafischeObjecten.rugzak;

import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import sebanana.util.grafischeObjecten.spatie.Item;

/**
 *
 * @author Ellen
 */
public class Rugzak extends HBox{
    private TableView<Item> tabel;
    private final ObservableList<Item> lijst = FXCollections.observableArrayList();

    public Rugzak() {

    tabel = new TableView<>(lijst);
    
    TableColumn k = new TableColumn("Rugzak");
    
    k.setCellValueFactory( new PropertyValueFactory<Item,Image>("Image"));
    
    ItemImageCellFactory cf = new ItemImageCellFactory();
    k.setCellFactory(cf);
    k.setEditable(false);
    k.setMinWidth(75);
    tabel.getColumns().add(k);

    tabel.setMaxWidth(80);
    tabel.setTranslateX(500);
    tabel.setTranslateY(50);
    
    
    this.getChildren().add(tabel);
    
    }
    
    
    public Node getTabel(){
        return tabel;
    }
    
    
    public void add(Item i){
        lijst.add(i);
    }
    
    public boolean remove(Item i){
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
        while(it.hasNext()){
            if(it.next().getId() == id){
                it.remove();
                return true;
            }
        }
        return false;
    }
}
