package interfaces;

import server.Room;
import server.User;

public interface UserToLevel {

  /**
   * Enter the level, getting a handle to the first room
   * @return
   */
  UserToRoom enterLevel(RoomToInventory rti, int userID);

  /**
   * Change room in this level, getting a handle to the next room
   * @param userID ID of the user that wishes to change room
   * @param newRoom The room that they wish to change into
   * @return
   */
  UserToRoom changeRoom(int userID, Room newRoom);

  /**
   * Get ID of current level, for tracking progress
   * @return
   */
  int getLevelID();
}
