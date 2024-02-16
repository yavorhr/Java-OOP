package SpecialisedSoldier;

import Soldier.SoldierImpl;
import Enums.SpecialCorpsEnum;

public abstract class SpecialisedSoldierImpl extends SoldierImpl {
  private double salary;
  private SpecialCorpsEnum corps;

  public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, SpecialCorpsEnum corps) {
    super(id, firstName, lastName);
    this.salary = salary;
    this.corps = corps;
  }

  public String getCorps() {
    return this.corps.toString();
  }
}
