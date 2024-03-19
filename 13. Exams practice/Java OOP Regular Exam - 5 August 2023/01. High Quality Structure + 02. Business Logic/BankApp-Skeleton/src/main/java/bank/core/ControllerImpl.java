package bank.core;

import bank.factory.BankFactory;
import bank.common.ConstantMessages;
import bank.entities.bank.Bank;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Collection<Bank> banks;

  public ControllerImpl() {
    this.banks = new ArrayList<>();
  }

  @Override
  public String addBank(String type, String name) {
    Bank bank = BankFactory.createBank(type, name);
    this.banks.add(bank);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_BANK_OR_LOAN_TYPE, type);
  }

  @Override
  public String addLoan(String type) {
    return null;
  }

  @Override
  public String returnedLoan(String bankName, String loanType) {
    return null;
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
