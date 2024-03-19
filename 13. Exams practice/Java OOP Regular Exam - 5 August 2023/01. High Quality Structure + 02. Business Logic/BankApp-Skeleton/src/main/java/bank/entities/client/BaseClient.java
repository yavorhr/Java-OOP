package bank.entities.client;

import bank.validator.Validator;

public abstract class BaseClient implements Client {
  private String name;
  private String id;
  private int interest;
  private double income;

  public BaseClient(String name, String id, int interest, double income) {
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
    Validator.validateClientName(name);
    this.name = name;
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

  public void setId(String id) {
    Validator.validateClientId(id);
    this.id = id;
  }

  public void setIncome(double income) {
    Validator.validateClientIncome(income);
    this.income = income;
  }
}
