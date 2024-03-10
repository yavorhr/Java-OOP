package Factory;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.enums.PeripheralType;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.*;

public class ComponentFactory {
  public static Component createComponent() {
    Component component = null;

    switch (componentType) {


      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
    }

    return component;
  }
}
