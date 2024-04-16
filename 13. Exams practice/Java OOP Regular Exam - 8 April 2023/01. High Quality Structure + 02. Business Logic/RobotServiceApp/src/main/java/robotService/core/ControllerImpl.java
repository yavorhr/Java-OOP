package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.services.Service;
import robotService.entities.supplements.Supplement;
import robotService.factory.ServiceFactory;
import robotService.factory.SupplementFactory;
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
    Supplement supplement = SupplementFactory.create(type);
    this.supplementsRepository.addSupplement(supplement);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
  }

  @Override
  public String supplementForService(String serviceName, String supplementType) {
    Service service = findService(serviceName);
    Supplement supplement = this.supplementsRepository.findFirst(supplementType);

    if (supplement == null) {
      return String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType);
    }

    service.addSupplement(supplement);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
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

  // helpers
  private Service findService(String serviceName) {
    return this.services
            .stream()
            .filter(s -> s.getName().equals(serviceName))
            .findFirst()
            .orElse(null);
  }
}
