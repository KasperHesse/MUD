package interfaces;

public interface UserToGameServer {

  /**
   * Log in with a username and password
   * @param username
   * @param password
   * @return
   */
  boolean login(String username, String password);

  /**
   * Join the game, getting a handle to the first level
   * @return
   */
  UserToLevel joinGame(int userID);

  /**
   * Change from one level to the next
   * @return
   * @param currentLevel
   */
  UserToLevel changeLevel(int userID, UserToLevel currentLevel);
}
