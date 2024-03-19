package bank.factory;

import bank.common.ExceptionMessages;
import bank.entities.bank.Bank;
import bank.entities.bank.BranchBank;
import bank.entities.bank.CentralBank;

public class BankFactory {

  public static Bank createBank(String type, String name) {
    Bank bank = null;

    switch (type) {
      case "CentralBank":
        bank = new CentralBank(name);
        break;
      case "BranchBank":
        bank = new BranchBank(name);
        break;
      default:
        throw new IllegalArgumentException(ExceptionMessages.INVALID_BANK_TYPE);
    }
    return bank;
  }
}
