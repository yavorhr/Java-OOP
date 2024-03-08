package factory;

import receiver.ElectronicDevice;
import receiver.Television;

public class TVRemote {
  public static ElectronicDevice getDevice() {
    return new Television();
  }
}
