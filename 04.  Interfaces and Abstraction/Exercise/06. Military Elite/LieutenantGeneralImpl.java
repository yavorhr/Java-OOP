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
}
