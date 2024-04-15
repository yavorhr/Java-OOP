package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;
import validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseService implements Service {
  private String name;
  private int capacity;
  private List<Supplement> supplements;
  private List<Robot> robots;

  public BaseService(String name, int capacity) {
    this.setName(name);
    this.capacity = capacity;
    this.supplements = new ArrayList<>();
    this.robots = new ArrayList<>();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    Validator.validateServiceName(name);
    this.name = name;
  }

  @Override
  public Collection<Robot> getRobots() {
    return Collections.unmodifiableList(this.robots);
  }

  @Override
  public Collection<Supplement> getSupplements() {
    return Collections.unmodifiableList(this.supplements);
  }

  @Override
  public void addRobot(Robot robot) {
    Validator.validateCapacity(this.capacity);
    this.robots.add(robot);
  }

  @Override
  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }

  @Override
  public void addSupplement(Supplement supplement) {

  }

  @Override
  public void feeding() {

  }

  @Override
  public int sumHardness() {
    return this.supplements
            .stream()
            .mapToInt(Supplement::getHardness)
            .sum();
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
