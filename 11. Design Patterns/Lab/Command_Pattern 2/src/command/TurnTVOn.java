package command;

import receiver.ElectronicDevice;

public class TurnTVOn implements Command {
  private ElectronicDevice theDevice;

  public TurnTVOn(ElectronicDevice theDevice) {
    this.theDevice = theDevice;
  }

  @Override
  public void undo() {
    theDevice.off();
  }

  @Override
  public void execute() {
    theDevice.on();
  }
}
