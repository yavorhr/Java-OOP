public enum StateEnum {
  IN_PROGRESS("inProgress"),
  FINISHED("finished");

  private String stringValue;

  StateEnum(String value) {
    this.stringValue = value;
  }

}
