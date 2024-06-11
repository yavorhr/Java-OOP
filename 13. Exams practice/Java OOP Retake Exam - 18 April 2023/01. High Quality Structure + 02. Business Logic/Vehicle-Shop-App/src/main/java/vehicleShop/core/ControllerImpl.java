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

    long brokenInstruments = 0;

    for (Worker worker : workers) {
      shop.make(vehicle, worker);
      brokenInstruments += getCountBrokenTools(worker);

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
    long size = getReachedVehicles();

    List<String> collect = workerRepository.getModels().stream()
            .map(helper -> String.format("Name: %s, Strength: %d%n" +
                            "Tools: %d fit left%n", helper.getName(), helper.getStrength(),
                    (int) helper.getTools().stream().filter(instrument -> !instrument.isUnfit()).count())).collect(Collectors.toList());

    return String.format("%d vehicles are ready!%n", size) + String.format("Info for workers:%n") + String.join("", collect).trim();
  }

  // Helpers
  private Worker getWorker(String workerName) {
    Worker worker = this.workerRepository.findByName(workerName);

    if (worker == null) {
      throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
    }
    return worker;
  }

  private long getReachedVehicles() {
    return vehicleRepository.getModels().stream().filter(Vehicle::reached).count();
  }

  private List<Worker> getWorkersWithEnergyAbove70() {
    List<Worker> workers =
            this.workerRepository
                    .getModels()
                    .stream()
                    .filter(w -> w.getStrength() > 70)
                    .collect(Collectors.toList());

    if (workers.isEmpty()) {
      throw new IllegalArgumentException(ExceptionMessages.NO_WORKER_READY);
    }
    return workers;
  }

  private long getCountBrokenTools(Worker worker) {
    return worker.getTools().stream().filter(Tool::isUnfit).count();
  }
}
