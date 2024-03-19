package bank.validator;

import bank.common.ExceptionMessages;
import bank.entities.loan.Loan;
import bank.repositories.LoanRepository;

public class Validator {
  public static void validateClientName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateClientId(String id) {
    if (id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateClientIncome(double income) {
    if (income <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
    }
  }

  public static void validateBankName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.BANK_NAME_CANNOT_BE_NULL_OR_EMPTY);
    }
  }

  public static void validateBankCapacityForNewClients(int capacity) {
    if (capacity == 0) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_ENOUGH_CAPACITY_FOR_CLIENT);
    }
  }

  public static void validateIfLoanExistsInRepository(LoanRepository loanRepository, String type) {
    if (loanRepository.findFirst(type) == null) {
      throw new IllegalArgumentException(ExceptionMessages.INVALID_LOAN_TYPE);
    }
  }
}
