package restaurant.entities.tables;

public class Indoors extends BaseTable{
  private static double PRICE_PER_PERSON = 3.50;


  public Indoors(int tableNumber, int size) {
    super(tableNumber, size, PRICE_PER_PERSON);
  }
}
