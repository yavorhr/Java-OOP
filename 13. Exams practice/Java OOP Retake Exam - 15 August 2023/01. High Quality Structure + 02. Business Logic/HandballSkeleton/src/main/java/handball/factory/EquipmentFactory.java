package handball.factory;

import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;

public class EquipmentFactory {
  public static Equipment create(String type) {
    Equipment equipment = null;

    switch (type) {
      case "ElbowPad" -> equipment = new ElbowPad();
      case "Kneepad" -> equipment = new Kneepad();
      default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
    }

    return equipment;
  }
}
