package bank.entities.bank;

import bank.entities.client.Client;
import bank.entities.loan.Loan;
import bank.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBank implements Bank {
  private String name;
  private int capacity;
  private Collection<Loan> loans;
  private Collection<Client> clients;

  protected BaseBank(String name, int capacity) {
    this.name = name;
    this.capacity = capacity;
    this.loans = new ArrayList<>();
    this.clients = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    Validator.validateBankName(name);
    this.name = name;
  }

  @Override
  public Collection<Client> getClients() {
    return this.clients;
  }

  @Override
  public Collection<Loan> getLoans() {
    return this.loans;
  }

  @Override
  public void addClient(Client client) {
    Validator.validateBankCapacityForNewClients(this.capacity);
    this.clients.add(client);
  }

  @Override
  public void removeClient(Client client) {

  }

  @Override
  public void addLoan(Loan loan) {

  }

  @Override
  public int sumOfInterestRates() {
    return this.loans.stream().mapToInt(Loan::getInterestRate).sum();
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
