package robotService.core;

import robotService.entities.services.Service;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Collection<Service> services;

  public ControllerImpl() {
    this.services = new ArrayList<>();
  }

  @Override
  public String addService(String type, String name) {

    return null;
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
