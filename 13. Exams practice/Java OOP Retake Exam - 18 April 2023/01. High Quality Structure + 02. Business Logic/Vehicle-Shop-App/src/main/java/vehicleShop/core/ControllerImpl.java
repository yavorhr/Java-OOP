package vehicleShop.core;

import vehicleShop.common.ConstantMessages;
import vehicleShop.common.ExceptionMessages;
import vehicleShop.factory.WorkerFactory;
import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.Tool;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.Repository;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
  private Repository<Worker> workerRepository;
  private Repository<Vehicle> vehicleRepository;
  private Shop shop;

  public ControllerImpl() {
    this.workerRepository = new WorkerRepository();
    this.vehicleRepository = new VehicleRepository();
    this.shop = new ShopImpl();
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
    Worker worker = getWorker(workerName);

    Tool tool = new ToolImpl(power);
    worker.addTool(tool);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOOL_TO_WORKER, power, workerName);
  }

  @Override
  public String makingVehicle(String vehicleName) {
    List<Worker> workers = getWorkersWithEnergyAbove70();
    Vehicle vehicle = this.vehicleRepository.findByName(vehicleName);

    int brokenInstruments = 0;

    for (Worker worker : workers) {
      shop.make(vehicle, worker);
      brokenInstruments += (int) worker.getTools().stream().filter(Tool::isUnfit).count();
      if (vehicle.reached()) {
        break;
      }
    }

    if (vehicle.reached()) {
      return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "done") +
              String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    return String.format(ConstantMessages.VEHICLE_DONE, vehicleName, "not done") +
            String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);

  }

  @Override
  public String statistics() {
    return null;
  }

  // Helpers
  private Worker getWorker(String workerName) {
    Worker worker = this.workerRepository.findByName(workerName);

    if (worker == null) {
      throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
    }
    return worker;
  }

  private List<Worker> getWorkersWithEnergyAbove70() {
    List<Worker> workers =
            this.workerRepository
                    .getWorkers()
                    .stream()
                    .filter(w -> w.getStrength() > 70)
                    .collect(Collectors.toList());

    if (workers.isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
    }
    return workers;
  }

  private boolean noWorkersLeft(List<Worker> workers) {
    return workers.stream().noneMatch(Worker::canWork);
  }

  private Worker findFirstWorkerWithEnoughStrength(List<Worker> workers) {
    return workers.stream().filter(Worker::canWork).findFirst().orElse(null);
  }

}
