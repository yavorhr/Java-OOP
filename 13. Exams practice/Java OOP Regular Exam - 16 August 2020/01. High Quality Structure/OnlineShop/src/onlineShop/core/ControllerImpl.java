package onlineShop.core;

import Factory.ComponentFactory;
import Factory.ComputerFactory;
import Factory.PeripheralFactory;
import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.common.enums.ComponentType;
import onlineShop.common.enums.ComputerType;
import onlineShop.common.enums.PeripheralType;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  Map<Integer, Computer> computers;
  Map<Integer, Component> components;
  Map<Integer, Peripheral> peripherals;

  public ControllerImpl() {
    this.computers = new HashMap<>();
  }

  @Override
  public String addComputer(String computerType, int id, String manufacturer, String model, double price) throws ClassNotFoundException, NoSuchMethodException {
    if (doesProductExist(id, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
    }

    Computer computer = ComputerFactory.createComputer(ComputerType.valueOf(computerType), id, manufacturer, model, price);
    computers.put(id, computer);

    return String.format(OutputMessages.ADDED_COMPUTER, id);
  }

  @Override
  public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
    if (doesProductExist(id, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    if (doesProductExist(id, "peripheral")) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
    }

    Computer computer = getComputerById(id);
    Peripheral peripheral = PeripheralFactory.createPeripheral(PeripheralType.valueOf(peripheralType),
            id,
            manufacturer,
            model,
            price,
            overallPerformance,
            connectionType);

    computer.addPeripheral(peripheral);
    return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
  }

  @Override
  public String removePeripheral(String peripheralType, int computerId) {
    return null;
  }

  @Override
  public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
    if (doesProductExist(id, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    if (doesProductExist(id, "component")) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
    }

    Computer computer = getComputerById(id);

    Component component = ComponentFactory.createComponent(ComponentType.valueOf(componentType), id,
            manufacturer,
            model,
            price,
            overallPerformance,
            generation);

    computer.addComponent(component);
    return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
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

  private boolean doesProductExist(int id, String product) {
    boolean result = false;

    switch (product) {
      case "computer" -> result = this.computers.values().stream().anyMatch(comp -> comp.getId() == id);
      case "component" -> result = this.components.values().stream().anyMatch(c -> c.getId() == id);
      case "peripheral" -> result = this.peripherals.values().stream().anyMatch(p -> p.getId() == id);
    }
    return result;
  }

  private Computer getComputerById(int id) {
    return this.computers.get(id);
  }
}
