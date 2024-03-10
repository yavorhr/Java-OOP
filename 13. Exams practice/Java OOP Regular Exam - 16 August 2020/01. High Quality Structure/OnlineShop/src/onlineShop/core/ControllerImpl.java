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
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller {
  Map<Integer, Computer> computers;
  Map<Integer, Component> components;
  Map<Integer, Peripheral> peripherals;

  public ControllerImpl() {
    this.computers = new HashMap<>();
    this.components = new HashMap<>();
    this.peripherals = new HashMap<>();
  }

  @Override
  public String addComputer(String computerType, int id, String manufacturer, String model, double price) throws ClassNotFoundException, NoSuchMethodException {
    if (doesProductExistById(id, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
    }

    Computer computer = ComputerFactory.createComputer(ComputerType.valueOf(computerType), id, manufacturer, model, price);
    computers.put(id, computer);

    return String.format(OutputMessages.ADDED_COMPUTER, id);
  }

  @Override
  public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
    if (!doesProductExistById(computerId, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    if (doesProductExistById(id, "peripheral")) {
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
    if (doesProductExistById(computerId, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    Computer computer = getComputerById(computerId);
    List<Peripheral> peripherals = computer.getPeripherals();

    if (peripherals.isEmpty() || !doesProductExistByType(peripherals, peripheralType)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
              peripheralType,
              computer.getClass().getSimpleName(),
              computerId));
    }

    Peripheral peripheral = getProductByType(peripherals, peripheralType);

    this.peripherals.remove(peripheral.getId());
    computer.getPeripherals().remove(peripheral);

    return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
  }

  @Override
  public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
    if (!doesProductExistById(computerId, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    if (doesProductExistById(id, "component")) {
      throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
    }

    Computer computer = getComputerById(computerId);

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
    if (doesProductExistById(computerId, "computer")) {
      throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }

    Computer computer = getComputerById(computerId);
    List<Component> components = computer.getComponents();

    if (components.isEmpty() || !doesProductExistByType(components, componentType)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
              componentType,
              computer.getClass().getSimpleName(),
              computerId));
    }

    Component component = getProductByType(components, componentType);

    this.components.remove(component.getId());
    computer.getComponents().remove(component);

    return String.format(OutputMessages.REMOVED_COMPONENT, componentType, component.getId());
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

  // Helpers

  private <T> boolean doesProductExistByType(List<T> collection, String type) {
    return collection.stream().anyMatch(c -> c.getClass().getSimpleName().equals(type));
  }

  private boolean doesProductExistById(int id, String product) {
    boolean result = false;

    switch (product) {
      case "computer" -> result = this.computers.containsKey(id);
      case "component" -> result = this.components.containsKey(id);
      case "peripheral" -> result = this.peripherals.containsKey(id);
    }
    return result;
  }

  private Computer getComputerById(int id) {
    return this.computers.get(id);
  }

  private <T extends Product> T getProductByType(List<T> list, String type) {
    return list.stream()
            .filter(c -> c.getClass().getSimpleName().equals(type))
            .limit(1)
            .findFirst()
            .orElse(null);
  }

}
