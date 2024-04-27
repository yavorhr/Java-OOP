package fairyShop.factory;

import fairyShop.common.ExceptionMessages;
import fairyShop.models.helper.Happy;
import fairyShop.models.helper.Helper;
import fairyShop.models.helper.Sleepy;

public class HelperFactory {
  public static Helper create(String type, String name) {
    Helper helper = null;

    switch (type) {
      case "Sleepy" -> helper = new Sleepy(name);
      case "Happy" -> helper = new Happy(name);
      default -> throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
    }

    return helper;
  }
}
