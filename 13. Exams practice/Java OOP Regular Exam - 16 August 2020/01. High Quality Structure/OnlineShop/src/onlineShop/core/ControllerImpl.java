package onlineShop.core;

import onlineShop.core.interfaces.Controller;

public class ControllerImpl implements Controller {


  @Override
  public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
    return null;
  }

  @Override
  public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
    return null;
  }

  @Override
  public String removePeripheral(String peripheralType, int computerId) {
    return null;
  }

  @Override
  public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
    return null;
  }

  @Override
  public String removeComponent(String componentType, int computerId) {
    return null;
  }

  @Override
  public String buyComputer(int id) {
    return null;
  }

  @Override
  public String BuyBestComputer(double budget) {
    return null;
  }

  @Override
  public String getComputerData(int id) {
    return null;
  }
}
