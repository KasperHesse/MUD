package server;

import interfaces.RoomToInventory;
import interfaces.UserToGameServer;
import interfaces.UserToLevel;
import interfaces.UserToRoom;

import java.util.List;

public class User {
  RoomToInventory inventory;

  UserToGameServer gameServer;
  UserToLevel      level;
  UserToRoom       room;

  public User(UserToGameServer gs) {
    this.gameServer = gs;
    this.inventory = new Inventory();
  }

  public RoomToInventory getInventory() {return this.inventory; }
}
