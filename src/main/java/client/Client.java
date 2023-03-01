package client;

import interfaces.UserToLevel;
import interfaces.UserToRoom;
import server.GameServer;
import server.Item;
import server.Room;
import server.User;

import java.util.List;

public class Client {
  public static void main(String[] args) {
    UserToLevel level;
    UserToRoom room;
    GameServer gs;
    User user;

    gs = new GameServer();
    user = new User(gs);

    //Get a handle to current level
    level = gs.joinGame(1);

    //And enter first room of that level
    //To do so, we must give handle to the user's inventory
    room = level.enterLevel(user.getInventory(), 1);
    System.out.printf("Move: Current room: %s\n", room);

    //Get adjacent rooms
    List<Room> adjRooms = room.getAdjacentRooms();
    System.out.printf("Adjacent rooms: %s\n", adjRooms);

    //And move to an adjacent room
    //Moving to adj room should unlink us from current room and move us to the other room
    room = level.changeRoom(1, adjRooms.get(0));
    System.out.printf("New room: %s\n\n", room);

    //Pick up an item
    System.out.println("Pick up item.");
    List<Item> items = room.viewRoomItems();
    room.requestItemPickup(items.get(0), 1);

    System.out.println(room);
    System.out.println();

    //Moving some more. Notice that inventory moves over and still has the item from room 1
    adjRooms = room.getAdjacentRooms();
    System.out.printf("Move: Adjacent rooms: %s\n", adjRooms);

    room = level.changeRoom(1, adjRooms.get(1));
    System.out.printf("New room: %s\n", room);
  }
}
