package bank.entities.loan;

public class StudentLoan extends BaseLoan {
  private static final int STUDENT_LOAN_INTEREST_RATE = 1;
  private static final double STUDENT_LOAN_ALLOWED_AMOUNT = 10000;

  protected StudentLoan() {
    super(STUDENT_LOAN_INTEREST_RATE, STUDENT_LOAN_ALLOWED_AMOUNT);
  }
}
