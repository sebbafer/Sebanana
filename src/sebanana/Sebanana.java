package sebanana;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sebanana.models.GameModel;
import sebanana.views.GameView;

/**
 *
 * @author Sebastiaan
 */
public class Sebanana extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        // View en model
        GameModel gameModel = GameModel.getInstance();
        GameView view = new GameView(primaryStage);
        view.setGameModel(gameModel);
        
        // Scene bouwen
        Scene scene = new Scene(view);
        
        // Stage instellen
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sebanana het spel");
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
