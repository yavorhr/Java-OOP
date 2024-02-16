package Commando;

import Enums.SpecialCorpsEnum;
import SpecialisedSoldier.SpecialisedSoldierImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
  List<Mission> missions;
  private double salary;

  public CommandoImpl(int id, String firstName, String lastName, double salary, SpecialCorpsEnum corps) {
    super(id, firstName, lastName, salary, corps);
    this.missions = new ArrayList<>();
    this.salary = salary;
  }

  @Override
  public void addMission(Mission mission) {
    this.missions.add(mission);
  }

  @Override
  public List<Mission> getMissions() {
    return Collections.unmodifiableList(this.missions);
  }

  @Override
  public String toString() {
    String superToString = super.toString() + String.format(" Salary: %.2f", this.salary);
    StringBuilder sb = new StringBuilder(superToString);

    sb.append(String.format("\nCorps: %s\n", super.getCorps()));
    sb.append("Missions: ");

    if (!this.missions.isEmpty()) {
      sb.append(System.lineSeparator());
      this.missions.forEach(m -> sb.append(m).append(System.lineSeparator()));
    }

    return sb.toString();
  }
}
