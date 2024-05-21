package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;
import restaurant.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
  private Collection<HealthyFood> foods;
  private Collection<Beverages> beverages;
  private int tableNumber;
  private int size;
  private int numberOfPeople;
  private double pricePerPerson;
  private boolean isReservedTable;
  private double allPeople;

  protected BaseTable(int tableNumber, int size, double pricePerPerson) {
    this.tableNumber = tableNumber;
    this.setSize(size);
    this.pricePerPerson = pricePerPerson;

    this.foods = new ArrayList<>();
    this.beverages = new ArrayList<>();
    this.setNumberOfPeople(numberOfPeople);
    this.isReservedTable = false;
    this.allPeople = 0;
  }

  @Override
  public int getTableNumber() {
    return this.tableNumber;
  }

  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  public int numberOfPeople() {
    return this.numberOfPeople;
  }

  @Override
  public double pricePerPerson() {
    return this.pricePerPerson;
  }

  @Override
  public boolean isReservedTable() {
    return this.isReservedTable;
  }

  @Override
  public double allPeople() {
    return this.pricePerPerson * this.numberOfPeople;
  }

  @Override
  public void reserve(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
    this.isReservedTable = true;
  }

  @Override
  public void orderHealthy(HealthyFood food) {
    this.foods.add(food);
  }

  @Override
  public void orderBeverages(Beverages beverages) {
    this.beverages.add(beverages);
  }

  @Override
  public double bill() {
    double beveragesBill = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
    double foodBill = this.foods.stream().mapToDouble(HealthyFood::getPrice).sum();

    return beveragesBill + foodBill;
  }

  @Override
  public void clear() {
    this.foods.clear();
    this.beverages.clear();
    this.isReservedTable = false;
    this.numberOfPeople = 0;
    this.allPeople = 0;
  }

  @Override
  public String tableInformation() {
    StringBuilder sb = new StringBuilder();

    sb.append(String.format("Table - %d", this.tableNumber))
            .append(System.lineSeparator());
    sb.append(String.format("Size - %d", this.size))
            .append(System.lineSeparator());
    sb.append(String.format("Type - %s", this.getClass().getSimpleName()))
            .append(System.lineSeparator());
    sb.append(String.format("All price - %.2f", this.pricePerPerson))
            .append(System.lineSeparator());

    return sb.toString();
  }

  private void setSize(int size) {
    Validator.validateSize(size);
    this.size = size;
  }

  private void setNumberOfPeople(int numberOfPeople) {
    Validator.validateNumberOfPeople(numberOfPeople);
    this.numberOfPeople = numberOfPeople;
  }
}
