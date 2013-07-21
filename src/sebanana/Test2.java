package sebanana;

import java.util.HashMap;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;
import sebanana.util.grafischeObjecten.figureke.ActionBenodigdheden;
import sebanana.util.grafischeObjecten.figureke.Spatiebaar;
import sebanana.util.grafischeObjecten.personage.Me;
import sebanana.util.grafischeObjecten.rugzak.Rugzak;
import sebanana.util.grafischeObjecten.tekstvak.Tekstvak;
import sebanana.util.wereld.ObjectenOpslag;

/**
 *
 * @author Ellen
 */
public class Test2 extends Application {
    
   private static final HashMap<KeyCode,Double> dX;
    private static final HashMap<KeyCode,Double> dY;
    private static final double OFFSET = 10;
    
    private static ObjectenOpslag opslag; 
    private static Me me;
    private static Tekstvak label;
    private static Rugzak rz;
    private static ActionBenodigdheden ab;
    
    static {
        dX = new HashMap<>();
        dY = new HashMap<>();
        
        dX.put(KeyCode.RIGHT, OFFSET);
        dY.put(KeyCode.RIGHT, 0.0);
        
        dX.put(KeyCode.LEFT, -OFFSET);
        dY.put(KeyCode.LEFT, 0.0);
        
        dX.put(KeyCode.UP, 0.0);
        dY.put(KeyCode.UP, -OFFSET);
        
        dX.put(KeyCode.DOWN, 0.0);
        dY.put(KeyCode.DOWN, OFFSET);
    }
    
    private final Group root = new Group();
    @Override
    public void start(final Stage primaryStage) throws JAXBException {
        primaryStage.setTitle("Test2");
        
        opslag = new ObjectenOpslag(root, null);
        
        
        label = new Tekstvak();
        root.getChildren().add(label);
        
        
        rz = new Rugzak();
        root.getChildren().add(rz);
        
        ab = new ActionBenodigdheden(label, opslag, rz);
        
        /*
         * save knop
         */
        Button save = new Button();
        save.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                opslag.doSaveTest();
                System.out.println("---");
                rz.doSaveTest();
                System.out.println("- - -");
            }
        });
        save.setText("Save");
        save.setTranslateX(400);
        save.setTranslateY(20);
        root.getChildren().add(save);
        
        /*
         * bewegend figuurtje
         */
        me = new Me(5.0, 10.0);
        root.getChildren().add(me.getNode());
        
        
        
        root.getStylesheets().add("sebanana/opmaak/opmaak.css");
        
        
        /*
         * beweging
         */
        primaryStage.setScene(new Scene(root));
        // waarom???? :(
        //primaryStage.getScene()
                rz.getTabel().setOnKeyPressed(new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent t) {
                
                
                if(dX.get(t.getCode()) != null){
                    double nx = me.getX() + dX.get(t.getCode());
                    double ny = me.getY() + dY.get(t.getCode());
                    
                    if (!opslag.ergensTegen(nx, ny)){
                        me.verplaats(nx, ny);
                    }
                    label.setText(null);
                    
                    
                }else if(t.getCode() == KeyCode.SPACE){
                    Spatiebaar b = opslag.opIets(me.getX(),me.getY());
                    
                    if(b != null && b.hasAction()){
                        b.doAction(ab);
                    }
                    
                    
                }
                
                
            }
            
        });
        
        
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

