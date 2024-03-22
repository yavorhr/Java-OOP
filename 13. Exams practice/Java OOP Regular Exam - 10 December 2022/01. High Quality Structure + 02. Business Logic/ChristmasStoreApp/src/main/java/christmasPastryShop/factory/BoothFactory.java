package christmasPastryShop.factory;

import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.booths.interfaces.Booth;

public class BoothFactory {

  public static Booth create(String type, int boothNumber, int capacity) {
    Booth booth = null;

    switch (type) {
      case "OpenBooth":
        booth = new OpenBooth(boothNumber, capacity);
        break;
      case "PrivateBooth":
        booth = new PrivateBooth(boothNumber, capacity);
        break;
    }

    return booth;
  }
}
