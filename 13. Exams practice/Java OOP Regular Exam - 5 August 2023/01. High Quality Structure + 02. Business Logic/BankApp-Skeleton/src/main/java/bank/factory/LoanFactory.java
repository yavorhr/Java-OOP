package bank.factory;

import bank.common.ExceptionMessages;
import bank.entities.loan.Loan;
import bank.entities.loan.MortgageLoan;
import bank.entities.loan.StudentLoan;

public class LoanFactory {
  Loan loan = null;

  public static Loan createLoan(String type) {
    Loan loan = null;

    switch (type) {
      case "MortgageLoan":
        loan = new MortgageLoan();
        break;
      case "StudentLoan":
        loan = new StudentLoan();
        break;
      default:
        throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
    }
    return loan;
  }
}
