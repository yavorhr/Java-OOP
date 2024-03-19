package bank.factory;

import bank.common.ExceptionMessages;
import bank.entities.client.Adult;
import bank.entities.client.Client;
import bank.entities.client.Student;

public class ClientFactory {
  Client client = null;

  public static Client createClient(String type, String name, String id, double income) {
    Client client = null;

    switch (type) {
      case "Adult" -> client = new Adult(name, id, income);
      case "Student" -> client = new Student(name, id, income);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_CLIENT_TYPE);
    }
    return client;
  }
  
}


