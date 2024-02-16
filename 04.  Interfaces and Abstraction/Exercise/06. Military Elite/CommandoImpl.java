import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
  List<Mission> missions;

  public CommandoImpl(int id, String firstName, String lastName, double salary, SpecialCorpsEnum corps) {
    super(id, firstName, lastName, salary, corps);
    this.missions = new ArrayList<>();
  }

  @Override
  public void addMission(Mission mission) {
    this.missions.add(mission);
  }

  @Override
  public List<Mission> getMissions() {
    return Collections.unmodifiableList(this.missions);
  }
}
