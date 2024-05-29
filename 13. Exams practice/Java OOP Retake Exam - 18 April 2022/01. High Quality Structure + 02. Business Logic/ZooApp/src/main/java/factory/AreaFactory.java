package factory;

import zoo.common.ExceptionMessages;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;

public class AreaFactory {
  public static Area create(String type, String name) {
    Area area = null;

    switch (type) {
      case "WaterArea" -> area = new WaterArea(name);
      case "LandArea" -> area = new LandArea(name);
      default -> throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
    }
    return area;
  }
}
