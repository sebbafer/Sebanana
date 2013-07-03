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
    private int progress;
    
    private List<InvalidationListener> listeners = new ArrayList<>();
    
    public GameModel(){
        // Initialisatie moet beter gebeuren uiteraard.
        roomModel = new RoomModel();
        playerModel = new PlayerModel();
        
        // Test code:
        roomModel.setRoomName("De begin kamer");
    }

    @Override
    public void addListener(InvalidationListener il) {
        listeners.remove(il);
    }

    @Override
    public void removeListener(InvalidationListener il) {
        listeners.remove(il);
    }
    
    private void fireInvalidationEvent(){
        for (InvalidationListener il : listeners){
            il.invalidated(this);
        }
    }
    
    public static GameModel getInstance(){
        // Hier zullen we de spelvooruitgang inlanden van zodra
        // TODO: Spelvooruitgang inladen
        return new GameModel();
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        fireInvalidationEvent();
    }
    
    public String getContent(){
        // Hier gaat de content voor het spel worden opgehaald enzo
        // afhankelijk van het level.
        // Dit gaat wrs. van een ander deelmodel komen ofzo.
        return "Welkom bij het beste spel ooit. \n"
                + "Hier komt willekeurige tekst dat u door het spel gaat leiden.";
        
    }
    
    public String getRoomString(){
        return roomModel.toString();
    }
    
    
}
