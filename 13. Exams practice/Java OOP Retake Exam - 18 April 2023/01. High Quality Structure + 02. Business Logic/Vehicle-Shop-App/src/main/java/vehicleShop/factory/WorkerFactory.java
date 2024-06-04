package vehicleShop.factory;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;

public class WorkerFactory {
  public static Worker create(String type, String name) {
    Worker worker;

    switch (type) {
      case "FirstShift" -> worker = new FirstShift(name);
      case "SecondShift" -> worker = new SecondShift(name);
      default -> throw new IllegalArgumentException(ExceptionMessages.WORKER_TYPE_DOESNT_EXIST);
    }

    return worker;
  }
}
