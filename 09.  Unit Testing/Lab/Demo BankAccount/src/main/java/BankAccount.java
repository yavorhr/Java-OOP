public class BankAccount {
  private double balance;

  public BankAccount() {
    this.balance = 0.0;
  }

  public void deposit(double balance) {
    if (balance <= 0) {
      throw new IllegalArgumentException("Deposit must be positive amount!");
    }
    this.balance += balance;
  }

  public void withdraw(double balance) {
    this.balance -= balance;
  }

  public double getBalance() {
    return this.balance;
  }
}
