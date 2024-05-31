package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;

public class VehicleRepository implements Repository<Vehicle> {


  @Override
  public Collection<Vehicle> getWorkers() {
    return null;
  }

  @Override
  public void add(Vehicle model) {

  }

  @Override
  public boolean remove(Vehicle model) {
    return false;
  }

  @Override
  public Vehicle findByName(String name) {
    return null;
  }
}
