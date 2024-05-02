package handball.entities.gameplay;

import handball.entities.team.BaseTeam;

public class Outdoor extends BaseGameplay {
  private static final int CAPACITY = 150;

  public Outdoor(String name) {
    super(name, CAPACITY);
  }
}
