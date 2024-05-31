package vehicleShop.models.worker;

import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class BaseWorker implements Worker {
  private String name;
  private int strength;
  private Collection<Tool> tools;

  protected BaseWorker(String name, int strength) {
    this.name = name;
    this.strength = strength;
    this.tools = new ArrayList<>();
  }

  @Override
  public void working() {
    this.strength -= 10;
    if (this.strength < 0) {
      this.strength = 0;
    }
  }

  @Override
  public void addTool(Tool tool) {
    this.tools.add(tool);
  }

  @Override
  public boolean canWork() {
    return this.strength > 0;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getStrength() {
    return this.strength;
  }

  @Override
  public Collection<Tool> getTools() {
    return Collections.unmodifiableList(this.tools;);
  }
}
