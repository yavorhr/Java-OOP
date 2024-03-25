package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
  private Collection<Player> civilPlayers;

  public ControllerImpl() {
    this.civilPlayers = new ArrayList<>();
  }

  @Override
  public String addPlayer(String name) {
    return null;
  }

  @Override
  public String addGun(String type, String name) {
    return null;
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
