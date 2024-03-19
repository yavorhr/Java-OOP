package bank.core;


import bank.entities.client.Client;
import bank.entities.loan.Loan;
import bank.factory.BankFactory;
import bank.common.ConstantMessages;
import bank.entities.bank.Bank;
import bank.factory.ClientFactory;
import bank.factory.LoanFactory;
import bank.repositories.LoanRepository;
import bank.validator.Validator;

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
    Client client = ClientFactory.createClient(clientType, clientName, clientID, income);
    String bankType = this.banks.get(bankName).getClass().getSimpleName();

    boolean result = Validator.validateIfClientMatchesWithBank(clientType, bankType);
    if (!result) {
      return ConstantMessages.UNSUITABLE_BANK;
    }

    this.banks.get(bankName).addClient(client);
    return (String.format(ConstantMessages.SUCCESSFULLY_ADDED_CLIENT_OR_LOAN_TO_BANK, clientType, bankName));
  }

  @Override
  public String finalCalculation(String bankName) {
    double incomeClients = this.banks.get(bankName).getClients().stream().mapToDouble(Client::getIncome).sum();
    double incomeLoans = this.banks.get(bankName).getLoans().stream().mapToDouble(Loan::getAmount).sum();

    return String.format(ConstantMessages.FUNDS_BANK, bankName, incomeClients + incomeLoans);
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();
    this.banks
            .values()
            .forEach(b -> sb.append(b.getStatistics()));

    return sb.toString().trim();
  }
}
