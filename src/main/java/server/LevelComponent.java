package server;

import interfaces.*;

/**
 * Level component. Level logic is implemented in class Level
 */
public class LevelComponent implements UserToLevel {

  //Level logic is implemented here. Could also be directly in the component
  Level level;

  public LevelComponent(int id) {
    this.level = new Level(id);
  }

  /**
   * Get a port into this level, allowing the user to interface with it
   * @return
   */
  public UserToLevel getLevelPort() {
    return level.getLevelPort();
  }

  @Override
  public UserToRoom enterLevel(RoomToInventory rti, int userID) {
    return level.enterLevel(rti, userID);
  }

  @Override
  public UserToRoom changeRoom(int userID, Room newRoom) {
    return level.changeRoom(userID, newRoom);
  }

  @Override
  public int getLevelID() {
    return level.getLevelID();
  }

}
