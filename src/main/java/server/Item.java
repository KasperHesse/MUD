package server;

public class Item {

  String label;

  public Item(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return "Item{" +
        "label='" + label + '\'' +
        '}';
  }
}
