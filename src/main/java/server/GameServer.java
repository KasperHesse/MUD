package server;

import interfaces.UserToGameServer;
import interfaces.UserToLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameServer implements UserToGameServer {

  List<LevelComponent> levels;
  Map<Integer, LevelComponent> userLocs;

  public GameServer() {
    this.levels = new ArrayList<>();
    this.levels.add(new LevelComponent(1));
    this.levels.add(new LevelComponent(2));

    this.userLocs = new HashMap<>();
  }

  @Override
  public boolean login(String username, String password) {
    return true; //No checks
  }

  @Override
  public UserToLevel joinGame(int userID) {
    this.userLocs.put(userID, this.levels.get(0));
    return this.levels.get(0).getLevelPort();
  }

  @Override
  public UserToLevel changeLevel(int userID, UserToLevel currentLevel) {
    //TBD
    return null;
  }
}
