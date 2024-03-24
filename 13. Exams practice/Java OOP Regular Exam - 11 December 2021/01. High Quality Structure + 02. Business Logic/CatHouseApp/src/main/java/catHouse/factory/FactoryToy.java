package catHouse.factory;

import catHouse.common.ExceptionMessages;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;

public class FactoryToy {
  public static Toy create(String type) {
    Toy toy = null;

    switch (type) {
      case "Ball" -> toy = new Ball();
      case "Mouse" -> toy = new Mouse();
      default -> throw new IllegalStateException(ExceptionMessages.INVALID_TOY_TYPE);
    }

    return toy;
  }
}
