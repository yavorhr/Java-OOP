package Engineer;

public class RepairPart {
  private String partName;
  private int hoursWorked;

  public RepairPart(String number, int hoursWorked) {
    this.partName = number;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public String toString() {
    return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
  }
}
