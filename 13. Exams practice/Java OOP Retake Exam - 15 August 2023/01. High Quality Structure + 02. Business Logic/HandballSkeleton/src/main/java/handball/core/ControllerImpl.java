package handball.core;

import handball.common.ConstantMessages;
import handball.common.ExceptionMessages;
import handball.entities.equipment.Equipment;
import handball.entities.gameplay.Gameplay;
import handball.entities.team.Team;
import handball.factory.EquipmentFactory;
import handball.factory.GamePlayFactory;
import handball.factory.TeamFactory;
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
    Equipment equipment = EquipmentFactory.create(equipmentType);
    this.equipmentRepository.add(equipment);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
  }

  @Override
  public String equipmentRequirement(String gameplayName, String equipmentType) {
    Equipment equipment = this.equipmentRepository.findByType(equipmentType);
    validateEquipment(equipmentType, equipment);

    this.equipmentRepository.remove(equipment);
    this.gamePlays.get(gameplayName).addEquipment(equipment);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
  }

  @Override
  public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
    Team team = TeamFactory.create(teamType, teamName, country, advantage);
    Gameplay gameplay = this.gamePlays.get(gameplayName);
    gameplay.addTeam(team);

    if (teamNotSuitableForArea(team.getPlayingArea(), gameplay.getClass().getSimpleName())) {
      return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
    }

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
  }

  @Override
  public String playInGameplay(String gameplayName) {
    Gameplay gameplay = this.gamePlays.get(gameplayName);
    gameplay.teamsInGameplay();

    return String.format(ConstantMessages.TEAMS_PLAYED, gameplay.getTeam().size());
  }

  @Override
  public String percentAdvantage(String gameplayName) {
    int totalAdvantage = this.gamePlays.get(gameplayName).getTeam().stream().mapToInt(Team::getAdvantage).sum();

    return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, totalAdvantage);
  }

  @Override
  public String getStatistics() {
    return null;
  }

  // Helpers
  private void validateEquipment(String equipmentType, Equipment equipment) {
    if (equipment == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
    }
  }

  private boolean teamNotSuitableForArea(String playingArea, String teamType) {
    return !playingArea.equals(teamType);
  }
}
