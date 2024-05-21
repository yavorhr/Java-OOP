package restaurant.entities.tables;

public class InGarden extends BaseTable {
  private static double PRICE_PER_PERSON = 4.50;

  public InGarden(int tableNumber, int size) {
    super(tableNumber, size, PRICE_PER_PERSON);
  }
}
