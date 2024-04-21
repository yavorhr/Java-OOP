package bakery.factory;

import bakery.entities.tables.InsideTable;
import bakery.entities.tables.OutsideTable;
import bakery.entities.tables.interfaces.Table;

public class TableFactory {
  public static Table create(String type, int tableNumber, int capacity) {
    Table table = null;

    switch (type) {
      case "InsideTable" -> table = new InsideTable(tableNumber, capacity);
      case "OutsideTable" -> table = new OutsideTable(tableNumber, capacity);
    }
    return table;
  }
}
