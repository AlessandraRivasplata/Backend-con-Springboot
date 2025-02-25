package datatransfer;

import java.util.List;

import entity.Room;

public class RoomsWrapper {
    private List<Room> rooms;

    public RoomsWrapper(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

