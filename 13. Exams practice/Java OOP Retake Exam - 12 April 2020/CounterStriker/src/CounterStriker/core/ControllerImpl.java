package CounterStriker.core;

import CounterStriker.common.OutputMessages;
import CounterStriker.factory.GunFactory;
import CounterStriker.factory.PlayerFactory;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;
import CounterStriker.validator.Validator;

import java.util.Comparator;

public class ControllerImpl implements Controller {
  private Repository<Gun> gunRepository;
  private Repository<Player> playerRepository;
  private Field field;

  public ControllerImpl() {
    this.gunRepository = new GunRepository();
    this.playerRepository = new PlayerRepository();
    this.field = new FieldImpl();
  }

  @Override
  public String addGun(String type, String name, int bulletsCount) {
    Gun gun = GunFactory.createGun(type, name, bulletsCount);
    this.gunRepository.add(gun);
    return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
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
    return this.field.start(this.playerRepository.getModels());
  }

  @Override
  public String report() {
    StringBuilder sb = new StringBuilder();

    this.playerRepository.getModels().stream().sorted((p1, p2) -> {
      int result = p1.getClass().getSimpleName()
              .compareTo(p2.getClass().getSimpleName());

      if (result == 0) {
        result = Integer.compare(p2.getHealth(), p1.getHealth());
      }

      if (result == 0) {
        result = p1.getUsername().compareTo(p2.getUsername());
      }
      return result;
    })
            .forEach(sb::append);

    return sb.toString().trim();
  }
}
