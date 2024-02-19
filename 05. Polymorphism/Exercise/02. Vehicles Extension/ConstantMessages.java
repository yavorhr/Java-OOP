import java.text.DecimalFormat;

public class ConstantMessages {

  public static final String MUST_BE_POSITIVE = "Fuel must be a positive number";
  public static final String CANNOT_FIT_FUEL = "Cannot fit fuel in tank";

  public static String vehicleNeedsRefuel(String vehicleType) {
    return String.format("%s needs refueling", vehicleType);
  }

  public static String vehicleTravelledKm(String vehicleType, double distance) {
    DecimalFormat formatter = new DecimalFormat("##.##");
    return String.format("%s travelled %s km", vehicleType, formatter.format(distance));

  }
}
