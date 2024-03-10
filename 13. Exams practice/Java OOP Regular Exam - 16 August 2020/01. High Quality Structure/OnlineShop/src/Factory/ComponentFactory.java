package Factory;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.enums.ComponentType;
import onlineShop.models.products.components.*;

public class ComponentFactory {
  public static Component createComponent(ComponentType componentType) {
    Component component = null;

    switch (componentType) {

      case CentralProcessingUnit -> component = new CentralProcessingUnit();
      case Motherboard -> component = new Motherboard();
      case PowerSupply -> component = new PowerSupply()
      case RandomAccessMemory -> component = new RandomAccessMemory();
      case SolidStateDrive -> component = new SolidStateDrive();
      case VideoCard -> component = new VideoCard();
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
    }

    return component;
  }
}
