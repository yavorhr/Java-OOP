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

    validateIfFoodExist(healthyFood.getName());

    this.healthFoodRepository.add(healthyFood);
    return String.format(OutputMessages.FOOD_ADDED, name);
  }


  @Override
  public String addBeverage(String type, int counter, String brand, String name) {
    Beverages beverage = BeverageFactory.create(type, counter, brand, name);

    validateIfBeverageExist(beverage.getName(), beverage.getBrand());
    this.beverageRepository.add(beverage);

    return String.format(OutputMessages.BEVERAGE_ADDED, type, brand);
  }

  @Override
  public String addTable(String type, int tableNumber, int capacity) {
    Table table = TableFactory.create(type, tableNumber, capacity);

    validateIfTableExist(table.getTableNumber());
    this.tableRepository.add(table);

    return String.format(OutputMessages.TABLE_ADDED, tableNumber);
  }

  @Override
  public String reserve(int numberOfPeople) {

    validateIfThereIsFreeTable(numberOfPeople);
    Table table = getFirstAvailableTable(numberOfPeople);

    table.reserve(numberOfPeople);

    return String.format(OutputMessages.TABLE_RESERVED,table.getTableNumber(), numberOfPeople);
  }

  @Override
  public String orderHealthyFood(int tableNumber, String healthyFoodName) {
    //TODO:
    return null;
  }

  @Override
  public String orderBeverage(int tableNumber, String name, String brand) {
    //TODO:
    return null;
  }

  @Override
  public String closedBill(int tableNumber) {
    //TODO:
    return null;
  }

  @Override
  public String totalMoney() {
    //TODO:
    return null;
  }

  // Helpers
  private void validateIfFoodExist(String name) {
    if (this.healthFoodRepository.foodByName(name) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_EXIST, name));
    }
  }

  private void validateIfBeverageExist(String name, String brand) {
    if (this.beverageRepository.beverageByName(name, brand) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.BEVERAGE_EXIST, name));
    }
  }

  private void validateIfTableExist(int tableNumber) {
    if (this.tableRepository.byNumber(tableNumber) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
    }
  }

  private void validateIfThereIsFreeTable(int numberOfPeople) {
    Table table = getFirstAvailableTable(numberOfPeople);

    if (table == null) {
      throw new IllegalArgumentException(String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople));
    }
  }

  private Table getFirstAvailableTable(int numberOfPeople) {
    return this.tableRepository
            .getAllEntities()
            .stream()
            .filter(t -> !t.isReservedTable() && t.getSize() <= numberOfPeople)
            .findFirst()
            .orElse(null);
  }


}
