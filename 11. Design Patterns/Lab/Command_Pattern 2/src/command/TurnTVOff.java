package command;

import receiver.ElectronicDevice;

public class TurnTVOff implements Command{
  private ElectronicDevice theDevice;

  public TurnTVOff(ElectronicDevice theDevice) {
    this.theDevice = theDevice;
  }

  @Override
  public void undo() {
    theDevice.on();
  }

  @Override
  public void execute() {
    theDevice.off();
  }
}

