package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.factory.DrinkFactory;
import bakery.factory.FoodFactory;
import bakery.factory.TableFactory;
import bakery.repositories.interfaces.*;

public class ControllerImpl implements Controller {
  private FoodRepository<BakedFood> foodRepository;
  private DrinkRepository<Drink> drinkRepository;
  private TableRepository<Table> tableRepository;


  public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
    this.foodRepository = foodRepository;
    this.drinkRepository = drinkRepository;
    this.tableRepository = tableRepository;
  }


  @Override
  public String addFood(String type, String name, double price) {
    validateIfFoodExists(name, type);
    BakedFood food = FoodFactory.create(type, name, price);

    this.foodRepository.add(food);

    return String.format(OutputMessages.FOOD_ADDED, type, name);
  }

  @Override
  public String addDrink(String type, String name, int portion, String brand) {
    validateIfDrinkExists(name, brand, type);
    Drink drink = DrinkFactory.create(type, name, portion, brand);
    this.drinkRepository.add(drink);

    return String.format(OutputMessages.DRINK_ADDED, type, name);
  }


  @Override
  public String addTable(String type, int tableNumber, int capacity) {
    validateTableNumber(tableNumber);
    Table table = TableFactory.create(type, tableNumber, capacity);

    this.tableRepository.add(table);
    return String.format(OutputMessages.TABLE_ADDED, tableNumber);
  }

  @Override
  public String reserveTable(int numberOfPeople) {
    Table table = findFreeTable(numberOfPeople);

    if (table == null) {
      return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    table.reserve(numberOfPeople);

    return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
  }

  @Override
  public String orderFood(int tableNumber, String foodName) {
    Table table = getTable(tableNumber);

    if (table == null) {
      return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
    }

    BakedFood food = this.foodRepository.getByName(foodName);

    if (food == null) {
      return String.format(OutputMessages.NONE_EXISTENT_FOOD, foodName);
    }

    table.orderFood(food);

    return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
  }

  private Table getTable(int tableNumber) {
    return this.tableRepository.getByNumber(tableNumber);
  }

  @Override
  public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
    //TODO:
    return null;

  }

  @Override
  public String leaveTable(int tableNumber) {
    //TODO:
    return null;
  }

  @Override
  public String getFreeTablesInfo() {
    //TODO:
    return null;
  }

  @Override
  public String getTotalIncome() {
    //TODO:
    return null;
  }

  // Helpers
  private void validateIfFoodExists(String name, String type) {
    if (this.foodRepository.getByName(name) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

  private void validateIfDrinkExists(String name, String brand, String type) {
    if (this.drinkRepository.getByNameAndBrand(name, brand) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

  private void validateTableNumber(int tableNumber) {
    if (getTable(tableNumber) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
    }
  }

  private Table findFreeTable(int numberOfPeople) {
    return this.tableRepository.getAll().stream().filter(t -> t.getCapacity() <= numberOfPeople && !t.isReserved()).findFirst().orElse(null);
  }
}
