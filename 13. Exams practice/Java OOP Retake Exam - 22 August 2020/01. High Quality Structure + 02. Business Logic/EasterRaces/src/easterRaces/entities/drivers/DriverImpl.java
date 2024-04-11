package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;
import easterRaces.validator.Validator;

public class DriverImpl implements Driver {
  private String name;
  private Car car;
  private int numberOfWins;
  private boolean canParticipate;

  public DriverImpl(String name) {
    this.setName(name);
    this.numberOfWins = 0;
    this.canParticipate = false;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Car getCar() {
    return this.car;
  }

  @Override
  public int getNumberOfWins() {
    return this.numberOfWins;
  }

  @Override
  public void addCar(Car car) {
    Validator.throwExceptionIfCarIsNull(car);
    setCar(car);
  }

  @Override
  public void winRace() {
    this.numberOfWins++;
  }

  @Override
  public boolean getCanParticipate() {
    return this.getCar() != null;
  }

  private void setCar(Car car) {
    this.car = car;
    this.canParticipate = true;
  }

  private void setName(String name) {
    Validator.throwExceptionIfEmptyName(name);
    this.name = name;
  }
}
