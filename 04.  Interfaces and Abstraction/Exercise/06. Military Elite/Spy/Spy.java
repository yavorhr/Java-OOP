package Spy;

import Soldier.SoldierImpl;

public class Spy extends SoldierImpl {
  private String codeNumber;

  public Spy(int id, String firstName, String lastName, String condeNumber) {
    super(id, firstName, lastName);
    this.codeNumber = condeNumber;
  }

  @Override
  public String toString() {
    return super.toString() + " Code Number: " + this.codeNumber;
  }
}
