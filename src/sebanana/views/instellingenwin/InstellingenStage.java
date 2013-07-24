package sebanana.views.instellingenwin;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sebanana.models.Modelverzameling;

/**
 *
 * @author Ellen
 */
public class InstellingenStage extends Stage{
    private Modelverzameling mv;
    private InstellingenController comp;
    
    public InstellingenStage(Modelverzameling mv) {
            super();
            this.mv = mv;

        try {
            FXMLLoader loader = new FXMLLoader(
                    InstellingenController.class.getResource("Instellingen.fxml")
                    );
            this.comp = new InstellingenController(mv);
            loader.setController(comp);
            Parent root = (Parent) loader.load();
            this.setScene(new Scene(root));
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        this.initModality(Modality.APPLICATION_MODAL);
    }

        
    
    
}
