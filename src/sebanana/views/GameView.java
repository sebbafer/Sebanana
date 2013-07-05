/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sebanana.views;

import java.io.IOException;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sebanana.models.GameModel;

/**
 *
 * @author Sebastiaan
 */
public class GameView extends BorderPane implements InvalidationListener {
    
    private GameModel gameModel;
    private GameviewController gameViewController;

    public GameView(Stage stage) throws IOException {
        // Pre-load code
        FXMLLoader loader = new FXMLLoader(
                GameView.class.getResource("gameview.fxml")
                );
        loader.setRoot(this);
        
        loader.load();
        
        // Post-load code
        gameViewController = loader.getController();
        gameViewController.setStage(stage);
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        gameModel.addListener(this);
        
        invalidated(gameModel); // Klein hackje wrs niet forever.
    }
    
    private void setContentText(String text){
        gameViewController.setContent(text);
    }

    @Override
    public void invalidated(Observable o) {
        setContentText(gameModel.getContent());
        // Die " " + is klein voorlopig hackje
        gameViewController.setRoomName(" " + gameModel.getRoomString());
    }
    
    
}
