package bank.entities.client;

public abstract class BaseClient implements Client {
  private String name;
  private int id;
  private int interest;
  private double income;

  public BaseClient(String name, int id, int interest, double income) {
    this.setName(name);
    this.setId(id);
    this.interest = interest;
    this.setIncome(income);
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {

  }

  @Override
  public int getInterest() {
    return this.interest;
  }

  @Override
  public double getIncome() {
    return this.income;
  }

  @Override
  public void increase() {

  }

  public void setId(int id) {
    this.id = id;
  }

  public void setIncome(double income) {
    this.income = income;
  }
}
