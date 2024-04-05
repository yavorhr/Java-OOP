package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.factory.GunFactory;
import viceCity.models.guns.Gun;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
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
  private Repository<Gun> allGunsRepository;
  private Neighbourhood neighbourhood;

  public ControllerImpl() {
    this.civilPlayers = new ArrayList<>();
    this.mainPlayer = new MainPlayer();
    this.allGunsRepository = new GunRepositoryImpl();
    this.neighbourhood = new GangNeighbourhood();
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

    this.allGunsRepository.add(gun);
    return String.format(ConstantMessages.GUN_ADDED, name, type);
  }

  @Override
  public String addGunToPlayer(String name) {
    if (gunRepositoryIsEmpty()) {
      return ConstantMessages.GUN_QUEUE_IS_EMPTY;
    }

    Gun gun = getFirstGunAvailable();

    Player player = null;

    if (name.equals("Vercetti")) {
      player = this.mainPlayer;
      addGunToPlayer(player, gun);

      return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, name, mainPlayer.getName());
    } else if (!doesCivilPlayerExist(name)) {
      return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
    } else {
      player = getPlayer(name);
      addGunToPlayer(player, gun);

      return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }
  }

  @Override
  public String fight() {
    this.neighbourhood.action(mainPlayer, civilPlayers);

    if (noShootoutYet()) {
      return ConstantMessages.FIGHT_HOT_HAPPENED;
    }
  }


  // Helpers
  private void addGunToPlayer(Player player, Gun gun) {
    player.getGunRepository().add(gun);
    this.allGunsRepository.remove(gun);
  }

  private boolean noShootoutYet() {
    return this.mainPlayer.getLifePoints() == 100 && this.civilPlayers.stream().allMatch(p -> p.getLifePoints() == 50);
  }


  private Player getPlayer(String name) {
    return this.civilPlayers
            .stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElse(null);
  }

  private boolean doesCivilPlayerExist(String name) {
    return this.civilPlayers
            .stream()
            .anyMatch(p -> p.getName()
                    .equals(name));
  }

  private boolean gunRepositoryIsEmpty() {
    return this.allGunsRepository.getModels().size() == 0;
  }

  private Gun getFirstGunAvailable() {
    return this.allGunsRepository.getModels().stream().findFirst().orElse(null);
  }

}
