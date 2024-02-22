
public class Main {
  public static void main(String[] args) {

    try {
      Person person = new Person(null, "Josh", 3);
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
