package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;
import validations.Validator;

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
    this.setCar(car);
  }

  @Override
  public void winRace() {
    this.numberOfWins++;
  }

  @Override
  public boolean getCanParticipate() {
    return this.car != null;
  }

  public void setCar(Car car) {
    Validator.throwExceptionIfCarIsNull(car);
    this.car = car;
  }
}
