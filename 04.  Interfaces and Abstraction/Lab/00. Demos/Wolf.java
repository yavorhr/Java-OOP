public class Wolf extends Mammal{
  @Override
  public void eat() {
    System.out.println("Wolf eats meat...");
  }

  @Override
  void run() {
    System.out.println("Wolf is running with 30 km/h");
  }
}
