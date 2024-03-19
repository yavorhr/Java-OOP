package bank.entities.client;

public class Student extends BaseClient {
  private static int INITIAL_INTEREST_PERCENT = 2;

  public Student(String name, String id, double income) {
    super(name, id, INITIAL_INTEREST_PERCENT, income);
  }

  @Override
  public void increase() {
    INITIAL_INTEREST_PERCENT++;
  }
}
