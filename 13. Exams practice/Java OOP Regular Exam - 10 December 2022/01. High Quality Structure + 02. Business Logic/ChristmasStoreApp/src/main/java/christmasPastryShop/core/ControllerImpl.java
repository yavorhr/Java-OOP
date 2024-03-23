package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.factory.BoothFactory;
import christmasPastryShop.factory.CocktailFactory;
import christmasPastryShop.factory.DelicacyFactory;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
  private static double STORE_INCOME = 0.0;
  private DelicacyRepository<Delicacy> delicacyRepository;
  private CocktailRepository<Cocktail> cocktailRepository;
  private BoothRepository<Booth> boothRepository;

  public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
    this.delicacyRepository = delicacyRepository;
    this.cocktailRepository = cocktailRepository;
    this.boothRepository = boothRepository;
  }

  @Override
  public String addDelicacy(String type, String name, double price) {
    Delicacy delicacy = DelicacyFactory.create(type, name, price);
    doesDelicacyExistInRepository(name, type);
    this.delicacyRepository.add(delicacy);

    return String.format(OutputMessages.DELICACY_ADDED, name, type);
  }

  @Override
  public String addCocktail(String type, String name, int size, String brand) {
    Cocktail cocktail = CocktailFactory.create(type, name, size, brand);
    doesCocktailExistInRepository(name, type);
    this.cocktailRepository.add(cocktail);

    return String.format(OutputMessages.COCKTAIL_ADDED, type, name);
  }

  @Override
  public String addBooth(String type, int boothNumber, int capacity) {
    Booth booth = BoothFactory.create(type, boothNumber, capacity);
    doesBootExistInRepository(boothNumber);
    this.boothRepository.add(booth);

    return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
  }

  @Override
  public String reserveBooth(int numberOfPeople) {
    if (findFirstAvailableBooth(numberOfPeople) == null) {
      return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    Booth booth = findFirstAvailableBooth(numberOfPeople);
    booth.reserve(numberOfPeople);
    return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
  }

  @Override
  public String leaveBooth(int boothNumber) {
    Booth booth = this.boothRepository.getByNumber(boothNumber);
    double bill = booth.getBill();
    STORE_INCOME += bill;
    booth.clear();

    return String.format(OutputMessages.BILL, boothNumber, bill);
  }

  @Override
  public String getIncome() {
    return String.format(OutputMessages.TOTAL_INCOME, STORE_INCOME);
  }

  private Booth findFirstAvailableBooth(int numberOfPeople) {
    return this.boothRepository
            .getAll()
            .stream()
            .filter(b -> b.getCapacity() >= numberOfPeople && !b.isReserved())
            .findFirst()
            .orElse(null);
  }

  // Helpers
  private void doesDelicacyExistInRepository(String name, String type) {
    if (this.delicacyRepository.getByName(name) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

  private void doesCocktailExistInRepository(String name, String type) {
    if (this.cocktailRepository.getByName(name) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

  private void doesBootExistInRepository(int number) {
    if (this.boothRepository.getByNumber(number) != null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, number));
    }
  }

}
