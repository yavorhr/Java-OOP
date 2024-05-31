package vehicleShop.models.worker;

public class FirstShift extends BaseWorker {
  private static final int INIT_STRENGTH = 100;

  public FirstShift(String name) {
    super(name, INIT_STRENGTH);
  }
}
