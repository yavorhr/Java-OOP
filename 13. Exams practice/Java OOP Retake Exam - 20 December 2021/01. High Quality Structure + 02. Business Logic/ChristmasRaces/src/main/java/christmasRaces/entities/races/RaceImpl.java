package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;
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
    Validator.throwExceptionIfDriverIsNull(driver);
    Validator.throwExceptionIfDriverCannotParticipate(driver);
    Validator.throwExceptionIfDriverAlreadyExistsInTheRace(this.drivers, driver, name);
    this.drivers.add(driver);
  }

  private void setName(String name) {
    Validator.throwExceptionIfEmptyName(name);
    this.name = name;
  }

  private void setLaps(int laps) {
    Validator.throwExceptionIfLapsAreBelowOne(laps);
    this.laps = laps;
  }

}