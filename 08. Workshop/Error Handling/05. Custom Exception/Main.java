
public class Main {
  public static void main(String[] args) {

    try {
      Student student = new Student("4avdar", "chavdar@abv.bg");
    } catch (InvalidPersonNameException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
