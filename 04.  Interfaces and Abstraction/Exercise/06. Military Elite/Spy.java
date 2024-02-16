public class Spy extends SoldierImpl {
  private String codeNumber;

  public Spy(int id, String firstName, String lastName, String condeNumber) {
    super(id, firstName, lastName);
    this.codeNumber = condeNumber;
  }
}
