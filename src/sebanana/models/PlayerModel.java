package sebanana.models;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author Sebastiaan
 */
public class PlayerModel implements Observable{
     // gegevens over de speler
     // waarde tussen 0 en 100
    private int happiness;
    private int energy;
     // behaald aantal punten in het spel
    private int points;
     // naam van de speler
    private String name;

    
    
    private boolean juisteWaarde(int waarde){
        return waarde >=0 && waarde <=100;
    }
    
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if(happiness != this.happiness && juisteWaarde(happiness)){
        this.happiness = happiness;
        fireInvalidationEvent();
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if(this.energy != energy && juisteWaarde(energy)){
        this.energy = energy;
        fireInvalidationEvent();
        }
    }

    
    
    public int getPoints() {
        return points;
    }

//    public void setPoints(int points) {
//        if(this.points != points){
//        this.points = points;
//        fireInvalidationEvent();
//        }
//    }

    public void addPoints(int add){
        if( add != 0){
        this.points +=add;
        fireInvalidationEvent();
        }
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!this.name.equals(name)){
        this.name = name;
        fireInvalidationEvent();
        }
    }
    
    /*
 * model
 */
    private List<InvalidationListener> listeners = new ArrayList<>();
        
    @Override
    public void addListener(InvalidationListener il) {
        listeners.add(il);
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
    
    public void doSaveTest(){
        System.out.println("TODO");
    }
    
}
