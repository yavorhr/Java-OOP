package bakery;

import bakery.core.ControllerImpl;
import bakery.core.EngineImpl;
import bakery.core.interfaces.*;
import bakery.entities.bakedFoods.interfaces.*;
import bakery.entities.drinks.interfaces.*;
import bakery.entities.tables.interfaces.*;
import bakery.io.ConsoleReader;
import bakery.io.ConsoleWriter;
import bakery.repositories.DrinkRepositoryImpl;
import bakery.repositories.FoodRepositoryImpl;
import bakery.repositories.TableRepositoryImpl;
import bakery.repositories.interfaces.*;

public class Main {
  public static void main(String[] args) {

    FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
    DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
    TableRepository<Table> tableRepository = new TableRepositoryImpl();

    Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

    ConsoleReader reader = new ConsoleReader();
    ConsoleWriter writer = new ConsoleWriter();

    EngineImpl engine = new EngineImpl(reader, writer, controller);

    engine.run();
  }
}
