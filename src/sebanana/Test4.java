package sebanana;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;
import sebanana.luisteraars.PlayerLuisteraar;
import sebanana.models.Modelverzameling;
import sebanana.views.MyMenubar;
import sebanana.views.StandaardBeeld;

/**
 *
 * @author Ellen
 */
public class Test4 extends Application {
    private Modelverzameling ab;
    private BorderPane root;
    
    @Override
    public void start(final Stage primaryStage) throws JAXBException {
        primaryStage.setTitle("Test3");
        root=new BorderPane();

        StandaardBeeld sb = new StandaardBeeld();
        ab=sb.getModel();
        new PlayerLuisteraar(ab);
        root.setCenter(sb);
        root.setTop(new MyMenubar(ab));
        
        
        root.getStylesheets().add("sebanana/opmaak/opmaak.css");
        
        
        primaryStage.setScene(new Scene(root));

        
      
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

