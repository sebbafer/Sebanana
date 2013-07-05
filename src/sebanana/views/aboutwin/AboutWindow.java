package sebanana.views.aboutwin;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Sebastiaan
 */
public class AboutWindow extends AnchorPane {

    public AboutWindow() throws IOException {
        super();
        
        FXMLLoader loader = new FXMLLoader(
                AboutWindow.class.getResource("aboutwindow.fxml")
                );
        
        loader.setRoot(this);
        
        loader.load();
    }
    
}
