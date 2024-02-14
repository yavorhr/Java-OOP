public class Goat extends Mammal{
  @Override
  public void eat() {
    System.out.println("Goat eats grass...");
  }

  @Override
  void run() {
    System.out.println("Goat is running with 15 km/h");
  }
}
