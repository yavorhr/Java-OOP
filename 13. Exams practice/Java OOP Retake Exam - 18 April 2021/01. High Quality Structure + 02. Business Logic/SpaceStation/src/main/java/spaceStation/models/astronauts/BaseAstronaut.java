package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.validator.Validator;

import java.util.stream.Collectors;

public abstract class BaseAstronaut implements Astronaut {
  private String name;
  private double oxygen;
  private Bag bag;

  protected BaseAstronaut(String name, double oxygen) {
    this.setName(name);
    this.setOxygen(oxygen);
    this.bag = new Backpack();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getOxygen() {
    return this.oxygen;
  }

  @Override
  public boolean canBreath() {
    return this.oxygen > 0;
  }

  @Override
  public Bag getBag() {
    return this.bag;
  }

  protected void decreaseOxygenWhenBreathe(double value) {
    this.oxygen -= value;

    if (oxygen < 0) {
      oxygen = 0;
    }
  }

  private void setName(String name) {
    Validator.validateAstronautName(name);
    this.name = name;
  }

  public void setOxygen(double oxygen) {
    Validator.validateAstronautOxygen(oxygen);
    this.oxygen = oxygen;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.name))
            .append(System.lineSeparator());

    sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.oxygen))
            .append(System.lineSeparator());

    sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, getItemsNames()))
            .append(System.lineSeparator());

    return sb.toString();
  }

  private String getItemsNames() {
    return this.getBag().getItems().size() == 0
            ? "None"
            : String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, this.getBag().getItems());
  }
}
