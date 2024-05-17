package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.Field;
import football.entities.supplement.Supplement;
import football.factory.FieldFactory;
import football.factory.SupplementFactory;
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
    validateSupplement(supplement);

    Field field = getField(fieldName);
    this.supplementRepository.remove(supplement);
    field.addSupplement(supplement);

    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
  }

  @Override
  public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
    return null;
  }

  @Override
  public String dragPlayer(String fieldName) {
    return null;
  }

  @Override
  public String calculateStrength(String fieldName) {
    return null;
  }

  @Override
  public String getStatistics() {
    return null;
  }

  // Helpers

  private void validateSupplement(Supplement supplement) {
    if (supplement == null) {
      throw new IllegalArgumentException(ExceptionMessages.NO_SUPPLEMENT_FOUND);
    }
  }

  private Field getField(String name) {
    return this.fields.stream()
            .filter(f -> f.getName().equals(name))
            .findFirst()
            .orElse(null);
  }


}
