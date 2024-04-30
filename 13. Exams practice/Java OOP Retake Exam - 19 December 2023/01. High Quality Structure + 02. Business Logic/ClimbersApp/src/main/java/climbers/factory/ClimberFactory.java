package climbers.factory;

import climbers.common.ExceptionMessages;
import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;

public class ClimberFactory {
  public static Climber create(String type, String name) {
    Climber climber = null;

    switch (type) {
      case "WallClimber" -> climber = new WallClimber(name);
      case "RockClimber" -> climber = new RockClimber(name);
      default -> throw new IllegalArgumentException(ExceptionMessages.CLIMBER_INVALID_TYPE);
    }

    return climber;
  }
}
