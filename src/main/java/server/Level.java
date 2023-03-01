package server;

import interfaces.RoomToInventory;
import interfaces.UserToLevel;
import interfaces.UserToRoom;

import java.util.*;

public class Level implements UserToLevel {

  int id;
  List<Room> rooms;
  Map<Integer, Room> userLocs; //Track the location of users


  public Level(int id) {
    //Levels have ID, associated rooms and track which rooms users are in
    this.id = id;
    this.rooms = new ArrayList<>();
    this.userLocs = new HashMap<>();
    //Same structure as Hubert's original PDF
    rooms.add(new StartRoom(0));
    for (int i=1; i<6; i++) {
      rooms.add(new Room(i));
    }
    rooms.add(new SpecialRoom(6));
    rooms.get(0).setAdjacentRooms(Arrays.asList(rooms.get(1), rooms.get(2)));
    rooms.get(1).setAdjacentRooms(Arrays.asList(rooms.get(0), rooms.get(3), rooms.get(4)));
    rooms.get(2).setAdjacentRooms(Arrays.asList(rooms.get(0), rooms.get(5)));
    rooms.get(3).setAdjacentRooms(Arrays.asList(rooms.get(1)));
    rooms.get(4).setAdjacentRooms(Arrays.asList(rooms.get(1), rooms.get(6)));
    rooms.get(5).setAdjacentRooms(Arrays.asList(rooms.get(2)));
    rooms.get(6).setAdjacentRooms(Arrays.asList(rooms.get(4)));
  }

  /**
   * Get an interface that allows a user to access this level.
   * Notice no "LevelPort" class, since all users can interact with the level through
   * the same port, so they get a handle directly to the implemented interface
   * @return
   */
  UserToLevel getLevelPort() {
    return this;
  }

  /**
   * Get an interface that allows a user to access room 0 on this level,
   * and the level to access that user's inventory
   * @param rti
   * @param userID
   * @return
   */
  public UserToRoom enterLevel(RoomToInventory rti, int userID) {
    this.userLocs.put(userID, this.rooms.get(0));
    return this.rooms.get(0).getPort(rti, userID);
  }

  public void leaveLevel(int userID) {
    this.userLocs.remove(userID).removeUser(userID);
  }

  @Override
  public UserToRoom changeRoom(int userID, Room newRoom) {
    //To change a user's room, we must first find the room that they're in
    Room userRoom = this.userLocs.get(userID);

    if (userRoom.getAdjacentRooms().contains(newRoom)) {
      //IF valid move: Remove old inventory mapping, create new mapping to new room
      this.userLocs.put(userID, newRoom);
      RoomToInventory rti = userRoom.removeUser(userID);
      return newRoom.getPort(rti, userID);
    } else {
      return null;
    }
  }

  @Override
  public int getLevelID() {
    return this.id;
  }
}
