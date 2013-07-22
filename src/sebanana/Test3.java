package sebanana;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;
import sebanana.util.grafischeObjecten.figureke.ActionBenodigdheden;
import sebanana.views.StandaardBeeld;

/**
 *
 * @author Ellen
 */
public class Test3 extends Application {
    private Group root;
    private ActionBenodigdheden ab;
    
    @Override
    public void start(final Stage primaryStage) throws JAXBException {
        primaryStage.setTitle("Test3");
        root=new Group();
        /*
         * save knop
         */
        Button save = new Button();
        save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ab.doSaveTest();
            }
        });
        save.setText("Save");
        save.setTranslateX(400);
        save.setTranslateY(20);
        
        
        StandaardBeeld sb = new StandaardBeeld();
        ab=sb.getActionBenodigdheden();
        root.getChildren().add(sb);
        
        
        root.getStylesheets().add("sebanana/opmaak/opmaak.css");
        
        
        primaryStage.setScene(new Scene(root));

        
          root.getChildren().add(save);
      
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

