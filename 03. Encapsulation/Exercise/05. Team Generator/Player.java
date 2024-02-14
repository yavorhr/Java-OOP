public class Player {
  private String name;
  private int endurance;
  private int spring;
  private int dribble;
  private int passing;
  private int shooting;

  public Player(String name, int endurance, int spring, int dribble, int passing, int shooting) {
    this.setName(name);
    this.endurance = endurance;
    this.spring = spring;
    this.dribble = dribble;
    this.passing = passing;
    this.shooting = shooting;
  }

  private void setName(String name) {
    if (!Validator.validateName(name)) {
      throw new IllegalArgumentException(ConstantMessages.INVALID_NAME);
    }
    this.name = name;
  }

  private void setEndurance(int endurance) {
    if (!Validator.validateStat(endurance)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Endurance"));
    }
    this.endurance = endurance;
  }

  private void setSpring(int spring) {
    this.spring = spring;
  }

  private void setDribble(int dribble) {
    this.dribble = dribble;
  }

  private void setPassing(int passing) {
    this.passing = passing;
  }

  private void setShooting(int shooting) {
    this.shooting = shooting;
  }

  public String getName() {
    return this.name;
  }

  public double overallSkillLevel(){

  }
}
