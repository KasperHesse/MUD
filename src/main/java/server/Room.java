package server;

import interfaces.RoomToInventory;
import interfaces.UserToRoom;

import java.util.*;

public class Room implements UserToRoom {

  int id;
  List<Item> items;
  List<Room> adjacentRooms;
  Map<Integer, UserToRoomPort> inventories; //Map from userID to that user's inventory

  public Room(int id) {
    this.id = id;
    this.items = new ArrayList<>();
    this.inventories = new HashMap<>();

    for(int i=0; i<(new Random()).nextInt(3)+1; i++) {
      this.items.add(new Item(String.format("Room %d, Item %d", id, i)));
    }
  }

  @Override
  public String toString() {
    return "Room{" +
        "id=" + id +
        ", items=" + items +
        '}';
  }

  /**
   * Get a port into this room
   * @return
   * @param rti
   * @param userID
   */
  public UserToRoom getPort(RoomToInventory rti, int userID) {
    UserToRoomPort utrp = new UserToRoomPort(this, rti);
    this.inventories.put(userID, utrp);
    return utrp;
  }

  public void setAdjacentRooms(List<Room> adj) {
    this.adjacentRooms = adj;
  }

  /**
   * Remove the mapping for a user from this room
   * @param userID
   * @return
   */
  RoomToInventory removeUser(int userID) {
    return inventories.remove(userID).getInventory();
  }


  @Override
  public boolean requestItemPickup(Item item, int userID) {
    if (this.items.contains(item)) {
      this.items.remove(item);
      UserToRoomPort inv = this.inventories.get(userID);
      inv.placeItem(item);
//      this.inventories.computeIfPresent(userID, (x, inv) -> inv.placeItem(item));
      return true;
    }
    return false;
  }

  @Override
  public List<User> getActivePlayerList() {
    return null;
  }

  @Override
  public List<Room> getAdjacentRooms() {
    return this.adjacentRooms;
  }

  @Override
  public List<Item> viewRoomItems() {
    return this.items;
  }

  @Override
  public int getRoomID() {
    return this.id;
  }
}
