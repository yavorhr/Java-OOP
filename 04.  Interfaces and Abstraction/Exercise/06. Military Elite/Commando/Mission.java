package Commando;

import Enums.StateEnum;

public class Mission {
  private String codeName;
  private StateEnum state;

  public Mission(String codeName, StateEnum state) {
    this.codeName = codeName;
    this.state = state;
  }

  public void completeMission() {
    this.state = StateEnum.Finished;
  }

  @Override
  public String toString() {
    return String.format("Code Name: %s State: %s", this.codeName, this.state);
  }
}
