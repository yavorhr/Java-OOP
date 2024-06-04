package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.factory.WorkerFactory;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

public class ControllerImpl implements Controller {
  private Repository<Worker> workerRepository;
  private Repository<Vehicle> vehicleRepository;

  public ControllerImpl() {
    this.workerRepository = new WorkerRepository();
    this.vehicleRepository = new VehicleRepository();
  }

  @Override
  public String addWorker(String type, String workerName) {
    Worker worker = WorkerFactory.create(type, workerName);
    this.workerRepository.add(worker);

    return String.format(ConstantMessages.ADDED_WORKER, type, workerName);
  }

  @Override
  public String addVehicle(String vehicleName, int strengthRequired) {
    Vehicle vehicle = new VehicleImpl(vehicleName, strengthRequired);

    this.vehicleRepository.add(vehicle);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_VEHICLE, vehicleName);
  }

  @Override
  public String addToolToWorker(String workerName, int power) {
    return null;
  }

  @Override
  public String makingVehicle(String vehicleName) {
    return null;
  }

  @Override
  public String statistics() {
    return null;
  }
}
