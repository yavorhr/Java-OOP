package bank.entities.loan;

public class MortgageLoan extends BaseLoan {
  private static final int STUDENT_LOAN_INTEREST_RATE = 3;
  private static final double STUDENT_LOAN_ALLOWED_AMOUNT = 50000;

  protected MortgageLoan() {
    super(STUDENT_LOAN_INTEREST_RATE, STUDENT_LOAN_ALLOWED_AMOUNT);
  }
}
