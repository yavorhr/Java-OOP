public class Main {
  public static void main(String[] args) {

    AddressBuilder addressBuilder = new AddressBuilder();

    Address build = addressBuilder
            .withName("Ivan")
            .withCity("Plodvid")
            .withEmail("ivan@gmail.com")
            .build();
  }
}
