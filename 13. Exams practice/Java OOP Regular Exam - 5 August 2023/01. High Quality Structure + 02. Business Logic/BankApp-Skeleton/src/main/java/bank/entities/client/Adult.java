package bank.entities.client;

public class Adult extends BaseClient {
  private static int INITIAL_INTEREST_PERCENT = 4;

  public Adult(String name, String id, double income) {
    super(name, id, INITIAL_INTEREST_PERCENT, income);
  }

  @Override
  public void increase() {
    INITIAL_INTEREST_PERCENT += 2;
  }
}
