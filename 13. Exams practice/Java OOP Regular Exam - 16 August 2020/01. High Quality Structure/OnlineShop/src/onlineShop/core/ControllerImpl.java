package onlineShop.core;

import Factory.ComputerFactory;
import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.common.enums.ComputerType;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.computers.Computer;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
  List<Computer> computers;

  public ControllerImpl() {
    this.computers = new ArrayList<>();
  }

  @Override
  public String addComputer(String computerType, int id, String manufacturer, String model, double price) throws ClassNotFoundException, NoSuchMethodException {
    if (doesComputerExist(id)) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
    }

    Computer computer = ComputerFactory.createComputer(ComputerType.valueOf(computerType), id, manufacturer, model, price);
    computers.add(computer);
    return String.format(OutputMessages.ADDED_COMPUTER, id);
  }

  @Override
  public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
    return null;
  }

  @Override
  public String removePeripheral(String peripheralType, int computerId) {
    return null;
  }

  @Override
  public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
    return null;
  }

  @Override
  public String removeComponent(String componentType, int computerId) {
    return null;
  }

  @Override
  public String buyComputer(int id) {
    return null;
  }

  @Override
  public String BuyBestComputer(double budget) {
    return null;
  }

  @Override
  public String getComputerData(int id) {
    return null;
  }

  private boolean doesComputerExist(int id) {
    return this.computers.stream().anyMatch(c -> c.getId() == id);
  }
}
