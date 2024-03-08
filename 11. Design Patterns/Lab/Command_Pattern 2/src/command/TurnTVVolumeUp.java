package command;

import receiver.ElectronicDevice;

public class TurnTVVolumeUp implements Command{
  ElectronicDevice theDevice;

  public TurnTVVolumeUp(ElectronicDevice theDevice) {
    this.theDevice = theDevice;
  }

  @Override
  public void undo() {
    theDevice.volumeDown();
  }

  @Override
  public void execute() {
    theDevice.volumeUp();
  }
}
