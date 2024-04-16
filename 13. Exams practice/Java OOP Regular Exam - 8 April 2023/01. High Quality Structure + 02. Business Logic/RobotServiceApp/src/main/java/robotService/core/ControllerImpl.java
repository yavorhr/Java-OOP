package robotService.core;

import robotService.common.ConstantMessages;
import robotService.entities.services.Service;
import robotService.factory.ServiceFactory;
import robotService.repositories.Repository;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Collection<Service> services;
  private Repository supplementsRepository;

  public ControllerImpl() {
    this.services = new ArrayList<>();
    this.supplementsRepository = new SupplementRepository();
  }

  @Override
  public String addService(String type, String name) {
    Service service = ServiceFactory.create(type, name);
    this.services.add(service);
    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
  }

  @Override
  public String addSupplement(String type) {
    return null;
  }

  @Override
  public String supplementForService(String serviceName, String supplementType) {
    return null;
  }

  @Override
  public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
    return null;
  }

  @Override
  public String feedingRobot(String serviceName) {
    return null;
  }

  @Override
  public String sumOfAll(String serviceName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
