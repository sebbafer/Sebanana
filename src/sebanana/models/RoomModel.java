package sebanana.models;

/**
 *
 * @author Sebastiaan
 */
public class RoomModel {
    
    private String roomName;
    
    @Override
    public String toString(){
        return roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    
    
}
