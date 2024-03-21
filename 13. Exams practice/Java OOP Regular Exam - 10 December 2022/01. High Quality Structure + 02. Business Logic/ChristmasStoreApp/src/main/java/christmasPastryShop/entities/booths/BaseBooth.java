package christmasPastryShop.entities.booths;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

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

  public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
    this.boothNumber = boothNumber;
    this.capacity = capacity;
    this.pricePerPerson = pricePerPerson;
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

  }

  @Override
  public double getBill() {
    return 0;
  }

  @Override
  public void clear() {

  }
}
