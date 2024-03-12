package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;
import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DriverRepository implements Repository<Driver>{
  List<Driver> drivers;

  public DriverRepository() {
    this.drivers = new ArrayList<>();
  }

  @Override
  public Driver getByName(String name) {
    return this.drivers.stream()
            .filter(c -> c.getName().equals(name))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Driver> getAll() {
    return this.drivers;
  }

  @Override
  public void add(Driver driver) {
    this.drivers.add(driver);
  }

  @Override
  public boolean remove(Driver driver) {
    return this.drivers.remove(driver);
  }
}
