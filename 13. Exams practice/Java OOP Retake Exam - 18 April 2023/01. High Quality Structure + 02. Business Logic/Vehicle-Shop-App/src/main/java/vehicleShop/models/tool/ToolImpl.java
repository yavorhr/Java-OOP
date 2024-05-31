package vehicleShop.models.tool;

public class ToolImpl implements Tool {
  private int power;

  public ToolImpl(int power) {
    this.power = power;
  }

  @Override
  public int getPower() {
    return this.power;
  }

  @Override
  public void decreasesPower() {
    this.power -= 5;
    if (this.power < 0) {
      this.power = 0;
    }
  }

  @Override
  public boolean isUnfit() {
    return this.power == 0;
  }
}
