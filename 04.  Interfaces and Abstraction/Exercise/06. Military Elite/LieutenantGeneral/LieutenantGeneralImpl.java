package LieutenantGeneral;

import Private.PrivateImpl;
import Soldier.SoldierImpl;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends SoldierImpl implements LieutenantGeneral {
  private List<PrivateImpl> privates;
  private double salary;

  public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
    super(id, firstName, lastName);
    this.privates = new ArrayList<>();
    this.salary = salary;
  }

  @Override
  public void addPrivate(PrivateImpl currentPrivate) {
    this.privates.add(currentPrivate);
  }

  @Override
  public String toString() {
    String superToString = super.toString() + String.format(" Salary: %.2f", this.salary);
    StringBuilder sb = new StringBuilder(superToString);

    sb.append("\nPrivates:");

    if (!this.privates.isEmpty()) {
      sb.append(System.lineSeparator());
      this.privates.forEach(p -> sb.append(p).append(System.lineSeparator()));
    }
    return sb.toString();
  }
}
