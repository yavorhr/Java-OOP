package restaurant.factory;

import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;

public class TableFactory {
  public static Table create(String type, int tableNumber, int capacity) {
    Table table = null;

    switch (type) {
      case "InGarden" -> table = new InGarden(tableNumber, capacity);
      case "Indoors" -> table = new Indoors(tableNumber, capacity);
      default -> throw new IllegalArgumentException("Invalid table type!")
    }

    return table;
  }
}
