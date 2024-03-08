package command;

import receiver.ElectronicDevice;

public class TurnTVVolumeDown implements Command{
  ElectronicDevice theDevice;

  public TurnTVVolumeDown(ElectronicDevice theDevice) {
    this.theDevice = theDevice;
  }

  @Override
  public void undo() {
    theDevice.volumeUp();
  }

  @Override
  public void execute() {
    theDevice.volumeDown();
  }
}
