package restaurant;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import restaurant.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {


        HealthFoodRepository<HealthyFood> healthFoodRepository;
        BeverageRepository<Beverages> beverageRepository;
        TableRepository<Table> tableRepository;

        /*
        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();
        */
    }
}
