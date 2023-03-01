package interfaces;

import server.Item;
import server.User;
import server.Room;

import java.util.List;

public interface UserToRoom {

  boolean requestItemPickup(Item item, int userID);

  List<User> getActivePlayerList();

  List<Room> getAdjacentRooms();

  List<Item> viewRoomItems();

  int getRoomID();
}
