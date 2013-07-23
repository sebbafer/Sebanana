package sebanana.util.grafischeObjecten.rugzak;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import sebanana.models.Modelverzameling;
import sebanana.util.grafischeObjecten.figureke.Item;

/**
 *
 * @author Ellen
 */
            //zielig
public class ItemImageCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    private Modelverzameling mv;

    public ItemImageCellFactory(Modelverzameling mv) {
        this.mv = mv;
    }
    

    @Override
    public final TableCell<S, T> call(TableColumn<S, T> p) {
        return new ItemImageCell<>();
    }
    
    
    
    public class ItemImageCell<S,T> extends TableCell<S, T>{

        public ItemImageCell() {

            
        }
        
    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        
        if (empty) {
            setText("");
            setGraphic(null);
        } else {
            //afbeelding
            ImageView iv = new ImageView((Image) item);
            iv.setFitHeight(50);
            iv.setFitWidth(30);
            
            setGraphic(iv);
                    
            
            //contextmenu
            final Item o = (Item) this.getTableView().getItems().get(this.getIndex());
            this.setContextMenu(o.getContextMenu(mv));     
            
        }
    }
    }
    
}
