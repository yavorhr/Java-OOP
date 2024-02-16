public class Mission {
  private String codeName;
  private StateEnum state;

  public Mission(String codeName, StateEnum state) {
    this.codeName = codeName;
    this.state = state;
  }

  public void completeMission() {
    this.state = StateEnum.FINISHED;
  }
}
