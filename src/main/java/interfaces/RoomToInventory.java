package interfaces;

import server.Item;

import java.util.List;

public interface RoomToInventory {
  /**
   * Remove an item from the inventory
   * @param item The item to remove
   * @return True if successful, false otherwise
   */
  boolean dropItem(Item item);

  /**
   * Place an item into the inventory
   * @param item  The item to place
   * @return True if successful, false otherwise
   */
  boolean placeItem(Item item);

  /**
   * Gets a list of the items contained in this inventory
   * @return
   */
  List<Item> viewInventoryItems();
}
