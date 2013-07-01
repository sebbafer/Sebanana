package sebanana.util;

import java.util.List;

/**
 *
 * @author Sebastiaan
 */
public class Room {
    
    private String name;
    private String roomID;
    private List<String> connectedRooms; // Een lijst van de roomIDs van aangesloten kamers
    private List<Item> items; // De items in die kamer
    
}
