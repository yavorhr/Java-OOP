package harpoonDiver.factory;

import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;

public class DiverFactory {
  public static Diver create(String kind, String diverName) {
    Diver diver = null;

    switch (kind) {
      case "OpenWaterDiver" -> diver = new OpenWaterDiver(diverName);
      case "DeepWaterDiver" -> diver = new DeepWaterDiver(diverName);
      case "WreckDiver" -> diver = new WreckDiver(diverName);
      default -> throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
    }
    return diver;
  }
}
