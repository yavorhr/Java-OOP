import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
  private List<RepairPart> repairs;

  public EngineerImpl(int id, String firstName, String lastName, double salary, SpecialCorpsEnum corps) {
    super(id, firstName, lastName, salary, corps);
    this.repairs = new ArrayList<>();
  }

  @Override
  public void addRepair(RepairPart repairPart) {
    this.repairs.add(repairPart);
  }

  @Override
  public List<RepairPart> getRepairs() {
    return Collections.unmodifiableList(this.repairs);
  }
}
