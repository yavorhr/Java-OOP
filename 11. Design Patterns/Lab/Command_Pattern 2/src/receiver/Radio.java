package receiver;

public class Radio implements ElectronicDevice {
  private int volume;

  public Radio() {
    this.volume = 0;
  }

  @Override
  public void on() {
    System.out.println("Radio is on");

  }

  @Override
  public void off() {
    System.out.println("Radio is off");
  }

  @Override
  public void volumeUp() {
    this.volume++;
    System.out.println("Radio volume is at: " + this.volume);

  }

  @Override
  public void volumeDown() {
    this.volume++;
    System.out.println("Radio volume is at: " + this.volume);
  }
}
