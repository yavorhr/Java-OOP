package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;
import easterRaces.validator.Validator;

public class DriverImpl implements Driver {
  private String name;
  private Car car;
  private int numberOfWins;
  private boolean canParticipate;

  public DriverImpl(String name) {
    this.name = name;
    this.numberOfWins = 0;
    this.canParticipate = false;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public Car getCar() {
    return null;
  }

  @Override
  public int getNumberOfWins() {
    return 0;
  }

  @Override
  public void addCar(Car car) {
    Validator.throwExceptionIfCarIsNull(car);
    setCar(car);
  }

  @Override
  public void winRace() {

  }

  @Override
  public boolean getCanParticipate() {
    return this.getCar() != null;
  }

  private void setCar(Car car) {
    this.car = car;
    this.canParticipate = true;
  }
}
