package viceCity.models.players;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

public class BasePlayer implements Player {
  private String name;
  private int lifePoints;
  private Repository<Gun> gunRepository;

  public BasePlayer(String name, int lifePoints) {
    this.name = name;
    this.lifePoints = lifePoints;
    this.gunRepository = new GunRepositoryImpl();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getLifePoints() {
    return this.lifePoints;
  }

  @Override
  public boolean isAlive() {
    return this.lifePoints > 0;
  }

  @Override
  public Repository<Gun> getGunRepository() {
    return this.gunRepository;
  }

  @Override
  public void takeLifePoints(int points) {
    this.lifePoints -= points;

    if (this.lifePoints < 0) {
      this.lifePoints = 0;
    }
  }
}