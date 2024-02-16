package Engineer;

import java.util.List;

public interface Engineer {

  void addRepair(RepairPart repairPart);

  List<RepairPart> getRepairs();

}
