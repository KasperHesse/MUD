package server;

import interfaces.UserToRoom;
import interfaces.RoomToInventory;

import java.util.List;

public class UserToRoomPort implements UserToRoom, RoomToInventory {

  UserToRoom room;
  RoomToInventory inventory;

  public UserToRoomPort(UserToRoom room, RoomToInventory inventory) {
    this.room = room;
    this.inventory = inventory;
  }

  RoomToInventory getInventory() {
    return this.inventory;
  }

  @Override
  public String toString() {
    return "UserToRoomPort{" +
        "room=" + room +
        ", inventory=" + inventory +
        '}';
  }

  @Override
  public boolean requestItemPickup(Item item, int userID) {
    return room.requestItemPickup(item, userID);
  }

  @Override
  public List<User> getActivePlayerList() {
    return room.getActivePlayerList();
  }

  @Override
  public List<Room> getAdjacentRooms() {
    return room.getAdjacentRooms();
  }

  @Override
  public List<Item> viewRoomItems() {
    return room.viewRoomItems();
  }

  @Override
  public int getRoomID() {
    return room.getRoomID();
  }

  @Override
  public boolean dropItem(Item item) {
    return inventory.dropItem(item);
  }

  @Override
  public boolean placeItem(Item item) {
    return inventory.placeItem(item);
  }

  @Override
  public List<Item> viewInventoryItems() {
    return inventory.viewInventoryItems();
  }
}
