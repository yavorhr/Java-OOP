package Factory;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.enums.ComponentType;
import onlineShop.models.products.components.*;

public class ComponentFactory {
  public static Component createComponent(ComponentType componentType, int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
    Component component = null;

    switch (componentType) {

      case CentralProcessingUnit -> component = new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
      case Motherboard -> component = new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
      case PowerSupply -> component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
      case RandomAccessMemory -> component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
      case SolidStateDrive -> component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
      case VideoCard -> component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
    }

    return component;
  }
}
