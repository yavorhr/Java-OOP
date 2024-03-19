package bank.core;

import bank.entities.loan.Loan;
import bank.factory.BankFactory;
import bank.common.ConstantMessages;
import bank.entities.bank.Bank;
import bank.factory.LoanFactory;
import bank.repositories.LoanRepository;
import bank.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, Bank> banks;
  private LoanRepository loanRepository;

  public ControllerImpl() {
    this.banks = new HashMap<>();
    loanRepository = new LoanRepository();
  }

  @Override
  public String addBank(String type, String name) {
    Bank bank = BankFactory.createBank(type, name);
    this.banks.put(name, bank);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
  }

  @Override
  public String addLoan(String type) {
    Loan loan = LoanFactory.createLoan(type);
    this.loanRepository.addLoan(loan);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
  }

  @Override
  public String returnedLoan(String bankName, String loanType) {
    Validator.validateIfLoanExistsInRepository(this.loanRepository, loanType);

    Loan loan = this.loanRepository.findFirst(loanType);
    this.loanRepository.removeLoan(loan);
    this.banks.get(bankName).addLoan(loan);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, loanType, bankName);
  }

  @Override
  public String addClient(String bankName, String clientType, String clientName, String clientID, double income) {
    return null;
  }

  @Override
  public String finalCalculation(String bankName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
