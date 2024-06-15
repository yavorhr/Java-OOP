package magicGame.models.magicians;

import magicGame.models.magics.Magic;
import validator.Validator;

public abstract class MagicianImpl implements Magician {
  private String username;
  private int health;
  private int protection;
  private boolean isAlive;
  private Magic magic;

  protected MagicianImpl(String username, int health, int protection, Magic magic) {
    this.setUsername(username);
    this.setHealth(health);
    this.setProtection(protection);
    this.setMagic(magic);
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

  private void setUsername(String username) {
    Validator.validateUsername(username);
    this.username = username;
  }

  private void setHealth(int health) {
    Validator.validateHealthPoints(health);
    this.health = health;
  }

  private void setProtection(int protection) {
    Validator.validateProtectionPoints(protection);
    this.protection = protection;
  }

  private void setMagic(Magic magic) {
    Validator.validateMagicWhenAddedToMagician(magic);
    this.magic = magic;
  }
}
