import command.TurnTVOff;
import command.TurnTVOn;
import command.TurnTVVolumeUp;
import factory.TVRemote;
import invoker.DeviceButton;
import receiver.ElectronicDevice;
import receiver.Radio;
import receiver.Television;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // receiver
    ElectronicDevice newDevice = TVRemote.getDevice();

    //command
    TurnTVOn onCommand = new TurnTVOn(newDevice);

    //invoker
    DeviceButton onPressed = new DeviceButton(onCommand);
    onPressed.press();

    TurnTVOff offCommand = new TurnTVOff(newDevice);
    onPressed = new DeviceButton(offCommand);
    onPressed.press();

    TurnTVVolumeUp volUpCommand = new TurnTVVolumeUp(newDevice);
    onPressed = new DeviceButton(volUpCommand);

    onPressed.press();
    onPressed.press();
    onPressed.press();

  }
}
