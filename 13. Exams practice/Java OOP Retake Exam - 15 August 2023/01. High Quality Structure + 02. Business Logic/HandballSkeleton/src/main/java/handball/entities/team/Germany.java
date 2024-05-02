package handball.entities.team;

public class Germany extends BaseTeam {
  private static final int ADVANTAGE_INCREASE_VALUE = 145;

  public Germany(String name, String country, int advantage) {
    super(name, country, advantage);
  }

  @Override
  public void play() {
    super.setAdvantage(ADVANTAGE_INCREASE_VALUE);
  }
}
