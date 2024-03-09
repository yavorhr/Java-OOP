package Factory;


import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.enums.ComputerType;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;


public class ComputerFactory {
  public static Computer createComputer(ComputerType computerType, int id, String manufacturer, String model, double price) throws NoSuchMethodException, ClassNotFoundException {
    Computer computer = null;

    switch (computerType) {
      case Laptop -> computer = new Laptop(id, manufacturer, model, price);
      case DesktopComputer -> computer = new DesktopComputer(id, manufacturer, model, price);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
    }

    return computer;
  }
}
