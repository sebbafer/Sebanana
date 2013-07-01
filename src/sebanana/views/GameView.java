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
import sebanana.models.GameModel;

/**
 *
 * @author Sebastiaan
 */
public class GameView extends BorderPane implements InvalidationListener {
    
    private GameModel gameModel;

    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(
                GameView.class.getResource("gameview.fxml")
                );
        loader.setRoot(this);
        loader.load();
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
        gameModel.addListener(this);
    }

    @Override
    public void invalidated(Observable o) {
        // Update de gameview
    }
    
    
    
}
