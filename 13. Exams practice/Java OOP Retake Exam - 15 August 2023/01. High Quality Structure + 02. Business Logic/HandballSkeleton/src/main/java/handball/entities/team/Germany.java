package handball.entities.team;

public class Germany extends BaseTeam {
  private static final int ADVANTAGE_INCREASE_VALUE = 145;
  private static final String PLAYING_AREA = "Indoor";

  public Germany(String name, String country, int advantage) {
    super(name, country, advantage);
  }

  @Override
  public void play() {
    super.setAdvantage(ADVANTAGE_INCREASE_VALUE);
  }

  @Override
  public String getPlayingArea() {
    return PLAYING_AREA;
  }
}
