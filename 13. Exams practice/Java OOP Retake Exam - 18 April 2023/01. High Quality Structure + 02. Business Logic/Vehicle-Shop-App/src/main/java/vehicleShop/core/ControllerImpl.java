package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.factory.WorkerFactory;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.WorkerRepository;

public class ControllerImpl implements Controller {
  private Repository<Worker> workerRepository;

  public ControllerImpl() {
    this.workerRepository = new WorkerRepository();
  }

  @Override
  public String addWorker(String type, String workerName) {
    Worker worker = WorkerFactory.create(type, workerName);
    this.workerRepository.add(worker);

    return String.format(ConstantMessages.ADDED_WORKER,type, workerName);
  }

  @Override
  public String addVehicle(String vehicleName, int strengthRequired) {
    return null;
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
