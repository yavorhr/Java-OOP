package CounterStriker.core;

import CounterStriker.common.OutputMessages;
import CounterStriker.factory.PlayerFactory;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;
import CounterStriker.validator.Validator;

public class ControllerImpl implements Controller {
  private Repository<Gun> gunRepository;
  private Repository<Player> playerRepository;
  private Field map;

  public ControllerImpl() {
    this.gunRepository = new GunRepository();
    this.playerRepository = new PlayerRepository();
    this.map = new FieldImpl();
  }

  @Override
  public String addGun(String type, String name, int bulletsCount) {
    return null;
  }

  @Override
  public String addPlayer(String type, String username, int health, int armor, String gunName) {
    Gun gun = this.gunRepository.findByName(gunName);

    Validator.throwErrorIfGunIsNull(gun);
    Player player = PlayerFactory.createPlayer(type, username, health, armor, gun);
    this.playerRepository.add(player);

    return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
  }

  @Override
  public String startGame() {
    return null;
  }

  @Override
  public String report() {
    return null;
  }
}
