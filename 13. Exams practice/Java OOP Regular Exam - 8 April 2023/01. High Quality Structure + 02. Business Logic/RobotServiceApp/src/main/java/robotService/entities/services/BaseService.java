package robotService.entities.services;

import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BaseService implements Service {
  private String name;
  private int capacity;
  private List<Supplement> supplements;
  private List<Robot> robots;

  public BaseService(String name, int capacity) {
    this.name = name;
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

  }

  @Override
  public void removeRobot(Robot robot) {

  }

  @Override
  public void addSupplement(Supplement supplement) {

  }

  @Override
  public void feeding() {

  }

  @Override
  public int sumHardness() {
    return 0;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
