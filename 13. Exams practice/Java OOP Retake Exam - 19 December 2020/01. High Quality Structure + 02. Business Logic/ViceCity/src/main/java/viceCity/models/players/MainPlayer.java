package viceCity.models.players;

public class MainPlayer extends BasePlayer {
  private static final int INITIAL_LIFE_POINTS = 100;

  public MainPlayer(String name) {
    super(name, INITIAL_LIFE_POINTS);
  }
}
