package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.factory.GunFactory;
import viceCity.models.guns.Gun;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepositoryImpl;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Collection<Player> civilPlayers;
  private Player mainPlayer;
  private Repository<Gun> gunRepository;

  public ControllerImpl() {
    this.civilPlayers = new ArrayList<>();
    this.mainPlayer = new MainPlayer();
    this.gunRepository = new GunRepositoryImpl();
  }

  @Override
  public String addPlayer(String name) {
    civilPlayers.add(new CivilPlayer(name));
    return String.format(ConstantMessages.PLAYER_ADDED, name);
  }

  @Override
  public String addGun(String type, String name) {
    Gun gun = GunFactory.create(type, name);

    if (gun == null) {
      return "Invalid gun type!";
    }

    this.gunRepository.add(gun);
    return String.format(ConstantMessages.GUN_ADDED, name, type);
  }

  @Override
  public String addGunToPlayer(String name) {
    return null;
  }

  @Override
  public String fight() {

    return null;
  }
}
