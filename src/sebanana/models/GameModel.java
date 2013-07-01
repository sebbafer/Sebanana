package sebanana.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author Sebastiaan
 */
public class GameModel implements Observable {
    
    private RoomModel roomModel;
    private PlayerModel playerModel;
    
    private List<InvalidationListener> listeners = new ArrayList<>();

    @Override
    public void addListener(InvalidationListener il) {
        listeners.remove(il);
    }

    @Override
    public void removeListener(InvalidationListener il) {
        listeners.remove(il);
    }
    
}
