package football.factory;

import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.NaturalGrass;

import java.lang.reflect.Field;

public class FieldFactory {
  public static Field create(String type, String name){
    Field field = null;

    switch (type){
      case "ArtificialTurf" -> field = new ArtificialTurf(name);
      case "NaturalGrass" -> field = new NaturalGrass(name);
      default: throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
    }

    return field;
  }
}
