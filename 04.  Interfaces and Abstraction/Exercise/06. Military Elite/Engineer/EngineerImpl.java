package Engineer;

import SpecialisedSoldier.SpecialisedSoldierImpl;
import Enums.SpecialCorpsEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
  private List<RepairPart> repairs;
  private double salary;

  public EngineerImpl(int id, String firstName, String lastName, double salary, SpecialCorpsEnum corps) {
    super(id, firstName, lastName, salary, corps);
    this.repairs = new ArrayList<>();
    this.salary = salary;
  }

  @Override
  public void addRepair(RepairPart repairPart) {
    this.repairs.add(repairPart);
  }

  @Override
  public List<RepairPart> getRepairs() {
    return Collections.unmodifiableList(this.repairs);
  }

  @Override
  public String toString() {
    String superToString = super.toString() + String.format(" Salary: %.2f", this.salary);
    StringBuilder sb = new StringBuilder(superToString);

    sb.append(String.format("\nCorps: %s\n", super.getCorps()));
    sb.append("Repairs: ");

    if (!this.repairs.isEmpty()) {
      sb.append(System.lineSeparator());
      this.repairs.forEach(r -> sb.append(r).append(System.lineSeparator()));
    }
    return sb.toString();
  }
}
