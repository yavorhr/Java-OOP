package Factory;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.enums.PeripheralType;
import onlineShop.models.products.peripherals.*;

public class PeripheralFactory {
  public static Peripheral createPeripheral(PeripheralType peripheralType, int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
    Peripheral peripheral = null;

    switch (peripheralType) {

      case Headset -> peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
      case Keyboard -> peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
      case Monitor -> peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
      case Mouse -> peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
    }

    return peripheral;
  }
}
