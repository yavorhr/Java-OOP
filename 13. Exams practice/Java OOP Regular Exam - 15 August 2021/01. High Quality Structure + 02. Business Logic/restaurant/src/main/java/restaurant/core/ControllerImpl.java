package restaurant.core;

import restaurant.common.ExceptionMessages;
import restaurant.common.OutputMessages;
import restaurant.core.interfaces.Controller;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.interfaces.Table;
import restaurant.factory.BeverageFactory;
import restaurant.factory.FoodFactory;
import restaurant.factory.TableFactory;
import restaurant.repositories.interfaces.*;

public class ControllerImpl implements Controller {
  private static double RESTAURANT_INCOME = 0.0;
  private HealthFoodRepository<HealthyFood> healthFoodRepository;
  private BeverageRepository<Beverages> beverageRepository;
  private TableRepository<Table> tableRepository;

  public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
    this.healthFoodRepository = healthFoodRepository;
    this.beverageRepository = beverageRepository;
    this.tableRepository = tableRepository;
  }

  @Override
  public String addHealthyFood(String type, double price, String name) {
    HealthyFood healthyFood = FoodFactory.create(type, price, name);

    throwErrorIfFoodExist(healthyFood.getName());

    this.healthFoodRepository.add(healthyFood);
    return String.format(OutputMessages.FOOD_ADDED, name);
  }


  @Override
  public String addBeverage(String type, int counter, String brand, String name) {
    Beverages beverage = BeverageFactory.create(type, counter, brand, name);

    throwErrorIfDrinkExist(beverage.getName(), beverage.getBrand());
    this.beverageRepository.add(beverage);

    return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
  }

  @Override
  public String addTable(String type, int tableNumber, int capacity) {
    Table table = TableFactory.create(type, tableNumber, capacity);

    throwErrorIfTableExist(table.getTableNumber());
    this.tableRepository.add(table);

    return String.format(OutputMessages.TABLE_ADDED, tableNumber);
  }

  @Override
  public String reserve(int numberOfPeople) {

    throwErrorIfNoFreeTable(numberOfPeople);
    Table table = getFirstAvailableTable(numberOfPeople);

    table.reserve(numberOfPeople);

    return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
  }

  @Override
  public String orderHealthyFood(int tableNumber, String foodName) {
    Table table = tableRepository.byNumber(tableNumber);
    HealthyFood food = healthFoodRepository.foodByName(foodName);

    throwErrorIfTableDoesNotExist(tableNumber);
    throwErrorIfFoodDoesNotExist(food, foodName);

    table.orderHealthy(food);

    return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, food.getName(), tableNumber);
  }


  @Override
  public String orderBeverage(int tableNumber, String name, String brand) {
    Table table = this.tableRepository.byNumber(tableNumber);
    Beverages beverage = this.beverageRepository.beverageByName(name, brand);

    throwErrorIfTableExist(tableNumber);
    throwErrorIfDrinkNotExist(beverage.getBrand(), beverage.getName());

    table.orderBeverages(beverage);

    return String.format(OutputMessages.BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
  }

  @Override
  public String closedBill(int tableNumber) {
    Table table = this.tableRepository.byNumber(tableNumber);
    double bill = table.bill();
    RESTAURANT_INCOME += bill;
    table.clear();

    return String.format(OutputMessages.BILL, tableNumber, bill);
  }

  @Override
  public String totalMoney() {
    return String.format(OutputMessages.TOTAL_MONEY, RESTAURANT_INCOME);
  }

  // Helpers

  private void throwErrorIfFoodExist(String name) {
    if (doesFoodExist(name)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }
  }

  private void throwErrorIfFoodDoesNotExist(HealthyFood food, String name) {
    if (food == null) {
      throw new IllegalArgumentException(String.format(OutputMessages.NONE_EXISTENT_FOOD, name));
    }
  }

  private void throwErrorIfDrinkExist(String name, String brand) {
    if (doesDrinkExist(name, brand)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
    }
  }

  private void throwErrorIfTableExist(int tableNumber) {
    if (doesTableExist(tableNumber)) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_IS_ALREADY_ADDED, tableNumber));
    }
  }

  private void throwErrorIfTableDoesNotExist(int tableNumber) {
    if (!doesTableExist(tableNumber)) {
      throw new IllegalArgumentException(String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber));
    }
  }

  private void throwErrorIfNoFreeTable(int numberOfPeople) {
    Table table = getFirstAvailableTable(numberOfPeople);

    if (table == null) {
      throw new IllegalArgumentException(String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople));
    }
  }

  private void throwErrorIfDrinkNotExist(String name, String brand) {
    if (!doesDrinkExist(name,brand)) {
      throw new IllegalArgumentException(OutputMessages.NON_EXISTENT_DRINK);
    }
  }

  private Table getFirstAvailableTable(int numberOfPeople) {
    return this.tableRepository
            .getAllEntities()
            .stream()
            .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
            .findFirst()
            .orElse(null);
  }

  // boolean check
  private boolean doesFoodExist(String name) {
    return this.healthFoodRepository.foodByName(name) != null;
  }

  private boolean doesTableExist(int tableNumber) {
    return this.tableRepository.byNumber(tableNumber) != null;
  }

  private boolean doesDrinkExist(String name, String brand) {
    return this.beverageRepository.beverageByName(name, brand) != null;
  }

}
