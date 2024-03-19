package bank.entities.bank;

public class BranchBank extends BaseBank {
  private static final int CAPACITY = 25;

  public BranchBank(String name) {
    super(name, CAPACITY);
  }
}
