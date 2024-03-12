package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarRepository implements Repository<Car> {
  List<Car> cars;

  public CarRepository() {
    this.cars = new ArrayList<>();
  }

  @Override
  public Car getByName(String model) {
    return this.cars.stream()
            .filter(c -> c.getModel().equals(model))
            .findFirst()
            .orElse(null);
  }

  @Override
  public Collection<Car> getAll() {
    return this.cars;
  }

  @Override
  public void add(Car car) {
    this.cars.add(car);
  }

  @Override
  public boolean remove(Car car) {
    return this.cars.remove(car);
  }
}
