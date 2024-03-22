package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
  private Collection<Delicacy> delicacyOrders;
  private Collection<Cocktail> cocktailOrders;
  private int boothNumber;
  private int capacity;
  private int numberOfPeople;
  private double pricePerPerson;
  private boolean isReserved;
  private double price;

  protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
    this.boothNumber = boothNumber;
    this.setCapacity(capacity);
    this.pricePerPerson = pricePerPerson;
    this.delicacyOrders = new ArrayList<>();
    this.cocktailOrders = new ArrayList<>();
  }

  @Override
  public int getBoothNumber() {
    return this.boothNumber;
  }

  @Override
  public int getCapacity() {
    return this.capacity;
  }

  @Override
  public boolean isReserved() {
    return this.isReserved;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void reserve(int numberOfPeople) {
    this.isReserved = true;
    setNumberOfPeople(numberOfPeople);
    this.setPrice(numberOfPeople * this.pricePerPerson);
  }

  @Override
  public double getBill() {
    return this.price;
  }

  @Override
  public void clear() {
    this.isReserved = false;
    this.numberOfPeople = 0;
    this.price = 0;
    this.cocktailOrders.clear();
    this.delicacyOrders.clear();
  }

  private void setCapacity(int capacity) {
    Validator.validateCapacity(capacity);
    this.capacity = capacity;
  }

  private void setNumberOfPeople(int numberOfPeople) {
    Validator.validateNumberOfPeople(numberOfPeople);
    this.numberOfPeople = numberOfPeople;
  }

  private void setPrice(double price) {
    this.price = price;
  }
}
