package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.Field;
import football.entities.player.Player;
import football.entities.supplement.Supplement;
import football.factory.FieldFactory;
import football.factory.SupplementFactory;
import football.factory.PlayerFactory;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;


public class ControllerImpl implements Controller {
  private Collection<Field> fields;
  private SupplementRepository supplementRepository;

  public ControllerImpl() {
    this.fields = new ArrayList<>();
    this.supplementRepository = new SupplementRepositoryImpl();
  }

  @Override
  public String addField(String fieldType, String fieldName) {
    Field field = FieldFactory.create(fieldType, fieldName);
    this.fields.add(field);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
  }

  @Override
  public String deliverySupplement(String type) {
    Supplement supplement = SupplementFactory.create(type);
    this.supplementRepository.add(supplement);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
  }

  @Override
  public String supplementForField(String fieldName, String supplementType) {
    Supplement supplement = this.supplementRepository.findByType(supplementType);
    validateSupplement(supplement, supplementType);

    Field field = getField(fieldName);
    this.supplementRepository.remove(supplement);
    field.addSupplement(supplement);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
  }

  @Override
  public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
    Player player = PlayerFactory.create(playerType, playerName, nationality, strength);
    Field field = getField(fieldName);
    field.addPlayer(player);

    if (!doesPlayerCanPlayOnField(playerType, field.getClass().getSimpleName())) {
      return ConstantMessages.FIELD_NOT_SUITABLE;
    }

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
  }

  @Override
  public String dragPlayer(String fieldName) {
    Field field = getField(fieldName);
    field.drag();

    return String.format(ConstantMessages.PLAYER_DRAG, field.getPlayers().size());
  }

  @Override
  public String calculateStrength(String fieldName) {
    Field field = getField(fieldName);

    int totalStrength = field.getPlayers()
            .stream()
            .mapToInt(Player::getStrength)
            .sum();

    return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, totalStrength);
  }

  @Override
  public String getStatistics() {
    StringBuilder sb = new StringBuilder();
    this.fields.forEach(f -> sb.append(f.getInfo()));

    return sb.toString();
  }

  // Helpers
  private void validateSupplement(Supplement supplement, String supplementType) {
    if (supplement == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
    }
  }

  private Field getField(String name) {
    return this.fields.stream()
            .filter(f -> f.getName().equals(name))
            .findFirst()
            .orElse(null);
  }

  private boolean doesPlayerCanPlayOnField(String playerType, String simpleName) {
    if (playerType.equals("Men") && simpleName.equals("ArtificialTurf")
            || playerType.equals("Women") && simpleName.equals("NaturalGrass")) {
      return false;
    }

    return true;
  }

}
