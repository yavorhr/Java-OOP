package zoo.core;

import factory.AreaFactory;
import zoo.common.ConstantMessages;
import zoo.entities.areas.Area;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, Area> areas;

  public ControllerImpl() {
    this.areas = new HashMap<>();
  }

  @Override
  public String addArea(String areaType, String areaName) {
    Area area = AreaFactory.create(areaType, areaName);
    this.areas.put(areaName, area);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
  }

  @Override
  public String buyFood(String foodType) {
    return null;
  }

  @Override
  public String foodForArea(String areaName, String foodType) {
    return null;
  }

  @Override
  public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
    return null;
  }

  @Override
  public String feedAnimal(String areaName) {
    return null;
  }

  @Override
  public String calculateKg(String areaName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
