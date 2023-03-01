package server;

import interfaces.RoomToInventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements RoomToInventory {

  List<Item> items;

  public Inventory() {
    this.items = new ArrayList<>();
  }
  @Override
  public boolean dropItem(Item item) {
    return this.items.remove(item);
  }

  @Override
  public boolean placeItem(Item item) {
    if (this.items.size() < 5) {
      return this.items.add(item);
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "Inventory{" +
        "items=" + items +
        '}';
  }

  @Override
  public List<Item> viewInventoryItems() {
    return this.items;
  }
}
