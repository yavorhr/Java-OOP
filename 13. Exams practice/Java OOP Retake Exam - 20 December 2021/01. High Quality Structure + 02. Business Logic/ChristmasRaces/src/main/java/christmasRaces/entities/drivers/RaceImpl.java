package christmasRaces.entities.drivers;

import christmasRaces.entities.races.Race;
import validations.Validator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RaceImpl implements Race {
  private String name;
  private int laps;
  private List<Driver> drivers;

  public RaceImpl(String name, int laps) {
    setName(name);
    setLaps(laps);
    this.drivers = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getLaps() {
    return this.laps;
  }

  @Override
  public Collection<Driver> getDrivers() {
    return Collections.unmodifiableList(this.drivers);
  }

  @Override
  public void addDriver(Driver driver) {

    this.drivers.add(driver);
  }

  private void setName(String name) {

    this.name = name;
  }

  private void setLaps(int laps) {

    this.laps = laps;
  }

}