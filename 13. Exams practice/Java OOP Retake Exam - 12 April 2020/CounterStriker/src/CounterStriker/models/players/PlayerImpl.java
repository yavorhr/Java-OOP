package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class PlayerImpl implements Player {
  private String username;
  private int health;
  private int armor;
  private boolean isAlive;
  private Gun gun;

  public PlayerImpl(String username, int health, int armor, Gun gun) {
    this.username = username;
    this.health = health;
    this.armor = armor;
    this.gun = gun;
    this.isAlive = true;
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
  public int getArmor() {
    return this.armor;
  }

  @Override
  public Gun getGun() {
    return this.gun;
  }

  @Override
  public boolean isAlive() {
    return this.isAlive;
  }

  @Override
  public void takeDamage(int points) {
    if (this.armor > points) {
      this.armor -= points;
    } else if (this.armor == 0) {
      this.health -= points;
    } else {
      int diff = Math.abs(this.armor -= points);
      this.health -= diff;
    }

    if (this.health <= 0) {
      this.isAlive = false;
    }
  }
}
