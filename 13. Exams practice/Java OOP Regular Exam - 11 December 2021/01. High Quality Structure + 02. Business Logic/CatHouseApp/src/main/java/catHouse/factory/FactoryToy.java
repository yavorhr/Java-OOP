package catHouse.factory;

import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;

public class FactoryToy {
  public static Toy create(String type) {
    Toy toy = null;

    switch (type) {
      case "Ball": {
        toy = new Ball();
      }
      case "Mouse": {
        toy = new Mouse();
      }
    }

    return toy;
  }
}
