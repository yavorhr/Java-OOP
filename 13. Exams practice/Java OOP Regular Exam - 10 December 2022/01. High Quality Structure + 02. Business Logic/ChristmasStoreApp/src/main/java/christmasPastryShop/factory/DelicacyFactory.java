package christmasPastryShop.factory;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.delicacies.GingerBread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

public class DelicacyFactory {

  public static Delicacy create(String type, String name, double price) {
    Delicacy delicacy = null;

    switch (type) {
      case "Gingerbread":
        delicacy = new GingerBread(name, price);
        break;
      case "Stolen":
        delicacy = new Stolen(name, price);
        break;
    }

    return delicacy;
  }
}
