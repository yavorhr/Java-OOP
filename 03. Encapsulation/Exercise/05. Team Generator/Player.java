public class Player {
  private String name;
  private int endurance;
  private int sprint;
  private int dribble;
  private int passing;
  private int shooting;

  public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
    this.setName(name);
    this.endurance = endurance;
    this.sprint = sprint;
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

  private void setSprint(int sprint) {
    if (!Validator.validateStat(sprint)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Sprint"));
    }
    this.sprint = sprint;
  }

  private void setDribble(int dribble) {
    if (!Validator.validateStat(dribble)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Dribble"));
    }
    this.dribble = dribble;
  }

  private void setPassing(int passing) {
    if (!Validator.validateStat(passing)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Passing"));
    }
    this.passing = passing;
  }

  private void setShooting(int shooting) {
    if (!Validator.validateStat(shooting)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Shooting"));
    }
    this.shooting = shooting;
  }

  public String getName() {
    return this.name;
  }

  public double overallSkillLevel() {
    return this.calcSkillLevel();
  }

  private double calcSkillLevel() {
    return this.endurance + this.sprint + this.shooting + this.dribble + this.passing / 5.00;
  }
}
