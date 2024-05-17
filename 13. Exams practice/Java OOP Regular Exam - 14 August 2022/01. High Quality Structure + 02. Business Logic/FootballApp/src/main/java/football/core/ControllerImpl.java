package football.core;


import football.common.ConstantMessages;
import football.entities.field.Field;
import football.factory.FieldFactory;
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

    return null;
  }

  @Override
  public String supplementForField(String fieldName, String supplementType) {
    return null;
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
}
