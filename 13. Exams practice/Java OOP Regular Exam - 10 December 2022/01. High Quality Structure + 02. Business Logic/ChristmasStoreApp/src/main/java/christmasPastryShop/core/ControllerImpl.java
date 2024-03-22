package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.factory.CocktailFactory;
import christmasPastryShop.factory.DelicacyFactory;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {
  private DelicacyRepository<Delicacy> delicacyRepository;
  private CocktailRepository<christmasPastryShop.entities.cocktails.interfaces.Cocktail> cocktailRepository;
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
    //TODO
    return null;
  }

  @Override
  public String reserveBooth(int numberOfPeople) {
    //TODO
    return null;
  }

  @Override
  public String leaveBooth(int boothNumber) {
    //TODO
    return null;
  }

  @Override
  public String getIncome() {
    //TODO
    return null;
  }

  // Helpers
  private void doesDelicacyExistInRepository(String name, String type) {
    if (this.delicacyRepository.getByName(name) == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

  private void doesCocktailExistInRepository(String name, String type) {
    if (this.cocktailRepository.getByName(name) == null) {
      throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
    }
  }

}
