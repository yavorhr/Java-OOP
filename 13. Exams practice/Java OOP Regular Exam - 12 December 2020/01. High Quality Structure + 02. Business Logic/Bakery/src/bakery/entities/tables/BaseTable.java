package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;
import bakery.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
  private int tableNumber;
  private int capacity;
  private double pricePerPerson;

  private Collection<BakedFood> foodOrders;
  private Collection<Drink> drinkOrders;
  private int numberOfPeople;
  private boolean isReserved;
  private double price;

  protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
    this.tableNumber = tableNumber;
    this.capacity = capacity;
    this.pricePerPerson = pricePerPerson;

    this.foodOrders = new ArrayList<>();
    this.drinkOrders = new ArrayList<>();
    this.numberOfPeople = 0;
    this.isReserved = false;
    this.price = 0;
  }

  @Override
  public int getTableNumber() {
    return this.tableNumber;
  }

  @Override
  public int getCapacity() {
    return this.capacity;
  }

  @Override
  public int getNumberOfPeople() {
    return this.numberOfPeople;
  }

  @Override
  public double getPricePerPerson() {
    return this.pricePerPerson;
  }

  @Override
  public boolean isReserved() {
    return this.isReserved;
  }

  @Override
  public double getPrice() {
    return this.numberOfPeople * this.pricePerPerson;
  }

  @Override
  public void reserve(int numberOfPeople) {
    setNumberOfPeople(numberOfPeople);
    this.isReserved = true;
  }

  @Override
  public void orderFood(BakedFood food) {
    this.foodOrders.add(food);
  }

  @Override
  public void orderDrink(Drink drink) {
    this.drinkOrders.add(drink);
  }

  @Override
  public double getBill() {
    double foodBill = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
    double drinksBill = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();

    return foodBill + drinksBill;
  }

  @Override
  public void clear() {
    this.drinkOrders.clear();
    this.foodOrders.clear();
    this.isReserved = false;
    this.numberOfPeople = 0;
    this.price = 0;
  }

  @Override
  public String getFreeTableInfo() {
    return null;
  }

  private void setNumberOfPeople(int numberOfPeople) {
    Validator.validateNumberOfPeople(numberOfPeople);
    this.numberOfPeople = numberOfPeople;
  }
}
