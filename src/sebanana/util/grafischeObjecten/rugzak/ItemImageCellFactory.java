package sebanana.util.grafischeObjecten.rugzak;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author Ellen
 */
            //zielig
public class ItemImageCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
     
    @Override
    public final TableCell<S, T> call(TableColumn<S, T> p) {
        return new ItemImageCell<>();
    }
    
    
    
    public class ItemImageCell<S,T> extends TableCell<S, T>{
        
    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        
        if (empty) {
            setText("");
        setGraphic(null);
        } else {
            ImageView iv = new ImageView((Image) item);
            iv.setFitHeight(50);
            iv.setFitWidth(30);
            
            setGraphic(iv);
        }
    }
    }
    
}
