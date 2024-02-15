public class Player {
  private String name;
  private int endurance;
  private int sprint;
  private int dribble;
  private int passing;
  private int shooting;

  public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
    this.setName(name);
    this.setEndurance(endurance);
    this.setSprint(sprint);
    this.setDribble(dribble);
    this.setPassing(passing);
    this.setShooting(shooting);
  }

  private void setName(String name) {
    if (Validator.invalidName(name)) {
      throw new IllegalArgumentException(ConstantMessages.INVALID_NAME);
    }
    this.name = name;
  }

  private void setEndurance(int endurance) {
    if (Validator.invalidStat(endurance)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Endurance"));
    }
    this.endurance = endurance;
  }

  private void setSprint(int sprint) {
    if (Validator.invalidStat(sprint)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Sprint"));
    }
    this.sprint = sprint;
  }

  private void setDribble(int dribble) {
    if (Validator.invalidStat(dribble)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Dribble"));
    }
    this.dribble = dribble;
  }

  private void setPassing(int passing) {
    if (Validator.invalidStat(passing)) {
      throw new IllegalArgumentException(ConstantMessages.invalidStatInout("Passing"));
    }
    this.passing = passing;
  }

  private void setShooting(int shooting) {
    if (Validator.invalidStat(shooting)) {
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
    return (this.endurance + this.sprint + this.shooting + this.dribble + this.passing) / 5.00;
  }
}
