package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;
import validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BaseService implements Service {
  private String name;
  private int capacity;
  private List<Supplement> supplements;
  private List<robotService.entities.robot.Robot> robots;

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
  public void addSupplement(Supplement supplement) {
    this.supplements.add(supplement);
  }

  @Override
  public void removeRobot(Robot robot) {
    this.robots.remove(robot);
  }

  @Override
  public void addRobot(Robot robot) {
    Validator.validateCapacity(this.capacity);
    this.robots.add(robot);
  }


  @Override
  public void feeding() {
    this.robots.forEach(Robot::eating);
  }

  public double sumRobotsPrices() {
    return this.robots
            .stream()
            .mapToDouble(Robot::getPrice)
            .sum();
  }

  public double sumSupplements() {
    return this.supplements
            .stream()
            .mapToDouble(Supplement::getPrice)
            .sum();
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
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
    sb.append(String.format("Robots: %s", getRobotNames())).append(System.lineSeparator());
    sb.append(String.format("Supplements: %d Hardness: %d", this.supplements.size(), this.sumHardness())).append(System.lineSeparator());

    return sb.toString();
  }

  private String getRobotNames() {
    if (this.robots.size() == 0) {
      return "None";
    }
    return this.robots.stream().map(robotService.entities.robot.Robot::getName).collect(Collectors.joining(", "));
  }
}
