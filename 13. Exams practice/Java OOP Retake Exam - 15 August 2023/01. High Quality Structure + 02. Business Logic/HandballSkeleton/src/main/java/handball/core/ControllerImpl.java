package handball.core;

import handball.common.ConstantMessages;
import handball.entities.gameplay.Gameplay;
import handball.factory.GamePlayFactory;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
  private Map<String, Gameplay> gamePlays;
  private Repository equipmentRepository;

  public ControllerImpl() {
    this.gamePlays = new HashMap<>();
    this.equipmentRepository = new EquipmentRepository();
  }

  @Override
  public String addGameplay(String gameplayType, String gameplayName) {
    Gameplay gameplay = GamePlayFactory.create(gameplayType, gameplayName);
    gamePlays.put(gameplayName, gameplay);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
  }

  @Override
  public String addEquipment(String equipmentType) {
    return null;
  }

  @Override
  public String equipmentRequirement(String gameplayName, String equipmentType) {
    return null;
  }

  @Override
  public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
    return null;
  }

  @Override
  public String playInGameplay(String gameplayName) {
    return null;
  }

  @Override
  public String percentAdvantage(String gameplayName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }
}
