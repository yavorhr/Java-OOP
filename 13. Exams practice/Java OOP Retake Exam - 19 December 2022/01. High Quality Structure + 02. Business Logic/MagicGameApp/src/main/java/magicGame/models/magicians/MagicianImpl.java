package magicGame.models.magicians;

import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {
  private String username;
  private int health;
  private int protection;
  private boolean isAlive;
  private Magic magic;

  protected MagicianImpl(String username, int health, int protection, Magic magic) {
    this.username = username;
    this.health = health;
    this.protection = protection;
    this.magic = magic;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public int getProtection() {
    return this.protection;
  }

  @Override
  public Magic getMagic() {
    return this.magic;
  }

  @Override
  public boolean isAlive() {
    return this.health > 0;
  }

  @Override
  public void takeDamage(int points) {
    int max = Math.max(0, this.protection - points);

    if (max > 0) {
      this.protection -= points;
    } else {
      int diff = Math.abs(this.protection -= points);
      this.protection = 0;
      this.health -= diff;
    }

    if (this.health < 0) {
      this.health = 0;
    }
  }
}
