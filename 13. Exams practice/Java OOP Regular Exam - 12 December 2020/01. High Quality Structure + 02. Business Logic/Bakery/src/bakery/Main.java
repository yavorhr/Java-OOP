package bakery;

import bakery.core.interfaces.*;
import bakery.entities.bakedFoods.interfaces.*;
import bakery.entities.drinks.interfaces.*;
import bakery.entities.tables.interfaces.*;
import bakery.repositories.interfaces.*;

public class Main {
  public static void main(String[] args) {

    String a = "";
    int a1 = a.length();
    FoodRepository<BakedFood> foodRepository; // TODO:  new FoodRepositoryImpl<>();
    DrinkRepository<Drink> drinkRepository;  // TODO:  new DrinkRepositoryImpl<>();
    TableRepository<Table> tableRepository; // TODO:  new TableRepositoryImpl<>();

    Controller controller; // TODO: new ControllerImpl(foodRepository, drinkRepository, tableRepository);

    // TODO:OPTIONAL
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();
  }
}
